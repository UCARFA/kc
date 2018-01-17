/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.participant;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.irb.ProtocolDocument;

import java.util.List;

/**
 * This class represents the event when a <code>{@link ProtocolParticipant}</code> is added to a 
 * <code>{@link Protocol}</code>.
 * 
 * @author Kuali Research Administration Team (kc.dev@kuali.org)
 */
public class AddProtocolParticipantEvent extends KcDocumentEventBaseExtension {
    
    private static final String NEW_PROTOCOL_PARTICIPANT_FIELD = "protocolHelper.newProtocolParticipant";
    
    private ProtocolParticipant newProtocolParticipant;
    private List<ProtocolParticipant> protocolParticipants;
    
    /**
     * Constructs a <code>{@link AddProtocolParticipantEvent}</code>.
     * 
     * @param errorPathPrefix
     * @param document
     * @param newProtocolParticipant
     * @param existingProtocolParticipants
     */
    public AddProtocolParticipantEvent(ProtocolDocument document, ProtocolParticipant newProtocolParticipant, 
            List<ProtocolParticipant> protocolParticipants) {
        super("Adding ProtocolParticipant to document " + getDocumentId(document), NEW_PROTOCOL_PARTICIPANT_FIELD, document);
    
        this.newProtocolParticipant = newProtocolParticipant;
        this.protocolParticipants = protocolParticipants;
    }
    
    public ProtocolParticipant getNewProtocolParticipant() {
        return newProtocolParticipant;
    }
    
    public List<ProtocolParticipant> getProtocolParticipants() {
        return protocolParticipants;
    }

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new AddProtocolParticipantRule();
    }
    
}
