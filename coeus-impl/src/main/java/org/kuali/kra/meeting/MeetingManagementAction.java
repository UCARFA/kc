/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.meeting;

import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.committee.impl.meeting.*;
import org.kuali.coeus.common.committee.impl.meeting.MeetingEventBase.ErrorType;
import org.kuali.coeus.common.committee.impl.service.CommitteeScheduleServiceBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.committee.document.CommitteeDocument;
import org.kuali.kra.committee.service.CommitteeScheduleService;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.reviewcomments.ReviewCommentsService;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionLiteBase;

import java.util.HashMap;
import java.util.Map;

public class MeetingManagementAction extends MeetingManagementActionBase {

    @Override
    protected MeetingAddMinuteEventBase getNewMeetingAddMinuteEventInstanceHook(String errorPathPrefix, CommitteeDocumentBase document, MeetingHelperBase meetingHelper, ErrorType type) {
        return new MeetingAddMinuteEvent(errorPathPrefix, (CommitteeDocument) document, (MeetingHelper) meetingHelper, type);
    }

    @Override
    protected CommScheduleActItemBase getNewCommScheduleActItemInstanceHook() {
        return new CommScheduleActItem();
    }

    @Override
    protected String getCommitteeScheduleActionIdHook() {
        return "committeeSchedule";
    }

    @Override
    protected String getCommitteeCommitteeActionIdHook() {
        return "committeeCommittee";
    }

    @Override
    protected CommitteeScheduleAttachmentsBase getNewCommitteeScheduleAttachmentsInstanceHook() {
        return new CommitteeScheduleAttachments();
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected Class<? extends CommitteeScheduleServiceBase> getCommitteeScheduleServiceClassHook() {
        return CommitteeScheduleService.class;
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected Class<? extends CommitteeScheduleBase> getCommitteeScheduleBOClass() {
        return CommitteeSchedule.class;
    }

    @Override
    protected String getDocumentNumber(ProtocolSubmissionLiteBase protocolSubmission) {
        Map<String, String> criteria = new HashMap<>();
        criteria.put(PROTOCOL_ID, protocolSubmission.getProtocolId().toString());
        Protocol protocol = getBusinessObjectService().findByPrimaryKey(Protocol.class, criteria);
        return protocol.getProtocolDocument().getDocumentNumber();
    }

    @Override
    protected String getActionIdHook() {
        return "protocolProtocol";
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected CommonMeetingService getMeetingService() {
        return KcServiceLocator.getService(MeetingService.class);
    }

    @Override
    protected org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsService<?> getReviewerCommentsService() {
        return KcServiceLocator.getService(ReviewCommentsService.class);
    }

    @Override
    protected MeetingControllerService getMeetingControllerService() {
        return KcServiceLocator.getService("meetingControllerService");
    }
}
