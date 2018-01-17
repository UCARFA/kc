/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.submit;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.actions.IacucActionsKeyValuesBase;
import org.kuali.kra.iacuc.actions.IacucProtocolStatus;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.ProtocolSpecialVersion;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Finds the available set of Submission Types when a protocol
 * is submitted for review by the IRB Committee.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class SubmissionTypeValuesFinder extends IacucActionsKeyValuesBase {
    

    private static final long serialVersionUID = -4743158845190302163L;

    @Override
    public List<KeyValue> getKeyValues() {
       
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        ProtocolDocumentBase pd = (ProtocolDocumentBase) getDocument();
        if (pd != null) {
            ProtocolBase protocol = pd.getProtocol();
            Collection<IacucProtocolSubmissionType> submissionTypes = this.getKeyValuesService().findAll(IacucProtocolSubmissionType.class);
            String currentStatus  = pd.getProtocol().getProtocolStatusCode();
            for (IacucProtocolSubmissionType submissionType : submissionTypes) {
                if (validStatusSubmissionTypePair(submissionType, currentStatus, protocol)) {
                    keyValues.add(new ConcreteKeyValue(submissionType.getSubmissionTypeCode(), submissionType.getDescription()));
                }
            }
        }
        
        return keyValues;
    }
    
    protected boolean validStatusSubmissionTypePair(IacucProtocolSubmissionType submissionType, String currentStatus, ProtocolBase protocol) {
        if (StringUtils.equalsIgnoreCase(submissionType.getSubmissionTypeCode(), IacucProtocolSubmissionType.INITIAL_SUBMISSION)) {
            return displayResubmission(currentStatus) || displayInitialSubmission(currentStatus);
        } else if (StringUtils.equalsIgnoreCase(submissionType.getSubmissionTypeCode(), IacucProtocolSubmissionType.FYI)) {
            return displayResubmission(currentStatus) || displayFYISubmission(currentStatus);
        } else if (StringUtils.equalsIgnoreCase(submissionType.getSubmissionTypeCode(), IacucProtocolSubmissionType.AMENDMENT)) {
            return displayResubmission(currentStatus) || displayAmendment(currentStatus, protocol);
        } else if (StringUtils.equalsIgnoreCase(submissionType.getSubmissionTypeCode(), IacucProtocolSubmissionType.CONTINUATION)) {
            return displayResubmission(currentStatus) || displayContinuation(currentStatus, protocol);
        } else if (StringUtils.equalsIgnoreCase(submissionType.getSubmissionTypeCode(), IacucProtocolSubmissionType.CONTINUATION_WITH_AMENDMENT)) {
            return displayResubmission(currentStatus) || displayContinuationWithAmendment(currentStatus, protocol);
        } else if (StringUtils.equalsIgnoreCase(submissionType.getSubmissionTypeCode(), IacucProtocolSubmissionType.RESPONSE_TO_PREV_IACUC_NOTIFICATION)) {
            return displayResubmission(currentStatus) || displayResponseToPrevIACUCNotification(currentStatus);
        } else if (StringUtils.equalsIgnoreCase(submissionType.getSubmissionTypeCode(), IacucProtocolSubmissionType.NOTIFY_IACUC)) {
            return displayNotifyIacuc(currentStatus, protocol);
        }
        return false; 
    }
    
    private boolean displayFYISubmission(String currentStatus) {
        String validStatuses[] = { 
                                   IacucProtocolStatus.IN_PROGRESS, 
                                   IacucProtocolStatus.WITHDRAWN, 
                                   IacucProtocolStatus.SUBMITTED_TO_IACUC,
                                   IacucProtocolStatus.ADMINISTRATIVELY_WITHDRAWN,
                                   IacucProtocolStatus.ADMINISTRATIVELY_INCOMPLETE
                                  };
        return validateCurrentStatus(currentStatus, validStatuses);
    }
    
    private boolean displayInitialSubmission(String currentStatus) {
        String validStatuses[] = { 
                                   IacucProtocolStatus.IN_PROGRESS, 
                                   IacucProtocolStatus.WITHDRAWN, 
                                   IacucProtocolStatus.SUBMITTED_TO_IACUC,
                                   IacucProtocolStatus.ADMINISTRATIVELY_WITHDRAWN,
                                   IacucProtocolStatus.ADMINISTRATIVELY_INCOMPLETE
                                  };
        return validateCurrentStatus(currentStatus, validStatuses);
    }
    
    private boolean displayResponseToPrevIACUCNotification(String currentStatus) {
        String validStatuses[] = { IacucProtocolStatus.MINOR_REVISIONS_REQUIRED,
                IacucProtocolStatus.MAJOR_REVISIONS_REQUIRED,
                IacucProtocolStatus.ACTIVE_ON_HOLD, IacucProtocolStatus.SUBMITTED_TO_IACUC, IacucProtocolStatus.RETURN_TO_PI, IacucProtocolStatus.TABLED };
        return validateCurrentStatus(currentStatus, validStatuses);
    }
    
    private boolean displayAmendment(String currentStatus, ProtocolBase protocol) {
        String validStatuses[] = { IacucProtocolStatus.WITHDRAWN, IacucProtocolStatus.AMENDMENT_IN_PROGRESS, IacucProtocolStatus.SUBMITTED_TO_IACUC };
        return validateCurrentStatus(currentStatus, validStatuses)  && hasAmmendmentProtocolNumber(protocol.getProtocolNumber());
    }
    
    private boolean displayContinuation(String currentStatus, ProtocolBase protocol) {
        String validStatuses[] = { IacucProtocolStatus.WITHDRAWN, IacucProtocolStatus.RENEWAL_IN_PROGRESS, IacucProtocolStatus.CONTINUATION_IN_PROGRESS, IacucProtocolStatus.SUBMITTED_TO_IACUC };
        return validateCurrentStatus(currentStatus, validStatuses)  && (hasRenewalProtocolNumber(protocol.getProtocolNumber()) || 
                hasContinuationProtocolNumber(protocol.getProtocolNumber()));
    }
    
    private boolean displayContinuationWithAmendment(String currentStatus, ProtocolBase protocol) {
        String validStatuses[] = { IacucProtocolStatus.WITHDRAWN, IacucProtocolStatus.RENEWAL_IN_PROGRESS, IacucProtocolStatus.CONTINUATION_IN_PROGRESS, IacucProtocolStatus.SUBMITTED_TO_IACUC };
        return validateCurrentStatus(currentStatus, validStatuses)  && (hasRenewalProtocolNumber(protocol.getProtocolNumber()) || 
                hasContinuationProtocolNumber(protocol.getProtocolNumber()));
    }
    
    private boolean hasAmmendmentProtocolNumber(String protocolNumber) {
        return protocolNumber.contains("A");
    }
    
    private boolean hasRenewalProtocolNumber(String protocolNumber) {
        return protocolNumber.contains(ProtocolSpecialVersion.RENEWAL.getCode());
    }

    private boolean hasContinuationProtocolNumber(String protocolNumber) {
        return protocolNumber.contains(ProtocolSpecialVersion.CONTINUATION.getCode());
    }

    private boolean hasFyiProtocolNumber(String protocolNumber) {
        return protocolNumber.contains(ProtocolSpecialVersion.FYI.getCode());
    }

    private boolean displayResubmission(String currentStatus) {
        String validStatuses[] = {IacucProtocolStatus.WITHDRAWN, IacucProtocolStatus.SUBMITTED_TO_IACUC};
        return validateCurrentStatus(currentStatus, validStatuses);
    }

    protected boolean displayNotifyIacuc(String currentStatus, ProtocolBase protocol) {
        boolean useAlternateNotifyIacucAction = getParameterService().getParameterValueAsBoolean(IacucProtocolDocument.class, Constants.ALTERNATE_NOTIFY_IACUC_ACTION_PARAM, false);
        if (useAlternateNotifyIacucAction) {
            String validStatuses[] = {IacucProtocolStatus.WITHDRAWN, IacucProtocolStatus.FYI_IN_PROGRESS, IacucProtocolStatus.SUBMITTED_TO_IACUC};
            return validateCurrentStatus(currentStatus, validStatuses) && hasFyiProtocolNumber(protocol.getProtocolNumber());
        } else {
            String validStatuses[] = { IacucProtocolStatus.ACTIVE,  IacucProtocolStatus.ADMINISTRATIVELY_APPROVED };
            String validSumissionStatuses[] = { IacucProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE, IacucProtocolSubmissionStatus.PENDING};
            String currentSubmissionStatus = protocol.getProtocolSubmission().getSubmissionStatusCode();
            return validateCurrentStatus(currentStatus, validStatuses)  && validateCurrentSubmissionStatus(currentSubmissionStatus, validSumissionStatuses);
        }
    }
    
    private boolean validateCurrentStatus(String currentStatus, String[] validStatuses) {
        for (String status : validStatuses) {
            if (StringUtils.equals(currentStatus, status)) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean validateCurrentSubmissionStatus(String currentSubmissionStatus, String[] validSubmissionStatuses) {
        for (String status : validSubmissionStatuses) {
            if (StringUtils.equals(currentSubmissionStatus, status)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected Class<? extends CommitteeServiceBase> getCommitteeServiceClassHook() {
        return IacucCommitteeService.class;
    }
}
