/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.kuali.kra.award.AwardDocumentRule;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class AwardFandaRateSaveEvent extends AwardFandaRateEvent {
    private int fandaRateIndex;

    /**
     * Constructs an AwardFandaRateSaveEvent with the given errorPathPrefix, 
     * awardDocument, and awardFandaRate.
     * 
     * @param errorPathPrefix
     * @param awardDocument
     * @param fandaRateIndex The index of the F&amp;A rate in the list of F&amp;A rates
     */
    public AwardFandaRateSaveEvent(String errorPathPrefix, AwardDocument awardDocument, int fandaRateIndex) {
        super("Saving F&A Rates in Award document " + getDocumentId(awardDocument)
                , errorPathPrefix, awardDocument, awardDocument.getAward().getAwardFandaRate().get(fandaRateIndex));
        this.fandaRateIndex = fandaRateIndex;
    }

    @Override
    public Class<? extends BusinessRule> getRuleInterfaceClass() {
        return AwardFandaRateSaveRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AwardDocumentRule) rule).processSaveFandaRateBusinessRules(this);
    }

    public int getFandaRateIndex() {
        return fandaRateIndex;
    }

}
