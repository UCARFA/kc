/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
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
        valid &= checkExistenceFromTable(Account.class, pk, SOURCE_ACCOUNT_CODE, SOURCE_ACCOUNT_CODE_FIELD);
        pk = new HashMap<>();
        pk.put(COST_SHARE_TYPE_CODE, validSourceAccountsCostShareType.getCostShareTypeCode());
        valid &= checkExistenceFromTable(CostShareType.class, pk, COST_SHARE_TYPE_CODE, COST_SHARE_TYPE_CODE_FIELD);
        return valid && doesEntryExist(document);
    }

    protected Boolean doesEntryExist(MaintenanceDocument document) {
        final String maintenanceAction = document.getNewMaintainableObject().getMaintenanceAction();
        if (!maintenanceAction.equals(KRADConstants.MAINTENANCE_DELETE_ACTION) &&
            !maintenanceAction.equals(KRADConstants.MAINTENANCE_EDIT_ACTION)) {
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
