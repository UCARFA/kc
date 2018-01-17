/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.location;

import org.junit.Test;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import static org.junit.Assert.assertEquals;

public class ProtocolLocationServiceTest extends KcIntegrationTestBase {
    protected static final String NEW_ORGANIZATION_VALUE =  "000004";
    
    /**
     * This method is to add a new protocol location
     * @throws Exception
     */
    @Test
    public void testAddProtocolLocation() throws Exception {
        
        ProtocolLocationService service  = new ProtocolLocationServiceImpl();
        
        Protocol protocol = new Protocol(){
            @Override
            public void refreshReferenceObject(String referenceObjectName) {}
            
        };
        
        service.addProtocolLocation(protocol, getNewProtocolLocation() );

        assertEquals(1, protocol.getProtocolLocations().size());
        
    }

    /**
     * This method is to get a new protocol location data
     * @return ProtocolLocation
     */
    private ProtocolLocation getNewProtocolLocation() {
        ProtocolLocation protocolLocation = new ProtocolLocation();
        protocolLocation.setOrganizationId(NEW_ORGANIZATION_VALUE);
        return protocolLocation;
        
    }

}
