/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.fundingproposal;

import org.apache.commons.lang3.StringUtils;

/**
 * Enum for determining the ways a proposal can be merged or added to an award.
 */
public enum FundingProposalMergeType {

    NOCHANGE("NC", "No Change"), MERGE("M", "Merge"), REPLACE("R", "Replace"), NEWAWARD("N", "Initial Funding");
    private String key;
    private String desc;
    private FundingProposalMergeType(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public static FundingProposalMergeType getFundingProposalMergeType(String key) {
        for (FundingProposalMergeType type : FundingProposalMergeType.values()) {
            if (StringUtils.equals(type.getKey(), key)) {
                return type;
            }
        }
        return null;
    }
}
