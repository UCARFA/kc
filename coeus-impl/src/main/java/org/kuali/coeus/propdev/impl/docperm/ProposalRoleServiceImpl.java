/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.docperm;

import org.kuali.coeus.common.framework.auth.SystemAuthorizationService;
import org.kuali.coeus.common.framework.auth.docperm.DocumentAccessConstants;
import org.kuali.kra.infrastructure.RoleConstants;
import org.kuali.rice.kim.api.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("proposalRoleService")
public class ProposalRoleServiceImpl implements ProposalRoleService {

    @Autowired
    @Qualifier("systemAuthorizationService")
    private SystemAuthorizationService systemAuthorizationService;

    public void setSystemAuthorizationService(SystemAuthorizationService systemAuthorizationService) {
        this.systemAuthorizationService = systemAuthorizationService;
    }

    public SystemAuthorizationService getSystemAuthorizationService() {
        return systemAuthorizationService;
    }

    @Override
    public List<Role> getRolesForDisplay() {
        return systemAuthorizationService.getRolesByType(RoleConstants.PROPOSAL_ROLE_TYPE, DocumentAccessConstants.DOC_LEVEL_KIM_TYPE_NAME, DocumentAccessConstants.DOC_LEVEL_KIM_TYPE_NAMESPACE);
    }
}
