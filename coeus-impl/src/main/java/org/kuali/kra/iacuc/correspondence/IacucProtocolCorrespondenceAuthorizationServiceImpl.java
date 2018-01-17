/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.correspondence;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.auth.IacucProtocolTask;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.auth.ProtocolTaskBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceAuthorizationServiceImplBase;

public class IacucProtocolCorrespondenceAuthorizationServiceImpl extends ProtocolCorrespondenceAuthorizationServiceImplBase
        implements IacucProtocolCorrespondenceAuthorizationService {

    @Override
    protected ProtocolTaskBase getNewProtocolTaskInstanceHook(String taskName, ProtocolBase protocol) {
        return new IacucProtocolTask(taskName, (IacucProtocol) protocol);
    }

}
