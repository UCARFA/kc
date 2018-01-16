/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;
import org.kuali.coeus.common.committee.impl.document.authorizer.CommitteeAuthorizerBase;

public abstract class ModifyScheduleAuthorizerBase extends CommitteeAuthorizerBase {

    @Override
    public boolean isAuthorized(String username, CommitteeTaskBase task) {
        boolean hasPermission = true;
        CommitteeBase committee = task.getCommittee();

        hasPermission = hasPermission(username, committee, getModfifySchedulePermissionNameHook());
        return hasPermission;
    }

    protected abstract String getModfifySchedulePermissionNameHook();

}
