package org.hippo.sample.hibernate.myhibernate;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import org.hippo.sample.hibernate.myhibernate.Configuration.EntityClassMapping;

public class Session {

	public Session(Connection connection, Transaction transaction, 
			Map<String, PreparedStatement> preparedStatements, Set<EntityClassMapping> entityClassMappings)
					throws SQLException {
		
		this.connection = connection;
		this.transaction = transaction;
		this.preparedStatements = preparedStatements;
		this.entityClassMappings = entityClassMappings;
		
	}
	
	public Transaction getTransaction() {
		return transaction;
	}
	
	public Serializable save(Object entity) 
			throws SQLException, NoSuchMethodException, SecurityException, 
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		PreparedStatement preparedStatement = preparedStatements.get("save");
		
		EntityClassMapping mapping = findEntityClassMapping(entityClassMappings, entity.getClass().getName());
		
		int count = 1;
		for (String fieldName: mapping.getFieldsOrderList()) {
			String methodName = "get"
					+fieldName.substring(0, 1).toUpperCase()
					+fieldName.substring(1, fieldName.length());
			Method method = entity.getClass().getMethod(methodName);
			
			Object value = method.invoke(entity);
			
			if (value.getClass().equals(Integer.class))
				preparedStatement.setInt(count++, (Integer)value);
			if (value.getClass().equals(Long.class))
				preparedStatement.setLong(count++, (Long)value);
			if (value.getClass().equals(String.class))
				preparedStatement.setString(count++, (String)value);
			
		}
		
		preparedStatement.execute();
		
		return (Serializable) entity;
	}
	
	public void close() throws SQLException {
		connection.close();
	}
	
	private final EntityClassMapping findEntityClassMapping(Set<EntityClassMapping> entityClassMappings, String className) {
		for (EntityClassMapping mapping: entityClassMappings) {
			if (mapping.getClassName().equals(className))
				return mapping;
		}
		return null;
	}
	
	private Connection connection;
	private Transaction transaction;
	private Map<String, PreparedStatement> preparedStatements;
	private Set<EntityClassMapping> entityClassMappings;
}
