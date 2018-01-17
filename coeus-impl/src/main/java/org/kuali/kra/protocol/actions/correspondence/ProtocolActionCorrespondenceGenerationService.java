/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.correspondence;

import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;
import org.kuali.kra.protocol.ProtocolBase;

/**
 * 
 * This interface defines the functions needed generate a correspondence and attach it to a protocol.
 */
public interface ProtocolActionCorrespondenceGenerationService {
    
    /**
     * 
     * This method attaches an appropriate template based PDF document to the protocol and saves it.
     * @param printableCorrespondence an implementation of AbstractProtocolActionsCorrespondence.
     * @throws PrintingException
     */
    void generateCorrespondenceDocumentAndAttach(ProtocolActionsCorrespondenceBase printableCorrespondence) throws PrintingException;
    
    AttachmentDataSource reGenerateCorrespondenceDocument(ProtocolActionsCorrespondenceBase printableCorrespondence) throws PrintingException ; 

    public void attachProtocolCorrespondence(ProtocolBase protocol, byte[] data, String correspTypeCode);
    
}
