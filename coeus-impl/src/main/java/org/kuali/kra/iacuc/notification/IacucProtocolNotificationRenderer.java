/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.notification;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolReviewType;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmission;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionQualifierType;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionType;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.notification.ProtocolNotificationRendererBase;
import org.kuali.kra.protocol.notification.ProtocolReplacementParameters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Renders fields for the IRB and IACUC notifications.
 */
public class IacucProtocolNotificationRenderer extends ProtocolNotificationRendererBase {

    private static final long serialVersionUID = 44807703047564273L;
    private static final String PROTOCOL_ACTION_TYPE_CODE = "protocolActionTypeCode";
    private static final String SUBMISSION_TYPE_CODE = "submissionTypeCode";
    private static final String SUBMISSION_QUALIFIER_TYPE_CODE = "submissionQualifierTypeCode";
    private static final String REVIEW_TYPE_CODE = "reviewTypeCode";

    public IacucProtocolNotificationRenderer(IacucProtocol protocol) {
        super(protocol);
    }

    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        IacucProtocolSubmission protocolSubmission = (IacucProtocolSubmission)getProtocol().getProtocolSubmission();
        if (protocolSubmission != null) {
            params.put(ProtocolReplacementParameters.LAST_SUBMISSION_NAME, getProtocolSubmissionName(protocolSubmission.getSubmissionTypeCode()));
            params.put(ProtocolReplacementParameters.LAST_SUBMISSION_TYPE_QUAL_NAME, getLastSubmissionTypeQualifierName(protocolSubmission.getSubmissionTypeQualifierCode()));
            params.put(ProtocolReplacementParameters.PROTOCOL_REVIEW_TYPE_DESC, getSafeMessage(ProtocolReplacementParameters.PROTOCOL_REVIEW_TYPE_DESC, getProtocolReviewTypeDescription(protocolSubmission.getProtocolReviewTypeCode())));
        } else {
            params.put(ProtocolReplacementParameters.LAST_SUBMISSION_NAME, StringUtils.EMPTY);
            params.put(ProtocolReplacementParameters.LAST_SUBMISSION_TYPE_QUAL_NAME, StringUtils.EMPTY);
            params.put(ProtocolReplacementParameters.PROTOCOL_REVIEW_TYPE_DESC, StringUtils.EMPTY);
        }
        ProtocolActionBase lastProtocolAction = getProtocol().getLastProtocolAction();
        if (lastProtocolAction != null) {
            params.put(ProtocolReplacementParameters.LAST_ACTION_NAME, getProtocolLastActionName(lastProtocolAction.getProtocolActionTypeCode()));    
            params.put(ProtocolReplacementParameters.LAST_ACTION_TYPE_CODE, lastProtocolAction.getProtocolActionTypeCode());
        } else {
            params.put(ProtocolReplacementParameters.LAST_ACTION_NAME, StringUtils.EMPTY);
            params.put(ProtocolReplacementParameters.LAST_ACTION_TYPE_CODE, StringUtils.EMPTY);
        }
        return params;
    }
    
    private String getProtocolLastActionName(String lastActionTypeCode) {
        String result = null;
        Map<String, String> fieldValues = new HashMap<>();
        fieldValues.put(PROTOCOL_ACTION_TYPE_CODE, lastActionTypeCode);
        List<IacucProtocolActionType> actionTypes = (List<IacucProtocolActionType>) getBusinessObjectService().findMatching(IacucProtocolActionType.class, fieldValues);
        if (CollectionUtils.isNotEmpty(actionTypes)) {
            result = actionTypes.get(0).getDescription();
        }
        
        return result;
    }

    private String getProtocolSubmissionName(String submissionTypeCode) {
        String result = null;
        Map<String, String> fieldValues = new HashMap<>();
        fieldValues.put(SUBMISSION_TYPE_CODE, submissionTypeCode);
        List<IacucProtocolSubmissionType> submissionTypes = 
            (List<IacucProtocolSubmissionType>) getBusinessObjectService().findMatching(IacucProtocolSubmissionType.class, fieldValues);
        if (CollectionUtils.isNotEmpty(submissionTypes)) {
            result = submissionTypes.get(0).getDescription();
        }
        
        return result;
    }
    
    private String getLastSubmissionTypeQualifierName(String submissionQualifierTypeCode) {
        String result = null;
        Map<String, String> fieldValues = new HashMap<>();
        fieldValues.put(SUBMISSION_QUALIFIER_TYPE_CODE, submissionQualifierTypeCode);
        List<IacucProtocolSubmissionQualifierType> submissionQualifierTypes = 
            (List<IacucProtocolSubmissionQualifierType>) getBusinessObjectService().findMatching(IacucProtocolSubmissionQualifierType.class, fieldValues);
        if (CollectionUtils.isNotEmpty(submissionQualifierTypes)) {
            result = submissionQualifierTypes.get(0).getDescription();
        }
        
        return result;
    }

    private String getProtocolReviewTypeDescription(String reviewTypeCode) {
        String result = null;
        Map<String, String> fieldValues = new HashMap<>();
        fieldValues.put(REVIEW_TYPE_CODE, reviewTypeCode);
        List<IacucProtocolReviewType> protocolReviewTypes = 
            (List<IacucProtocolReviewType>) getBusinessObjectService().findMatching(IacucProtocolReviewType.class, fieldValues);
        if (CollectionUtils.isNotEmpty(protocolReviewTypes)) {
            result = protocolReviewTypes.get(0).getDescription();
        }        
        return result;
    }

    @Override
    protected Class<? extends CommitteeBase> getCommonCommitteeBOClassHook() {
        return IacucCommittee.class;
    }
    
}
