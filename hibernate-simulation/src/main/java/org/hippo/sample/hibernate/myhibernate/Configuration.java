package org.hippo.sample.hibernate.myhibernate;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Configuration {

	public class EntityClassMapping {
		
		public EntityClassMapping() {
			fieldColumnMappings = new HashMap<String, String>();
			fieldsOrderList = new ArrayList<String>();
			keys = new HashSet<String>();
		}
		
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public String getTableName() {
			return tableName;
		}
		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
		public Map<String, String> getFieldColumnMappings() {
			return fieldColumnMappings;
		}
		public void setFieldColumnMappings(Map<String, String> fieldColumnMappings) {
			this.fieldColumnMappings = fieldColumnMappings;
		}
		public List<String> getFieldsOrderList() {
			return fieldsOrderList;
		}
		public void setFieldsOrderList(List<String> fieldsOrderList) {
			this.fieldsOrderList = fieldsOrderList;
		}
		public Set<String> getKeys() {
			return keys;
		}
		public void setKeys(Set<String> keys) {
			this.keys = keys;
		}
		
		private String className;
		private String tableName;
		private Map<String, String> fieldColumnMappings;
		private List<String> fieldsOrderList;
		private Set<String> keys;
	}
	
	public Configuration() {
		configurationFilePath = "hibernate.cfg.xml";
		settings = new HashMap<String, String>();
		entityClassMappings = new HashSet<EntityClassMapping>();
	}
	public Configuration(String filePath) {
		this();
		configurationFilePath = filePath;
	}
	
	public Configuration configure() 
			throws JDOMException, IOException {
		InputStream resource = this.getClass().getClassLoader().getResourceAsStream(configurationFilePath);
		parseConfigurationFile(resource);
		return this;
	}
	
	public SessionFactory buildSessionFactory() {
		return new SessionFactory(this);
	}
	
	public final Map<String, String> getSettings() {
		return settings;
	}
	
	public final Set<EntityClassMapping> getEntityClassMappings() {
		return entityClassMappings;
	}
	
	private void parseConfigurationFile(InputStream stream)
			throws JDOMException, IOException {
		
		SAXBuilder builder = new SAXBuilder();
		
		Document doc = builder.build(stream);
		
		Element hibernateConfigurationElement = doc.getRootElement();
		Element sessionFactoryElement = hibernateConfigurationElement.getChild("session-factory");
		
		Map<String, String> settings = 
				parseProperties((List<Element>) sessionFactoryElement.getChildren("property"));
		this.settings = settings;
		
		Set<EntityClassMapping> entityClassMappings = new HashSet<EntityClassMapping>();
		for (Element e: (List<Element>) sessionFactoryElement.getChildren("mapping")) {
			String filePath = e.getAttributeValue("resource");
			entityClassMappings.addAll(
					parseEntityClassMappingFile(
							this.getClass().getClassLoader().getResourceAsStream(filePath)));
		}
		this.entityClassMappings = entityClassMappings;
		
	}
	
	private Set<EntityClassMapping> parseEntityClassMappingFile(InputStream stream) 
			throws JDOMException, IOException {
		
		Set<EntityClassMapping> mappings = new HashSet<EntityClassMapping>();
		
		SAXBuilder builder = new SAXBuilder();
		
		Document doc = builder.build(stream);
		
		Element hibernateMappingElement = doc.getRootElement();
		
		for (Element clazz: (List<Element>) hibernateMappingElement.getChildren("class")) {
			mappings.add(parseEntityClassMapping(clazz));
		}
		
		return mappings;
	}
	
	private EntityClassMapping parseEntityClassMapping(Element mappingClass) {
		
		EntityClassMapping mapping = new EntityClassMapping();
		
		String className = mappingClass.getAttributeValue("name");
		String tableName = mappingClass.getAttributeValue("table");
		
		mapping.setClassName(className);
		mapping.setTableName(tableName);
		
		// Get Id properties
		for (Element id: (List<Element>) mappingClass.getChildren("id")) {
			String fieldName = id.getAttributeValue("name");
			String columnName = id.getAttributeValue("column");
			
			mapping.fieldColumnMappings.put(fieldName, columnName);
			mapping.fieldsOrderList.add(fieldName);
			mapping.keys.add(fieldName);
		}
		
		// Get normal properties
		for (Element property: (List<Element>) mappingClass.getChildren("property")) {
			String fieldName = property.getAttributeValue("name");
			// TODO: hard code here
			String columnName = ((Element)property.getChildren("column").get(0)).getAttributeValue("name");
			
			mapping.fieldColumnMappings.put(fieldName, columnName);
			mapping.fieldsOrderList.add(fieldName);
		}
		
		return mapping;
		
	}
	
	private Map<String, String> parseProperties(List<Element> properties) {
		Map<String, String> settings = new HashMap<String, String>();
		for (Element p: properties) {
			String propName = p.getAttribute("name").getValue();
			String propValue = p.getText();
			settings.put(propName, propValue);
		}
		return settings;
	}
	
	private String configurationFilePath;
	private Map<String, String> settings;
	private Set<EntityClassMapping> entityClassMappings;
	
}
