/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.rest;


import org.kuali.coeus.sys.framework.auth.AuthServiceUserLoginFilter;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.rest.AuthServiceRestUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component("authServiceRestUtilService")
public class AuthServiceRestUtilServiceImpl implements AuthServiceRestUtilService {

	private static final String AUTHORIZATION_PREFIX = "Bearer ";
	private static final String AUTHORIZATION_HEADER_NAME = "Authorization";
	
	@Autowired
	@Qualifier("globalVariableService")
	private GlobalVariableService globalVariableService;
	
	@Override
	public HttpHeaders getAuthServiceStyleHttpHeadersForUser() {
		return getAuthServiceStyleHttpHeadersForToken(getAuthTokenValueForCurrentUser());
	}

	@Override
	public HttpHeaders getAuthServiceStyleHttpHeadersForToken(final String authTokenValueForCurrentUser) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(AUTHORIZATION_HEADER_NAME, authTokenValueForCurrentUser.startsWith(AUTHORIZATION_PREFIX) 
				? authTokenValueForCurrentUser 
				: AUTHORIZATION_PREFIX + authTokenValueForCurrentUser);
		return headers;
	}
	
	protected String getAuthTokenValueForCurrentUser() {
		return AuthServiceUserLoginFilter.getAuthToken(globalVariableService.getUserSession());
	}

	public GlobalVariableService getGlobalVariableService() {
		return globalVariableService;
	}

	public void setGlobalVariableService(GlobalVariableService globalVariableService) {
		this.globalVariableService = globalVariableService;
	}

}
