/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.unit.sync;

import org.apache.commons.lang.StringUtils;
import org.kuali.coeus.common.framework.unit.sync.TargetRoleInfo;
import org.kuali.coeus.common.framework.unit.sync.UnitRole;
import org.kuali.coeus.common.framework.unit.sync.UnitRoleSync;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.KRADConstants;

public class UnitRoleSyncMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {

    private static final String DESCENDS = "targetRoleInfos[%s].descends";
    private static final String ERROR_UNIT_ROLE_SYNC_DESCENDS = "error.unit.role.sync.descends";

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return isValidDescends(document);
    }

    public boolean isValidDescends(MaintenanceDocument document) {
        UnitRoleSync unitRoleSync = (UnitRoleSync) document.getNewMaintainableObject().getDataObject();
        if (unitRoleSync != null && unitRoleSync.getTargetRoleInfos() != null) {
            for (int i = 0; i < unitRoleSync.getTargetRoleInfos().size(); i++) {
                final TargetRoleInfo targetRoleInfo = unitRoleSync.getTargetRoleInfos().get(i);
                if (targetRoleInfo.isDescends() && StringUtils.isNotBlank(targetRoleInfo.getRoleId())) {

                    if (targetRoleInfo.getRole() == null) {
                        final UnitRole role = new UnitRole();
                        role.setId(targetRoleInfo.getRoleId());
                        targetRoleInfo.setRole(role);
                    }

                    targetRoleInfo.getRole().refresh();

                    if (!targetRoleInfo.getRole().isUnitHierarchy()) {
                        GlobalVariables.getMessageMap().putError(String.format(KRADConstants.MAINTENANCE_NEW_MAINTAINABLE + DESCENDS, i), ERROR_UNIT_ROLE_SYNC_DESCENDS, targetRoleInfo.getRole().getNamespaceCode(), targetRoleInfo.getRole().getName());
                    }
                }
            }
        }
        return true;
    }

}
