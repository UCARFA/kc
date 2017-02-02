/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.kuali.coeus.common.budget.framework.core;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.bo.CostShareType;

public class ValidSourceAccountsCostShareType extends KcPersistableBusinessObjectBase {

    private Long code;
    private Integer costShareTypeCode;
    private Long sourceAccountCode;
    private CostShareType costShareType;
    private CostShareSourceAccount costShareSourceAccount;
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

    public CostShareSourceAccount getCostShareSourceAccount() {
        return costShareSourceAccount;
    }

    public void setCostShareSourceAccount(CostShareSourceAccount costShareSourceAccount) {
        this.costShareSourceAccount = costShareSourceAccount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
