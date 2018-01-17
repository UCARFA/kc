/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.correspondence;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.auth.ProtocolTask;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.auth.ProtocolTaskBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceAuthorizationServiceImplBase;

public class IrbProtocolCorrespondenceAuthorizationServiceImpl extends ProtocolCorrespondenceAuthorizationServiceImplBase implements IrbProtocolCorrespondenceAuthorizationService {

    @Override
    protected ProtocolTaskBase getNewProtocolTaskInstanceHook(String taskName, ProtocolBase protocol) {
        return new ProtocolTask(taskName, (Protocol) protocol);
    }

}
