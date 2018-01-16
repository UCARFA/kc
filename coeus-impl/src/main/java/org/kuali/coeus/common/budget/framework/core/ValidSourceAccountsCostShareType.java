/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.budget.framework.core;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.bo.CostShareType;

public class ValidSourceAccountsCostShareType extends KcPersistableBusinessObjectBase {

    private Long code;
    private Integer costShareTypeCode;
    private Long sourceAccountCode;
    private CostShareType costShareType;
    private Account account;
    private Boolean active = Boolean.TRUE;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Integer getCostShareTypeCode() {
        return costShareTypeCode;
    }

    public void setCostShareTypeCode(Integer costShareTypeCode) {
        this.costShareTypeCode = costShareTypeCode;
    }

    public Long getSourceAccountCode() {
        return sourceAccountCode;
    }

    public void setSourceAccountCode(Long sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
    }

    public CostShareType getCostShareType() {
        return costShareType;
    }

    public void setCostShareType(CostShareType costShareType) {
        this.costShareType = costShareType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
