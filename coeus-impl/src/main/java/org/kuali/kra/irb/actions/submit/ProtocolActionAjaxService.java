/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;


public interface ProtocolActionAjaxService extends org.kuali.kra.protocol.actions.ProtocolActionAjaxService {
    

    /**
     * Get the valid upcoming committee dates for scheduling a protocol.
     * This method is used exclusively by DWR for obtaining a list to show
     * to the end user in a drop-down menu.  To handle the conversion from
     * Java to JavaScript, the list is returned as a comma separated string.
     * The format is: <key1>;<description1>;<key2>;<description2>;...
     * @param committeeId the committee's unique id
     * @return the string representation of schedule dates
     */
    public String getValidCommitteeDates(String committeeId, String docFormKey);
}
