/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.document.authorizer;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.document.authorization.PessimisticLock;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * The Modify CommitteeBase Authorizer checks to see if the user has 
 * permission to modify a committee. Authorization depends upon whether
 * the committee is being created or modified.  For creation, the
 * user needs the ADD_COMMITTEE permission.  If the committee is being
 * modified, the user only needs to have the MODIFY_COMMITTEE permission 
 * for that committee.
 */
public abstract class ModifyCommitteeAuthorizerBase extends CommitteeAuthorizerBase {

    @Override
    public boolean isAuthorized(String userId, CommitteeTaskBase task) {
        boolean hasPermission = true;
        CommitteeBase committee = task.getCommittee();
        if (committee.getId() == null) {
            
            // We have to consider the case when we are saving the committee for the first time.

            hasPermission = hasUnitPermission(userId, getModuleNamespaceCodeHook(), getPermissionNameForAddCommiteeHook());
        } 
        else {
            /*
             * After the initial save, the committee can only be modified has the required permission.
             */
            hasPermission = !committee.getCommitteeDocument().isViewOnly() &&
                            !isPessimisticLocked(committee.getCommitteeDocument()) &&
                            hasPermission(userId, committee, getPermissionNameForModifyCommitteeHook());
        }

        // Verify that document is not locked
        if (isPessimisticLocked(committee.getCommitteeDocument())) {
            hasPermission = false;
        }

        return hasPermission;
    }

    protected abstract String getPermissionNameForModifyCommitteeHook();

    protected abstract String getModuleNamespaceCodeHook();

    protected abstract String getPermissionNameForAddCommiteeHook();
    
    

    private boolean isPessimisticLocked(Document document) {
        boolean isLocked = false;
        for (PessimisticLock lock : document.getPessimisticLocks()) {
            // if lock is owned by current user, do not display message for it
            if (!lock.isOwnedByUser(GlobalVariables.getUserSession().getPerson())) {
                isLocked = true;
            }
        }
        return isLocked;
    }
}
