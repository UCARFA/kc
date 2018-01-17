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
import org.kuali.coeus.common.framework.print.PrintingService;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTracking;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * This class is the implementation of {@link ReportTrackingPrintingService}. It has
 * capability to print any reports related to Award like Delta Report, Award
 * Notice etc.
 * 
 * @author
 * 
 */

public class ReportTrackingPrintingServiceImpl implements ReportTrackingPrintingService{

    private PrintingService printingService;
     private BusinessObjectService businessObjectService;
     private ReportTrackingPrint reportTrackingPrint;

 @Override
 public AttachmentDataSource printAwardReportTracking(
             List<Printable> printableArtifactList) throws PrintingException {
             AttachmentDataSource attachmentDataSource =  getPrintingService().print(printableArtifactList);
         String fileName = "ReportTrackingPrint" + Constants.PDF_FILE_EXTENSION;
         try {
             attachmentDataSource.setName(URLEncoder.encode(fileName,"UTF-8"));
         } catch (UnsupportedEncodingException e) {
             attachmentDataSource.setName(fileName);
         }
         attachmentDataSource.setType(Constants.PDF_REPORT_CONTENT_TYPE);

         return attachmentDataSource;
     }

     @Override
     public AwardReportTracking getReportPrintable(ReportTrackingType reportType, ReportTracking detailResult, AwardReportTracking printable) {
            switch(reportType) {
                case AWARD_REPORT_TRACKING :
                    printable = getReportTrackingPrint();
                    printable.setPrintableBusinessObject(detailResult);
                    break;
                    }
            return printable;
        }
    /**
     * @return the printingService
     */
    public PrintingService getPrintingService() {
        return printingService;
    }

    /**
     * @param printingService
     *            the printingService to set
     */
    public void setPrintingService(PrintingService printingService) {
        this.printingService = printingService;
    }

    

    public ReportTrackingPrint getReportTrackingPrint() {
        return reportTrackingPrint;
    }

    public void setReportTrackingPrint(ReportTrackingPrint reportTrackingPrint) {
        this.reportTrackingPrint = reportTrackingPrint;
    }

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
  
}
