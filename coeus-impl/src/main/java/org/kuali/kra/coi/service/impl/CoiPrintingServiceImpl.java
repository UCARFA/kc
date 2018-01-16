/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.service.impl;

import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.Printable;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.common.framework.print.PrintingService;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.print.CoiCertificationPrint;
import org.kuali.kra.coi.print.CoiReportType;
import org.kuali.kra.coi.service.CoiPrintingService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * 
 * This class implements the CoiPrintingService.
 */
public class CoiPrintingServiceImpl  implements CoiPrintingService {

    private PrintingService printingService;
    private CoiCertificationPrint coiCertificationPrint;

    public PrintingService getPrintingService() {
        return printingService;
    }
    
    public void setPrintingService(PrintingService printingService) {
        this.printingService = printingService;
    }

    public CoiCertificationPrint getCoiCertificationPrint() {
        return coiCertificationPrint;
    }

    public void setCoiCertificationPrint(CoiCertificationPrint coiCertificationPrint) {
        this.coiCertificationPrint = coiCertificationPrint;
    }
     @Override
     public Printable getCoiPrintArtifacts(CoiDisclosure coiDisclosure) { 
         
         CoiReportType reportType = CoiReportType.COI_BATCH_CORRESPONDENCE;
         AbstractPrint printable = (AbstractPrint)getCoiPrintable(reportType);
         printable.setPrintableBusinessObject(coiDisclosure);
         return printable;
     }
    @Override
     public AttachmentDataSource print(List<Printable> printableArtifactList) throws PrintingException {
         String fileName = "";
         AttachmentDataSource attachmentDataSource =  getPrintingService().print(printableArtifactList);
         CoiCertificationPrint certificationPrint = (CoiCertificationPrint) printableArtifactList.get(0);
         CoiDisclosure coiDisclosure = (CoiDisclosure) certificationPrint.getPrintableBusinessObject();
         fileName = "PendingDisclosure" + Constants.PDF_FILE_EXTENSION;
          try {
               attachmentDataSource.setName(URLEncoder.encode(fileName,"UTF-8"));
           } catch (UnsupportedEncodingException e) {
               attachmentDataSource.setName(fileName);
           }
           attachmentDataSource.setType(Constants.PDF_REPORT_CONTENT_TYPE);

           return attachmentDataSource;
       }
       

    @Override
    @SuppressWarnings("MissingCasesInEnumSwitch")
    public AbstractPrint getCoiPrintable(CoiReportType reportType) {
    	AbstractPrint printable = null;
        switch(reportType) {
            case COI_APPROVED_DISCLOSURE :
                printable = getCoiCertificationPrint();
                break;
                }
        return printable;
    }
}


