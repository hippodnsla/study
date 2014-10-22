package org.hippo.sample.j2se.performacemonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {

	public PerformanceHandler(Object target, PerformaceMonitor monitor) {
		this.target = target;
		this.monitor = monitor;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		monitor.begin();
		
		Object ret = method.invoke(target, args);
		
		monitor.end();
		
		return ret;
	}
	
	private Object target;
	private PerformaceMonitor monitor;
}
