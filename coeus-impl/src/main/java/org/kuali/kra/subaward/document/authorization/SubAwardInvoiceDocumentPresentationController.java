/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.document.authorization;


import org.kuali.rice.kew.api.document.DocumentStatus;
import org.kuali.rice.kns.document.authorization.DocumentPresentationController;
import org.kuali.rice.kns.document.authorization.MaintenanceDocumentPresentationControllerBase;
import org.kuali.rice.krad.document.Document;

/**
 * Determines read-only fields on the Proposal Log maintenance document.
 */
public class SubAwardInvoiceDocumentPresentationController extends MaintenanceDocumentPresentationControllerBase
    implements DocumentPresentationController {

    private static final long serialVersionUID = -5900944810037193950L;

    @Override
    public boolean canEdit(Document document) {
        boolean canEdit = super.canEdit(document);
        if (canEdit) {
            if (document.getDocumentHeader().getWorkflowDocument().getStatus() == DocumentStatus.ENROUTE) {
                canEdit = false;
            }
        }
        return canEdit;
    }
}
