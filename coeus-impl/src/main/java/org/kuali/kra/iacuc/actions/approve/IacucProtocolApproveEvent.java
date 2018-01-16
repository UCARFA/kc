/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.approve;

import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.protocol.actions.approve.ProtocolApproveEventBase;

public class IacucProtocolApproveEvent extends ProtocolApproveEventBase {

    public IacucProtocolApproveEvent(IacucProtocolDocument document, IacucProtocolApproveBean protocolApproveBean) {
        super(document, protocolApproveBean);
    }

    @Override
    protected IacucProtocolApproveRule getNewProtocolApproveRuleInstanceHook() {
        return new IacucProtocolApproveRule();
    }

   
}
