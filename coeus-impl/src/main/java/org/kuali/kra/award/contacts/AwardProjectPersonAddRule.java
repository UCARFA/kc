/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This defines the rules for AwardProjectPerson
 */
public interface AwardProjectPersonAddRule extends BusinessRule {
    public static final String AWARD_PROJECT_PERSON_LIST_ERROR_KEY = "projectPersonnelBean.newAwardContact";
    public static final String ERROR_AWARD_PROJECT_PERSON_PI_EXISTS = "error.awardProjectPerson.pi.exists";
    public static final String ERROR_AWARD_PROJECT_PERSON_EXISTS = "error.awardProjectPerson.person.exists";
    public static final String ERROR_AWARD_PROJECT_KEY_PERSON_ROLE_REQUIRED = "error.awardProjectPerson.keyperson.role.required";
    
    /**
     * This method should be called before adding a new Project Person
     * @param event
     * @return
     */
    boolean processAddAwardProjectPersonBusinessRules(AwardProjectPersonRuleAddEvent event);

}
