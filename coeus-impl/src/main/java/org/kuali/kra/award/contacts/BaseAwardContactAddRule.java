/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.kuali.rice.krad.util.GlobalVariables;

/**
 * Common rule processing for adds
 */
public class BaseAwardContactAddRule {
    public static final String ERROR_AWARD_CONTACT_REQUIRED = "error.award.contact.person.required";
    public static final String ERROR_AWARD_CONTACT_ROLE_REQUIRED = "error.award.contact.person.role.required";

    /**
     * Verify contact AND role are selected
     * @param newContact
     * @return
     */
    boolean checkForSelectedContactAndRole(AwardContact newContact, String errorPath) {
        return checkForSelectedContact(newContact, errorPath) & checkForSelectedContactRole(newContact, errorPath);
    }

    /**
     * Verify a contact is selected
     * @param newContact
     * @return
     */
    boolean checkForSelectedContact(AwardContact newContact, String errorPath) {
        boolean valid = newContact.getContact() != null;
        
        if(!valid) {
            GlobalVariables.getMessageMap().putError(errorPath, ERROR_AWARD_CONTACT_REQUIRED);
        }
        
        return valid;
    }

    /**
     * Verify a contact role is picked
     * @param newContact
     * @return
     */
    boolean checkForSelectedContactRole(AwardContact newContact, String errorPath) {
        boolean valid = newContact.getContactRole() != null;

        if(!valid) {
            GlobalVariables.getMessageMap().putError(errorPath, ERROR_AWARD_CONTACT_ROLE_REQUIRED);
        }

        return valid;
    }
}
