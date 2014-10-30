package org.hippo.sample.j2ee.ws.model;

import java.net.URL;

public class ClientSession {

	public URL getAddress() {
		return address;
	}
	public void setAddress(URL address) {
		this.address = address;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	private URL address;
	private Session session;
}
