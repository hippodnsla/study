package org.hippo.sample.j2ee.dom4j;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
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
	public void testOutputSimpleXMLFile() {
		
		Document document =  DocumentHelper.createDocument();
		document.addElement("root")
					.addElement("class")
							.addAttribute("name", "xml")
							.addAttribute("time", "now");
		
		try {
			
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter writer = new XMLWriter(new FileWriter("target/test.xml"), format);
			
			writer.write(document);
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReadXMLFile() {
		
		XMLPrinter printer = new XMLPrinter();
		Document document = readXMLDocument(new File("src/main/resources/student.xml"));
		
		// Read root
		Element root = document.getRootElement();
		System.out.println(root.getName());
		
		// Iterate
		System.out.println(printer.getElementString(root));
	}
	
	@Test
	public void testQueryXMLFile() {
		
		XMLQuerier querier = new XMLQuerier();
		Document document = readXMLDocument(new File("src/main/resources/student.xml"));
		
		Node[] list = querier.query(document, "//skill");
		for(Node n: list)
			System.out.println("<" + n.getName() + ">"
								+ n.valueOf(".") +
								"</" + n.getName() + ">");
	}
	
	private Document readXMLDocument(File file) {
		
		SAXReader reader = new SAXReader();
		// Read document
		Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}

}
