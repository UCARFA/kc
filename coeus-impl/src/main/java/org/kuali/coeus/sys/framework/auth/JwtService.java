/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.auth;


public interface JwtService {
    /**
     * This method validates the authorization header when service2service is enabled.
     * If it can't be validated or service2service is disabled it returns false;
     * The authToken must be formatted as "<authorization prefrix> <jwt> to validate.
     *
     * @param authToken expects authorization prefix followed by a valid jwt
     * @return boolean.
     */
    boolean verifyToken(String authToken);

    /**
     * This method generates a valid jwt based on a shared secret if service2service is enabled.
     * If service2service is disabled it returns configured system auth token
     *
     * @return String jwt.
     */
    String createToken();
}

