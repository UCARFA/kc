/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.ipreview;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.kns.document.authorization.MaintenanceDocumentAuthorizer;
import org.kuali.rice.kns.document.authorization.MaintenanceDocumentAuthorizerBase;

import java.util.Map;

/**
 * Custom document authorizer for IntellectualPropertyReview maintenance document.
 * We use a custom authorizer to add Unit Number qualification for KIM role-based authorizations.
 */
public class IntellectualPropertyReviewDocumentAuthorizer 
    extends MaintenanceDocumentAuthorizerBase implements MaintenanceDocumentAuthorizer {
    
    @Override
    protected void addRoleQualification(
            Object primaryBusinessObjectOrDocument,
            Map<String, String> attributes) {
        super.addRoleQualification(primaryBusinessObjectOrDocument, attributes);
        MaintenanceDocument maintenanceDocument = (MaintenanceDocument) primaryBusinessObjectOrDocument;
        IntellectualPropertyReview ipReview = 
            (IntellectualPropertyReview) maintenanceDocument.getOldMaintainableObject().getDataObject();
        if (!StringUtils.isBlank(ipReview.getLeadUnitNumber())) {
            attributes.put(KcKimAttributes.UNIT_NUMBER, ipReview.getLeadUnitNumber());
        } else {
            attributes.put(KcKimAttributes.UNIT_NUMBER, "*");
        }
    }

}
