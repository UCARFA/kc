/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.auth;

/**
 * This class checks authorization for answering COI disclosure questionnaires
 */
public class AnswerCoiDisclosureQuestionnaireAuthorizer extends ModifyCoiDisclosureAuthorizer {
    
    @Override
    public boolean isAuthorized(String userId, CoiDisclosureTask task) {
        return super.isAuthorized(userId, task);
    }

}
