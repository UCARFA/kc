/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

/**
 * 
 * This class are the common API for all projects that need coi disclosure
 */
public interface Disclosurable {
// TODO : this should keep expanding when we moving forward for coi implementation
    /**
     * 
     * This method is mainly to get the title
     * @return
     */
    String getProjectName();
    
    /**
     * 
     * This method to get project number
     * @return
     */
    String getProjectId();
}
