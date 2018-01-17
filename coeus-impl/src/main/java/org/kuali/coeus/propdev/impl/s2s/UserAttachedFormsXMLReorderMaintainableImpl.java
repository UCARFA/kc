/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s;

import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.kns.maintenance.KualiMaintainableImpl;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.Map;

public class UserAttachedFormsXMLReorderMaintainableImpl extends KualiMaintainableImpl {

    private static final long serialVersionUID = -2403270541923494151L;
    public static final String DOCUMENT_NEW_MAINTAINABLE_OBJECT_NODE_TO_MOVE = "document.newMaintainableObject.nodeToMove";

    @Override
    public void processAfterNew(MaintenanceDocument document, Map<String, String[]> requestParameters) {
        super.processAfterNew(document, requestParameters);
        this.addInfomationalMessage();
    }

    protected void addInfomationalMessage() {
        GlobalVariables.getMessageMap().putInfo(DOCUMENT_NEW_MAINTAINABLE_OBJECT_NODE_TO_MOVE, KeyConstants.XML_REORDER_WARNING);
    }
    
}
