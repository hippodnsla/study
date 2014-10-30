package org.hippo.sample.j2ee.ws.server;

import java.net.MalformedURLException;
import java.net.URL;

import org.hippo.sample.j2ee.ws.manager.ClientManager;
import org.hippo.sample.j2ee.ws.manager.ServerManager;
import org.hippo.sample.j2ee.ws.manager.ServiceManager;
import org.hippo.sample.j2ee.ws.service.impl.AuthenticationServiceImpl;
import org.hippo.sample.j2ee.ws.service.impl.SystemServiceImpl;
import org.hippo.sample.j2ee.ws.service.impl.TimeServiceImpl;

public class Server implements Runnable {

	public Server() {
		this.serviceManager = new ServiceManager();
		this.serverManager = new ServerManager();
		this.clientManager = new ClientManager();
		configure();
	}
	
	public void run() {
		try {
			while (!isShutdownNow) {
//				Thread.currentThread().wait(5000);
				Thread.sleep(5000);
				System.out.println("Running....");
			}
			System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void initilize() {
		configure();
	}
	
	private void configure() {
		
		try {
			serviceManager.setAddress(new URL("http://localhost:9876/webservice"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		serviceManager.register(AuthenticationServiceImpl.class);
		serviceManager.register(TimeServiceImpl.class);
		serviceManager.register(SystemServiceImpl.class);
		
		((SystemServiceImpl) serviceManager.getServiceInstance(SystemServiceImpl.class))
				.setServerManager(serverManager);
		((AuthenticationServiceImpl) serviceManager.getServiceInstance(AuthenticationServiceImpl.class))
				.setClientManager(clientManager);
		
		serverManager.setServerInstance(this);
	}
	
	public boolean isShutdownNow() {
		return isShutdownNow;
	}

	public synchronized void setShutdownNow(boolean isShutdownNow) {
		this.isShutdownNow = isShutdownNow;
		this.notify();
	}
	
	private ClientManager clientManager;
	private ServerManager serverManager;
	private ServiceManager serviceManager;
	
	private boolean isShutdownNow;
	
}
