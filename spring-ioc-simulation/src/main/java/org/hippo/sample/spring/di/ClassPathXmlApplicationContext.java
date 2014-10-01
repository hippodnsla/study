package org.hippo.sample.spring.di;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.util.Assert;

public class ClassPathXmlApplicationContext implements BeanFactory {

	private static final Logger LOGGER = Logger.getLogger(ClassPathXmlApplicationContext.class);
	
	public ClassPathXmlApplicationContext() 
			throws JDOMException, IOException, ClassNotFoundException, InstantiationException, 
			IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, 
			InvocationTargetException {
		
		this("beans.xml");
	}
	public ClassPathXmlApplicationContext(String path) 
			throws JDOMException, IOException, ClassNotFoundException, InstantiationException, 
			IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, 
			InvocationTargetException {
		
		beans = new HashMap<String, Object>();
		
		InputStream resource = this.getClass().getClassLoader().getResourceAsStream(path);
		
		initContext(resource);
	}
	
	public Object getBean(String id) {
		Assert.notNull(id);
		Object o = beans.get(id);
		Assert.notNull(o, "Cannot find bean of given id");
		return o;
	}
	
	private void initContext(InputStream stream) 
			throws JDOMException, IOException, ClassNotFoundException, InstantiationException, 
			IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, 
			InvocationTargetException {
		
		SAXBuilder builder = new SAXBuilder();
		
		Document doc = builder.build(stream);
		
		List<Element> xmlBeans = (List<Element>) doc.getRootElement().getChildren("bean");
		
		for(Element xmlBean: xmlBeans) {
			
			String id = xmlBean.getAttributeValue("id");
			Assert.notNull(id);
			String clazz = xmlBean.getAttributeValue("class");
			Assert.notNull(clazz);
			
			LOGGER.debug("Loaded ["+id+", "+clazz+"]");
			Object o = Class.forName(clazz).newInstance();
			
			for(Element xmlProperty: (List<Element>)xmlBean.getChildren("property")) {
				
				String name = xmlProperty.getAttributeValue("name");
				String ref = xmlProperty.getAttributeValue("ref");
				Object refClazz = beans.get(ref);
				
				
				String setMethodName = "set"+Character.toString(name.charAt(0)).toUpperCase()+name.substring(1, name.length());
				Method setMethod = o.getClass().getMethod(setMethodName, refClazz.getClass().getInterfaces()[0]);
				setMethod.invoke(o, refClazz);
			}
			
			
			
			beans.put(id, o);
		}
	}
	
	private Map<String, Object> beans;

}
