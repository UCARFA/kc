/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class AwardBudgetStatus extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private String awardBudgetStatusCode;

    private String description;

    private AwardBudgetExt awardBudgetExt;

    public AwardBudgetStatus() {
    }

    public String getAwardBudgetStatusCode() {
        return awardBudgetStatusCode;
    }

    public void setAwardBudgetStatusCode(String awardBudgetStatusCode) {
        this.awardBudgetStatusCode = awardBudgetStatusCode;
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
