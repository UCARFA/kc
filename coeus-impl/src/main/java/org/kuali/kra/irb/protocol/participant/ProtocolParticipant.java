/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.participant;

import org.kuali.kra.protocol.ProtocolAssociateBase;

/**
 * 
 * This class implements the protocol participant object.
 * 
 * @author Kuali Research Administration Team (kc.dev@kuali.org)
 */
public class ProtocolParticipant extends ProtocolAssociateBase {


    private static final long serialVersionUID = 1716821047021762233L;

    private Long protocolParticipantId;

    private String participantTypeCode;

    private Integer participantCount;

    private ParticipantType participantType;

    public ProtocolParticipant() {
    }

    public Long getProtocolParticipantId() {
        return protocolParticipantId;
    }

    public void setProtocolParticipantId(Long protocolParticipantId) {
        this.protocolParticipantId = protocolParticipantId;
    }

    public String getParticipantTypeCode() {
        return participantTypeCode;
    }

    public void setParticipantTypeCode(String participantTypeCode) {
        this.participantTypeCode = participantTypeCode;
    }

    public Integer getParticipantCount() {
        return (participantCount == null) ? 0 : participantCount;
    }

    public void setParticipantCount(Integer participantCount) {
        this.participantCount = participantCount;
    }

    public void setParticipantType(ParticipantType participantType) {
        this.participantType = participantType;
    }

    public ParticipantType getParticipantType() {
        return participantType;
    }

    @Override
    public void resetPersistenceState() {
        this.setProtocolParticipantId(null);
    }
}
