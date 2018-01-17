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
public class ProtocolExpeditedReviewCheckListItem extends ProtocolAssociateBase {

    private Long protocolExpeditedCheckListId;

    private Long submissionIdFk;

    private Integer submissionNumber;

    private String expeditedReviewCheckListCode;

    private ProtocolSubmission protocolSubmission;

    private ExpeditedReviewCheckListItem expeditedReviewCheckListItem;

    public ProtocolExpeditedReviewCheckListItem() {
    }

    public Long getProtocolExpeditedCheckListId() {
        return protocolExpeditedCheckListId;
    }

    public void setProtocolExpeditedCheckListId(Long protocolExpeditedCheckListId) {
        this.protocolExpeditedCheckListId = protocolExpeditedCheckListId;
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

    public String getExpeditedReviewCheckListCode() {
        return expeditedReviewCheckListCode;
    }

    public void setExpeditedReviewCheckListCode(String expeditedReviewCheckListCode) {
        this.expeditedReviewCheckListCode = expeditedReviewCheckListCode;
    }

    public ProtocolSubmission getProtocolSubmission() {
        return protocolSubmission;
    }

    public void setProtocolSubmission(ProtocolSubmission protocolSubmission) {
        this.protocolSubmission = protocolSubmission;
    }

    public ExpeditedReviewCheckListItem getExpeditedReviewCheckListItem() {
        if (expeditedReviewCheckListItem == null && StringUtils.isNotBlank(expeditedReviewCheckListCode)) {
            refreshReferenceObject("expeditedReviewCheckListItem");
        }
        return expeditedReviewCheckListItem;
    }

    public void setExpeditedReviewCheckListItem(ExpeditedReviewCheckListItem expeditedReviewCheckListItem) {
        this.expeditedReviewCheckListItem = expeditedReviewCheckListItem;
    }

    @Override
    public void resetPersistenceState() {
    	protocolExpeditedCheckListId = null;
    }
}
