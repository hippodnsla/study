package org.hippo.sample.j2se;

import java.lang.reflect.Proxy;

import org.hippo.sample.j2se.entity.Entity;
import org.hippo.sample.j2se.performacemonitor.PerformaceMonitor;
import org.hippo.sample.j2se.performacemonitor.PerformanceHandler;

public class Factory {
	
	public static Factory getInstance() {
		if (Factory.self == null)
			Factory.self = new Factory();
		return Factory.self;
	}
	private Factory() {}
	
	public <E extends Entity> E getInstance(Class<E> entityClazz) {
		
		if (entityClazz == null)
			throw new IllegalArgumentException();
		
		E proxy = null;
		try {
			
			E target = entityClazz.newInstance();
			
			PerformanceHandler handler = getInstanceOfPerformanceHandler(
					target,
					getInstanceOfPerformaceMonitor());
			
			Object obj = Proxy.newProxyInstance(
					entityClazz.getClassLoader(),
					entityClazz.getInterfaces(),
					handler);
			
			if (obj == null /*|| obj.getClass() != entityClazz*/) {
				throw new IllegalStateException();
			}
			
			proxy = (E) obj;
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return proxy;
	}
	
	public PerformaceMonitor getInstanceOfPerformaceMonitor() {
		return new PerformaceMonitor();
	}
	
	public PerformanceHandler getInstanceOfPerformanceHandler(
			Object target, PerformaceMonitor monitor) {
		return new PerformanceHandler(target, monitor);
	}
	
	private static Factory self;
}
