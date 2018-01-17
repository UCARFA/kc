/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.approve;

import org.kuali.kra.protocol.ProtocolDocumentBase;

/**
 * 
 * This class handles the persistence of an approval action to a protocol.
 */
public interface ProtocolApproveService {
    
    /**
     * Approves a full submission to a ProtocolBase.
     * @param protocolDocument the current ProtocolBase
     * @param actionBean the bean that contains the comments and dates
     * @throws Exception
     */
    void grantFullApproval(ProtocolDocumentBase protocolDocument, ProtocolApproveBean actionBean) throws Exception;

    /**
     * Approves a response submission to a ProtocolBase.
     * @param protocolDocument the current ProtocolBase
     * @param actionBean the bean that contains the comments and dates
     * @throws Exception
     */
    void grantResponseApproval(ProtocolDocumentBase protocolDocument, ProtocolApproveBean actionBean) throws Exception;
    
    
    /**
     * Administratively approves a ProtocolBase.
     * @param protocolDocument the current ProtocolBase
     * @param actionBean the bean that contains the comments and dates
     * @throws Exception
     */
    public void grantAdminApproval(ProtocolDocumentBase protocolDocument, ProtocolApproveBean actionBean) throws Exception;

}
