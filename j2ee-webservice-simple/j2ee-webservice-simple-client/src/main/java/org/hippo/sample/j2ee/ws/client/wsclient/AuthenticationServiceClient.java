package org.hippo.sample.j2ee.ws.client.wsclient;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.hippo.sample.j2ee.ws.model.Session;
import org.hippo.sample.j2ee.ws.service.AuthenticationService;

@SuppressWarnings("restriction")
public class AuthenticationServiceClient implements AuthenticationService {

	public AuthenticationServiceClient(URL url, QName qname) {
		super();
		Service service = Service.create(url, qname);
		this.service = service.getPort(AuthenticationService.class);
	}
	
	public Session login(String username, String password) {
		return this.service.login(username, password);
	}

	public void logout(Session session) {
		this.service.logout(session);
	}
	
	private AuthenticationService service;
}
