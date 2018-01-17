/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.impl.question;

public interface QuestionAuthorizationService {

    /**
     * 
     * This method checks if the current user has the specified permission.
     * @param permissionName the name of the permission
     * @return true if the user has permission; otherwise false
     */
    boolean hasPermission(String permissionName);
    
}
