package org.hippo.sample.j2ee.ws.manager;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

@SuppressWarnings("restriction")
public class ServiceManager {

	public ServiceManager() {
		this.services = new HashMap<Class<?>, Object>();
		this.endpoints = new HashMap<Class<?>, Endpoint>();
	}
	
	public void register(Class<?> serviceType) {
		Object serviceInstance = null;
		try {
			serviceInstance = serviceType.newInstance();
		} catch (InstantiationException e) {
			throw new IllegalArgumentException(e);
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException(e);
		}
		Endpoint p = Endpoint.publish(address.toString()+"/"+serviceType.getSimpleName(), serviceInstance);
		services.put(serviceType, serviceInstance);
		endpoints.put(serviceType, p);
	}
	
	public Object getServiceInstance(Class<?> serviceType) {
		return services.get(serviceType);
	}
	
	public Endpoint getServiceEndpoint(Class<?> serviceType) {
		return endpoints.get(serviceType);
	}
	
	public URL getAddress() {
		return address;
	}
	public void setAddress(URL address) {
		this.address = address;
	}
	
	private Map<Class<?>, Object> services;
	private Map<Class<?>, Endpoint> endpoints;
	private URL address;
}
