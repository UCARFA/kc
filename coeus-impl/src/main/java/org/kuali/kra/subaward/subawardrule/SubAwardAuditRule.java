/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.subaward.subawardrule;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.AuditError;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.DocumentAuditRule;

import java.util.ArrayList;
import java.util.List;

/**
 * This class processes audit rules
 * (warnings) for the Report Information related
 * data of the SubAwardDocument.
 */
public class SubAwardAuditRule extends
        KcTransactionalDocumentRuleBase implements DocumentAuditRule{

    private static final String CONTACTS_AUDIT_ERRORS = "contactsAuditErrors";
    private List<AuditError> auditErrors;

    /**
     *
     * Constructs a SubAwardAuditRule.java. Added so unit test would not
     * need to call processRunAuditBusinessRules
     *  and therefore declare a document.
     */
    public SubAwardAuditRule() {
        auditErrors = new ArrayList<AuditError>();
    }

    /**
     * @see org.kuali.core.rule.DocumentAuditRule#processRunAuditBusinessRules(
     * org.kuali.core.document.Document)
     */
    @Override
    public boolean processRunAuditBusinessRules(Document document) {
        boolean valid = true;
        auditErrors = new ArrayList<AuditError>();

        valid &= checkForAtLeastOneContact(document);

        reportAndCreateAuditCluster();

        return valid;

    }

    /**
     * This method creates and adds
     * the AuditCluster to the Global AuditErrorMap.
     */
    @SuppressWarnings("unchecked")
    protected void reportAndCreateAuditCluster() {
        if (auditErrors.size() > 0) {
            AuditCluster existingErrors = (AuditCluster)
            GlobalVariables.getAuditErrorMap().get(CONTACTS_AUDIT_ERRORS);
            if (existingErrors == null) {
                GlobalVariables.getAuditErrorMap().put(
            CONTACTS_AUDIT_ERRORS, new AuditCluster(
            Constants.SUBAWARD_CONTACTS_PANEL_NAME,
                        auditErrors, Constants.AUDIT_ERRORS));
            } else {
                existingErrors.getAuditErrorList().addAll(auditErrors);
            }
        }
    }
    /**.
     * This method checkForAtLeastOneContact
     * @param document
     * @return boolean.
     */
    protected boolean checkForAtLeastOneContact(Document document) {
        SubAwardDocument subAwardDocument = (SubAwardDocument)document;
        subAwardDocument.getSubAward().getSubAwardContactsList().size();
        if (subAwardDocument.getSubAward().
          getSubAwardContactsList().size() <= 0) {
            subAwardDocument.getSubAward().setDefaultOpen(false);
            auditErrors.add(new AuditError(Constants.
          SUBAWARD_AUDIT_RULE_ERROR_KEY, KeyConstants.ERROR_SUBAWARD_CONTACT,
          Constants.MAPPING_SUBAWARD_PAGE
          + "." + Constants.SUBAWARD_CONTACTS_PANEL_ANCHOR));
            return false;
        } else {
            subAwardDocument.getSubAward().setDefaultOpen(true);
            return true;
        }
    }
}
