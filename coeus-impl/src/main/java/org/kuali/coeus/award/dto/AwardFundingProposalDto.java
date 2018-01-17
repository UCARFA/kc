/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.dto;

public class AwardFundingProposalDto {

    private Long awardFundingProposalId;

    private Long proposalId;

    private boolean active;

    private String mergeTypeCode;

    public String getMergeTypeCode() {
        return mergeTypeCode;
    }

    public void setMergeTypeCode(String mergeTypeCode) {
        this.mergeTypeCode = mergeTypeCode;
    }

    public Long getAwardFundingProposalId() {
        return awardFundingProposalId;
    }

    public void setAwardFundingProposalId(Long awardFundingProposalId) {
        this.awardFundingProposalId = awardFundingProposalId;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
