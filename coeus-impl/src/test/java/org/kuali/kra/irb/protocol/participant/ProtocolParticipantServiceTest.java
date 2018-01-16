/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.participant;

import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.irb.Protocol;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class ProtocolParticipantServiceTest {

    private Protocol protocol;

    @Before
    public void setUp() {

        ProtocolParticipant protocolParticipant1 = new ProtocolParticipant() {
            @Override
            public void refreshReferenceObject(String referenceObjectName) {

            }
        };
        protocolParticipant1.setParticipantTypeCode("1");
        protocolParticipant1.setParticipantCount(15);

        ProtocolParticipant protocolParticipant2 = new ProtocolParticipant() {
            @Override
            public void refreshReferenceObject(String referenceObjectName) {

            }
        };
        protocolParticipant2.setParticipantTypeCode("2");
        protocolParticipant2.setParticipantCount(25);

        ProtocolParticipant protocolParticipant3 = new ProtocolParticipant() {
            @Override
            public void refreshReferenceObject(String referenceObjectName) {

            }
        };
        protocolParticipant3.setParticipantTypeCode("3");
        protocolParticipant3.setParticipantCount(35);

        protocol = new Protocol(){
            @Override
            public void refreshReferenceObject(String referenceObjectName) {}    
        };
        protocol.setProtocolParticipants(new ArrayList<ProtocolParticipant>());
        protocol.getProtocolParticipants().add(protocolParticipant1);
        protocol.getProtocolParticipants().add(protocolParticipant2);
        protocol.getProtocolParticipants().add(protocolParticipant3);
    }

    @Test
    public void testAddProtocolParticipant() {
        ProtocolParticipant protocolParticipant = new ProtocolParticipant() {
            @Override
            public void refreshReferenceObject(String referenceObjectName) {

            }
        };
        protocolParticipant.setParticipantTypeCode("4");

        final ProtocolParticipantServiceImpl protocolParticipantService = new ProtocolParticipantServiceImpl();

        protocolParticipantService.addProtocolParticipant(protocol, protocolParticipant);
        
        int participantSize = protocol.getProtocolParticipants().size();
        assertTrue("participant size is " + participantSize, participantSize == 4);
        String participantCode1 = protocol.getProtocolParticipant(0).getParticipantTypeCode();
        assertTrue("participant type code of participant 1 is " + participantCode1, "1".equals(participantCode1));
        String participantCode2 = protocol.getProtocolParticipant(1).getParticipantTypeCode();
        assertTrue("participant type code of participant 2 is " + participantCode2, "2".equals(participantCode2));
        String participantCode3 = protocol.getProtocolParticipant(2).getParticipantTypeCode();
        assertTrue("participant type code of participant 3 is " + participantCode3, "3".equals(participantCode3));
        String participantCode4 = protocol.getProtocolParticipant(3).getParticipantTypeCode();
        assertTrue("participant type code of participant 4 is " + participantCode4, "4".equals(participantCode4));
        
    }

}
