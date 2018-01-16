/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.delete;

import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.rice.kew.api.exception.WorkflowException;

public interface ProtocolDeleteService {
    
    /**
     * Delete a protocol/amendment/renewal.
     * @param protocolDocument the protocol/amendment/renewal
     * @throws WorkflowException
     */
    public void delete(ProtocolDocumentBase protocolDocument) throws WorkflowException;

    }
