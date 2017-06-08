/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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

