/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.rule;

import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.persistence.PersistenceVerificationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.krad.maintenance.MaintenanceDocument;
import org.kuali.rice.krad.rules.MaintenanceDocumentRuleBase;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.util.MessageMap;

import java.util.Collection;
import java.util.Collections;

public class KcKradMaintenanceDocumentRuleBase extends MaintenanceDocumentRuleBase {

    private transient PersistenceVerificationService persistenceVerificationService;
    private transient GlobalVariableService globalVariableService;

    @Override
    protected boolean processGlobalRouteDocumentBusinessRules(MaintenanceDocument document) {
        boolean success = super.processGlobalRouteDocumentBusinessRules(document);

        if (document.getNewMaintainableObject().getMaintenanceAction().equals(KRADConstants.MAINTENANCE_DELETE_ACTION)) {
            MessageMap messages = getPersistenceVerificationService().verifyRelationshipsForDelete(getNewDataObject(), relationshipDeleteVerificationIgnores());
            success &= !messages.hasErrors();
            getGlobalVariableService().getMessageMap().merge(messages);
        }
        return success;
    }

    /**
     * Override this method to manually ignore certain relationships from delete verification.
     */
    protected Collection<Class<?>> relationshipDeleteVerificationIgnores() {
        return Collections.emptyList();
    }

    protected PersistenceVerificationService getPersistenceVerificationService() {
        if (persistenceVerificationService == null) {
            this.persistenceVerificationService = KcServiceLocator.getService(PersistenceVerificationService.class);
        }
        return persistenceVerificationService;
    }

    public void setPersistenceVerificationService(PersistenceVerificationService persistenceVerificationService) {
        this.persistenceVerificationService = persistenceVerificationService;
    }

    protected GlobalVariableService getGlobalVariableService() {
        if (globalVariableService == null) {
            this.globalVariableService = KcServiceLocator.getService(GlobalVariableService.class);
        }
        return globalVariableService;
    }

    public void setGlobalVariableService(GlobalVariableService globalVariableService) {
        this.globalVariableService = globalVariableService;
    }
}
