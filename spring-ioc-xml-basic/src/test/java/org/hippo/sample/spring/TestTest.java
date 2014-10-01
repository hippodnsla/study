package org.hippo.sample.spring;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.hippo.sample.spring.calculationservice.Calculation;
import org.hippo.sample.spring.calculationservice.Calculator;
import org.hippo.sample.spring.dataservice.DataService;
import org.hippo.sample.spring.dataservice.DataServiceLocator;
import org.hippo.sample.spring.dataservice.InformationDataService;
import org.hippo.sample.spring.model.InformationEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/ApplicationContext.xml");
		
		ConfigurationManager configurationManager = (ConfigurationManager) context.getBean("configurationManager");
		
		configurationManager.setProperty("simulation", "covmatrix", "/data/CPMBatch/ResearchStaticFiles/CovMatrix.txt");
		
		System.out.println(configurationManager.getProperty("global", "version"));
		System.out.println(configurationManager.getProperty("global", "database"));

		System.out.println(configurationManager.getProperty("simulation", "covmatrix"));
	}
	
	@Test
	public void test2() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/ApplicationContext.xml");
		
		DataServiceLocator dataServiceLocator = (DataServiceLocator) context.getBean("dataServiceLocator");
		
		DataService<?> dataService = dataServiceLocator.findDataService(InformationEntity.class);
		
		assertNotNull(dataService);
		assertTrue(dataService instanceof InformationDataService);
		
		DataService<InformationEntity> informationDataService = (DataService<InformationEntity>) dataService;
		
		InformationEntity entity = informationDataService.read(0);
		assertNotNull(entity);
		
	}
	
	@Test
	public void test3() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/ApplicationContext.xml");
		
		Calculation calc1 = (Calculation) context.getBean("calculation");
		Calculation calc2 = (Calculation) context.getBean("calculation");
		
		assertTrue(calc1!=calc2);
		
	}

}
