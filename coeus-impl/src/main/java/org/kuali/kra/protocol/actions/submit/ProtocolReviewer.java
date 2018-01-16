/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.submit;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.SkipVersioning;
import org.kuali.kra.protocol.ProtocolReviewerBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewBase;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ProtocolReviewer extends ProtocolReviewerBase {

    private Long protocolReviewerId;

    private String protocolNumber;

    private Integer sequenceNumber;

    private Integer submissionNumber;

    private String reviewerTypeCode;

    private ProtocolReviewerType protocolReviewerType;

    // transient property for submission detail display 
    @SkipVersioning
    private transient List<ProtocolOnlineReviewBase> protocolOnlineReviews = new ArrayList<ProtocolOnlineReviewBase>();

    public Long getProtocolReviewerId() {
        return protocolReviewerId;
    }

    public void setProtocolReviewerId(Long protocolReviewerId) {
        this.protocolReviewerId = protocolReviewerId;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Integer getSubmissionNumber() {
        return submissionNumber;
    }

    public void setSubmissionNumber(Integer submissionNumber) {
        this.submissionNumber = submissionNumber;
    }

    public void setReviewerTypeCode(String reviewerTypeCode) {
        this.reviewerTypeCode = reviewerTypeCode;
    }

    public String getReviewerTypeCode() {
        return reviewerTypeCode;
    }

    public ProtocolReviewerType getProtocolReviewerType() {
        if (protocolReviewerType == null && StringUtils.isNotBlank(reviewerTypeCode)) {
            refreshReferenceObject("protocolReviewerType");
        }
        return protocolReviewerType;
    }

    public void setProtocolReviewerType(ProtocolReviewerType protocolReviewerType) {
        this.protocolReviewerType = protocolReviewerType;
    }

    /**
     * Gets the protocolOnlineReviews attribute. 
     * @return Returns the protocolOnlineReviews.
     */
    public List<ProtocolOnlineReviewBase> getProtocolOnlineReviews() {
        return protocolOnlineReviews;
    }

    /**
     * Sets the protocolOnlineReviews attribute value.
     * @param protocolOnlineReviews The protocolOnlineReviews to set.
     */
    public void setProtocolOnlineReviews(List<ProtocolOnlineReviewBase> protocolOnlineReviews) {
        this.protocolOnlineReviews = protocolOnlineReviews;
    }

    @Override
    public List buildListOfDeletionAwareLists() {
        List managedLists = super.buildListOfDeletionAwareLists();
        if (protocolOnlineReviews != null) {
            managedLists.add(protocolOnlineReviews);
        }
        return managedLists;
    }
    
}
