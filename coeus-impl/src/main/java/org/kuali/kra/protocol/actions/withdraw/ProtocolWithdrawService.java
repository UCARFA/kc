/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.withdraw;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;

/**
 * ProtocolBase Withdraw Service.
 */
public interface ProtocolWithdrawService {

    /**
     * Perform the task of withdrawing a protocol. A new protocol document will be created
     * so that it can be re-submitted into workflow at a later time.
     * @param protocol the protocol
     * @param withdrawBean the required data for performing a withdrawal
     * @return new protocol document 
     * @throws Exception 
     */
    public ProtocolDocumentBase withdraw(ProtocolBase protocol, ProtocolWithdrawBean withdrawBean) throws Exception;

    
    /**
     * Perform the task of administratively withdrawing a protocol. A new protocol document will be created
     * so that it can be re-submitted into workflow at a later time.
     * @param protocol the protocol
     * @param withdrawBean the required data for performing a withdrawal
     * @return new protocol document 
     * @throws Exception 
     */
    public ProtocolDocumentBase administrativelyWithdraw(ProtocolBase protocol, ProtocolAdministrativelyWithdrawBean administrativelyWithdrawBean) throws Exception;
    
    /**
     * Perform the task of administratively marking a protocol as 'incomplete'. A new protocol document will be created
     * so that it can be re-submitted into workflow at a later time.
     * @param protocol the protocol
     * @param withdrawBean the required data for performing a withdrawal
     * @return new protocol document 
     * @throws Exception 
     */
    public ProtocolDocumentBase administrativelyMarkIncomplete(ProtocolBase protocol, ProtocolAdministrativelyIncompleteBean markIncompleteBean) throws Exception;
}
