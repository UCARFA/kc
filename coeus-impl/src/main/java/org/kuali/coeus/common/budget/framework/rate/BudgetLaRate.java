/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.rate;

import org.kuali.coeus.common.budget.api.rate.BudgetLaRateContract;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EPS_PROP_LA_RATES")
public class BudgetLaRate extends AbstractBudgetRate implements BudgetLaRateContract {

    private static final long serialVersionUID = -993765790460645503L;

    public BudgetLaRate() {
        super();
    }

    public BudgetLaRate(String unitNumber, InstituteLaRate instituteLaRate) {
        super(unitNumber, instituteLaRate);
    }
}
