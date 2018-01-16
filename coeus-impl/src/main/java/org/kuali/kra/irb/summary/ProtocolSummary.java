/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.summary;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProtocolSummary extends org.kuali.kra.protocol.summary.ProtocolSummary {

    private static final long serialVersionUID = -259451094188180892L;
    
    private List<ParticipantSummary> participants = new ArrayList<ParticipantSummary>();
        
    public ProtocolSummary() {
        
    }

    public List<ParticipantSummary> getParticipants() {
        return participants;
    }
    
    public void add(ParticipantSummary participantSummary) {
        participants.add(participantSummary);
    }

    @Override
    public void compare(org.kuali.kra.protocol.summary.ProtocolSummary other) {
        super.compare(other);
        compareParticipants((ProtocolSummary) other);
    }
    
    private void compareParticipants(ProtocolSummary other) {
        for (ParticipantSummary participant : participants) {
            participant.compare(other);
        }
    }
    
    public ParticipantSummary findParticipant(String description) {
        for (ParticipantSummary participant : participants) {
            if (StringUtils.equals(participant.getDescription(), description)) {
                return participant;
            }
        }
        return null;
    }
}
