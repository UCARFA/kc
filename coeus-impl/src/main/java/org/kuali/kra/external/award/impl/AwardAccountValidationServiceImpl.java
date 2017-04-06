/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.kra.external.award.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.commitments.AwardFandaRate;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.external.award.AwardAccountService;
import org.kuali.kra.external.award.AwardAccountValidationService;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.ObjectUtils;

import java.util.List;

public class AwardAccountValidationServiceImpl implements AwardAccountValidationService {

    private static final String AWARD_EFFECTIVE_DATE_NOT_SPECIFIED = "error.award.createAccount.invalid.effectiveDate";
    private static final String AWARD_ID_NOT_SPECIFIED = "error.award.createAccount.invalid.awardId";
    private static final String AWARD_END_DATE_NOT_SPECIFIED = "error.award.createAccount.invalid.endDate";
    private static final String AWARD_ACTIVITY_TYPE_CODE = "error.award.createAccount.invalid.activityTypeCode";
    private static final String AWARD_PAYMENT_BASIS_NOT_SPECIFIED = "error.award.createAccount.invalid.paymentBasis";
    private static final String AWARD_PAYMENT_METHOD_NOT_SPECIFIED = "error.award.createAccount.invalid.paymentMethod";
    private static final String AWARD_ADDRESS_NOT_COMPLETE = "error.award.createAccount.invalid.piAddress";
    private static final String AWARD_PI_NOT_SPECIFIED = "error.award.createAccount.invalid.pi";
    private static final String AWARD_F_AND_A_RATE_NOT_SPECIFIED = "error.award.createAccount.invalid.rate";
    private AwardAccountService awardAccountService;
    
    public boolean validateAwardAccountDetails(Award award) {
        boolean rulePassed = true;
        
        rulePassed &= isValidEffectiveDate(award);
        rulePassed &= isValidExpenseGuidelineText(award);
        rulePassed &= isValidExpirationDate(award);
        rulePassed &= isValidHigherEducationCode(award);
        rulePassed &= isValidPaymentBasis(award);
        rulePassed &= isValidPaymentMethod(award);
        rulePassed &= isValidAddress(award);
        rulePassed &= isValidFandarate(award);        
       
        return rulePassed;
    }


    /**
     * This method check if the default address (PI address) is present.
     * @param award
     * @return isValid
     */
    protected boolean isValidAddress(Award award) {
       
        boolean isValid = true;
        if (ObjectUtils.isNull(award.getPrincipalInvestigator())) {
            GlobalVariables.getMessageMap().putError(AWARD_PI_NOT_SPECIFIED, 
                    KeyConstants.AWARD_PI_NOT_SPECIFIED);
            isValid = false;
        } else {
            KcPerson principalInvestigator = award.getPrincipalInvestigator().getPerson();
            if (ObjectUtils.isNotNull(principalInvestigator)) {
                String streetAddress = principalInvestigator.getAddressLine1();
                String cityName = principalInvestigator.getCity();
                String stateCode = principalInvestigator.getState();
                String postalCode = principalInvestigator.getPostalCode();
                if (StringUtils.isBlank(streetAddress) || StringUtils.isBlank(cityName)
                    || StringUtils.isBlank(stateCode) || StringUtils.isBlank(postalCode))  {
                    GlobalVariables.getMessageMap().putError(AWARD_ADDRESS_NOT_COMPLETE, 
                            KeyConstants.AWARD_ADDRESS_NOT_COMPLETE);
                    isValid = false;
                }
            } else {
                GlobalVariables.getMessageMap().putError(AWARD_ADDRESS_NOT_COMPLETE, 
                        KeyConstants.AWARD_ADDRESS_NOT_COMPLETE);
                isValid = false;
            }
        }
        
        return isValid;
    }

    protected boolean isValidFandarate(Award award) {
        List<AwardFandaRate> rates = award.getAwardFandaRate();
        boolean isValid = true;

        if (!getAwardAccountService().isFinancialRestApiEnabled()) {
            if (ObjectUtils.isNull(rates) || rates.size() == 0) {
                GlobalVariables.getMessageMap().putError(AWARD_F_AND_A_RATE_NOT_SPECIFIED,
                        KeyConstants.AWARD_F_AND_A_RATE_NOT_SPECIFIED);
                isValid = false;
            }
        }
      
        return isValid;
    }
    
    protected boolean isValidPaymentBasis(Award award) {
        if (award.getBasisOfPaymentCode() == null) {
            GlobalVariables.getMessageMap().putError(AWARD_PAYMENT_BASIS_NOT_SPECIFIED, 
                                                    KeyConstants.AWARD_PAYMENT_BASIS_NOT_SPECIFIED);
            return false;
        }
        return true;
    }
    
    protected boolean isValidPaymentMethod(Award award) {
        if (award.getMethodOfPaymentCode() == null) {
            GlobalVariables.getMessageMap().putError(AWARD_PAYMENT_METHOD_NOT_SPECIFIED, 
                                                    KeyConstants.AWARD_PAYMENT_METHOD_NOT_SPECIFIED);
            return false;
        }
        return true;
    }
    
    protected boolean isValidHigherEducationCode(Award award) {
        if (award.getActivityTypeCode() == null) {
            GlobalVariables.getMessageMap().putError(AWARD_ACTIVITY_TYPE_CODE, 
                                                    KeyConstants.AWARD_ACTIVITY_TYPE_CODE);
            return false;
        }
        return true;
    }

    protected boolean isValidEffectiveDate(Award award) {
        if (award.getAwardEffectiveDate() == null) {
            GlobalVariables.getMessageMap().putError(AWARD_EFFECTIVE_DATE_NOT_SPECIFIED, 
                                                    KeyConstants.AWARD_NO_VALID_EFFECTIVE_DATE);
            return false;
        }
        return true; 
    }

    protected boolean isValidExpenseGuidelineText(Award award) { 
        if (award.getAwardId() == null) {
            GlobalVariables.getMessageMap().putError(AWARD_ID_NOT_SPECIFIED, 
                                                    KeyConstants.AWARD_ID_NOT_SPECIFIED);
            return false;
        }
        return true;
    }

    protected boolean isValidExpirationDate(Award award) {
        if (award.getProjectEndDate() == null) {
            GlobalVariables.getMessageMap().putError(AWARD_END_DATE_NOT_SPECIFIED, 
                                                    KeyConstants.AWARD_END_DATE_NOT_SPECIFIED);
            return false;
        }
        return true;
    }

    /*
    Cannot autowire because of account validation service being in core spring context which
    becomes available before award spring context
     */
    public AwardAccountService getAwardAccountService() {
        return KcServiceLocator.getService(AwardAccountService.class);
    }
}
