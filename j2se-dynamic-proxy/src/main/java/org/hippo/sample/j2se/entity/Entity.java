package org.hippo.sample.j2se.entity;

import java.io.Serializable;

public interface Entity extends Serializable {
	long getId();
	void setId(long id);
}
