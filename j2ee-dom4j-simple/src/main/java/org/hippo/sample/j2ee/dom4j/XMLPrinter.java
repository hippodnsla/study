package org.hippo.sample.j2ee.dom4j;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;


public class XMLPrinter {

	
	public String getElementString(Element element) {
		return getElementString(element, 0);
	}
	
	private String getElementString(Element element, int level) {
		String content = "";
		// Print Head, Properties
		content += getElementHeadString(element);
		// Print Content
		content += getElementContentString(element);
		// Print Sub-elements
		List<Element> list = element.elements();
		for(int i=0; i<list.size(); i++)
			content += "\n" + getElementString(list.get(i), level+1);
		// Print Tail
		content += getElementTailString(element) + "\n";
		// Print Tabs
		for(int i=0; i<level; i++)
			content = "\t" + content;
		return content;
	}
	
	private String getElementHeadString(Element e) {
		return "<" + e.getName() + getAttributesString(e) + ">";
	}
	private String getElementContentString(Element e) {
		return e.getData().toString().trim();
	}
	private String getElementTailString(Element e) {
		return "</"+ e.getName() +">";
	}
	
	private String getAttributesString(Element e) {
		String content = "";
		List<Attribute> list = e.attributes();
		for(int i=0; i<list.size(); i++)
			content += " "+getAttributeString(list.get(i));
		return content;
	}
	private String getAttributeString(Attribute a) {
		return a.getName() + "=" +
				"\"" + a.getData() + "\"";
	}

}
