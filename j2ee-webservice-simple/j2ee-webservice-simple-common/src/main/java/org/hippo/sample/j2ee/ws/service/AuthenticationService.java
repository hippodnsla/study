package org.hippo.sample.j2ee.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.hippo.sample.j2ee.ws.model.Session;

@SuppressWarnings("restriction")
@WebService
@SOAPBinding(style=Style.RPC)
public interface AuthenticationService {

	@WebMethod
	Session login(String username, String password);
	
	@WebMethod
	void logout(Session session);
}
