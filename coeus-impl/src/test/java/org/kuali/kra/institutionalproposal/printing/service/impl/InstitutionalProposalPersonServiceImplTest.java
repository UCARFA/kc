package org.kuali.kra.institutionalproposal.printing.service.impl;


import junit.framework.Assert;
import org.junit.Test;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPerson;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPersonUnit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InstitutionalProposalPersonServiceImplTest {

    @Test
    public void testGetPersonsSelectedForCreditSplitWithOptInEnabled() {

        InstitutionalProposalPersonServiceImpl service = new InstitutionalProposalPersonServiceImpl() {
            @Override
            public Boolean isCreditSplitOptInEnabled() {
                return true;
            }
        };

        List<InstitutionalProposalPerson> proposalPersons = new ArrayList<>();
        InstitutionalProposalPerson institutionalProposalPerson1 = new MockInstitutionalProposalPerson();
        institutionalProposalPerson1.setIncludeInCreditAllocation(false);
        institutionalProposalPerson1.setContactRoleCode(ContactRole.PI_CODE);

        InstitutionalProposalPerson institutionalProposalPerson2 = new MockInstitutionalProposalPerson();
        institutionalProposalPerson2.setIncludeInCreditAllocation(true);
        institutionalProposalPerson2.setContactRoleCode(ContactRole.COI_CODE);

        proposalPersons.add(institutionalProposalPerson1);
        proposalPersons.add(institutionalProposalPerson2);

        List<InstitutionalProposalPerson> filteredPersons = service.getPersonsSelectedForCreditSplit(proposalPersons);
        Assert.assertTrue(filteredPersons.size() == 1);

        InstitutionalProposalPersonUnit unit1 = new InstitutionalProposalPersonUnit();
        unit1.setUnitNumber("000001");
        institutionalProposalPerson1.add(unit1);

        filteredPersons = service.getPersonsSelectedForCreditSplit(proposalPersons);
        Assert.assertTrue(filteredPersons.size() == 1);

        institutionalProposalPerson2.add(unit1);
        filteredPersons = service.getPersonsSelectedForCreditSplit(proposalPersons);
        Assert.assertTrue(filteredPersons.size() == 1);
        Assert.assertTrue(filteredPersons.get(0).getContactRoleCode().equalsIgnoreCase(ContactRole.COI_CODE));

        institutionalProposalPerson1.setIncludeInCreditAllocation(true);
        filteredPersons = service.getPersonsSelectedForCreditSplit(proposalPersons);
        Assert.assertTrue(filteredPersons.size() == 2);

        institutionalProposalPerson1.setIncludeInCreditAllocation(null);
        institutionalProposalPerson2.setIncludeInCreditAllocation(null);
        filteredPersons = service.getPersonsSelectedForCreditSplit(proposalPersons);
        Assert.assertTrue(filteredPersons.size() == 2);

    }

    @Test
    public void testGetPersonsSelectedForCreditSplitWithOptInDisabled() {

        InstitutionalProposalPersonServiceImpl service = new InstitutionalProposalPersonServiceImpl() {
            @Override
            public Boolean isCreditSplitOptInEnabled() {
                return false;
            }
        };

        List<InstitutionalProposalPerson> proposalPersons = new ArrayList<>();
        InstitutionalProposalPerson institutionalProposalPerson1 = new MockInstitutionalProposalPerson();
        institutionalProposalPerson1.setIncludeInCreditAllocation(false);
        institutionalProposalPerson1.setContactRoleCode(ContactRole.PI_CODE);

        InstitutionalProposalPerson institutionalProposalPerson2 = new MockInstitutionalProposalPerson();
        institutionalProposalPerson2.setIncludeInCreditAllocation(true);
        institutionalProposalPerson2.setContactRoleCode(ContactRole.COI_CODE);

        InstitutionalProposalPerson institutionalProposalPerson3 = new MockInstitutionalProposalPerson();
        institutionalProposalPerson3.setIncludeInCreditAllocation(true);
        institutionalProposalPerson3.setContactRoleCode(ContactRole.KEY_PERSON_CODE);

        proposalPersons.add(institutionalProposalPerson1);
        proposalPersons.add(institutionalProposalPerson2);
        proposalPersons.add(institutionalProposalPerson3);

        List<InstitutionalProposalPerson> filteredPersons = service.getPersonsSelectedForCreditSplit(proposalPersons);
        Assert.assertTrue(filteredPersons.size() == 3);

        InstitutionalProposalPersonUnit unit1 = new InstitutionalProposalPersonUnit();
        unit1.setUnitNumber("000001");
        institutionalProposalPerson1.add(unit1);

        filteredPersons = service.getPersonsSelectedForCreditSplit(proposalPersons);
        Assert.assertTrue(filteredPersons.size() == 3);
        Assert.assertTrue(filteredPersons.get(0).getContactRoleCode().equalsIgnoreCase(ContactRole.PI_CODE));

        institutionalProposalPerson2.add(unit1);
        institutionalProposalPerson3.add(unit1);

        filteredPersons = service.getPersonsSelectedForCreditSplit(proposalPersons);
        Assert.assertTrue(filteredPersons.size() == 3);

        institutionalProposalPerson1.setIncludeInCreditAllocation(true);
        filteredPersons = service.getPersonsSelectedForCreditSplit(proposalPersons);
        Assert.assertTrue(filteredPersons.size() == 3);

    }

    class MockInstitutionalProposalPerson extends InstitutionalProposalPerson {
        @Override
        public Boolean defaultIncludeInCreditAllocation(String proposalPersonRoleId) {
            final Collection<String> roles = new ArrayList<>();
            roles.add("PI");
            roles.add("COI");
            roles.add("MPI");
            return roles.contains(proposalPersonRoleId);
        }
    }
}
