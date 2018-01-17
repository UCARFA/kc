/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.timeandmoney.service.AwardFnaDistributionService;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

public class AwardFnaDistributionServiceImpl implements AwardFnaDistributionService {
    
    public static final String AWARD_FNA_DISTRIBUTION_PARAMETER_NAME = "AWARD_FNA_DISTRIBUTION";
    public static final String AWARD_FNA_DISTRIBUTION_NAMESPACE = "KC-AWARD";
    public static final String AWARD_FNA_DISTRIBUTION_COMPONENT = "Document";
    private ParameterService parameterService;

    @Override
    public boolean displayAwardFAndADistributionEqualityValidationAsWarning() {
        String parmValue = getFandAParameterValue();
        return isOptional(parmValue);
    }

    @Override
    public boolean displayAwardFAndADistributionEqualityValidationAsError() {
        String parmValue = getFandAParameterValue();
        return isMandatory(parmValue);
    }
    
    @Override
    public boolean disableFAndADistributionEqualityValidation() {
        String parmValue = getFandAParameterValue();
        return isDisabled(parmValue);
    }
    
    protected String getFandAParameterValue() {
        String parmVal = getParameterService().getParameterValueAsString(AWARD_FNA_DISTRIBUTION_NAMESPACE, 
                AWARD_FNA_DISTRIBUTION_COMPONENT, AWARD_FNA_DISTRIBUTION_PARAMETER_NAME);
        return parmVal;
    }
    
        
    protected boolean isDisabled(String parameterValue) {
        return StringUtils.equalsIgnoreCase("D", parameterValue);
    }
    
    protected boolean isMandatory(String parameterValue) {
        return StringUtils.equalsIgnoreCase("M", parameterValue);
    }
    
    protected boolean isOptional(String parameterValue) {
        return StringUtils.equalsIgnoreCase("O", parameterValue);
    }

    public ParameterService getParameterService() {
        return parameterService;
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }
}
