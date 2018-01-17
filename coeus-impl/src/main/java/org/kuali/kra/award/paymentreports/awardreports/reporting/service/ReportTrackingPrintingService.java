/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports.reporting.service;

import org.kuali.coeus.common.framework.print.Printable;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTracking;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;

import java.util.List;

/**
 * This class provides the means for printing reports related to Award. It has
 * the capability to provide a PDF document of various reports related to Award
 * like Delta Report, Award Notice etc.
 * 
 * @author
 * 
 */
public interface ReportTrackingPrintingService {

    /**
     * This method will return the printable object
     * @param reportTrackingType
     *           report tracking type
     * @param detailResult
     *            report to be generated
     * @param printable
     */
    public AwardReportTracking getReportPrintable(ReportTrackingType reportTrackingType,ReportTracking detailResult,AwardReportTracking printable);

    /**
     * This method is for prints all Award Reports
     * @param printableArtifactList list of Award reports
     */
    public AttachmentDataSource printAwardReportTracking(List<Printable> printableArtifactList) throws PrintingException;
    
    
}
