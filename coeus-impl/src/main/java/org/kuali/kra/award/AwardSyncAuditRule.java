/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.coeus.common.framework.version.history.VersionHistory;
import org.kuali.coeus.common.framework.version.history.VersionHistoryService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.awardhierarchy.AwardHierarchy;
import org.kuali.kra.award.awardhierarchy.AwardHierarchyService;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncChange;
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

public class AwardSyncAuditRule implements DocumentAuditRule {

    protected String SYNC_ERRORS = "awardSyncAuditErrors";
    
    protected List<AuditError> auditErrors;
    
    @Override
    public boolean processRunAuditBusinessRules(Document document) {
        boolean valid = true;
        AwardDocument awardDocument = (AwardDocument) document;
        auditErrors = new ArrayList<AuditError>();
        Award award = awardDocument.getAward();
        if (award.getSyncChanges() != null && !award.getSyncChanges().isEmpty()) {
            for (AwardSyncChange change : award.getSyncChanges()) {
                if (change.getSyncDescendantsType() == null) {
                    valid = false;
                    auditErrors.add(new AuditError("document.awardList[0].syncChanges[" 
                            + award.getSyncChanges().indexOf(change) + "].syncDescendants",
                            KeyConstants.ERROR_SYNC_DESCENDANT_BLANK, 
                            Constants.MAPPING_AWARD_ACTIONS_PAGE + "." + "Award Hierarchy Sync"));
                }
            }
            AwardHierarchy hierarchy = getAwardHierarchyService().loadAwardHierarchyBranch(award.getAwardNumber());
            if (hierarchy != null) {
                for (AwardHierarchy curHierarchy : hierarchy.getChildren()) {
                    valid &= validateHierarchyIsActive(curHierarchy);
                }
            }
        }
        reportAndCreateAuditCluster();
        return valid;
    }
    
    protected AwardHierarchyService getAwardHierarchyService() {
        return KcServiceLocator.getService(AwardHierarchyService.class);
    }
    
    protected VersionHistoryService getVersionHistoryService() {
        return KcServiceLocator.getService(VersionHistoryService.class);
    }
    
    /**
     * This method creates and adds the AuditCluster to the Global AuditErrorMap.
     */
    @SuppressWarnings("unchecked")
    protected void reportAndCreateAuditCluster() {
        if (auditErrors.size() > 0) {
            GlobalVariables.getAuditErrorMap().put(SYNC_ERRORS, new AuditCluster("Award Hierarchy Sync",
                    auditErrors, Constants.AUDIT_ERRORS));
        } 
    }
    
    protected boolean validateHierarchyIsActive(AwardHierarchy hierarchy) {
        boolean success = isAwardActive(hierarchy.getAwardNumber());
        if (!success) {
            auditErrors.add(new AuditError("document.awardList[0].syncChanges",
                    KeyConstants.ERROR_SYNC_AWARD_STATUS, 
                    Constants.MAPPING_AWARD_ACTIONS_PAGE + "." + "Award Hierarchy Sync", 
                    new String[]{hierarchy.getAwardNumber()}));
        }
        for (AwardHierarchy curHierarchy : hierarchy.getChildren()) {
            success &= validateHierarchyIsActive(curHierarchy);
        }
        return success;
    }
    
    protected boolean isAwardActive(String awardNumber) {
        boolean success = false;
        List<VersionHistory> versions = getVersionHistoryService().loadVersionHistory(Award.class, awardNumber);
        for (VersionHistory history : versions) {
            if (history.getStatus() == VersionStatus.PENDING) {
                return false;
            } else if (history.getStatus() == VersionStatus.ACTIVE) {
                success = true;
            }
        }
        return success;
    }
}
