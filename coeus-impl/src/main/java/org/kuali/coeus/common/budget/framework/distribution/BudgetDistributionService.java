/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.distribution;

import org.kuali.coeus.common.budget.framework.core.Budget;

public interface BudgetDistributionService {

    /**
     * This method initializes both the Cost Sharing and Unrecovered F&amp;A defaults
     */
    public void initializeCollectionDefaults(Budget budget);
    
    /**
     * This method initializes the Cost Sharing defaults
     */
    public void initializeCostSharingCollectionDefaults(Budget budget);
    
    /**
     * This method initializes the Unrecovered F&amp;A defaults
     */
    public void initializeUnrecoveredFandACollectionDefaults(Budget budget);
    
}
