/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.print;

import org.kuali.coeus.common.framework.print.Printable;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolFormBase;

import java.util.List;

/**
 * 
 * This class is for ProtocolBase print in protocol actions page
 */
public interface ProtocolPrintingService {
    
    /**
     * 
     * This method to print the report.  Actually this service is just use PrintingService's print
     * But need to be defined here.
     * @param printableArtifactList
     * @return
     * @throws PrintingException
     */
    AttachmentDataSource print(String reportName, List<Printable> printableArtifactList) throws PrintingException;
    
    /**
     * 
     * This method is to get the printable Artifacts for the selected protocol.
     * @param protocol
     * @return
     */
    Printable getProtocolPrintArtifacts(ProtocolBase protocol) ; 
    
    
    /**
     * This method is to print items in protocol document
     * @param protocolForm
     * @return
     * @throws PrintingException
     */
    AttachmentDataSource printProtocolDocument(ProtocolFormBase protocolForm) throws PrintingException;
   
    /**
     * This method is to print selected protocol items
     * @param protocolForm
     * @return
     * @throws PrintingException
     */
    AttachmentDataSource printProtocolSelectedItems(ProtocolFormBase protocolForm) throws PrintingException;
    
}
