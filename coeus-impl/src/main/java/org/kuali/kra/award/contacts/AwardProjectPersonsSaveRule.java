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
public interface AwardProjectPersonsSaveRule extends BusinessRule {
    public static final String AWARD_PROJECT_PERSON_LIST_ERROR_KEY = "projectPersons";
    public static final String ERROR_AWARD_PROJECT_PERSON_NO_PI = "error.awardProjectPerson.no.pi.exists";
    public static final String ERROR_AWARD_PROJECT_PERSON_MULTIPLE_PI_EXISTS = "error.awardProjectPerson.pi.exists";
    public static final String ERROR_AWARD_PROJECT_KEY_PERSON_ROLE_REQUIRED = "error.awardProjectPerson.keyperson.role.required";
    public static final String ERROR_AWARD_PROJECT_PERSON_UNIT_DETAILS_REQUIRED = "error.awardProjectPerson.unit.details.required";
    public static final String ERROR_AWARD_PROJECT_PERSON_LEAD_UNIT_REQUIRED = "error.awardProjectPerson.lead.unit.required";
    public static final String ERROR_AWARD_PROJECT_PERSON_DUPLICATE_UNITS = "error.awardProjectPerson.duplicate.units";
    
    /**
     * This method should be called before adding a new Project Person
     * @param event
     * @return
     */
    boolean processSaveAwardProjectPersonsBusinessRules(SaveAwardProjectPersonsRuleEvent event);

}
