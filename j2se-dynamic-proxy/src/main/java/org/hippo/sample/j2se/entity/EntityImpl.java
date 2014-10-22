package org.hippo.sample.j2se.entity;

public class EntityImpl implements Entity {

	private static final long serialVersionUID = -6099608801471719073L;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	@Override
	public String toString() {
		return id+" ["+obj+"]";
	}
	
	private Object obj;
	private long id;

}
