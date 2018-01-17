/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.document.authorization;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.TimeAndMoneyPermissionConstants;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kns.document.authorization.TransactionalDocumentAuthorizerBase;
import org.kuali.rice.krad.document.Document;

import java.util.Map;

/**
 * This class is the Time and Money Document Authorizer.  It determines the edit modes and
 * document actions for all time and money documents.
 */
public class TimeAndMoneyDocumentAuthorizer extends TransactionalDocumentAuthorizerBase {
    
    public static final String CREATE_TIME_AND_MONEY_PERMISSION = "Create Time And Money Document";

    @Override
    public boolean canRoute(Document document, Person user) {
        boolean canRoute;
        TimeAndMoneyDocument tmDocument = (TimeAndMoneyDocument) document;
        canRoute = 
                (!(isFinal(document) || isProcessed (document)) && hasPermission(tmDocument, user, 
                                TimeAndMoneyPermissionConstants.SUBMIT_TIME_AND_MONEY_DOCUMENT));
        return canRoute;
    }
    
    protected boolean isFinal(Document document) {
        return KewApiConstants.ROUTE_HEADER_FINAL_CD.equals(
                document.getDocumentHeader().getWorkflowDocument().getStatus().getCode());
    }
    
    protected boolean isProcessed (Document document){
       boolean isProcessed = false;
       String status = document.getDocumentHeader().getWorkflowDocument().getStatus().getCode();
       // if document is in processed state
       if (status.equalsIgnoreCase(KewApiConstants.ROUTE_HEADER_PROCESSED_CD))
               isProcessed = true;
       return isProcessed;   
   }
    
    @Override
    protected void addRoleQualification(
            Object primaryBusinessObjectOrDocument,
            Map<String, String> attributes) {
        super.addRoleQualification(primaryBusinessObjectOrDocument, attributes);
        TimeAndMoneyDocument timeAndMoneyDocument = (TimeAndMoneyDocument) primaryBusinessObjectOrDocument;
        if (timeAndMoneyDocument.getAward() != null 
                && timeAndMoneyDocument.getAward().getLeadUnit() != null) {
            attributes.put(KcKimAttributes.UNIT_NUMBER, timeAndMoneyDocument.getAward().getLeadUnit().getUnitNumber());
        } else {
            attributes.put(KcKimAttributes.UNIT_NUMBER, "*");
        }
    }
    
    public boolean hasCreatePermission(TimeAndMoneyDocument timeAndMoneyDocument, Person user) {
        boolean retVal = hasPermission(timeAndMoneyDocument, user, CREATE_TIME_AND_MONEY_PERMISSION);
        return retVal;
    }
    
    private boolean hasPermission(TimeAndMoneyDocument timeAndMoneyDocument, Person user, String permissionName) {
        return this.isAuthorized(timeAndMoneyDocument, Constants.MODULE_NAMESPACE_TIME_AND_MONEY, permissionName, user.getPrincipalId());
    }
}
