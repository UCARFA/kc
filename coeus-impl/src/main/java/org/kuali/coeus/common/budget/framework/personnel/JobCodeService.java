/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.personnel;


public interface JobCodeService {

    /**
     * 
     * This method provides the appropriate JobCode Title
     * for a particular jobCode string.
     * 
     * @param jobCode
     * @return
     */
    public String findJobCodeTitle(String jobCode);
    
    /**
     * 
     * This method provides the appropriate JobCode object
     * for a particular jobCode string.
     * 
     * @param jobCode
     * @return
     */
    public JobCode findJobCodeRef(String jobCode);
    
}
