/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.bo;


import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class FundingSourceType extends KcPersistableBusinessObjectBase {

    public static final String SPONSOR = "1";

    public static final String UNIT = "2";

    public static final String OTHER = "3";

    public static final String PROPOSAL_DEVELOPMENT = "4";

    public static final String INSTITUTIONAL_PROPOSAL = "5";

    public static final String AWARD = "6";

    private String fundingSourceTypeCode;

    private String description;

    private boolean fundingSourceTypeFlag;

    public FundingSourceType() {
    }

    public String getFundingSourceTypeCode() {
        return fundingSourceTypeCode;
    }

    public void setFundingSourceTypeCode(String fundingSourceTypeCode) {
        this.fundingSourceTypeCode = fundingSourceTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getFundingSourceTypeFlag() {
        return fundingSourceTypeFlag;
    }

    public void setFundingSourceTypeFlag(boolean fundingSourceTypeFlag) {
        this.fundingSourceTypeFlag = fundingSourceTypeFlag;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((fundingSourceTypeCode == null) ? 0 : fundingSourceTypeCode.hashCode());
        result = prime * result + (fundingSourceTypeFlag ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FundingSourceType other = (FundingSourceType) obj;
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equalsIgnoreCase(other.description)) {
            return false;
        }
        if (fundingSourceTypeCode == null) {
            if (other.fundingSourceTypeCode != null) {
                return false;
            }
        } else if (!fundingSourceTypeCode.equals(other.fundingSourceTypeCode)) {
            return false;
        }
        if (fundingSourceTypeFlag != other.fundingSourceTypeFlag) {
            return false;
        }
        return true;
    }
}
