/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.kuali.coeus.common.framework.type.InvestigatorCreditType;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This class processes AwardPersonCreditSplitRules
 */
public class AwardPersonUnitCreditSplitRuleImpl extends KcTransactionalDocumentRuleBase implements AwardPersonUnitCreditSplitRule {
    private static final ScaleTwoDecimal MAX_TOTAL_VALUE = new ScaleTwoDecimal(100.00);
    
    @Override
    public boolean checkAwardPersonUnitCreditSplitTotals(AwardPersonUnitCreditSplitRuleEvent event) {
        int errorCount = 0;
        AwardPerson person = event.getProjectPerson();
        for(InvestigatorCreditType creditType: loadInvestigatorCreditTypes()) {
            if(creditType.addsToHundred()) {
                ScaleTwoDecimal value = event.getTotalsByCreditSplitType().get(creditType.getCode());
                if(value == null) {
                    break;   // value may not have been initialized yet, so we don't want to block save
                }
                if(!MAX_TOTAL_VALUE.subtract(value).isZero()) {
                    reportError(AWARD_CREDIT_SPLIT_LIST_ERROR_KEY, AWARD_PERSON_UNIT_CREDIT_SPLIT_ERROR_MSG_KEY,
                                creditType.getDescription(), person.getFullName());
                    errorCount++;
                }
            }
        }
        
        return errorCount == 0;
        
    }
    
    @SuppressWarnings("unchecked")
    Collection<InvestigatorCreditType> loadInvestigatorCreditTypes() {
        Map<String,String> valueMap = new HashMap<String, String>();
        valueMap.put("active", "true");
        return getBusinessObjectService().findMatching(InvestigatorCreditType.class, valueMap);
    }
}
