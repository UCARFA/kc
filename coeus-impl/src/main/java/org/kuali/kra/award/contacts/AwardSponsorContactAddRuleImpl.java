/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.kuali.kra.award.home.Award;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * This class implements the specified rule
 */
public class AwardSponsorContactAddRuleImpl extends BaseAwardContactAddRule {
    public static final String AWARD_SPONSOR_CONTACT_LIST_ERROR_KEY = "sponsorContactsBean.newAwardContact";
    public static final String ERROR_AWARD_SPONSOR_CONTACT_EXISTS = "error.awardSponsorContact.person.exists";

    public boolean processAddAwardSponsorContactBusinessRules(Award award, AwardSponsorContact newContact) {
        return checkForSelectedContactAndRole(newContact, AWARD_SPONSOR_CONTACT_LIST_ERROR_KEY) && checkForDuplicatePerson(award, newContact);
    }

    boolean checkForDuplicatePerson(Award award, AwardSponsorContact newContact) {
        boolean valid = true;
        for(AwardSponsorContact unitContact: award.getSponsorContacts()) {
            valid = !(unitContact.getRolodexId().equals(newContact.getRolodexId()) && unitContact.getRoleCode().equalsIgnoreCase(newContact.getContactRoleCode()));
            if(!valid) {
                GlobalVariables.getMessageMap().putError(AWARD_SPONSOR_CONTACT_LIST_ERROR_KEY, ERROR_AWARD_SPONSOR_CONTACT_EXISTS, newContact.getFullName(), newContact.getContactRole().getRoleDescription());
                break;
            }
        }
        
        return valid;
    }
}
