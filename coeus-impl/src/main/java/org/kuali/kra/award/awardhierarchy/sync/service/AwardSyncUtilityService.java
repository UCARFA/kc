/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.service;

import org.kuali.kra.award.awardhierarchy.sync.AwardSyncLog;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncStatus;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.bo.PersistableBusinessObject;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface AwardSyncUtilityService {

    /**
     * 
     * Parse the message map and grab error messages out expanding the error key for the status
     * message.
     * @param awardStatus
     * @return
     */
    List<AwardSyncLog> getLogsFromSaveErrors(AwardSyncStatus awardStatus);
    
    /**
     * 
     * Parse the audit error map out and generate hierarchy sync logs expanding out
     * the error key for the real error.
     * @param awardStatus
     * @return
     */
    List<AwardSyncLog> getLogsFromAuditErrors(AwardSyncStatus awardStatus);
    
    /**
     * 
     * Based on org.kuali.rice.kew.routelog.web.RouteLogAction.populateRouteLogFutureRequests
     * that is used to generate the list of requests for a document enroute.
     * @param awardDocument
     * @return
     * @throws WorkflowException
     */
    List<String> buildListForFYI(AwardDocument awardDocument) throws WorkflowException;
    
    /**
     * Returns true if the object passed in has the same sync keys as keyValues.
     * @param object
     * @param keyValues
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     */
    boolean doKeyValuesMatch(PersistableBusinessObject object, Map<String, Object> keyValues)
        throws NoSuchFieldException, IllegalAccessException, 
        InvocationTargetException, ClassNotFoundException;  
    
    /**
     * Finds a BO in the collection whose keys match those in the keyValue map.
     * @param items
     * @param keyValues
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     */
    PersistableBusinessObject findMatchingBo(Collection<? extends PersistableBusinessObject> items, Map<String, Object> keyValues) 
        throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;    
}
