/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.printing;

import org.kuali.rice.krad.bo.BusinessObjectBase;

public class AwardTransactionSelectorBean extends BusinessObjectBase {

    private Integer awardVersion;
    private Integer amountInfoIndex;
    private Boolean requireSignature;

    @Override
    public void refresh() {
        //do nothing
    }

    public Integer getAwardVersion() {
        return awardVersion;
    }

    public void setAwardVersion(Integer awardVersion) {
        this.awardVersion = awardVersion;
    }

    public Boolean getRequireSignature() {
        return requireSignature;
    }

    public void setRequireSignature(Boolean requireSignature) {
        this.requireSignature = requireSignature;
    }

    public Integer getAmountInfoIndex() {
        return amountInfoIndex;
    }

    public void setAmountInfoIndex(Integer amountInfoIndex) {
        this.amountInfoIndex = amountInfoIndex;
    }
    

}
