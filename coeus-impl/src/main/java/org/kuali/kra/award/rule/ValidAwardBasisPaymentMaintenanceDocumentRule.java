/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.rule;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.AwardBasisOfPayment;
import org.kuali.kra.award.home.AwardType;
import org.kuali.kra.award.home.ValidAwardBasisPayment;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.util.MessageMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This class is check the uniqueness of award type code and basis of payment code.
 */
public class ValidAwardBasisPaymentMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {

    @Override
    public boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        final ValidAwardBasisPayment validAwardBasisPayment = (ValidAwardBasisPayment) document.getNewMaintainableObject().getDataObject();

        if (!document.getNewMaintainableObject().getMaintenanceAction().equals(KRADConstants.MAINTENANCE_DELETE_ACTION)) {
            return validateUniqueueCodes(validAwardBasisPayment.getAwardType(), validAwardBasisPayment.getBasisOfPayment());
        } else {
            return true;
        }
    }

    /*
     * ensure the uniqueness of award type/basis of payment
     */
    private boolean validateUniqueueCodes(final AwardType awardType, final AwardBasisOfPayment basisOfPayment) {
        
        boolean valid = true;
        if (awardType != null && basisOfPayment != null &&StringUtils.isNotBlank(awardType.getCode().toString()) && StringUtils.isNotBlank(basisOfPayment.getBasisOfPaymentCode())) {
            final Map<String, String> pkMap = new HashMap<String, String>();
            pkMap.put("awardTypeCode", awardType.getCode().toString());
            pkMap.put("basisOfPaymentCode", basisOfPayment.getBasisOfPaymentCode());
            final int matchingCount = KcServiceLocator.getService(BusinessObjectService.class).countMatching(ValidAwardBasisPayment.class, pkMap);
            
            if (matchingCount > 0 ) {
                final MessageMap errorMap = GlobalVariables.getMessageMap();
                errorMap.putError("document.newMaintainableObject.awardTypeCode", KeyConstants.ERROR_AWARD_BASIS_EXIST,
                        new String[] {awardType.getDescription(), basisOfPayment.getDescription() });
                valid = false;
            }
        }
        return valid;
    }

}
