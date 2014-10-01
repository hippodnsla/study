package org.hippo.sample.spring.model;

import java.io.Serializable;

public interface Entity extends Serializable {
	
	long getId();
	
	void setId(long id);
}
