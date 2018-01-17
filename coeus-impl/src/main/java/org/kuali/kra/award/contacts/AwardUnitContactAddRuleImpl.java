/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministratorType;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * This class implements the specified rule
 */
public class AwardUnitContactAddRuleImpl extends BaseAwardContactAddRule {
    public static final String AWARD_UNIT_CONTACT_LIST_ERROR_KEY = "unitContactsBean.unitContact.unitAdministratorTypeCode";
    public static final String ERROR_AWARD_UNIT_CONTACT_EXISTS = "error.awardUnitContact.person.exists";
    private static final String PERSON_ERROR_KEY = "unitContactsBean.newAwardContact.fullName";
    /**
     * @param event
     * @return
     */
    public boolean processAddAwardUnitContactBusinessRules(Award award, AwardUnitContact newUnitContact) {
        boolean valid = checkForSelectedContactAdministratorTypeCode(newUnitContact);
        valid &= checkForDuplicatePerson(award, newUnitContact);
        valid &= checkForSelectedPerson(newUnitContact);
        return  valid;
    }

    public boolean checkForSelectedContactAdministratorTypeCode(AwardUnitContact newContact) {
        AwardUnitContact awardUnitContact = (AwardUnitContact) newContact;
        boolean valid = awardUnitContact.getUnitAdministratorTypeCode() != null;

        if(!valid) {
            GlobalVariables.getMessageMap().putError(AWARD_UNIT_CONTACT_LIST_ERROR_KEY, ERROR_AWARD_CONTACT_ROLE_REQUIRED);
        }

        return valid;
    }
    
    private boolean checkForSelectedPerson(AwardUnitContact newContact) {
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

    boolean checkForDuplicatePerson(Award award, AwardUnitContact newUnitContact) {
        boolean valid = true;
        for(AwardUnitContact unitContact: award.getAwardUnitContacts()) {
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

    private void registerError(AwardUnitContact newUnitContact) {
        String roleDescription = getRoleDescription(newUnitContact);
        GlobalVariables.getMessageMap().putError(PERSON_ERROR_KEY, ERROR_AWARD_UNIT_CONTACT_EXISTS, 
                                                newUnitContact.getContact().getFullName(), roleDescription);
    }
    private String getRoleDescription(AwardUnitContact newUnitContact) {
        String roleDescription = "";
        BusinessObjectService boService = KcServiceLocator.getService(BusinessObjectService.class);
        UnitAdministratorType aType = boService.findBySinglePrimaryKey(UnitAdministratorType.class, newUnitContact.getUnitAdministratorTypeCode());
        if (aType != null) {
            roleDescription = aType.getDescription();
        }
        return roleDescription;
    }
}
