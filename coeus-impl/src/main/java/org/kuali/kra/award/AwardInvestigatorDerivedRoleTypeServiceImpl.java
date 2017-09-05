/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.kra.award;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.contacts.AwardUnitContact;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardService;
import org.kuali.kra.bo.AbstractProjectPerson;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.kra.workflow.AbstractProjectPersonDerivedRoleTypeServiceImpl;

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
    // KTW - add unit contacts to list
    /*
    @Override
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
    */

    protected AwardService getAwardService() {
        return awardService;
    }

    public void setAwardService(AwardService awardService) {
        this.awardService = awardService;
    }

}
