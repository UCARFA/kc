/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.rice.krad.lookup;

import org.kuali.coeus.common.framework.auth.UnitAuthorizationService;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.authorization.KraAuthorizationConstants;
import org.kuali.kra.award.infrastructure.AwardPermissionConstants;
import org.kuali.kra.award.paymentreports.awardreports.reporting.service.SentReportNotification;
import org.kuali.rice.krad.exception.AuthorizationException;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.UifPropertyPaths;
import org.kuali.rice.krad.uif.util.ObjectPropertyUtils;
import org.kuali.rice.krad.util.KRADConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = KRADConstants.ControllerMappings.LOOKUP)
public class SentReportNotificationLookupController extends LookupController {

    public static final String DELETE_SENT_REPORT_NOTIFICATION_PERM = AwardPermissionConstants.MODIFY_AWARD_REPORT_TRACKING.getAwardPermission();
    private static final String AUTH_EXCEPTION_DELETE_ACITON = "Delete";
    private static final String AUTH_EXCEPTION_NOTIFICATIONS_TYPE = "Report Tracking Notifications";

    private BusinessObjectService businessObjectService;
    private GlobalVariableService globalVariableService;
    private UnitAuthorizationService unitAuthorizationService;

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=deleteSelectedReportNotifications")
    public ModelAndView deleteSelectedReportNotifications(LookupForm lookupForm) {
        ModelAndView modelAndView = getModelAndViewService().getModelAndView(lookupForm);
        if (!isAuthorizedToDeleteNotifications()) {
            throw new AuthorizationException(getGlobalVariableService().getUserSession().getPrincipalName(), AUTH_EXCEPTION_DELETE_ACITON, AUTH_EXCEPTION_NOTIFICATIONS_TYPE);
        }
        if (lookupForm.getLookupResults().stream().allMatch(result -> result instanceof SentReportNotification)) {
            if (lookupForm.getSelectedCollectionLines().containsKey(UifPropertyPaths.LOOKUP_RESULTS)) {
                List<?> notificationsToDelete = lookupForm.getSelectedCollectionLines().get(UifPropertyPaths.LOOKUP_RESULTS).stream()
                        .map(selectedLine -> ObjectPropertyUtils.getPropertyValue(lookupForm, selectedLine))
                        .collect(Collectors.toList());
                getBusinessObjectService().delete(notificationsToDelete);
                lookupForm.getLookupResults().removeAll(notificationsToDelete);
                lookupForm.getSelectedCollectionLines().clear();
            }
        }
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=deleteAllReportNotifications")
    public ModelAndView deleteAllReportNotifications(LookupForm lookupForm) {
        ModelAndView modelAndView = getModelAndViewService().getModelAndView(lookupForm);
        if (!isAuthorizedToDeleteNotifications()) {
            throw new AuthorizationException(getGlobalVariableService().getUserSession().getPrincipalName(), AUTH_EXCEPTION_DELETE_ACITON, AUTH_EXCEPTION_NOTIFICATIONS_TYPE);
        }
        Collection<?> searchResults = lookupForm.getLookupResults();
        if (searchResults != null && searchResults.stream().allMatch(result -> result instanceof SentReportNotification)) {
            getBusinessObjectService().delete(searchResults);
            lookupForm.setLookupResults(Collections.emptyList());
        }
        return modelAndView;
    }

    private boolean isAuthorizedToDeleteNotifications() {
        String principalId = getGlobalVariableService().getUserSession().getPrincipalId();
        return getUnitAuthorizationService().hasPermission(principalId, KraAuthorizationConstants.KC_AWARD_NAMESPACE, DELETE_SENT_REPORT_NOTIFICATION_PERM);
    }

    public BusinessObjectService getBusinessObjectService() {
        if (businessObjectService == null) {
            businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
        }
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    public GlobalVariableService getGlobalVariableService() {
        if (globalVariableService == null) {
            globalVariableService = KcServiceLocator.getService(GlobalVariableService.class);
        }
        return globalVariableService;
    }

    public void setGlobalVariableService(GlobalVariableService globalVariableService) {
        this.globalVariableService = globalVariableService;
    }

    private UnitAuthorizationService getUnitAuthorizationService() {
        if (unitAuthorizationService == null) {
            unitAuthorizationService = KcServiceLocator.getService(UnitAuthorizationService.class);
        }
        return unitAuthorizationService;
    }

    public void setUnitAuthorizationService(UnitAuthorizationService unitAuthorizationService) {
        this.unitAuthorizationService = unitAuthorizationService;
    }

}
