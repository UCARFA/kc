/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministratorType;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.GlobalVariables;


public class InstitutionalProposalUnitContactAddRuleImpl {

    public static final String INSTITUTIONAL_PROPOSAL_UNIT_CONTACT_LIST_ERROR_KEY = "unitContactsBean.unitContact.unitAdministratorTypeCode";
    public static final String ERROR_INSTITUTIONAL_PROPOSAL_UNIT_CONTACT_EXISTS = "error.institutionalProposalUnitContact.person.exists";
    public static final String ERROR_INSTITUTIONAL_PROPOSAL_CONTACT_REQUIRED = "error.institutionalProposal.contact.person.required";
    public static final String ERROR_INSTITUTIONAL_PROPOSAL_CONTACT_ROLE_REQUIRED = "error.institutionalProposal.contact.person.role.required";
    private static final String PERSON_ERROR_KEY = "unitContactsBean.newInstitutionalProposalContact.fullName";
    
    /**
     * @param event
     * @return
     */
    public boolean processAddInstitutionalProposalUnitContactBusinessRules(InstitutionalProposal institutionalProposal, 
                                                                                InstitutionalProposalUnitContact newUnitContact) {
        boolean valid = checkForSelectedContactAdministratorTypeCode(newUnitContact);
        valid &= checkForDuplicatePerson(institutionalProposal, newUnitContact);
        valid &= checkForSelectedPerson(newUnitContact);
        return  valid; 
    }

    public boolean checkForSelectedContactAdministratorTypeCode(InstitutionalProposalUnitContact newContact) {
        InstitutionalProposalUnitContact institutionalProposalUnitContact = (InstitutionalProposalUnitContact) newContact;
        boolean valid = institutionalProposalUnitContact.getUnitAdministratorTypeCode() != null;

        if(!valid) {
            GlobalVariables.getMessageMap().putError(INSTITUTIONAL_PROPOSAL_UNIT_CONTACT_LIST_ERROR_KEY, ERROR_INSTITUTIONAL_PROPOSAL_CONTACT_ROLE_REQUIRED);
        }

        return valid;
    }
    
    private boolean checkForSelectedPerson(InstitutionalProposalUnitContact newContact) {
        boolean valid = true;

        if (StringUtils.isBlank(newContact.getPersonId())) {
            if (StringUtils.isBlank(newContact.getFullName())) {
                GlobalVariables.getMessageMap().putError(PERSON_ERROR_KEY, KeyConstants.ERROR_MISSING_UNITCONTACT_PERSON);
            }
            else {
                GlobalVariables.getMessageMap().putError(PERSON_ERROR_KEY, KeyConstants.ERROR_INVALID_UNITCONTACT_PERSON);
            }
            valid = false;
        }

        return valid;
    }

    boolean checkForDuplicatePerson(InstitutionalProposal institutionalProposal, InstitutionalProposalUnitContact newUnitContact) {
        boolean valid = true;
        for(InstitutionalProposalUnitContact unitContact: institutionalProposal.getInstitutionalProposalUnitContacts()) {
            // equal, but not both are null
            valid = !(StringUtils.equals(unitContact.getPersonId(),newUnitContact.getPersonId()) 
                        && StringUtils.equals(unitContact.getUnitAdministratorTypeCode(),newUnitContact.getUnitAdministratorTypeCode()));
            if(!valid) {
                registerError(newUnitContact);
                break;
            }
        }
        
        return valid;
    }
    
    /**
     * Verify contact AND role are selected
     * @param newContact
     * @return
     */
    boolean checkForSelectedContactAndRole(InstitutionalProposalContact newContact, String errorPath) {
        return checkForSelectedContact(newContact, errorPath) & checkForSelectedContactRole(newContact, errorPath);
    }

    /**
     * Verify a contact is selected
     * @param newContact
     * @return
     */
    boolean checkForSelectedContact(InstitutionalProposalContact newContact, String errorPath) {
        boolean valid = newContact.getContact() != null;
        
        if(!valid) {
            GlobalVariables.getMessageMap().putError(errorPath, ERROR_INSTITUTIONAL_PROPOSAL_CONTACT_REQUIRED);
        }
        
        return valid;
    }

    /**
     * Verify a contact role is picked
     * @param newContact
     * @return
     */
    boolean checkForSelectedContactRole(InstitutionalProposalContact newContact, String errorPath) {
        InstitutionalProposalUnitContact ipuc = (InstitutionalProposalUnitContact) newContact; 
        boolean valid = ipuc.getUnitAdministratorTypeCode() != null;

        if(!valid) {
            GlobalVariables.getMessageMap().putError(errorPath, ERROR_INSTITUTIONAL_PROPOSAL_CONTACT_ROLE_REQUIRED);
        }

        return valid;
    }

    @SuppressWarnings("deprecation")
    private void registerError(InstitutionalProposalUnitContact newUnitContact) {
        String roleDescription = getRoleDescription(newUnitContact);
        GlobalVariables.getMessageMap().putError(PERSON_ERROR_KEY, ERROR_INSTITUTIONAL_PROPOSAL_UNIT_CONTACT_EXISTS, 
                                                newUnitContact.getContact().getFullName(), roleDescription);
    }

    private String getRoleDescription(InstitutionalProposalUnitContact newUnitContact) {
        String roleDescription = "";
        BusinessObjectService boService = KcServiceLocator.getService(BusinessObjectService.class);
        UnitAdministratorType aType = boService.findBySinglePrimaryKey(UnitAdministratorType.class, newUnitContact.getUnitAdministratorTypeCode());
        if (aType != null) {
            roleDescription = aType.getDescription();
        }
        return roleDescription;
    }
}
