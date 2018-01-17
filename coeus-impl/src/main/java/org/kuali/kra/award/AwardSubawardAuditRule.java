/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.approvedsubawards.AwardApprovedSubaward;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.AuditError;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.DocumentAuditRule;

import java.util.ArrayList;
import java.util.List;

public class AwardSubawardAuditRule implements DocumentAuditRule {
    
    private static final String SUBAWARD_AUDIT_ERRORS = "subawardAuditErrors";
    private static final String SUBAWARD_AUDIT_WARNINGS = "subawardAuditWarnings";
    private static final String ORGANIZATION = "Organization";

    List<AwardApprovedSubaward> awardApprovedSubawards;
    private List<AuditError> auditErrors;
    private List<AuditError> auditWarnings;
    
    @Override
    public boolean processRunAuditBusinessRules(Document document) {
        boolean valid = true;
        AwardDocument awardDocument = (AwardDocument) document;
        auditErrors = new ArrayList<>();
        auditWarnings = new ArrayList<>();
        Award award = awardDocument.getAward();
        this.awardApprovedSubawards = award.getAwardApprovedSubawards();
        if(!validateApprovedSubawardDuplicateOrganization(awardApprovedSubawards)){
            valid = false;
            auditWarnings.add(new AuditError(Constants.SUBAWARD_AUDIT_RULES_ERROR_KEY,
                    KeyConstants.ERROR_DUPLICATE_ORGANIZATION_NAME, 
                    Constants.MAPPING_AWARD_HOME_PAGE + "." + Constants.SUBAWARD_PANEL_ANCHOR,
                    new String[]{ORGANIZATION}));
        }
        for (int i = 0; i < awardApprovedSubawards.size(); i++) {
            AwardApprovedSubaward subAward = awardApprovedSubawards.get(i);
            ScaleTwoDecimal amount = subAward.getAmount();
            if (amount == null) {
                valid = false;  // a "required field" error is already reported by the framework, so don't call reportError
            } else if(!amount.isGreaterThan(ScaleTwoDecimal.ZERO)) {
                valid = false;
                auditWarnings.add(new AuditError("document.awardList[0].awardApprovedSubawards[" + i + "].amount",
                        KeyConstants.ERROR_AMOUNT_IS_ZERO,
                        Constants.MAPPING_AWARD_HOME_PAGE + "." + Constants.SUBAWARD_PANEL_ANCHOR,
                        null));
            }
        }
        reportAndCreateAuditCluster();
        return valid;
    }
    
    /**
     * This method creates and adds the AuditCluster to the Global AuditErrorMap.
     */
    protected void reportAndCreateAuditCluster() {
        if (auditErrors.size() > 0) {
            GlobalVariables.getAuditErrorMap().put(SUBAWARD_AUDIT_ERRORS, new AuditCluster(Constants.SUBAWARD_PANEL_NAME,
                                                                                          auditErrors, Constants.AUDIT_ERRORS));
        } 
        if (auditWarnings.size() > 0) {
            GlobalVariables.getAuditErrorMap().put(SUBAWARD_AUDIT_WARNINGS, new AuditCluster(Constants.SUBAWARD_PANEL_NAME,
                    auditWarnings, Constants.AUDIT_WARNINGS));            
        }
    }
    
    /**
    *
    * Test Approved Subawards for duplicate organizations
    * @return Boolean
    */
    protected boolean validateApprovedSubawardDuplicateOrganization(List<AwardApprovedSubaward> awardApprovedSubawards){
            boolean valid = true;
            int index = 0;
        test:
            for (AwardApprovedSubaward loopAwardApprovedSubaward : awardApprovedSubawards) {
                int innerIndex = 0;
                for(AwardApprovedSubaward testAwardApprovedSubaward : awardApprovedSubawards) {
                    if (innerIndex != index) {
                        if(testAwardApprovedSubaward.getOrganizationName().equals(loopAwardApprovedSubaward.getOrganizationName())){
                            valid = false;
                            break test;
                        }
                        innerIndex++;
                    }
                }
                index++;
            }
            return valid;
    }
    
}
