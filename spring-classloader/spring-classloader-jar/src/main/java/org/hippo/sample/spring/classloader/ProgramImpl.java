package org.hippo.sample.spring.classloader;

public class ProgramImpl implements Program {

	public Entity function(String content) {
		Entity e = new Entity();
		e.setContent(content);
		return e;
	}
}
