package org.hippo.sample.j2ee.ws.service.impl;

import javax.jws.WebService;

import org.hippo.sample.j2ee.ws.manager.ClientManager;
import org.hippo.sample.j2ee.ws.model.Session;
import org.hippo.sample.j2ee.ws.service.AuthenticationService;

@SuppressWarnings("restriction")
@WebService(endpointInterface="org.hippo.sample.j2ee.ws.service.AuthenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	public Session login(String username, String password) {
		return clientManager.login(username, password);
	}
	
	public void logout(Session session) {
		clientManager.logout(session);
	}

	public ClientManager getClientManager() {
		return clientManager;
	}

	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}
	
	private ClientManager clientManager;
}
