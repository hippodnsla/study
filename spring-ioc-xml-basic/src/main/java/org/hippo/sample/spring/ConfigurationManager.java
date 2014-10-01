package org.hippo.sample.spring;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.util.Assert;

public class ConfigurationManager {
	
	private class Property {
		private String domain;
		private String key;
		private String value;
	}
	
	public ConfigurationManager(String domain, Properties properties) {
		this();
		for (Object key: properties.keySet()) {
			Object value = properties.get(key);
			setProperty(domain, (String) key, (String) value);
		}
	}
	public ConfigurationManager() {
		properties = new HashMap<String, Map<String, String>>();
	}
	
	public String getProperty(String domain, String key) {
		Map<String, String> keyValues = properties.get(domain);
		if (keyValues == null)
			return null;
		return keyValues.get(key);
	}
	
	public void setProperty(String domain, String key, String value) {
		
		Assert.notNull(domain);
		Assert.notNull(key);
		Assert.notNull(value);
		
		Map<String, String> keyValues = null;
		if (properties.containsKey(domain)) {
			keyValues = properties.get(domain);
		} else {
			keyValues = new HashMap<String, String>();
			properties.put(domain, keyValues);
		}
		
		keyValues.put(key, value);
	}
	
	private Map<String, Map<String, String>> properties;
}

	

	
