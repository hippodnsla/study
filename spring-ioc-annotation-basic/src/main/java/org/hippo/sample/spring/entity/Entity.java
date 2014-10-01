package org.hippo.sample.spring.entity;

import java.io.Serializable;

public interface Entity extends Serializable {
	
	long getId();
	
	void setId(long id);
}
