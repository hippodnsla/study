package org.hippo.sample.j2ee.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;

import org.hippo.sample.j2ee.ws.client.wsclient.AuthenticationServiceClient;
import org.hippo.sample.j2ee.ws.client.wsclient.SystemServiceClient;
import org.hippo.sample.j2ee.ws.client.wsclient.TimeServiceClient;
import org.hippo.sample.j2ee.ws.model.Session;
import org.joda.time.DateTime;

public class Driver {

	public static void main(String[] args) throws MalformedURLException {
		
		Scanner input = new Scanner(System.in);
		
		TimeServiceClient timeServiceClient = new TimeServiceClient(
				new URL("http://localhost:9876/webservice/TimeServiceImpl?wsdl"), 
				new QName("http://impl.service.ws.j2ee.sample.hippo.org/", "TimeServiceImplService"));
		SystemServiceClient systemServiceClient = new SystemServiceClient(
				new URL("http://localhost:9876/webservice/SystemServiceImpl?wsdl"), 
				new QName("http://impl.service.ws.j2ee.sample.hippo.org/", "SystemServiceImplService"));
		AuthenticationServiceClient authenticationServiceClient = new AuthenticationServiceClient(
				new URL("http://localhost:9876/webservice/AuthenticationServiceImpl?wsdl"), 
				new QName("http://impl.service.ws.j2ee.sample.hippo.org/", "AuthenticationServiceImplService"));
		
		System.out.println("Please input your command:");
		while (true) {
			String line = input.next();
			
			if (line.equalsIgnoreCase("help")) {
				System.out.println("help, exit, cobdate, shutdown, login, logout");
			}
			if (line.equalsIgnoreCase("exit")) {
				System.exit(-1);
			}
			if (line.equalsIgnoreCase("cobdate")) {
				DateTime cobdate = timeServiceClient.getCOBDate();
				System.out.println(cobdate);
			}
			if (line.equalsIgnoreCase("shutdown")) {
				boolean isShutdownNow = systemServiceClient.shutdown();
				if (isShutdownNow)
					System.out.println("Server shutting down...");
			}
			if (line.contains("login")) {
				int begin = line.indexOf('(')+1;
				int end = line.indexOf(')');
				line = line.substring(begin, end);
				String[] data = line.split(",");
				Session session = authenticationServiceClient.login(data[0], data[1]);
				System.out.println("Welcome "+session.getUser().getUsername()+"!");
				System.out.println("current session id is: "+session.getId());
			}
		}
		
	}

}
