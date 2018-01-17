/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.document.authorizer;

import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;

/**
 * The View CommitteeBase Authorizer determines if a user has the right
 * to view a specific committee.
 */
public abstract class ViewCommitteeAuthorizerBase extends CommitteeAuthorizerBase {

    @Override
    public boolean isAuthorized(String userId, CommitteeTaskBase task) {
        return hasPermission(userId, task.getCommittee(), getPermissionNameForViewCommitteeHook());
    }

    protected abstract String getPermissionNameForViewCommitteeHook();
    
}
