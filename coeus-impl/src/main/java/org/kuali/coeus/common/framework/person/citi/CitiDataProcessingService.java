/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.citi;


public interface CitiDataProcessingService {

    /**
     * This method processes all the of the citi records that are Staged, or Errored and does the following:
     *
     * 1) clears existing error messages for each record
     * 2) validates each record, saving any validation errors and marking Errored status if applicable
     * 3) Using the mapping table, generates new or updates existing training records, and marks the record as processed.
     *
     * At the end of this method, all records should be marked as either Processed or Errored.  If Errored, there
     * should be error messages present for the record.
     */
    void processRecords();
}
