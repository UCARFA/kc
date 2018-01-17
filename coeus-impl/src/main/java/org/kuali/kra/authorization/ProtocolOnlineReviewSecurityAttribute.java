/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.authorization;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.kuali.rice.kew.api.KewApiServiceLocator;
import org.kuali.rice.kew.api.action.ActionItem;
import org.kuali.rice.kew.api.actionlist.ActionListService;
import org.kuali.rice.kew.api.document.Document;
import org.kuali.rice.kew.framework.document.security.DocumentSecurityAttribute;
import org.kuali.rice.kns.service.DocumentHelperService;


public class ProtocolOnlineReviewSecurityAttribute implements DocumentSecurityAttribute {

    private DocumentHelperService documentHelperService;
    private ActionListService actionListService;

    /*
     * Cannot use canopen doc perm here because it does not exist for ONLR docs
     */
    @Override
    public boolean isAuthorizedForDocument(String principalId, Document document) {
        boolean retVal= false;
        String documentId = document.getDocumentId();
        // get the action items for this document and check if any of them have the same principal id as the current user
        List<ActionItem> actionItemsForDocument = this.getActionListService().getAllActionItems(documentId);
        for(ActionItem actionItem: actionItemsForDocument) {
            if(StringUtils.equals(principalId, actionItem.getPrincipalId())) {
                retVal = true;
                break;                    
            }
        }
        return retVal;
    }
    
    protected ActionListService getActionListService() {
        if(this.actionListService == null) {
            this.actionListService = KewApiServiceLocator.getActionListService();
        }
        return this.actionListService;
    }

}
