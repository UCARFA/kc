/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.participant;

import org.kuali.kra.irb.Protocol;

/**
 * 
 * This interface describes the service API to maintain the <code>{@link ProtocolParticipant}</code>s of a
 * <code>{@link Protocol}</code>.
 * 
 * @author Kuali Research Administration Team (kc.dev@kuali.org)
 */
public interface ProtocolParticipantService {

    /**
     * This method adds the ProtocolParticipant to the List of ProtocolParticipants along with the 
     * appropriate ParticipantType.
     * 
     * @param protocol which contains list of ProtocolParticipant.
     * @param protocolParticipant which is added to ProtocolParticipants list after setting ParticipantType.
     */
    void addProtocolParticipant(Protocol protocol, ProtocolParticipant protocolParticipant);

}
