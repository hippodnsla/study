package org.hippo.sample.spring;

import java.lang.reflect.Proxy;

import org.hippo.sample.spring.entity.Entity;
import org.hippo.sample.spring.performacemonitor.PerformaceMonitor;
import org.hippo.sample.spring.performacemonitor.PerformanceHandler;
import org.springframework.util.Assert;

public class Factory {
	
	public static Factory getInstance() {
		if (Factory.self == null)
			Factory.self = new Factory();
		return Factory.self;
	}
	private Factory() {}
	
	public <E extends Entity> E getInstance(Class<E> entityClazz) {
		
		Assert.notNull(entityClazz);
		
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
