package org.hippo.sample.spring.classloader;

import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) throws Exception {
		
		Driver driver = new Driver();
		
		AbstractRefreshableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/SpringConfiguration.xml");
		
		String jarPath = "file:/C:/Users/hippo/Workspaces/study/spring-classloader/spring-classloader-loader/spring-classloader-jar-0.0.1-SNAPSHOT.jar";
		
		driver.loadJarToApplicationContext(
				applicationContext,
				new URL(jarPath));
		
		// Test
		Object bean = applicationContext.getBean("program");
		Program p = (Program) bean;
		System.out.println(bean.getClass());
		System.out.println(p.function("hello world!").getContent());
		
	}

	public void loadJarToApplicationContext(AbstractRefreshableApplicationContext applicationContext, URL url) throws ClassNotFoundException {
		
		ClassLoader loader = URLClassLoader.newInstance(new URL[] {url}, getClass().getClassLoader());
		
		URL applicationContextUrl = loader.getResource("ApplicationContext.xml");
		if (applicationContextUrl == null)
			throw new IllegalArgumentException("Cannot find \"ApplicationContext.xml\" in "+url);
		
		DefaultListableBeanFactory rootBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
		
		// Parse ApplicationContext in Jar package
		DefaultListableBeanFactory jarBeanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader(jarBeanFactory);
		reader.loadBeanDefinitions(applicationContextUrl.toString());
		BeanDefinitionRegistry beanDefinitionRegistry = reader.getRegistry();
	
		// Copy bean definitions from jar to root application context
		for(String beanId: beanDefinitionRegistry.getBeanDefinitionNames()) {
			BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(beanId);
			rootBeanFactory.registerBeanDefinition(beanId, beanDefinition);
		}
		
		// Set external class loader to bean factory
		applicationContext.getBeanFactory().setBeanClassLoader(loader);
		
	}
}
