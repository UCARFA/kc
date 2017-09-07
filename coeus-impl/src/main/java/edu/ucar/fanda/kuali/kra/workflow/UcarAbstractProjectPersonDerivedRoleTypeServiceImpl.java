package edu.ucar.fanda.kuali.kra.workflow;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.contacts.AwardUnitContact;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardService;
import org.kuali.kra.bo.AbstractProjectPerson;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.kra.workflow.AbstractProjectPersonDerivedRoleTypeServiceImpl;
import org.kuali.rice.core.api.membership.MemberType;
import org.kuali.rice.kim.api.role.RoleMembership;
import org.kuali.rice.kns.kim.role.DerivedRoleTypeServiceBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class UcarAbstractProjectPersonDerivedRoleTypeServiceImpl extends AbstractProjectPersonDerivedRoleTypeServiceImpl {
    // UCAR - Add unit contacts
    protected abstract List<? extends AwardUnitContact> getProjectUnitContacts(Map<String, String> qualification);

    @Override
    public List<RoleMembership> getRoleMembersFromDerivedRole(String namespaceCode, String roleName, Map<String,String> qualification) {
        validateRequiredAttributesAgainstReceived(qualification);

        List<RoleMembership> members = new ArrayList<RoleMembership>();
        List<? extends AbstractProjectPerson> projectPersons = getProjectPersons(qualification);
        // UCAR - Add unit contacts
        List<? extends AwardUnitContact> projectUnitContacts = getProjectUnitContacts(qualification);


        String subQualification = qualification.get(KcKimAttributes.SUB_QUALIFIER);

        if (projectPersons != null && !projectPersons.isEmpty()) {
            if (!StringUtils.equals(roleName, Constants.ALL_INVESTIGATORS) && !StringUtils.equals(roleName, Constants.PRINCIPAL_INVESTIGATOR)) {
                projectPersons = filterListByRole(projectPersons, roleName);
            }

            if (StringUtils.isNotBlank(subQualification)) {
                projectPersons = filterListByRole(projectPersons, subQualification);
            }

            for (AbstractProjectPerson proposalPerson : projectPersons) {
                if (proposalPerson.getPerson() != null) {
                    members.add( RoleMembership.Builder.create(null, null, proposalPerson.getPerson().getPersonId(), MemberType.PRINCIPAL, null).build() );
                }
            }
            // UCAR - add unit contacts to role
            for (AwardUnitContact unitContact : projectUnitContacts) {
                if (unitContact.getPerson() != null) {
                    members.add( RoleMembership.Builder.create(null, null, unitContact.getPerson().getPersonId(), MemberType.PRINCIPAL, null).build() );
                }
            }
        }

        return members;
    }
}
