/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.subawardrule;

import org.kuali.kra.subaward.bo.SubAwardAmountReleased;
import org.kuali.rice.kns.rule.PromptBeforeValidation;
import org.kuali.rice.kns.rules.PromptBeforeValidationBase;
import org.kuali.rice.krad.document.Document;

import java.util.Calendar;

/**
 * If a newly created Permanent proposal log has the same PI as one or more Temporary logs,
 * check if the user wants to merge one of the Temporary logs to the Permanent log.
 * This prompt will occur upon submission of the Permanent log.
 */
public class SubAwardInvoicePromptBeforeValidation extends PromptBeforeValidationBase implements PromptBeforeValidation {
    
    protected static final String EFFECTIVE_DATE_PROMPT_ID = "effectiveDate";
    protected static final String EFFECTIVE_DATE_PROMPT = "Invoice Effective Date is more than 30 days in the past or more than 30 days in the future. Do you wish to continue?";
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean doPrompts(Document document) {
        SubAwardAmountReleased invoice = (SubAwardAmountReleased) document.getNoteTarget();
        if (invoice.getEffectiveDate() != null) {
            Calendar beforeEffective = Calendar.getInstance();
            beforeEffective.add(Calendar.DAY_OF_MONTH, -30);
            Calendar afterEffective = Calendar.getInstance();
            afterEffective.add(Calendar.DAY_OF_MONTH, 30);
            Calendar effectiveDate = Calendar.getInstance();
            effectiveDate.setTime(invoice.getEffectiveDate());
            
            if (effectiveDate.before(beforeEffective) || effectiveDate.after(afterEffective)) {
                if (!askOrAnalyzeYesNoQuestion(EFFECTIVE_DATE_PROMPT_ID, EFFECTIVE_DATE_PROMPT)) {
                    abortRulesCheck();
                    return false;
                } else {
                    return true;
                }
            } 
        }
        return true;
    }
}
