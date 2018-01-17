/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.print.service;

import org.kuali.coeus.common.committee.impl.print.CommitteeReportType;
import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.Printable;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;

import java.util.List;

/**
 * This class provides the means for printing reports related to CommitteeBase. It has the
 * capability to provide a PDF document of various reports related to CommitteeBase like 
 * Roster and Future Scheduled Meetings.
 */
public interface CommitteePrintingServiceBase {
    
    /**
     * 
     * This method gets the specific implementation for printing a committee report based
     * on the report type.
     * @param printType
     * @return printable
     */
    AbstractPrint getCommitteePrintable(CommitteeReportType reportType, String committeeId);
    
    /**
     * This method generates the required report and returns the PDF stream as
     * {@link AttachmentDataSource}.
     * 
     * @param printableArtifact the specific implementation for printing the report.
     * @return {@link AttachmentDataSource} which contains the byte array of the
     *         generated PDF
     * @throws PrintingException if any errors occur during report generation
     */
    AttachmentDataSource print(List<Printable> printableArtifactList) throws PrintingException;

}
