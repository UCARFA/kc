/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.budget.framework.core.CostElement;
import org.kuali.kra.service.ObjectCodeToBudgetCategoryCodeService;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("objectCodeToBudgetCategoryCodeService")
public class ObjectCodeToBudgetCategoryCodeServiceImpl implements ObjectCodeToBudgetCategoryCodeService {

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Override
    public String getBudgetCategoryCodeForCostElment(String objectCode) {
        String budgetCategoryCode = null;

        if (StringUtils.isNotEmpty(objectCode)) {
            CostElement costElement = dataObjectService.find(CostElement.class, objectCode);
            if (costElement != null) {
                budgetCategoryCode = costElement.getBudgetCategoryCode();
            }
        }

        return budgetCategoryCode;
    }

    public DataObjectService getDataObjectService() {
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }
}
