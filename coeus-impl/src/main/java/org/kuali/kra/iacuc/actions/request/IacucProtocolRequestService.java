/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.request;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.rice.kew.api.exception.WorkflowException;

/**
 * Protocol Request Service.
 */
public interface IacucProtocolRequestService {

    /**
     * Submit a protocol request. The corresponding submission and protocol action
     * entries will be added to the database.
     * @param protocol the protocol
     * @param requestBean the request data
     */
    public void submitRequest(IacucProtocol protocol, IacucProtocolRequestBean requestBean) throws WorkflowException;
}
