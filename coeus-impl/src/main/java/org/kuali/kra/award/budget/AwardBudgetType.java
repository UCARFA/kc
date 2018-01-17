/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class AwardBudgetType extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private String awardBudgetTypeCode;

    private String description;

    private AwardBudgetExt awardBudgetExt;

    public AwardBudgetType() {
    }

    public String getAwardBudgetTypeCode() {
        return awardBudgetTypeCode;
    }

    public void setAwardBudgetTypeCode(String awardBudgetTypeCode) {
        this.awardBudgetTypeCode = awardBudgetTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AwardBudgetExt getAwardBudgetExt() {
        return awardBudgetExt;
    }

    public void setAwardBudgetExt(AwardBudgetExt awardBudgetExt) {
        this.awardBudgetExt = awardBudgetExt;
    }
}
