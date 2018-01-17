/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.rest;

import org.springframework.http.HttpHeaders;

public interface AuthServiceRestUtilService {

	/**
	 * Gets auth server style headers for the given version. Depends on there being an active usersession that was authenticated via AuthServiceFilter.
	 * @return Headers for connecting to auth service style rest endpoints. Will contain invalid/blank authentication token in the case that
	 * a valid user session does not exist.
	 */
	HttpHeaders getAuthServiceStyleHttpHeadersForUser();
	
	HttpHeaders getAuthServiceStyleHttpHeadersForToken(String authToken);
}
