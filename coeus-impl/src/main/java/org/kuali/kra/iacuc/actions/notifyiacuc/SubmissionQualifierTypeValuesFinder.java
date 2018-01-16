/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.notifyiacuc;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.iacuc.actions.IacucActionsKeyValuesBase;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionQualifierType;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionType;
import org.kuali.kra.iacuc.actions.submit.IacucValidProtoSubTypeQual;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeService;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.*;

/**
 * Finds the available set of Submission Qualifier Types for a Notify IRB request.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class SubmissionQualifierTypeValuesFinder extends IacucActionsKeyValuesBase {

    @Override
    @SuppressWarnings("unchecked")
    public List<KeyValue> getKeyValues() {

        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put("submissionTypeCode", IacucProtocolSubmissionType.FYI);
        List<IacucValidProtoSubTypeQual> validProtoSubTypeQuals = (List<IacucValidProtoSubTypeQual>) getBusinessObjectService().findMatching(
                IacucValidProtoSubTypeQual.class, fieldValues);
        if (validProtoSubTypeQuals.isEmpty()) {
            keyValues.add(ValuesFinderUtils.getSelectOption());
            Collection<IacucProtocolSubmissionQualifierType> submissionQualifierTypes = this.getKeyValuesService().findAll(
                    IacucProtocolSubmissionQualifierType.class);
            for (IacucProtocolSubmissionQualifierType submissionQualifierType : submissionQualifierTypes) {
                if (isAllowed(submissionQualifierType)) {
                    keyValues.add(new ConcreteKeyValue(submissionQualifierType.getSubmissionQualifierTypeCode(),
                        submissionQualifierType.getDescription()));
                }
            }
        } else {
            for (IacucValidProtoSubTypeQual typeQual : validProtoSubTypeQuals) {
                keyValues.add(new ConcreteKeyValue(typeQual.getSubmissionTypeQualCode(), typeQual.getSubmissionTypeQualifier()
                        .getDescription()));
            }
        }

        return keyValues;
    }

    /**
     * There are many submission qualifier types but only a few are available for a Notify IRB request.
     * 
     * @param submissionQualifierType the submission qualifier type
     * @return true if applicable; otherwise false
     */
    private boolean isAllowed(IacucProtocolSubmissionQualifierType submissionQualifierType) {
        String typeCodes[] = { IacucProtocolSubmissionQualifierType.AE_UADE, IacucProtocolSubmissionQualifierType.ANNUAL_REPORT,
                IacucProtocolSubmissionQualifierType.ANNUAL_REPORT, IacucProtocolSubmissionQualifierType.COMPLAINT,
                IacucProtocolSubmissionQualifierType.DEVIATION, IacucProtocolSubmissionQualifierType.IACUC_PROTOCOL_RELATED_COI_PROJECT,
                IacucProtocolSubmissionQualifierType.ELIGIBILITY_EXCEPTIONS_PROTOCOL_DEVIATIONS,
                IacucProtocolSubmissionQualifierType.SELF_REPORT_FOR_NONCOMPLIANCE };

        for (String typeCode : typeCodes) {
            if (StringUtils.equals(typeCode, submissionQualifierType.getSubmissionQualifierTypeCode())) {
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
