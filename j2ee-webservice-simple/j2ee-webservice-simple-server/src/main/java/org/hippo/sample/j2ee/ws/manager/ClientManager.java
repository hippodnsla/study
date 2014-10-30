package org.hippo.sample.j2ee.ws.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hippo.sample.j2ee.ws.model.ClientSession;
import org.hippo.sample.j2ee.ws.model.Session;
import org.hippo.sample.j2ee.ws.model.User;

public class ClientManager {

	public ClientManager() {
		this.clientSessions = new ArrayList<ClientSession>();
	}
	
	public Session login(String username, String password) {
		
		User user = getUser(username, password);
		
		Session session = new Session();
		session.setUser(user);
		session.setId(UUID.randomUUID().getLeastSignificantBits());
		
		ClientSession clientSession = new ClientSession();
		clientSession.setSession(session);
		clientSessions.add(clientSession);
		
		return session;
	}
	
	public void logout(Session session) {
		for(ClientSession clientSession: clientSessions) {
			if (clientSession.getSession().equals(session))
				clientSessions.remove(clientSession);
		}
	}
	
	private User getUser(String username, String password) {
		User user = null;
		if (username.equals("root") && password.equals("password")) {
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
		}
		return user;
	}
	
	private List<ClientSession> clientSessions;
}
