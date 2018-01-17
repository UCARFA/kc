/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.budget;

import org.kuali.coeus.common.budget.framework.calculator.BudgetCalculationService;
import org.kuali.kra.external.budget.impl.BudgetAdjustmentClientImpl;
import org.kuali.kra.external.budget.impl.BudgetAdjustmentKSBClientImpl;
import org.kuali.kra.external.unit.service.InstitutionalUnitService;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("budgetAdjustmentClient")
public class BudgetAdjustmentClientFactoryBean implements FactoryBean<BudgetAdjustmentClient> {

    @Autowired
    @Qualifier("documentService")
    private DocumentService documentService;

    @Autowired
    @Qualifier("parameterService")
    private ParameterService parameterService;

    @Autowired
    @Qualifier("institutionalUnitService")
    private InstitutionalUnitService institutionalUnitService;

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Autowired
    @Qualifier("budgetCalculationService")
    private BudgetCalculationService budgetCalculationService;

    @Autowired
    @Qualifier("budgetAdjustmentServiceHelper")
    private BudgetAdjustmentServiceHelper budgetAdjustmentServiceHelper;

    @Autowired
    @Qualifier("kualiConfigurationService")
    private ConfigurationService configurationService;

    @Override
    public BudgetAdjustmentClient getObject() throws Exception {
        final BudgetAdjustmentClient object;
        if(configurationService.getPropertyValueAsBoolean("shared.rice")) {
            object = (BudgetAdjustmentKSBClientImpl.getInstance());
        } else {
            object = (BudgetAdjustmentClientImpl.getInstance());
        }
        object.setDocumentService(documentService);
        object.setParameterService(parameterService);
        object.setBusinessObjectService(businessObjectService);
        object.setInstitutionalUnitService(institutionalUnitService);
        object.setBudgetCalculationService(budgetCalculationService);
        object.setBudgetAdjustmentServiceHelper(budgetAdjustmentServiceHelper);
        object.setConfigurationService(configurationService);
        return object;
    }

    @Override
    public Class<? extends BudgetAdjustmentClient> getObjectType() {
        return BudgetAdjustmentClient.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
    
    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }
    
    public void setBudgetAdjustmentServiceHelper(BudgetAdjustmentServiceHelper budgetAdjustmentServiceHelper) {
        this.budgetAdjustmentServiceHelper = budgetAdjustmentServiceHelper;
    }
    
    public void setInstitutionalUnitService(InstitutionalUnitService institutionalUnitService) {
        this.institutionalUnitService = institutionalUnitService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
    
    public void setBudgetCalculationService(BudgetCalculationService budgetCalculationService) {
        this.budgetCalculationService = budgetCalculationService;
    }

    public void setConfigurationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }
}
