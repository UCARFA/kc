package org.kuali.coeus.common.impl.rolodex;

import org.kuali.coeus.common.framework.rolodex.Rolodex;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.List;

import static org.kuali.coeus.sys.framework.service.KcServiceLocator.getService;

    public class RolodexMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(Document document) {
        return super.processCustomRouteDocumentBusinessRules(document);
    }

    @Override
    protected boolean processGlobalRouteDocumentBusinessRules(MaintenanceDocument document) {
        /*
        Required Parameter to Enforce Unique Email:
            ENFORCE_UNIQUE_EMAIL
                Example:
                Namespace: KC-GEN
                Component: All
                Application ID: KC
                Parameter Name: ENFORCE_UNIQUE_EMAIL
                Paramter Value: true
                Parameter Description: Enforce Unique Email in Address Book
                Parameter Type Code: Config
                Parameter Constraint Code: Allowed
        */
        // MAINTENANCE_EDIT_ACTION

        String maintainenceAction = document.getNewMaintainableObject().getMaintenanceAction();
        if (!maintainenceAction.equals(KRADConstants.MAINTENANCE_DELETE_ACTION)) {
            Boolean enforceUniqueEmail = getParameterService().getParameterValueAsBoolean("KC-GEN", "All", "ENFORCE_UNIQUE_EMAIL");
          //  Rolodex newRolodex = (Rolodex) document.getDocumentBusinessObject();
            if (enforceUniqueEmail != null && enforceUniqueEmail) {
                Rolodex newRolodex = (Rolodex) document.getNewMaintainableObject().getDataObject();
                Rolodex oldRolodex = (Rolodex) document.getOldMaintainableObject().getDataObject();
                if ((newRolodex.getEmailAddress() == null || newRolodex.getEmailAddress().isEmpty())
                     || (maintainenceAction.equals(KRADConstants.MAINTENANCE_EDIT_ACTION) && newRolodex.getEmailAddress() != oldRolodex.getEmailAddress() && !checkEmailUnique(newRolodex))
                     || (!maintainenceAction.equals(KRADConstants.MAINTENANCE_EDIT_ACTION) && !checkEmailUnique(newRolodex))) {
                    getGlobalVariableService().getMessageMap().putError(KRADConstants.MAINTENANCE_NEW_MAINTAINABLE + "emailAddress", "error.rolodex.emailAddress.unique", new String[]{"Email Address"});
                }
            }
        }

        boolean success = super.processGlobalRouteDocumentBusinessRules(document);

        return success;
    }

    private Boolean checkEmailUnique(Rolodex rolodexEntry) {
        Boolean uniqueEmail = false;
        List<Rolodex> rolodex = getRolodexDao().getRolodexByEmail(rolodexEntry.getEmailAddress());
        if (rolodex != null && rolodex.isEmpty()) {
            uniqueEmail = true;
        }
        return uniqueEmail;
    }

    private RolodexDaoOjb getRolodexDao() {
        return (RolodexDaoOjb) getService(RolodexDao.class);
    }

    private ParameterService getParameterService() {
        return KcServiceLocator.getService(ParameterService.class);
    }
}
