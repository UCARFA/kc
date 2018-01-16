/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBase;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class is to handle Award template sync
 */
public class AwardTemplateSyncEvent  extends KcDocumentEventBase {

    private AwardDocument awardDocument;
    private Award award;


    public AwardTemplateSyncEvent(String description, String errorPathPrefix, Document document) {
        super(description, errorPathPrefix, document);
        this.awardDocument = (AwardDocument)document;
        this.award = awardDocument.getAward();
    }

    @Override
    protected void logEvent() {
        
    }

    @Override
    public Class getRuleInterfaceClass() {
        return AwardTemplateSyncRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        
        return ((AwardTemplateSyncRule)rule).processAwardTemplateSyncRules(this);
    }

    /**
     * Gets the award attribute. 
     * @return Returns the award.
     */
    public Award getAward() {
        return award;
    }

    /**
     * Sets the award attribute value.
     * @param award The award to set.
     */
    public void setAward(Award award) {
        this.award = award;
    }

}
