/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.species.exception;

import org.kuali.kra.iacuc.IacucProtocol;

public interface IacucProtocolExceptionService {

    /**
     * This method adds Protocol Exception to the List of Protocol Exception.
     * @param protocol which contains list of ProtocolException.
     * @param ProtocolException object is added to ProtocolException list.
     */
    public abstract void addProtocolException(IacucProtocol protocol, IacucProtocolException protocolException);
    
    /**
     * This method is to get a new formatted protocol exception
     * @param protocol
     * @param protocolException
     * @return
     */
    public IacucProtocolException getNewProtocolException(IacucProtocol protocol, IacucProtocolException protocolException);

}
