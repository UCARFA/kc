/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.kuali.rice.krad.rules.rule.BusinessRule;


public interface InstitutionalProposalPersonUnitAddRule extends BusinessRule {

    public static final String PROPOSAL_PROJECT_PERSON_LIST_ERROR_KEY = "projectPersonnelBean.newAwardPersonUnit";
    public static final String ERROR_PROPOSAL_PROJECT_PERSON_PI_EXISTS = "error.awardProjectPerson.pi.exists";
    public static final String ERROR_PROPOSAL_PROJECT_PERSON_EXISTS = "error.awardProjectPerson.person.exists";
    public static final String ERROR_PROPOSAL_PROJECT_PERSON_DUPLICATE_UNITS = "error.awardProjectPerson.duplicate.units";
    public static final String NEW_UNIT_NUMBER_FIELD = "projectPersonnelBean.newInstitutionalProposalPersonUnit[0].unitNumber";
    
    /**
     * This method should be called before adding a new Project Person
     * @param event
     * @return
     */
    boolean processAddInstitutionalProposalPersonUnitBusinessRules(InstitutionalProposalPersonUnitRuleAddEvent event);
}
