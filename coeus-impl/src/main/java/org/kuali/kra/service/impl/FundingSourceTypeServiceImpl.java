/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.bo.FundingSourceType;
import org.kuali.kra.service.FundingSourceTypeService;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @see org.kuali.kra.service.FundingSourceTypeService
 */
public class FundingSourceTypeServiceImpl implements FundingSourceTypeService {

    private BusinessObjectService businessObjectService;

    
    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }


    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }


    @Override
    public FundingSourceType getFundingSourceType(String sourceTypeId) {

        FundingSourceType sourceType = null;

        Map<String, String> primaryKeys = new HashMap<String, String>();
        if (StringUtils.isNotEmpty(sourceTypeId)) {
            primaryKeys.put("fundingSourceTypeCode", sourceTypeId);
            sourceType = (FundingSourceType)businessObjectService.findByPrimaryKey(FundingSourceType.class, primaryKeys);
        }
        return sourceType;
    }

}
