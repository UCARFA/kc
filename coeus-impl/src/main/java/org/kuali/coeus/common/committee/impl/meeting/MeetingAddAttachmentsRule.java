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
import org.kuali.kra.infrastructure.KeyConstants;

public class MeetingAddAttachmentsRule  extends KcTransactionalDocumentRuleBase implements KcBusinessRule<MeetingAddAttachmentsEvent> {

    String propertyPrefix ="meetingHelper.newCommitteeScheduleAttachments" ;
    private static final String ATTACHMENTS_ID = ".attachmentsTypeCode";
    private static final String ATTACHMENTS_FILE = ".document" ;
    private static final String noValue = "";
    
    @Override
    public boolean processRules(MeetingAddAttachmentsEvent event) {

        boolean isValid = true;
        CommitteeScheduleAttachmentsBase committeeScheduleAttachments = event.getMeetingHelper().getNewCommitteeScheduleAttachments();
        if (committeeScheduleAttachments.getAttachmentsTypeCode() == null){
            isValid = false;
            reportError(propertyPrefix+ATTACHMENTS_ID
                    , KeyConstants.ERROR_COMMITTEESCHEDULEATTACHMENTS_ATTACHMENTTYPE ); 
        }
        if (committeeScheduleAttachments.getNewFile().getFileName().equals(noValue)){
            isValid = false;
            reportError(propertyPrefix+ATTACHMENTS_FILE
                    , KeyConstants.ERROR_COMMITTEESCHEDULEATTACHMENTS_FILENAME ); 
        }
        return isValid;
    }
}
