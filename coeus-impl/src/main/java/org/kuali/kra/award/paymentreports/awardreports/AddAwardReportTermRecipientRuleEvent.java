/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports;

import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class is for rule validation when adding new item
 */
public class AddAwardReportTermRecipientRuleEvent extends AwardReportTermRecipientRuleEvent {

    /**
     * 
     * Constructs a AddAwardReportTermRecipientRuleEvent.java.
     * @param errorPathPrefix
     * @param awardDocument
     * @param award
     * @param awardReportTermRecipientItem
     */
    public AddAwardReportTermRecipientRuleEvent(String errorPathPrefix, AwardDocument awardDocument, Award award, AwardReportTerm parentAwardReportTerm, AwardReportTermRecipient awardReportTermRecipientItem) {
        super(errorPathPrefix, awardDocument, award, parentAwardReportTerm, awardReportTermRecipientItem);
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AwardReportTermRecipientRule)rule).processAddAwardReportTermRecipientBusinessRules(this);
    }
}
