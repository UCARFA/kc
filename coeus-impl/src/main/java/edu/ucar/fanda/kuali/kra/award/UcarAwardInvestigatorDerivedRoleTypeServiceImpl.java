package edu.ucar.fanda.kuali.kra.award;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.contacts.AwardUnitContact;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardService;
import org.kuali.kra.bo.AbstractProjectPerson;
import org.kuali.kra.kim.bo.KcKimAttributes;
import edu.ucar.fanda.kuali.kra.workflow.UcarAbstractProjectPersonDerivedRoleTypeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UcarAwardInvestigatorDerivedRoleTypeServiceImpl extends UcarAbstractProjectPersonDerivedRoleTypeServiceImpl {

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

    protected AwardService getAwardService() {
        return awardService;
    }

    public void setAwardService(AwardService awardService) {
        this.awardService = awardService;
    }

}
