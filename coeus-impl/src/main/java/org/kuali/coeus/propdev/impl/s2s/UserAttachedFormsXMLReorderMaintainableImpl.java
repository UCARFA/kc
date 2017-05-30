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
