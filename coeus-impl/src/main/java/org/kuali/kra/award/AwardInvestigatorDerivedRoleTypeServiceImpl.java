/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AwardInvestigatorDerivedRoleTypeServiceImpl extends AbstractProjectPersonDerivedRoleTypeServiceImpl {
    
    protected List<String> requiredAttributes = new ArrayList<String>();
	{
		requiredAttributes.add(KcKimAttributes.AWARD);
	}
	
	private AwardService awardService;

    @Override
    protected List<? extends AbstractProjectPerson> getProjectPersons(Map<String, String> qualification) {
        String awardIdStr = qualification.get(KcKimAttributes.AWARD);

        if (StringUtils.isNotBlank(awardIdStr) && awardIdStr.matches("\\d+")) {
            Long awardId = Long.valueOf(awardIdStr);
            Award award = getAwardService().getAward(awardId);
            return award.getProjectPersons();
        } else {
            return new ArrayList<AbstractProjectPerson>();
        }
    }

    // UCAR Unit Contacts
    protected List<? extends AwardUnitContact> getProjectUnitContacts(Map<String, String> qualification) {
        String awardIdStr = qualification.get(KcKimAttributes.AWARD);

        if (StringUtils.isNotBlank(awardIdStr) && awardIdStr.matches("\\d+")) {
            Long awardId = Long.valueOf(awardIdStr);
            Award award = getAwardService().getAward(awardId);

            return award.getAwardUnitContacts();
        } else {
            return new ArrayList<AwardUnitContact>();
        }
    }

    @Override
    public List<RoleMembership> getRoleMembersFromDerivedRole(String namespaceCode, String roleName, Map<String,String> qualification) {
        validateRequiredAttributesAgainstReceived(qualification);

        List<RoleMembership> members = new ArrayList<RoleMembership>();
        List<? extends AbstractProjectPerson> projectPersons = getProjectPersons(qualification);
        String subQualification = qualification.get(KcKimAttributes.SUB_QUALIFIER);
        // UCAR - Add unit contacts
        List<? extends AwardUnitContact> projectUnitContacts = getProjectUnitContacts(qualification);

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
    protected AwardService getAwardService() {
        return awardService;
    }

    public void setAwardService(AwardService awardService) {
        this.awardService = awardService;
    }

}
