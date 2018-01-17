/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.kra.infrastructure.KeyConstants;

import java.util.List;

/**
 * Defines the rule that a user cannot delete an Other Action if it is being used in a Minute entry.
 */
public class MeetingDeleteOtherRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<MeetingDeleteOtherEvent> {

    /**
     * Checks to see whether the Other Action being deleted is being used by any of the Minute entries.
     * 
     * @see org.kuali.coeus.sys.framework.rule.KcBusinessRule#processRules(org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension)
     */
    @Override
    public boolean processRules(MeetingDeleteOtherEvent event) {
        boolean rulePassed = true;
        ErrorReporter errorReporter = KcServiceLocator.getService(ErrorReporter.class);
        
        int itemNumber = event.getOtherNumber();
        CommScheduleActItemBase deletedCommScheduleActItem = event.getMeetingHelper().getCommitteeSchedule().getCommScheduleActItems().get(itemNumber);
        List<? extends CommitteeScheduleMinuteBase> committeeScheduleMinutes = event.getMeetingHelper().getCommitteeSchedule().getCommitteeScheduleMinutes();
        for (CommitteeScheduleMinuteBase committeeScheduleMinute : committeeScheduleMinutes) {
            if (deletedCommScheduleActItem.equals(committeeScheduleMinute.getCommScheduleActItem())) {
                errorReporter.reportError("meetingHelper.newOtherAction.", KeyConstants.ERROR_CANNOT_DELETE_ACTION_ITEM_IN_USE);
                rulePassed = false;
            }
        }
        
        return rulePassed;
    }

}
