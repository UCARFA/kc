/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.protocol.ProtocolAssociateBase;

@SuppressWarnings("serial")
public class ProtocolExemptStudiesCheckListItem extends ProtocolAssociateBase {

    private Long protocolExemptCheckListId;

    private Long submissionIdFk;

    private Integer submissionNumber;

    private String exemptStudiesCheckListCode;


    private ProtocolSubmission protocolSubmission;

    private ExemptStudiesCheckListItem exemptStudiesCheckListItem;

    public ProtocolExemptStudiesCheckListItem() {
    }

    public Long getProtocolExemptCheckListId() {
        return protocolExemptCheckListId;
    }

    public void setProtocolExemptCheckListId(Long protocolExemptCheckListId) {
        this.protocolExemptCheckListId = protocolExemptCheckListId;
    }

    public Long getSubmissionIdFk() {
        return submissionIdFk;
    }

    public void setSubmissionIdFk(Long submissionIdFk) {
        this.submissionIdFk = submissionIdFk;
    }

    public Integer getSubmissionNumber() {
        return submissionNumber;
    }

    public void setSubmissionNumber(Integer submissionNumber) {
        this.submissionNumber = submissionNumber;
    }

    public String getExemptStudiesCheckListCode() {
        return exemptStudiesCheckListCode;
    }

    public void setExemptStudiesCheckListCode(String exemptStudiesCheckListCode) {
        this.exemptStudiesCheckListCode = exemptStudiesCheckListCode;
    }

    public ProtocolSubmission getProtocolSubmission() {
        return protocolSubmission;
    }

    public void setProtocolSubmission(ProtocolSubmission protocolSubmission) {
        this.protocolSubmission = protocolSubmission;
    }

    public void setExemptStudiesCheckListItem(ExemptStudiesCheckListItem exemptStudiesCheckListItem) {
        this.exemptStudiesCheckListItem = exemptStudiesCheckListItem;
    }

    public ExemptStudiesCheckListItem getExemptStudiesCheckListItem() {
        if (exemptStudiesCheckListItem == null && StringUtils.isNotBlank(exemptStudiesCheckListCode)) {
            refreshReferenceObject("exemptStudiesCheckListItem");
        }
        return exemptStudiesCheckListItem;
    }

    @Override
    public void resetPersistenceState() {
    	protocolExemptCheckListId = null;
    }

}
