/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.committee.rule.event.CommitteeActionPrintCommitteeDocumentEvent;
import org.kuali.kra.infrastructure.KeyConstants;

/**
 * 
 * This class contains the document rules of the Action Print section.
 */
public class CommitteeActionPrintCommitteeDocumentRule extends KcTransactionalDocumentRuleBase
                                                       implements KcBusinessRule<CommitteeActionPrintCommitteeDocumentEvent> {
    private static final String PRINT_TYPE_FIELD = "committeeHelper.reportType";
    private static final String MEETING_PRINT_TYPE_FIELD = "meetingHelper.reportType";

/**
 * 
 * This method processes the rules of the CommitteeActionPrintCommitteeDocumentEvent.
 * 
 * @param event to be validated against the rules.
 * @return true if validation passed the rules, false otherwise.
 */
    @Override
    public boolean processRules(CommitteeActionPrintCommitteeDocumentEvent event) {
        boolean rulePassed = true;
        
        if (!event.getPrintRooster() && !event.getPrintFutureScheduledMeeting()) {
            if (event.isOnMeetingAction()) {
                reportError(MEETING_PRINT_TYPE_FIELD, KeyConstants.ERROR_COMMITTEE_ACTION_PRINT_REPORT_NOT_SPECIFIED);
            } else {
                reportError(PRINT_TYPE_FIELD, KeyConstants.ERROR_COMMITTEE_ACTION_PRINT_REPORT_NOT_SPECIFIED);
            }
            rulePassed = false;
        }
        
        return rulePassed;
    }

}
