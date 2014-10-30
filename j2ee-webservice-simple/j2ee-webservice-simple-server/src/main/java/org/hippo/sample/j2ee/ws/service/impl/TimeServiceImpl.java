package org.hippo.sample.j2ee.ws.service.impl;

import javax.jws.WebService;

import org.hippo.sample.j2ee.ws.service.TimeService;
import org.joda.time.DateTime;

@SuppressWarnings("restriction")
@WebService(endpointInterface="org.hippo.sample.j2ee.ws.service.TimeService")
public class TimeServiceImpl implements TimeService {

	public DateTime getCOBDate() {
		return new DateTime();
	}

}
