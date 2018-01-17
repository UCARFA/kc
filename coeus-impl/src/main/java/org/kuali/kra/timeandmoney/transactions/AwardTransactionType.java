/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.transactions;

import org.kuali.kra.award.AwardAssociate;

public class AwardTransactionType extends AwardAssociate {

    private static final long serialVersionUID = 1L;

    private Integer awardTransactionTypeCode;

    private String description;

    private boolean showInActionSummary;

    public AwardTransactionType() {
    }

    public Integer getAwardTransactionTypeCode() {
        return awardTransactionTypeCode;
    }

    public void setAwardTransactionTypeCode(Integer awardTransactionTypeCode) {
        this.awardTransactionTypeCode = awardTransactionTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getShowInActionSummary() {
        return showInActionSummary;
    }

    public void setShowInActionSummary(boolean showInActionSummary) {
        this.showInActionSummary = showInActionSummary;
    }

    @Override
    public void resetPersistenceState() {
    }
}
