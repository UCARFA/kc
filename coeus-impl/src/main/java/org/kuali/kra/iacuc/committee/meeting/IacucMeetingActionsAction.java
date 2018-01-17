/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.meeting;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.common.committee.impl.meeting.*;
import org.kuali.coeus.common.committee.impl.print.service.CommitteePrintingServiceBase;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.common.questionnaire.framework.print.CorrespondencePrintingService;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.actions.reviewcomments.IacucReviewCommentsService;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeSchedule;
import org.kuali.kra.iacuc.committee.print.service.IacucCommitteePrintingService;
import org.kuali.kra.iacuc.committee.print.service.IacucScheduleCorrespondencePrint;
import org.kuali.kra.iacuc.correspondence.IacucProtocolActionCorrespondenceGenerationService;
import org.kuali.kra.iacuc.correspondence.IacucProtocolActionsCorrespondence;
import org.kuali.kra.iacuc.correspondence.IacucProtocolCorrespondenceType;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsService;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionLiteBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondence;
import org.kuali.rice.core.api.datetime.DateTimeService;
import org.kuali.rice.krad.util.GlobalVariables;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IacucMeetingActionsAction extends MeetingActionsActionBase {

    @Override
    protected ScheduleAgendaBase getNewScheduleAgendaInstanceHook() {
        return new IacucScheduleAgenda();
    }

    @Override
    protected String getProtocolCorrespondenceAgendaTypeCodeHook() {
        return IacucProtocolCorrespondenceType.AGENDA;
    }

    @Override
    protected CommScheduleMinuteDocBase getNewCommScheduleMinuteDocInstanceHook() {
        return new IacucCommScheduleMinuteDoc();
    }

    @Override
    protected String getProtocolCorrespondenceMinutesTypeCodeHook() {
        return IacucProtocolCorrespondenceType.MINUTES;
    }


    @Override
    protected Class<? extends CommitteeScheduleBase> getCommitteeScheduleBOClass() {
        return IacucCommitteeSchedule.class;
    }

    @Override
    protected String getDocumentNumber(ProtocolSubmissionLiteBase protocolSubmission) {
        Map<String, String> criteria = new HashMap<>();
        criteria.put(PROTOCOL_ID, protocolSubmission.getProtocolId().toString());
        IacucProtocol protocol = getBusinessObjectService().findByPrimaryKey(IacucProtocol.class, criteria);
        return protocol.getProtocolDocument().getDocumentNumber();
    }

    @Override
    protected String getActionIdHook() {
        return "iacucProtocolProtocol";
    }

    @Override
    protected CommonMeetingService getMeetingService() {
        return KcServiceLocator.getService(IacucMeetingService.class);
    }

    @Override
    protected ReviewCommentsService<?> getReviewerCommentsService() {
        return KcServiceLocator.getService(IacucReviewCommentsService.class);
    }

    @Override
    protected CommitteePrintingServiceBase getCommitteePrintingService() {
        return KcServiceLocator.getService(IacucCommitteePrintingService.class);
    }

    @Override
    public ActionForward regenerateCorrespondence(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        MeetingHelperBase meetingHelper = ((MeetingFormBase) form).getMeetingHelper();
        meetingHelper.setRegeneratedCorrespondences(new ArrayList<ProtocolCorrespondence>());
        for (ProtocolCorrespondence protocolCorrespondence : meetingHelper.getCorrespondences()) {
            if (protocolCorrespondence.isRegenerateFlag()) {
                ProtocolBase protocol = protocolCorrespondence.getProtocol();
                AttachmentDataSource dataSource = generateCorrespondenceDocumentAndAttach(protocol, protocolCorrespondence);

                if (dataSource != null) {
                    protocolCorrespondence.setCorrespondence(dataSource.getData());
                    protocolCorrespondence.setFinalFlag(false);
                    protocolCorrespondence.setCreateUser(GlobalVariables.getUserSession().getPrincipalName());
                    protocolCorrespondence.setCreateTimestamp(KcServiceLocator.getService(DateTimeService.class)
                            .getCurrentTimestamp());
                }
                meetingHelper.getRegeneratedCorrespondences().add(protocolCorrespondence);
            }
        }
        getBusinessObjectService().save(meetingHelper.getRegeneratedCorrespondences());
        return mapping.findForward("correspondence");
    }

    protected AttachmentDataSource generateCorrespondenceDocumentAndAttach(ProtocolBase protocol, ProtocolCorrespondence oldCorrespondence) throws PrintingException {
        IacucProtocolActionsCorrespondence correspondence = new IacucProtocolActionsCorrespondence(oldCorrespondence.getProtocolAction().getProtocolActionTypeCode());
        correspondence.setProtocol(protocol);
        return getProtocolActionCorrespondenceGenerationService().reGenerateCorrespondenceDocument(correspondence);
    }

    private IacucProtocolActionCorrespondenceGenerationService getProtocolActionCorrespondenceGenerationService() {
        return KcServiceLocator.getService(IacucProtocolActionCorrespondenceGenerationService.class);
    }

    @Override
    protected CorrespondencePrintingService getCorrespondencePrintingService() {
        return KcServiceLocator.getService(IacucScheduleCorrespondencePrint.class);
    }

    @Override
    protected MeetingControllerService getMeetingControllerService() {
        return KcServiceLocator.getService("iacucMeetingControllerService");
    }
    
}
