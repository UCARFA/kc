/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.assignagenda;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;

/**
 * Validate the assignment of a protocol to a agenda.
 */
public class ProtocolAssignToAgendaRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<ProtocolAssignToAgendaEvent> {

    private static final String COMMITTEE_ID_FIELD = "committeeId";
    private static final String ACTION_DATE_FIELD = "actionDate";

    @Override
    public boolean processRules(ProtocolAssignToAgendaEvent event) {
        boolean isValid = true;
        
        if (StringUtils.isBlank(event.getProtocolAssignToAgendaBean().getCommitteeId())) {
            isValid = false;
            reportError(COMMITTEE_ID_FIELD, KeyConstants.ERROR_PROTOCOL_COMMITTEE_NOT_SELECTED);
        }
        
        if (event.getProtocolAssignToAgendaBean().getActionDate() == null) {
            isValid = false;
            reportError(ACTION_DATE_FIELD, KeyConstants.ERROR_PROTOCOL_ASSIGN_TO_AGENDA_NO_ACTION_DATE);
        }
       
        return isValid;
    }
    
}
