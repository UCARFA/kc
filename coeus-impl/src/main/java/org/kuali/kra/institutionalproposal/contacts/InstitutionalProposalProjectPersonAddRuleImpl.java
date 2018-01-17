/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.rice.krad.util.GlobalVariables;


public class InstitutionalProposalProjectPersonAddRuleImpl extends BaseInstitutionalProposalContactAddRule implements
        InstitutionalProposalProjectPersonAddRule {

    @Override
    public boolean processAddInstitutionalProposalProjectPersonBusinessRules(InstitutionalProposalProjectPersonRuleAddEvent event) {
        InstitutionalProposalPerson newProjectPerson = event.getNewProjectPerson();
        InstitutionalProposal institutionalProposal = ((InstitutionalProposalDocument) event.getDocument()).getInstitutionalProposal();
        
        return checkForSelectedContactAndRole(newProjectPerson) && (checkForExistingPrincipalInvestigators(institutionalProposal, newProjectPerson) 
                                                                    & checkForDuplicatePerson(institutionalProposal, newProjectPerson));
    }
    
    boolean checkForSelectedContactAndRole(InstitutionalProposalContact newContact) {
        return super.checkForSelectedContactAndRole(newContact, PROPOSAL_PROJECT_PERSON_LIST_ERROR_KEY);
    }
    
    /**
     * Verify a PI exists
     * @param institutionalProposal
     * @param newProjectPerson
     * @return
     */
    boolean checkForExistingPrincipalInvestigators(InstitutionalProposal institutionalProposal, InstitutionalProposalPerson newProjectPerson) {
        boolean valid = true;
        if(newProjectPerson.isPrincipalInvestigator()) {
            for(InstitutionalProposalPerson p: institutionalProposal.getProjectPersons()) {
                if(p.isPrincipalInvestigator()) {
                    valid = false;
                    break;
                }
            }
        }
        
        if(!valid) {
            GlobalVariables.getMessageMap().putError(PROPOSAL_PROJECT_PERSON_LIST_ERROR_KEY, ERROR_PROPOSAL_PROJECT_PERSON_PI_EXISTS);
        }
        
        return valid;
    }

    /**
     * Verify no duplicate person
     * @param institutionalProposal
     * @param newProjectPerson
     * @return
     */
    boolean checkForDuplicatePerson(InstitutionalProposal institutionalProposal, InstitutionalProposalPerson newProjectPerson) {
        boolean valid = true;
        for(InstitutionalProposalPerson p: institutionalProposal.getProjectPersons()) {
            if (p.getClass().equals(newProjectPerson.getClass()) 
                    && p.getContact().getIdentifier().equals(newProjectPerson.getContact().getIdentifier())
                    && isImportantPerson(p) && isImportantPerson(newProjectPerson)) {
                valid = false;
                break;
            }
        }
        
        if(!valid) {
            GlobalVariables.getMessageMap().putError(PROPOSAL_PROJECT_PERSON_LIST_ERROR_KEY, ERROR_PROPOSAL_PROJECT_PERSON_EXISTS, 
                                                                                newProjectPerson.getContact().getFullName());
        }

        return valid;
    }
    
    private boolean isProjectPersonInvestigator(InstitutionalProposalPerson projectPerson) {
        return projectPerson.isCoInvestigator() || projectPerson.isPrincipalInvestigator();
    }

    private boolean isImportantPerson(InstitutionalProposalPerson person) {
        return isProjectPersonInvestigator(person) || person.isKeyPerson() || person.isMultiplePi();
    }
}
