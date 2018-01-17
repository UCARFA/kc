/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.custom;

import org.kuali.coeus.common.impl.custom.CustomDataRule;
import org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.DocumentAuditRule;

/**
 * This class processes audit rules (warnings) for various KcTransactionalDocument extensions
 */
public class KcDocumentBaseAuditRule implements DocumentAuditRule {

    @Override
    public boolean processRunAuditBusinessRules(Document document) {
        boolean valid = true;

        if (document instanceof KcTransactionalDocumentBase) {
            valid = new CustomDataRule().processRules(new AuditCustomDataEvent((KcTransactionalDocumentBase)document));
        }

        return valid;
    }

}
