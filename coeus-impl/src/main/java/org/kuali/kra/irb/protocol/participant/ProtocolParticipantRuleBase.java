/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.participant;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.kns.service.DictionaryValidationService;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;

/**
 * This class contains the rules to validate a <code>{@link ProtocolParticipant}</code>.
 * 
 * @author Kuali Research Administration Team (kc.dev@kuali.org)
 */
public class ProtocolParticipantRuleBase extends KcTransactionalDocumentRuleBase {
    
    private static final String DOT = ".";
    
    private static final String PARTICIPANT_TYPE_CODE_FIELD = "participantTypeCode";
    private DictionaryValidationService dictionaryValidationService;
    /**
     * ProcessDefinitionDefinitionDefinition the validation rules for an <code>{@link AddProtocolParticipantEvent}</code>
     * Participants with an invalid participant type code, duplicate participants (i.e. same
     * participant type code), or where the participant count is a non-positive number are not allowed.
     * 
     * @param addProtocolParticipantEvent
     * @return <code>true</code> if valid, <code>false</code> otherwise
     */
    public boolean processAddProtocolParticipantEvent(AddProtocolParticipantEvent addProtocolParticipantEvent) {
        boolean rulePassed = true;
        
        ProtocolParticipant newProtocolParticipant = addProtocolParticipantEvent.getNewProtocolParticipant();
        List<ProtocolParticipant> protocolParticipants = addProtocolParticipantEvent.getProtocolParticipants();
        String errorPath = addProtocolParticipantEvent.getErrorPathPrefix();
        getKnsDictionaryValidationService().validateBusinessObject(newProtocolParticipant);
        rulePassed &= GlobalVariables.getMessageMap().hasNoErrors();

        rulePassed &= validateUniqueParticipantType(newProtocolParticipant, protocolParticipants, errorPath);
        
        return rulePassed;
    }
    
    private boolean validateUniqueParticipantType(ProtocolParticipant newProtocolParticipant, List<ProtocolParticipant> protocolParticipants, 
            String errorPath) {
        
        boolean isValid = true;
        
        for (ProtocolParticipant protocolParticipant : protocolParticipants) {
            if (StringUtils.equals(protocolParticipant.getParticipantTypeCode(), newProtocolParticipant.getParticipantTypeCode())) {
                isValid = false;
                reportError(errorPath + DOT + PARTICIPANT_TYPE_CODE_FIELD, KeyConstants.ERROR_PROTOCOL_PARTICIPANT_TYPE_DUPLICATE);
                break;
            }
        }
        
        return isValid;
    }

    @Override
    protected DictionaryValidationService getKnsDictionaryValidationService() {
        if (this.dictionaryValidationService == null) {
            this.dictionaryValidationService = KNSServiceLocator.getKNSDictionaryValidationService();
        }
        return this.dictionaryValidationService;
    }

}
