/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service;

public interface ObjectCodeToBudgetCategoryCodeService {
    /**
     * This method returns the budget category code for a given object code.
     * @param objectCode identifier for the object code
     * @return The budget category code for the relative object code.
     */
    public String getBudgetCategoryCodeForCostElment(String objectCode);

}
