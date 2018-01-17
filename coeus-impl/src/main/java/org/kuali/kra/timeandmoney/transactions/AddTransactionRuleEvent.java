/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.transactions;

import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class is for rule validation when adding new item
 */
public class AddTransactionRuleEvent extends TransactionRuleEvent {

    /**
     * Constructs a AddTransactionRuleEvent.
     * @param errorPathPrefix
     * @param timeAndMoneyDocument
     * @param pendingTransactionItem
     */
    public AddTransactionRuleEvent(String errorPathPrefix, TimeAndMoneyDocument timeAndMoneyDocument, PendingTransaction pendingTransactionItem) {
        super(errorPathPrefix, timeAndMoneyDocument, pendingTransactionItem);
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((TransactionRule)rule).processAddPendingTransactionBusinessRules(this);
    }
}
