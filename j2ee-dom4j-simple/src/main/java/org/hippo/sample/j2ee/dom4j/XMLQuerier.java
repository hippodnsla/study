package org.hippo.sample.j2ee.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

public class XMLQuerier {

	public Node[] query(Document document, String select) {
		List<Node> list = document.selectNodes(select);
		return list.toArray(new Node[list.size()]);
	}
	
}
