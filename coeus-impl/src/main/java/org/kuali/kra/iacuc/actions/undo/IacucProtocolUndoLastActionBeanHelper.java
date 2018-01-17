/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.undo;

import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.actions.IacucProtocolStatus;
import org.kuali.kra.protocol.actions.undo.UndoLastActionBeanHelperBase;

import java.io.Serializable;

public class IacucProtocolUndoLastActionBeanHelper extends UndoLastActionBeanHelperBase implements Serializable {

    private static final long serialVersionUID = 792168534895993037L;

    @Override
    protected String getApprovedActionTypeCodeHook() {
        return IacucProtocolActionType.IACUC_APPROVED;
    }

    @Override
    protected String getDeletedProtocolStatusHook() {
        return IacucProtocolStatus.DELETED;
    }

    protected static final String[] notUndoableActions = new String[]{IacucProtocolActionType.IACUC_PROTOCOL_CREATED, 
        IacucProtocolActionType.IACUC_DELETED, IacucProtocolActionType.CORRESPONDENCE_GENERATED, 
        IacucProtocolActionType.SUBMITTED_TO_IACUC, IacucProtocolActionType.AMENDMENT_CREATED, 
        IacucProtocolActionType.RENEWAL_CREATED, IacucProtocolActionType.EXPIRED, 
        IacucProtocolActionType.IACUC_WITHDRAWN, IacucProtocolActionType.ADMINISTRATIVELY_WITHDRAWN, 
        IacucProtocolActionType.ADMINISTRATIVE_CORRECTION, IacucProtocolActionType.NOTIFY_IACUC};

    @Override
    protected String[] getNotUndoableActions() {
        return notUndoableActions;
    }

}
