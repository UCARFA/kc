/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.coi.CoiDisclosureStatus;
import org.kuali.kra.coi.CoiDispositionStatus;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.GlobalVariables;


public class CoiDisclosureAdministratorActionRule {

    private static final String ADMIN_ERRORS = "coiAdminActionErrors";
    
    public boolean isValidStatus(String disclosureStatus, String dispositionStatus) {
        return isValidStatus(disclosureStatus, convertDispositionStatus(dispositionStatus));
    }
    
    public boolean isValidStatus(String disclosureStatus, Integer dispositionStatus) {
        boolean isValid = true;
        if (StringUtils.isBlank(disclosureStatus)) {
            GlobalVariables.getMessageMap().putError(ADMIN_ERRORS, KeyConstants.ERROR_COI_DISCLOSURE_STATUS_REQUIRED);    
            isValid = false;
        }
        if (dispositionStatus == null) {
            GlobalVariables.getMessageMap().putError(ADMIN_ERRORS, KeyConstants.ERROR_COI_DISPOSITON_STATUS_REQUIRED); 
            isValid = false;
        }
        CoiDispositionStatus disposition = KcServiceLocator.getService(BusinessObjectService.class).findBySinglePrimaryKey(CoiDispositionStatus.class, dispositionStatus);
        if (disposition == null) {
            GlobalVariables.getMessageMap().putError(ADMIN_ERRORS, KeyConstants.ERROR_COI_DISPOSITON_STATUS_REQUIRED);
            isValid = false;
        }
        //if the disposition requires disapproval, then the disclosureStatus must be disapproved.
        if (StringUtils.equals(disposition.getCoiDisclosureStatusCode(), CoiDisclosureStatus.DISAPPROVED) 
                && !StringUtils.equals(disclosureStatus, CoiDisclosureStatus.DISAPPROVED)) {
            GlobalVariables.getMessageMap().putError(ADMIN_ERRORS, KeyConstants.ERROR_COI_DISCLOSURE_STATUS_INVALID);
            isValid = false;
        }
        return isValid;
    }
    
    public boolean isValidDispositionStatus(String dispositionStatus) {
        return isValidDispositionStatus(convertDispositionStatus(dispositionStatus));
    }
    
    public boolean isValidDispositionStatus(Integer dispositionStatus) {        
        boolean isValid = true;
        if (dispositionStatus == null) {
            GlobalVariables.getMessageMap().putError(Constants.DISCLOSURE_MANUAL_DISPOSITION_STATUS, KeyConstants.ERROR_COI_DISPOSITON_STATUS_REQUIRED); 
            isValid = false;
        }
        return isValid;
    }
    
    protected Integer convertDispositionStatus(String dispositionStatus) {
        return dispositionStatus != null ? Integer.valueOf(dispositionStatus) : null;
    }

}
