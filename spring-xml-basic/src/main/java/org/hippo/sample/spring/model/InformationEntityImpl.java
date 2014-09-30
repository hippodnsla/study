package org.hippo.sample.spring.model;

public class InformationEntityImpl implements InformationEntity {

	private static final long serialVersionUID = 1L;
	
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	private String information;
	private long id;
	

}
