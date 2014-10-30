package org.hippo.sample.j2ee.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.joda.time.DateTime;

@SuppressWarnings("restriction")
@WebService
@SOAPBinding(style=Style.RPC)
public interface TimeService {
	
	@WebMethod
	DateTime getCOBDate();
	
}
