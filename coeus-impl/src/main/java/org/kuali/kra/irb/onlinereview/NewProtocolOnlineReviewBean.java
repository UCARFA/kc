/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.onlinereview;

import org.kuali.rice.krad.bo.BusinessObjectBase;

import java.sql.Date;

public class NewProtocolOnlineReviewBean extends BusinessObjectBase {

    private Long newProtocolReviewCommitteeMembershipId;

    private String newReviewerTypeCode;

    private Date newReviewDateRequested;

    private Date newReviewDateDue;

    private String newReviewDocumentDescription;

    private String newReviewExplanation;

    private String newReviewOrganizationDocumentNumber;

    public Long getNewProtocolReviewCommitteeMembershipId() {
        return newProtocolReviewCommitteeMembershipId;
    }

    public void setNewProtocolReviewCommitteeMembershipId(Long newProtocolReviewCommitteeMembershipId) {
        this.newProtocolReviewCommitteeMembershipId = newProtocolReviewCommitteeMembershipId;
    }

    public String getNewReviewerTypeCode() {
        return newReviewerTypeCode;
    }

    public void setNewReviewerTypeCode(String newReviewerTypeCode) {
        this.newReviewerTypeCode = newReviewerTypeCode;
    }

    public Date getNewReviewDateRequested() {
        return newReviewDateRequested;
    }

    public void setNewReviewDateRequested(Date newReviewDateRequested) {
        this.newReviewDateRequested = newReviewDateRequested;
    }

    public Date getNewReviewDateDue() {
        return newReviewDateDue;
    }

    public void setNewReviewDateDue(Date newReviewDateDue) {
        this.newReviewDateDue = newReviewDateDue;
    }

    public String getNewReviewDocumentDescription() {
        return newReviewDocumentDescription;
    }

    public void setNewReviewDocumentDescription(String newReviewDocumentDescription) {
        this.newReviewDocumentDescription = newReviewDocumentDescription;
    }

    public String getNewReviewExplanation() {
        return newReviewExplanation;
    }

    public void setNewReviewExplanation(String newReviewExplanation) {
        this.newReviewExplanation = newReviewExplanation;
    }

    public String getNewReviewOrganizationDocumentNumber() {
        return newReviewOrganizationDocumentNumber;
    }

    public void setNewReviewOrganizationDocumentNumber(String newReviewOrganizationDocumentNumber) {
        this.newReviewOrganizationDocumentNumber = newReviewOrganizationDocumentNumber;
    }

    @Override
    public void refresh() {
    }
}
