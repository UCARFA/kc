/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports.reporting.service;

import org.kuali.kra.lookup.KraLookupableHelperServiceImpl;

/**
 * Report Tracking Lookupable Helper Service.
 */
public class ReportTrackingLookupableHelperServiceImpl extends KraLookupableHelperServiceImpl {

    private static final long serialVersionUID = 721845462946339775L;

    @Override
    protected String getDocumentTypeName() {
        return "ReportTracking";
    }

    @Override
    protected String getHtmlAction() {
        return "reportTrackingLookup.do";
    }

    @Override
    protected String getKeyFieldName() {
        return "awardReportTrackingId";
    }
}
