/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.rate;

/**
 * 
 * This class represents INSTITUTE_LA_RATE record
 */
public class InstituteLaRate extends AbstractInstituteRate {

    private static final long serialVersionUID = 6467972635670502396L;

    @Override
    protected AbstractBudgetRate createBudgetRate() {
        return new BudgetLaRate();
    }
}
