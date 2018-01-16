/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.AuditError;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.DocumentAuditRule;

import java.util.ArrayList;
import java.util.List;

public class AwardCostShareAuditRule implements DocumentAuditRule {
    private static final String AUDIT_CLUSTER = "costShareAuditErrors";
    
    private List<AuditError> auditErrors;

    @Override
    public boolean processRunAuditBusinessRules(Document document) {
        AwardDocument awardDocument = (AwardDocument)document;
        Award award = awardDocument.getAward();
        boolean retval = validateCostShareDoesNotViolateUniqueConstraintNonNull(award.getAwardCostShares());
        if (!retval) {
            reportAndCreateAuditCluster();            
        }
        return retval;
    }

    public boolean validateCostShareDoesNotViolateUniqueConstraintNonNull(List<AwardCostShare> awardCostShares) {
        boolean valid = true;
        for (AwardCostShare costShare1 : awardCostShares) {
            if (costShare1.getCostShareTypeCode() != null) {
                for (AwardCostShare costShare2 : awardCostShares) {
                    if (costShare1 != costShare2 && StringUtils.equals(costShare1.getProjectPeriod(), costShare2.getProjectPeriod()) &&
                            costShare1.getCostShareTypeCode().equals(costShare2.getCostShareTypeCode()) &&
                            StringUtils.equalsIgnoreCase(costShare1.getSource(), costShare2.getSource()) &&
                            StringUtils.equalsIgnoreCase(costShare1.getDestination(), costShare2.getDestination())) {
                        valid = false;
                        addAuditError(new AuditError("document.awardList[0].awardCostShares[" + awardCostShares.indexOf(costShare1) + "].fiscalYear",
                                KeyConstants.ERROR_DUPLICATE_ENTRY,
                                Constants.MAPPING_AWARD_COMMITMENTS_PAGE + "." + Constants.COST_SHARE_PANEL_ANCHOR));
                    }
                }
            } else {
                valid = false;
                addAuditError(new AuditError("document.awardList[0].awardCostShares[" + awardCostShares.indexOf(costShare1) + "].costShareTypeCode",
                        KeyConstants.ERROR_COST_SHARE_TYPE_REQUIRED,
                        Constants.MAPPING_AWARD_COMMITMENTS_PAGE + "." + Constants.COST_SHARE_PANEL_ANCHOR));
            }
        }
        return valid;
    }

    private void addAuditError(AuditError auditError) {
        if(auditErrors == null) {
            auditErrors = new ArrayList<>();
        }
        auditErrors.add(auditError);
    }

    protected void reportAndCreateAuditCluster() {
        if (auditErrors.size() > 0) {
            GlobalVariables.getAuditErrorMap().put(AUDIT_CLUSTER, new AuditCluster(Constants.COST_SHARE_PANEL_NAME, auditErrors, Constants.AUDIT_ERRORS));
        }
    }
}
