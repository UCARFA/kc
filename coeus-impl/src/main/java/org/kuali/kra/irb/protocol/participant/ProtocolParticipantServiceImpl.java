/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.participant;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.irb.Protocol;

/**
 * 
 * This class implements the services to maintain the <code>{@link ProtocolParticipant}</code>s of a 
 * <code>{@link Protocol}</code>.
 * 
 * @author Kuali Research Administration Team (kc.dev@kuali.org)
 */
public class ProtocolParticipantServiceImpl implements ProtocolParticipantService {

    /**
     * This method adds the ProtocolParticipant to the List of ProtocolParticipants along with the 
     * appropriate ParticipantType.
     * 
     * @param protocol which contains list of ProtocolParticipant.
     * @param protocolParticipant which is added to ProtocolParticipants list after setting ParticipantType.
     */
    @Override
    public void addProtocolParticipant(Protocol protocol, ProtocolParticipant protocolParticipant) {
        protocolParticipant.setProtocol(protocol);
        if (StringUtils.isBlank(protocolParticipant.getProtocolNumber())) {
            protocolParticipant.setProtocolNumber("0");
        }
        protocolParticipant.refreshReferenceObject("participantType");
        protocol.getProtocolParticipants().add(protocolParticipant);
    }

}
