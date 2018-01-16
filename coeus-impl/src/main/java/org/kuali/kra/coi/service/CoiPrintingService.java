/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.service;

import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.Printable;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.print.CoiReportType;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;

import java.util.List;

/**
 * This class provides the interface for printing reports related to COI. It has the
 * capability to provide a PDF document of various reports related to COI like 
 * certifications.
 */
public interface CoiPrintingService {

    public AbstractPrint getCoiPrintable(CoiReportType reportType);
    
    public Printable getCoiPrintArtifacts(CoiDisclosure coiDisclosure);
    
    public AttachmentDataSource print(List<Printable> printableArtifactList) throws PrintingException;
    
}
