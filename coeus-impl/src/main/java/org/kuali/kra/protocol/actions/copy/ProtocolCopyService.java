/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.copy;

import org.kuali.kra.protocol.ProtocolDocumentBase;


/**
 * The ProtocolBase Copy Service is responsible for copying protocols.
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface ProtocolCopyService<GenericProtocolDocument extends ProtocolDocumentBase> {
    
    /**
     * Copy a protocol document.
     * 
     * @param doc the protocol document to copy.
     * @return the new document that is saved in the database; 
     *         otherwise null if an error occurred, e.g. the user didn't have permission to copy the document
     * @throws Exception if anything really bad happens
     */
    public GenericProtocolDocument copyProtocol(GenericProtocolDocument doc) throws Exception;
   
    /**
     * Copy a protocol document with a given protocol number.  This is
     * used when protocols are copied for amendments and renewals.  Instead
     * of creating a new protocol number, the original one is appended to.
     * 
     * @param doc the protocol document to copy.
     * @param protocolNumber the protocol number to assign to the protocol
     * @return the new document that is saved in the database; 
     *         otherwise null if an error occurred, e.g. the user didn't have permission to copy the document
     * @throws Exception if anything really bad happens
     */
    public ProtocolDocumentBase copyProtocol(GenericProtocolDocument doc, String protocolNumber, boolean isAmendmentRenewal) throws Exception;
}
