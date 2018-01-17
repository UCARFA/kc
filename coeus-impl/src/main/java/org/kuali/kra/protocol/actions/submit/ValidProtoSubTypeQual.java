/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.submit;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class ValidProtoSubTypeQual extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = 6546751709369749190L;

    private Long validProtoSubTypeQualId;

    private String submissionTypeCode;

    private String submissionTypeQualCode;

    private ProtocolSubmissionTypeBase submissionType;

    private ProtocolSubmissionQualifierTypeBase submissionTypeQualifier;

    public ValidProtoSubTypeQual() {
    }

    public Long getValidProtoSubTypeQualId() {
        return validProtoSubTypeQualId;
    }

    public void setValidProtoSubTypeQualId(Long validProtoSubTypeQualId) {
        this.validProtoSubTypeQualId = validProtoSubTypeQualId;
    }

    public String getSubmissionTypeCode() {
        return submissionTypeCode;
    }

    public void setSubmissionTypeCode(String submissionTypeCode) {
        this.submissionTypeCode = submissionTypeCode;
    }

    public String getSubmissionTypeQualCode() {
        return submissionTypeQualCode;
    }

    public void setSubmissionTypeQualCode(String submissionTypeQualCode) {
        this.submissionTypeQualCode = submissionTypeQualCode;
    }

    public ProtocolSubmissionTypeBase getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(ProtocolSubmissionTypeBase submissionType) {
        this.submissionType = submissionType;
    }

    public ProtocolSubmissionQualifierTypeBase getSubmissionTypeQualifier() {
        return submissionTypeQualifier;
    }

    public void setSubmissionTypeQualifier(ProtocolSubmissionQualifierTypeBase submissionTypeQualifier) {
        this.submissionTypeQualifier = submissionTypeQualifier;
    }
}
