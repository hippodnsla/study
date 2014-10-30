package org.hippo.sample.j2ee.ws.client.wsclient;

import java.net.URL;

import javax.xml.ws.Service;
import javax.xml.namespace.QName;

import org.hippo.sample.j2ee.ws.service.TimeService;
import org.joda.time.DateTime;

@SuppressWarnings("restriction")
public class TimeServiceClient implements TimeService {

	public TimeServiceClient(URL url, QName qname) {
		super();
		Service service = Service.create(url, qname);
		this.service = service.getPort(TimeService.class);
	}

	public DateTime getCOBDate() {
		return this.service.getCOBDate();
	}
	
	private TimeService service;
}
