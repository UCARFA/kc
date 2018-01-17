/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.sponsor.form;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.sponsor.form.SponsorForms;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.rice.kns.document.MaintenanceDocument;

/**
 * This class overrides the custom route and custom approve methods of the MaintenanceDocument processing to check the length of the
 * sponsor code and return a more informative error message than the Rice message if the length constraint is violated.
 */
public class SponsorFormsMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {

    public SponsorFormsMaintenanceDocumentRule() {
        super();
    }
    
    @Override
    protected boolean processCustomSaveDocumentBusinessRules(MaintenanceDocument document) {
        return checkSponsorCodeOrHierarchyName(document);
    }

    @Override
    protected boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return checkSponsorCodeOrHierarchyName(document);
    }

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return checkSponsorCodeOrHierarchyName(document);
    }

    /**
     * This method verifies that the sponsorCode adheres to the required rules.
     * 
     * @param document
     * @return
     */
    private boolean checkSponsorCodeOrHierarchyName(MaintenanceDocument document) {
        boolean valid = true;
        SponsorForms sponsorForm = (SponsorForms) document.getNewMaintainableObject().getDataObject();
        if (StringUtils.isBlank(sponsorForm.getSponsorCode()) && StringUtils.isBlank(sponsorForm.getSponsorHierarchyName())
                || (StringUtils.isNotBlank(sponsorForm.getSponsorCode()) && StringUtils.isNotBlank(sponsorForm.getSponsorHierarchyName()))) {
            getGlobalVariableService().getMessageMap().putError("document.newMaintainableObject.sponsorCode", "error.sponsorForms.selector");
            valid = false;
        }
        return valid;
    }

}
