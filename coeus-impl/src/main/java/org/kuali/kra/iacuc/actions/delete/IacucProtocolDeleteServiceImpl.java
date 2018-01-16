/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.delete;

import org.kuali.kra.iacuc.actions.IacucProtocolStatus;
import org.kuali.kra.protocol.actions.delete.ProtocolDeleteServiceImplBase;

public class IacucProtocolDeleteServiceImpl extends ProtocolDeleteServiceImplBase implements IacucProtocolDeleteService {

    @Override
    protected String getDeletedProtocolStatusCodeHook() {
        return IacucProtocolStatus.DELETED;
    }

  
}
