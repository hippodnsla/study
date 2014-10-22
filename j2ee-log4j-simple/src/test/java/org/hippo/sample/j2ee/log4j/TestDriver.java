package org.hippo.sample.j2ee.log4j;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.SimpleLayout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDriver {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testFileAppenderSimpleLayout() {
		
		//// Setup ////
		//
		Logger logger = Logger.getLogger(Test.class);
		// Add a ConsoleAppender that uses PatternLayout using the PatternLayout.TTCC_CONVERSION_PATTERN 
		// 	and prints to System.out to the root category.
		Layout layout = new SimpleLayout();
		Appender appender;
		try {
			appender = new RollingFileAppender(layout, "log.txt");
			((RollingFileAppender)appender).setMaxFileSize("2KB");
			logger.addAppender(appender);
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
		// Setup logger level
		logger.setLevel(Level.DEBUG);
		
		//// Request ////
		for(int i=0; i<10; i++) {
			logger.debug("This is debug "+i);
			logger.info("This is info "+i);
			logger.warn("This is warning "+i);
			logger.error("This is error "+i);
			logger.fatal("This is fatal "+i);
		}
	}

	@Test
	public void testConsoleAppenderPatternLayout() {
		
		//// Setup ////
		//
		Logger logger = Logger.getLogger(Test.class);
		// Add a ConsoleAppender that uses PatternLayout using the PatternLayout.TTCC_CONVERSION_PATTERN 
		// 	and prints to System.out to the root category.
		Layout layout = new PatternLayout("%t - %m%n");
		Appender appender = new ConsoleAppender(layout, ConsoleAppender.SYSTEM_OUT);
		logger.addAppender(appender);
		//BasicConfigurator.configure();
		// Setup logger level
		logger.setLevel(Level.INFO);
		
		//// Request ////
		// request to debug, but will not apply, cause of level is info currently
		logger.debug("This is debug");
		// request to info, warn, error, fatal
		logger.info("This is info");
		logger.warn("This is warning");
		logger.error("This is error");
		logger.fatal("This is fatal");
	}

	@Test
	public void testConfigurationFile() {
		
		MyClass myClazz = new MyClass();
		myClazz.MyMethod();
		
	}
	
}
