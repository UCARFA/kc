/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministrator;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.institutionalproposal.web.struts.form.InstitutionalProposalForm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class InstitutionalProposalCentralAdminContactsBean implements Serializable {


    private static final long serialVersionUID = 2893460587069915649L;

    
    protected InstitutionalProposalForm institutionalProposalForm;
    private List<InstitutionalProposalUnitContact> centralAdminContacts = new ArrayList<>();
    private static final String DEFAULT_GROUP_CODE_FOR_CENTRAL_ADMIN_CONTACTS = "C";
    
    
    public InstitutionalProposalCentralAdminContactsBean(InstitutionalProposalForm institutionalProposalForm) {
        this.institutionalProposalForm = institutionalProposalForm;
    }
    
    public void initCentralAdminContacts() {
        centralAdminContacts = new ArrayList<>();
        List<UnitAdministrator> unitAdministrators = 
            getUnitService().retrieveUnitAdministratorsByUnitNumber(institutionalProposalForm.getInstitutionalProposalDocument().getInstitutionalProposal().getUnitNumber());
        for(UnitAdministrator unitAdministrator : unitAdministrators) {
            if(unitAdministrator.getUnitAdministratorType().getDefaultGroupFlag().equals(DEFAULT_GROUP_CODE_FOR_CENTRAL_ADMIN_CONTACTS)) {
                KcPerson person = getKcPersonService().getKcPersonByPersonId(unitAdministrator.getPersonId());
                InstitutionalProposalUnitContact newInstitutionalProposalUnitContact = new InstitutionalProposalUnitContact();
                newInstitutionalProposalUnitContact.setInstitutionalProposal(institutionalProposalForm.getInstitutionalProposalDocument().getInstitutionalProposal());
                newInstitutionalProposalUnitContact.setPerson(person);
                newInstitutionalProposalUnitContact.setUnitAdministratorType(unitAdministrator.getUnitAdministratorType());
                newInstitutionalProposalUnitContact.setFullName(person.getFullName());
                centralAdminContacts.add(newInstitutionalProposalUnitContact);
            }
        }
    }
    
    public UnitService getUnitService() {
        return (UnitService) KcServiceLocator.getService(UnitService.class);
    }
    
    public KcPersonService getKcPersonService() {
        return (KcPersonService) KcServiceLocator.getService(KcPersonService.class);
    }


    /**
     * This method finds the count of InstitutionalProposalContacts in the "Central Administrator" category
     * @return The list; may be empty
     */
    public List<InstitutionalProposalUnitContact> getCentralAdminContacts() {
        return centralAdminContacts;
    }
    
    /**
     * This method finds the count of InstitutionalProposalContacts in the "Unit Contacts" category
     * @return The count; may be 0
     */
    public int getCentralAdminContactsCount() {
        return getCentralAdminContacts().size();
    }
}
