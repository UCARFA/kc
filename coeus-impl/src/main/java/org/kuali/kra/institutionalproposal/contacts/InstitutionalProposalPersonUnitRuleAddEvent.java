/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBase;
import org.kuali.kra.award.contacts.AwardPersonUnitRuleAddEvent;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;


public class InstitutionalProposalPersonUnitRuleAddEvent extends KcDocumentEventBase {

private static final Log LOG = LogFactory.getLog(AwardPersonUnitRuleAddEvent.class);
    
    private InstitutionalProposalPersonUnit newPersonUnit;
    private InstitutionalProposalPerson projectPerson;
    
    protected InstitutionalProposalPersonUnitRuleAddEvent(String description, String errorPathPrefix, Document document, 
            InstitutionalProposalPerson projectPerson, InstitutionalProposalPersonUnit newPersonUnit) {
        super(description, errorPathPrefix, document);
        this.newPersonUnit = newPersonUnit;
        this.projectPerson = projectPerson;
    }


    public InstitutionalProposalPersonUnit getNewPersonUnit() {
        return newPersonUnit;
    }

    public InstitutionalProposalPerson getProjectPerson() {
        return projectPerson;
    }
    
    @Override
    public Class<InstitutionalProposalPersonUnitAddRule> getRuleInterfaceClass() {
        return InstitutionalProposalPersonUnitAddRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((InstitutionalProposalPersonUnitAddRule) rule).processAddInstitutionalProposalPersonUnitBusinessRules(this);
    }

    @Override
    protected void logEvent() {
        LOG.info("Logging AddInstitutionalProposalProjectPersonRuleEvent");
    }

}
