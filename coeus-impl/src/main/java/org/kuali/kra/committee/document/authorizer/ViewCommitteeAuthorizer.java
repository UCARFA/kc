/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.document.authorizer;

import org.kuali.coeus.common.committee.impl.document.authorizer.ViewCommitteeAuthorizerBase;
import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * The View Committee Authorizer determines if a user has the right
 * to view a specific committee.
 */
public class ViewCommitteeAuthorizer extends ViewCommitteeAuthorizerBase {

    @Override
    protected String getPermissionNameForViewCommitteeHook() {
        return PermissionConstants.VIEW_COMMITTEE;
    }
    
}
