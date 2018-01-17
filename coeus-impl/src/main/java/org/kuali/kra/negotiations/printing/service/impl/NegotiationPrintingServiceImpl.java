/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.printing.service.impl;

import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.common.framework.print.PrintingService;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.award.printing.service.AwardPrintingService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.kra.negotiations.printing.NegotiationActivityPrintType;
import org.kuali.kra.negotiations.printing.print.NegotiationActivityprint;
import org.kuali.kra.negotiations.printing.service.NegotiationPrintingService;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;

import java.util.Map;

/**
 * This class is the implementation of {@link AwardPrintingService}. It has
 * capability to print report related to Negotiation 
 * 
 * @author
 * 
 */
public class NegotiationPrintingServiceImpl implements NegotiationPrintingService {
    
    private PrintingService printingService; 
    private NegotiationActivityprint negotiationActivityPrint;
    private String reportFileNamePrefix= "";   

    public PrintingService getPrintingService() {
        return printingService;
    }
    public void setPrintingService(PrintingService printingService) {
        this.printingService = printingService;
    }  
    public NegotiationActivityprint getNegotiationActivityPrint() {
        return negotiationActivityPrint;
    }
    public void setNegotiationActivityPrint(NegotiationActivityprint negotiationActivityPrint) {
        this.negotiationActivityPrint = negotiationActivityPrint;
    }   
    
    /**
     * This method generates the required report and returns the PDF stream as
     * {@link AttachmentDataSource}
     * 
     * @param negotiationDocument
     *            Negotiation data using which report is generated
     * @param negotiationReportType
     *            report to be generated
     * @param reportParameters
     *            {@link Map} of parameters required for report generation
     * @return {@link AttachmentDataSource} which contains the byte array of the
     *         generated PDF
     * @throws PrintingException
     *             if any errors occur during report generation
     */
    @Override
    public AttachmentDataSource printNegotiationActivityReport(KcPersistableBusinessObjectBase negotiationDocument,
                                                               NegotiationActivityPrintType negotiationReportType, Map<String, Object> reportParameters) throws PrintingException {
                
        AttachmentDataSource source = null;
        AbstractPrint printable = null;        
        printable = getNegotiationActivityPrint();               
        Negotiation negotiation=(Negotiation) negotiationDocument;
        reportFileNamePrefix = negotiation.getNegotiationId().toString();
        printable.setPrintableBusinessObject(negotiationDocument);
        printable.setReportParameters(reportParameters);       
        source = getPrintingService().print(printable);
        source.setName(getReportName(reportFileNamePrefix, negotiationReportType.getNegotiationActivityPrintType()));
        source.setType(Constants.PDF_REPORT_CONTENT_TYPE);
        return source;   
    }    
    
    protected String getReportName(String reportFileNamePrefix, String reportName) {
        StringBuilder reportFullName = new StringBuilder(reportFileNamePrefix).append(
                "_").append(reportName.replace(' ', '_')).append(
                Constants.PDF_FILE_EXTENSION);
        return reportFullName.toString();
    }    
}
