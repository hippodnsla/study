package org.hippo.sample.j2ee.ws.manager;

import org.hippo.sample.j2ee.ws.server.Server;

public class ServerManager {
	
	public Server getServerInstance() {
		return serverInstance;
	}

	public void setServerInstance(Server serverInstance) {
		this.serverInstance = serverInstance;
	}
	
	private Server serverInstance;

	
}
