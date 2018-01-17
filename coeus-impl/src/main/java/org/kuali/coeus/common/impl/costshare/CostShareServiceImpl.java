/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.costshare;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.costshare.CostShareService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("costShareService")
public class CostShareServiceImpl implements CostShareService {
    
    private static final String PARAM_LABEL_NAME = "CostShareProjectPeriodNameLabel"; 
    
    private static final String STANDARD_COST_SHARE_LABEL_FISCAL_YEAR = "Fiscal Year";
    private static final String STANDARD_COST_SHARE_LABEL_PROJECT_PERIOD = "Project Period";

    @Autowired
    @Qualifier("parameterService")
    private ParameterService parameterService; 

    @Override
    public String getCostShareLabel() {
        return this.getParameterService().getParameterValueAsString(Constants.KC_GENERIC_PARAMETER_NAMESPACE, 
                    Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, PARAM_LABEL_NAME);
    }
    
    @Override
    public boolean validateProjectPeriodAsFiscalYear() {
        boolean retVal = StringUtils.equalsIgnoreCase(STANDARD_COST_SHARE_LABEL_FISCAL_YEAR, getCostShareLabel());
        return retVal;
    }
    
    @Override
    public boolean validateProjectPeriodAsProjectPeriod() {
        boolean retVal = StringUtils.equalsIgnoreCase(STANDARD_COST_SHARE_LABEL_PROJECT_PERIOD, getCostShareLabel());
        return retVal;
    }

    public ParameterService getParameterService() {
        return parameterService;
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

}
