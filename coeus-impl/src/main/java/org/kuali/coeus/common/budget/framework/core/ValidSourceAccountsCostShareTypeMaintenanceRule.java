/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.common.budget.framework.core;

import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.kra.bo.CostShareType;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.HashMap;
import java.util.Map;

public class ValidSourceAccountsCostShareTypeMaintenanceRule extends KcMaintenanceDocumentRuleBase {

    public static final String COST_SHARE_TYPE_CODE = "costShareTypeCode";
    public static final String SOURCE_ACCOUNT_CODE = "sourceAccountCode";
    public static final String FIELD_NAME = "Cost share type code and Source account code";
    public static final String SECTION_ID = "Edit Valid Source Accounts Cost Share Type";
    public static final String CODE = "code";
    public static final String SOURCE_ACCOUNT_CODE_FIELD = "Source Account Code";
    public static final String COST_SHARE_TYPE_CODE_FIELD = "Cost Share Type Code";

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return doesEntryExist(document);
    }
    
    @Override
    protected boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        boolean valid = Boolean.TRUE;
        ValidSourceAccountsCostShareType validSourceAccountsCostShareType = (ValidSourceAccountsCostShareType) document.getDocumentBusinessObject();
        Map<String, Object> pk = new HashMap<>();
        pk.put(CODE, validSourceAccountsCostShareType.getSourceAccountCode());
        valid &= checkExistenceFromTable(CostShareSourceAccount.class, pk, SOURCE_ACCOUNT_CODE, SOURCE_ACCOUNT_CODE_FIELD);
        pk = new HashMap<>();
        pk.put(COST_SHARE_TYPE_CODE, validSourceAccountsCostShareType.getCostShareTypeCode());
        valid &= checkExistenceFromTable(CostShareType.class, pk, COST_SHARE_TYPE_CODE, COST_SHARE_TYPE_CODE_FIELD);
        return valid && doesEntryExist(document);
    }

    protected Boolean doesEntryExist(MaintenanceDocument document) {
        if (!document.getNewMaintainableObject().getMaintenanceAction().equals(KRADConstants.MAINTENANCE_DELETE_ACTION)) {
            ValidSourceAccountsCostShareType validSourceAccountsCostShareType = (ValidSourceAccountsCostShareType) document.getDocumentBusinessObject();
            return validate(validSourceAccountsCostShareType);
        }
        return Boolean.TRUE;
    }

    private boolean validate(ValidSourceAccountsCostShareType validSourceAccountsCostShareType) {
        Map<String, Object> pk = new HashMap<>();
        pk.put(COST_SHARE_TYPE_CODE, validSourceAccountsCostShareType.getCostShareTypeCode());
        pk.put(SOURCE_ACCOUNT_CODE, validSourceAccountsCostShareType.getSourceAccountCode());
        boolean valid = getBoService().countMatching(ValidSourceAccountsCostShareType.class, pk) == 0;
        if (!valid) {
            getGlobalVariableService().getMessageMap().putErrorWithoutFullErrorPath(SECTION_ID, RiceKeyConstants.ERROR_DUPLICATE_ELEMENT,
                    FIELD_NAME, validSourceAccountsCostShareType.getCostShareTypeCode().toString() + " and " + validSourceAccountsCostShareType.getSourceAccountCode());
        }

        return valid;
    }
}
