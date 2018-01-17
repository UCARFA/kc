/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.paymentschedule;

import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;

/**
 * The AwardPaymentScheduleRuleImpl
 */
public class AwardPaymentScheduleRuleImpl extends KcTransactionalDocumentRuleBase
                                            implements AwardPaymentScheduleRule {

    private static final String DUE_DATE_ERROR_PARM = "Due Date (Due Date)";

    /**
     * 
     * @see org.kuali.kra.award.paymentreports.paymentschedule.AwardPaymentScheduleRule#processAwardPaymentScheduleBusinessRules(
     * org.kuali.kra.award.paymentreports.paymentschedule.AwardPaymentScheduleRuleEvent)
     */
    @Override
    public boolean processAwardPaymentScheduleBusinessRules(AwardPaymentScheduleRuleEvent event) {
        return processCommonValidations(event);        
    }
    /**
     * 
     * This method processes new AwardPaymentSchedule rules
     * 
     * @param event
     * @return
     */
    @Override
    public boolean processAddAwardPaymentScheduleBusinessRules(AddAwardPaymentScheduleRuleEvent event) {
        return processCommonValidations(event);        
    }
    
    private boolean processCommonValidations(AwardPaymentScheduleRuleEvent event) {
        AwardPaymentSchedule paymentScheduleItem = event.getPaymentScheduleItemForValidation();        
        List<AwardPaymentSchedule> items = event.getAward().getPaymentScheduleItems();
        return isUnique(items, paymentScheduleItem);
    }
    
    /**
     * An payment schedule item is unique if no other matching items are in the collection
     * To know if this is a new add or an edit of an existing equipment item, we check 
     * the identifier for nullity. If null, this is an add; otherwise, it's an update
     * If an update, then we expect to find one match in the collection (itself). If an add, 
     * we expect to find no matches in the collection 
     * @param paymentScheduleItems
     * @param paymentScheduleItem
     * @return
     */
    boolean isUnique(List<AwardPaymentSchedule> paymentScheduleItems, AwardPaymentSchedule paymentScheduleItem) {
        boolean duplicateFound = false;
        for(AwardPaymentSchedule listItem: paymentScheduleItems) {
            duplicateFound = paymentScheduleItem != listItem && listItem.equals(paymentScheduleItem);
            if(duplicateFound) {
                break;
            }
        }
        
        if(duplicateFound) {
            if(!hasDuplicateErrorBeenReported()) {
                reportError(PAYMENT_SCHEDULE_ITEMS_LIST_ERROR_KEY, 
                        KeyConstants.ERROR_AWARD_PAYMENT_SCHEDULE_ITEM_NOT_UNIQUE, DUE_DATE_ERROR_PARM);
            }
        }
        return !duplicateFound;
    }
    
    private boolean hasDuplicateErrorBeenReported() {
        return GlobalVariables.getMessageMap().containsMessageKey(KeyConstants.ERROR_AWARD_PAYMENT_SCHEDULE_ITEM_NOT_UNIQUE);
    }
}
