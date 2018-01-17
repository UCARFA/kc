/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.auth;

import javax.servlet.http.HttpServletRequest;

import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.web.filter.UserLoginFilter;

public class AuthServiceUserLoginFilter extends UserLoginFilter {
	
	@Override
	public void updateUserSession(UserSession userSession, HttpServletRequest request) {
		if (userSession != null) {
			String authToken = (String) request.getSession().getAttribute(AuthServiceFilter.AUTH_SERVICE_FILTER_AUTH_TOKEN_SESSION_ATTR);
			AuthUser authUser = (AuthUser) request.getSession().getAttribute(AuthServiceFilter.AUTH_SERVICE_FILTER_AUTHED_USER_ATTR);
			if (authToken != null) {
				userSession.addObject(AuthServiceFilter.AUTH_SERVICE_FILTER_AUTH_TOKEN_SESSION_ATTR, authToken);
			} else {
				userSession.removeObject(AuthServiceFilter.AUTH_SERVICE_FILTER_AUTH_TOKEN_SESSION_ATTR);
			}
			if (authUser != null) {
				userSession.addObject(AuthServiceFilter.AUTH_SERVICE_FILTER_AUTHED_USER_ATTR, authUser);
			} else {
				userSession.removeObject(AuthServiceFilter.AUTH_SERVICE_FILTER_AUTHED_USER_ATTR);
			}
	        GlobalVariables.setUserSession(userSession);
		}
	}
	
	public static String getAuthToken(UserSession userSession) {
		return (String) userSession.getObjectMap().get(AuthServiceFilter.AUTH_SERVICE_FILTER_AUTH_TOKEN_SESSION_ATTR);
	}
	
	public static AuthUser getAuthUserObject(UserSession userSession) {
		return (AuthUser) userSession.getObjectMap().get(AuthServiceFilter.AUTH_SERVICE_FILTER_AUTHED_USER_ATTR);
	}
}
