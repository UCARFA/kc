/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions;


import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolReviewerType;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.ProtocolActionAjaxServiceImplBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewBase;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

import java.util.List;
import java.util.Optional;

public class IacucProtocolActionAjaxServiceImpl extends ProtocolActionAjaxServiceImplBase implements IacucProtocolActionAjaxService {
    
    private ParameterService parameterService;
    
    public static final String DEFAULT_REVIEW_TYPE_PARAMETER_NAME = "IACUC_ALL_COMM_REVIEWERS_DEFAULT_ASSIGNED";

    @Override
    public Class<? extends ProtocolBase> getProtocolClassHook() {
        return IacucProtocol.class;
    }

    @Override
    public Class getProtocolReviewerTypeClassHook() {
        return IacucProtocolReviewerType.class;
    }
    
    @Override
    public String getDefaultCommitteeReviewTypeCode() {
        return this.getParameterService().getParameterValueAsString("KC-IACUC", "Document", DEFAULT_REVIEW_TYPE_PARAMETER_NAME);
    }

    public ParameterService getParameterService() {
        return parameterService;
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }
    
    @Override
    public String getReviewers(String protocolId, String committeeId, String scheduleId) {

        /*
         * no reviewers should be assigned if schedule not chosen.
         */
        if (StringUtils.isNotBlank(scheduleId)) {
            return getRevs(protocolId, committeeId, scheduleId);
        }
        return "";
    }

    protected String getRevs(String protocolId, String committeeId, String scheduleId) {
        StringBuffer ajaxList = new StringBuffer();

        final IacucProtocol protocol = getBusinessObjectService().findBySinglePrimaryKey(IacucProtocol.class, protocolId);

        // filter out the protocol personnel; they cannot be reviewers on their own protocol
        List<CommitteeMembershipBase> filteredMembers = protocol.filterOutProtocolPersonnel(getCommitteeService().getAvailableMembers(committeeId, scheduleId));

        for (CommitteeMembershipBase filteredMember : filteredMembers) {
            if (StringUtils.isNotBlank(filteredMember.getPersonId())) {
                ajaxList.append(filteredMember.getPersonId() + ";" + filteredMember.getPersonName() + ";N;");
                final Optional<ProtocolOnlineReviewBase> review = protocol.getProtocolOnlineReviews().stream().filter(r -> filteredMember.getPersonId().equals(r.getProtocolReviewer().getPersonId())).findFirst();
                ajaxList.append((review.isPresent() ? review.get().getProtocolReviewer().getReviewerTypeCode() : "") + ";");
            } else {
                ajaxList.append(filteredMember.getRolodexId() + ";" + filteredMember.getPersonName() + ";Y;");
                final Optional<ProtocolOnlineReviewBase> review = protocol.getProtocolOnlineReviews().stream().filter(r -> filteredMember.getRolodexId().equals(r.getProtocolReviewer().getRolodexId())).findFirst();
                ajaxList.append((review.isPresent() ? review.get().getProtocolReviewer().getReviewerTypeCode() : "") + ";");
            }
        }

        return clipLastChar(ajaxList);
    }

    @Override
    public String getModifySubmissionProtocolReviewers(String protocolId, String committeeId, String scheduleId, String protocolReviewTypeCode) {
        return getRevs(protocolId, committeeId, scheduleId);
    }


}
