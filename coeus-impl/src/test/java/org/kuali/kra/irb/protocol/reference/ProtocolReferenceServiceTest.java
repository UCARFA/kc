/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.reference;

import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.irb.Protocol;

import static org.junit.Assert.assertEquals;

public class ProtocolReferenceServiceTest  {
    
    Protocol protocol;
    ProtocolReference protocolReference = new ProtocolReference();
    
    @Before
    public void setUp() throws Exception {
        protocol = new Protocol(){
            @Override
            public void refreshReferenceObject(String referenceObjectName) {}

           
        };
        protocolReference = new ProtocolReference() {
            @Override
            public void refreshReferenceObject(String referenceObjectName) {

            }
        };
           
    }
    
    @Test
    public void testAddProtocolReference() throws Exception {
        
        ProtocolReferenceServiceImpl service = new ProtocolReferenceServiceImpl();
        
        service.addProtocolReference(protocol, protocolReference);
        
        assertEquals(1, protocol.getProtocolReferences().size());
        
    }
}
