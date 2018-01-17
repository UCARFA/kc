/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.transactions;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This interface defines the rule processing method
 */

public interface TransactionRule extends BusinessRule {
    public static final String PENDING_TRANSACTION_ITEMS_LIST_ERROR_KEY = "pendingTransactionItems";
    
    /**
     * This method is used to validate AwardPaymentSchedule items in an Award
     * @param awardApprovedEquipmentRuleEvent
     * @return
     */
    boolean processPendingTransactionBusinessRules(TransactionRuleEvent event);
    
    /**
     * 
     * This method is used to validate a new AwardPaymentSchedule to be added to an Award
     * @param event
     * @return
     */
    boolean processAddPendingTransactionBusinessRules(AddTransactionRuleEvent event);
}
