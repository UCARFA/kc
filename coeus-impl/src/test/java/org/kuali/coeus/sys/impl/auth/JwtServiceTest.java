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
package org.kuali.coeus.sys.impl.auth;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.auth.JwtService;

public class JwtServiceTest {
    boolean enabled = false;
    boolean singleUse = false;

    class MockJwtServiceImpl extends JwtServiceImpl {
        @Override
        protected boolean isService2serviceEnabled() {
            return enabled;
        }

        @Override
        protected String getServiceSecret() {
            return "secret";
        }

        @Override
        protected boolean isSingleUse() {
            return singleUse;
        }

        @Override
        protected String getSystemAuthToken() {
            return "TEST_SYSTEM_AUTH_TOKEN";
        }
    }


    @Test
    public void createTokenWithService2ServiceDisabled() {
        enabled = false;
        singleUse = false;
        JwtService jwtService = new MockJwtServiceImpl();
        String jwt = jwtService.createToken();
        assertEquals("should return the configuration system auth Token", "TEST_SYSTEM_AUTH_TOKEN", jwt);
    }

    @Test
    public void createTokenWithService2ServiceEnabledSingleUseDisabled() {
        enabled = true;
        singleUse = false;
        JwtService jwtService = new MockJwtServiceImpl();
        String jwt = jwtService.createToken();
        boolean verified = jwtService.verifyToken(jwt);
        boolean secondVerification = jwtService.verifyToken(jwt);
        assertEquals("should verify jwt on first attempt", true, verified);
        assertEquals("should verify jwt on second attempt", true, secondVerification);
    }

    @Test
    public void createTokenWithService2ServiceEnabledSingleUseEnabled() {
        enabled = true;
        singleUse = true;
        JwtService jwtService = new MockJwtServiceImpl();
        String jwt = jwtService.createToken();
        boolean verified = jwtService.verifyToken(jwt);
        boolean secondVerification = jwtService.verifyToken(jwt);
        assertEquals("should verify jwt on first attempt", true, verified);
        assertEquals("should not verify jwt on second attempt", false, secondVerification);
    }
}

