package org.hippo.sample.j2ee.log4j;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;
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
	public void testRollingFileAppenderSimpleLayout() {
		
		System.out.println("testFileAppenderSimpleLayout()");
		
		//// Setup ////
		Logger logger = Logger.getLogger(Test.class);
		
		
		try {
			Layout layout = new SimpleLayout();
			Appender appender = new RollingFileAppender(layout, "target/log-filerollingappender-simplelayout.log");
			((RollingFileAppender)appender).setMaxFileSize("1KB");
			logger.addAppender(appender);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		
		// Setup logger level
		logger.setLevel(Level.DEBUG);
		
		//// Request ////
		for(int i=0; i<100; i++) {
			logger.debug("This is debug "+i);
			logger.info("This is info "+i);
			logger.warn("This is warning "+i);
			logger.error("This is error "+i);
			logger.fatal("This is fatal "+i);
		}
	}

	@Test
	public void testWriterAppenderHTMLLayout() {

		System.out.println("testWriterAppenderHTMLLayout()");
		
		//// Setup ////
		Logger logger = Logger.getLogger(Test.class);

		try {
			Layout layout = new HTMLLayout();
			FileOutputStream stream = new FileOutputStream("target/log-writerappender-htmllayout.htm");
			Appender appender = new WriterAppender(layout, stream);
			logger.addAppender(appender);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail();
		}
		
		// Setup logger level
		logger.setLevel(Level.INFO);
		
		//// Request ////
		logger.debug("This is debug");
		logger.info("This is info");
		logger.warn("This is warning");
		logger.error("This is error");
		logger.fatal("This is fatal");
	}

	@Test
	public void testConfigurationFile() {
		
		System.out.println("testConfigurationFile()");
		
		MyClass myClazz = new MyClass();
		myClazz.MyMethod();
		
	}
	
}
