/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.closeout;

import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;

/**
 * The AwardCloseoutRuleImpl
 */
public class AwardCloseoutRuleImpl extends KcTransactionalDocumentRuleBase implements AwardCloseoutRule {
        
    private static final String CLOSEOUT_REPORT_NAME_PROPERTY = "closeoutReportName";
    private static final String REPORT_NAME_ERROR_PARM = "Final Report (Final Report)";

    /**
     * 
     * @see org.kuali.kra.award.paymentreports.closeout.AwardCloseoutRule#processAwardCloseoutBusinessRules(
     *          org.kuali.kra.award.paymentreports.closeout.AwardCloseoutRuleEvent)
     */
    @Override
    public boolean processAwardCloseoutBusinessRules(AwardCloseoutRuleEvent event) {
        return processCommonValidations(event);        
    }
    /**
     * 
     * This method processes new AwardCloseout rules
     * 
     * @param event
     * @return
     */
    @Override
    public boolean processAddAwardCloseoutBusinessRules(AddAwardCloseoutRuleEvent event) {
        return areRequiredFieldsComplete(event.getCloseoutItemForValidation()) && processCommonValidations(event);        
    }
    
    /*
     * This method processes the common validations.
     * 
     * @param event
     * @return
     */
    private boolean processCommonValidations(AwardCloseoutRuleEvent event) {
        AwardCloseout closeoutItem = event.getCloseoutItemForValidation();        
        List<AwardCloseout> items = event.getAward().getAwardCloseoutItems();
        return isUnique(items, closeoutItem);
    }
    
    /*
     * An closeout item is unique if no other matching items are in the collection
     * To know if this is a new add or an edit of an existing equipment item, we check 
     * the identifier for nullity. If null, this is an add; otherwise, it's an update
     * If an update, then we expect to find one match in the collection (itself). If an add, 
     * we expect to find no matches in the collection 
     * @param closeoutItems
     * @param closeoutItem
     * @return
     */
    protected boolean isUnique(List<AwardCloseout> closeoutItems, AwardCloseout closeoutItem) {
        boolean duplicateFound = false;
        for(AwardCloseout listItem: closeoutItems) {
            duplicateFound = closeoutItem != listItem && listItem.equals(closeoutItem);
            if(duplicateFound) {
                if(!hasDuplicateErrorBeenReported()) {
                    reportError(CLOSEOUT_ITEMS_LIST_ERROR_KEY, KeyConstants.ERROR_AWARD_CLOSEOUT_ITEM_NOT_UNIQUE, REPORT_NAME_ERROR_PARM);
                }
                break;
            }
        }
        
        return !duplicateFound;
    }

    /*
     * Validate required fields present
     * @param closeoutItem
     * @return
     */
    protected boolean areRequiredFieldsComplete(AwardCloseout closeoutItem) {        
        boolean itemValid = closeoutItem != null && closeoutItem.getCloseoutReportName() != null;
        
        if(!itemValid) {
            reportError(CLOSEOUT_REPORT_NAME_PROPERTY, KeyConstants.ERROR_AWARD_CLOSEOUT_REPORT_NAME_REQUIRED, REPORT_NAME_ERROR_PARM);
        }        
        
        return itemValid;
    }
    
    private boolean hasDuplicateErrorBeenReported() {
        return GlobalVariables.getMessageMap().containsMessageKey(KeyConstants.ERROR_AWARD_CLOSEOUT_ITEM_NOT_UNIQUE);
    }
}
