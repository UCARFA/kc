/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.submit;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class ValidProtoSubRevType extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 3396505214377892706L;

    private Long validProtoSubRevTypeId;

    private String submissionTypeCode;

    private String protocolReviewTypeCode;

    private ProtocolReviewTypeBase protocolReviewType;

    private ProtocolSubmissionTypeBase submissionType;

    public ValidProtoSubRevType() {
    }

    public Long getValidProtoSubRevTypeId() {
        return validProtoSubRevTypeId;
    }

    public void setValidProtoSubRevTypeId(Long validProtoSubRevTypeId) {
        this.validProtoSubRevTypeId = validProtoSubRevTypeId;
    }

    public String getSubmissionTypeCode() {
        return submissionTypeCode;
    }

    public void setSubmissionTypeCode(String submissionTypeCode) {
        this.submissionTypeCode = submissionTypeCode;
    }

    public String getProtocolReviewTypeCode() {
        return protocolReviewTypeCode;
    }

    public void setProtocolReviewTypeCode(String protocolReviewTypeCode) {
        this.protocolReviewTypeCode = protocolReviewTypeCode;
    }

    public ProtocolReviewTypeBase getProtocolReviewType() {
        return protocolReviewType;
    }

    public void setProtocolReviewType(ProtocolReviewTypeBase protocolReviewType) {
        this.protocolReviewType = protocolReviewType;
    }

    public ProtocolSubmissionTypeBase getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(ProtocolSubmissionTypeBase submissionType) {
        this.submissionType = submissionType;
    }
}
