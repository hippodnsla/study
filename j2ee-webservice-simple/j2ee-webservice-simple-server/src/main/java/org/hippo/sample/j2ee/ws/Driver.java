package org.hippo.sample.j2ee.ws;

import org.hippo.sample.j2ee.ws.server.Server;

public class Driver {

	public static void main(String[] args) {
		
		Thread t = new Thread(new Server());
		t.start();

	}

}
