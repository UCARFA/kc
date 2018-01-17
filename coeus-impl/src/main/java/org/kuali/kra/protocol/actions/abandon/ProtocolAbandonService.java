/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.abandon;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean;
import org.kuali.rice.kew.api.exception.WorkflowException;

public interface ProtocolAbandonService {

        /**
         * 
         * This method is to abandon protocol which is SRR or SMR.
         * @param protocol
         * @param protocolAbandonBean
         * @throws WorkflowException
         */
        public void abandonProtocol(ProtocolBase protocol, ProtocolGenericActionBean protocolAbandonBean) throws WorkflowException ;

}
