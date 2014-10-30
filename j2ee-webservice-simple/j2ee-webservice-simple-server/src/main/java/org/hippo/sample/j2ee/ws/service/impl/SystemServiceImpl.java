package org.hippo.sample.j2ee.ws.service.impl;

import javax.jws.WebService;

import org.hippo.sample.j2ee.ws.manager.ServerManager;
import org.hippo.sample.j2ee.ws.service.SystemService;

@SuppressWarnings("restriction")
@WebService(endpointInterface="org.hippo.sample.j2ee.ws.service.SystemService")
public class SystemServiceImpl implements SystemService {

	public boolean shutdown() {
		serverManager.getServerInstance().setShutdownNow(true);
		return true;
	}
	
	public ServerManager getServerManager() {
		return serverManager;
	}
	public void setServerManager(ServerManager serverManager) {
		this.serverManager = serverManager;
	}
	
	private ServerManager serverManager;
}
