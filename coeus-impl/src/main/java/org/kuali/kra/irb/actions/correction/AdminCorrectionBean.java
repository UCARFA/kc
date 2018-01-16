/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.correction;

import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.ProtocolEditableBean;

public class AdminCorrectionBean extends ProtocolEditableBean implements org.kuali.kra.protocol.actions.correction.AdminCorrectionBean {

    private static final long serialVersionUID = 3247703113947298472L;
    
    private String comments;
    private boolean applyCorrection;
    
    /**
     * Constructs a AdminCorrectionBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public AdminCorrectionBean(ActionHelper actionHelper) {
        super(actionHelper);
    }
    
    @Override
    public String getComments() {
        return comments;
    }
    
    @Override
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    @Override
    public boolean isApplyCorrection() {
        return applyCorrection;
    }
    
    @Override
    public void setApplyCorrection(boolean applyCorrection) {
        this.applyCorrection = applyCorrection;
    }
    
    @Override
    public boolean isAmendmentRenewalOutstanding() {
        return !(getGeneralInfoEnabled() &&  
            getFundingSourceEnabled() && 
            getProtocolReferencesEnabled() && 
            getProtocolOrganizationsEnabled() && 
            getSubjectsEnabled() && 
            getAddModifyAttachmentsEnabled() && 
            getAreasOfResearchEnabled() && 
            getSpecialReviewEnabled() && 
            getProtocolPersonnelEnabled() && 
            getOthersEnabled() &&
            getProtocolPermissionsEnabled() &&
            getQuestionnaireEnabled());
    }

}
