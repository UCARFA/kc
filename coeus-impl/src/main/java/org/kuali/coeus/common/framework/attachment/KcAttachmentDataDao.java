/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.attachment;

public interface KcAttachmentDataDao {
	
	/**
	 * Using the ID provided, retrieves the given file data stored in the file_data table.
	 * @param id the id.  If blank will return null
	 * @return the data or null if the id is blank
	 */
    byte[] getData(String id);
    
    /**
     * Stores the data and returns a new randomly generated ID value that can be used to retrieve the
     * data. If the BO calling this previously stored data, pass in the previous ID and it will be deleted
     * before saving the new data.
     * @param data the data.  cannot be null or empty
     * @param previousId optional, used to delete any previously stored data before persisting new data.
     * @return the id for the saved data
     */
    String saveData(byte[] data, String previousId);
    
    /**
     * Removes the record from file_data table by id.
     * @param id the id.  If blank will return null
     */
    void removeData(String id);
}
