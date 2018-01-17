/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s;

import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;

import java.util.HashMap;
import java.util.Map;

public class UserAttachedFormsXMLReorderRule extends KcMaintenanceDocumentRuleBase {

    public static final String NODE_TO_MOVE = "nodeToMove";
    public static final String TARGET_NODE = "targetNode";
    public static final String FIELD_NAME = "";
    public static final String SECTION_ID = "Edit User Attached Forms XML Reorder";

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return doesEntryExist(document);
    }
    
    @Override
    protected boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return doesEntryExist(document);
    }

    protected Boolean doesEntryExist(MaintenanceDocument document) {
        return validate((UserAttachedFormsXMLReorder) document.getDocumentBusinessObject());
    }

    private boolean validate(UserAttachedFormsXMLReorder userAttachedFormsXMLReorder) {
        Map<String, Object> pk = new HashMap<>();
        pk.put(NODE_TO_MOVE, userAttachedFormsXMLReorder.getNodeToMove());
        pk.put(TARGET_NODE, userAttachedFormsXMLReorder.getTargetNode());
        boolean valid = getBoService().countMatching(UserAttachedFormsXMLReorder.class, pk) == 0;
        if (!valid) {
            getGlobalVariableService().getMessageMap().putErrorWithoutFullErrorPath(SECTION_ID, RiceKeyConstants.ERROR_DUPLICATE_ELEMENT,
                    FIELD_NAME, userAttachedFormsXMLReorder.getNodeToMove() + " and " + userAttachedFormsXMLReorder.getTargetNode());
        }

        return valid;
    }
}
