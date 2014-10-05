package org.hippo.sample.hibernate.myhibernate;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.hippo.sample.hibernate.myhibernate.Configuration.EntityClassMapping;

public class SessionFactory {
	
	public SessionFactory(final Configuration configuration) {
		this.configuration = configuration;
	}
	
	public Session openSession() throws SQLException {
		
		Connection conn = configureConnection(configuration.getSettings());
		conn.setAutoCommit(false);
		
		Map<String, PreparedStatement> mappings = 
				configurePreparedStatements(conn, configuration.getEntityClassMappings());
		
		Transaction tran = new Transaction(conn);
		
		return new Session(conn, tran, mappings, configuration.getEntityClassMappings());
	}
	
	private Connection configureConnection(Map<String, String> settings) throws SQLException {
		
		Connection conn = null;
		
		if (settings.get("connection.driver_class").equals("com.mysql.jdbc.Driver")) {
			 conn = DriverManager.getConnection(
					settings.get("connection.url"), 
					settings.get("connection.username"),
					settings.get("connection.password"));
		}
		
		return conn;
	}
	
	private Map<String, PreparedStatement> configurePreparedStatements(Connection conn, final Set<Configuration.EntityClassMapping> mappings
			) throws SQLException {
		
		
		Map<String, PreparedStatement> preparedStatements = new HashMap<String, PreparedStatement>();
		
		//TODO: hard code
		EntityClassMapping mapping = mappings.iterator().next();
		
		preparedStatements.put("save", conn.prepareStatement(confSavePreparedStatement(mapping)));
		
		return preparedStatements;
	}
	
	private String confSavePreparedStatement(EntityClassMapping mapping) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("insert into ");
		builder.append(mapping.getTableName());
		
		// Add column names
		builder.append(" (");
		for (String fieldName: mapping.getFieldsOrderList()) {
			builder.append(mapping.getFieldColumnMappings().get(fieldName));
			builder.append(", ");
		}
		builder.delete(builder.length()-2, builder.length());
		builder.append(") ");
		
		// Add values for columns
		builder.append("values");
		builder.append(" (");
		for (int i=0; i<mapping.getFieldsOrderList().size(); i++) {
			builder.append("?");
			builder.append(", ");
		}
		builder.delete(builder.length()-2, builder.length());
		builder.append(") ");
		
		return builder.toString();
	}
	
	
	private Configuration configuration;
}
