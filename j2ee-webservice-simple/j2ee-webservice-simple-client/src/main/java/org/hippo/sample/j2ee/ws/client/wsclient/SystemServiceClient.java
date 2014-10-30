package org.hippo.sample.j2ee.ws.client.wsclient;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.hippo.sample.j2ee.ws.service.SystemService;

@SuppressWarnings("restriction")

public class SystemServiceClient implements SystemService {

	public SystemServiceClient(URL url, QName qname) {
		super();
		Service service = Service.create(url, qname);
		this.service = service.getPort(SystemService.class);
	}
	
	public boolean shutdown() {
		return this.service.shutdown();
	}

	private SystemService service;

	
}
