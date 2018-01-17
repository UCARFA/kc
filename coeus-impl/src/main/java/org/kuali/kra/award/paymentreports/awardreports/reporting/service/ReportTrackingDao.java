/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports.reporting.service;

import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTracking;
import org.kuali.rice.krad.dao.LookupDao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Report Tracking DAO interface.
 */
public interface ReportTrackingDao extends LookupDao {

    /**
     * Get a list of report tracking BOs with the groupedByAttr populated
     * and then sorted by the displayByAttrs. This allows grouping and returning
     * code fields but after an OJB refresh of the BO, sorting by the displayed
     * attributes(such as the related description fields).
     * @param searchValues
     * @param groupedByAttrs
     * @param displayByAttrs
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    List<ReportTracking> getResultsGroupedBy(Map<String, String> searchValues, List<String> groupedByAttrs, List<String> displayByAttrs) throws IllegalAccessException, InvocationTargetException;
    
    /**
     * Return a list of report tracking BOs that match the search values and are sorted by
     * the detailAttrs list of columns.
     * @param searchValues
     * @param detailAttrs
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    List<ReportTracking> getDetailResults(Map<String, String> searchValues, List<String> detailAttrs) throws IllegalAccessException, InvocationTargetException;

}
