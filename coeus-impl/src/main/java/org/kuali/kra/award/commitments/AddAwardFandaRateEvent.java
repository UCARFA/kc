/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.kuali.kra.award.document.AwardDocument;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * 
 * This class represents the AddAwardFandaRateEvent
 */
public class AddAwardFandaRateEvent extends AwardFandaRateEvent{
    
    /**
     * Constructs an AddAwardFandaRateEvent with the given errorPathPrefix, 
     * awardDocument, and awardFandaRate.
     * 
     * @param errorPathPrefix
     * @param awardDocument
     * @param awardFandaRate
     */
    public AddAwardFandaRateEvent(String errorPathPrefix, AwardDocument awardDocument
            , AwardFandaRate awardFandaRate) {
        super("adding Indirect Cost Rate to Award document " + getDocumentId(awardDocument)
                , errorPathPrefix, awardDocument, awardFandaRate);
    }

    /**
     * Constructs an AddAwardFandaRateEvent with the given errorPathPrefix
     * , document, and awardFandaRate.
     * 
     * @param errorPathPrefix
     * @param document
     * @param awardFandaRate
     */
    public AddAwardFandaRateEvent(String errorPathPrefix, Document document
            , AwardFandaRate awardFandaRate) {
        this(errorPathPrefix, (AwardDocument) document, awardFandaRate);
    }

    @Override
    public Class<? extends BusinessRule> getRuleInterfaceClass() {
        return AwardFandaRateRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddFandaRateRule) rule).processAddFandaRateBusinessRules(this);
    }

}
