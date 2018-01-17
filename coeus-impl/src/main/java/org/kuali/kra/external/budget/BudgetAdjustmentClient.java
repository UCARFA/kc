/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.budget;

import org.kuali.kra.award.budget.document.AwardBudgetDocument;
import org.kuali.coeus.common.budget.framework.calculator.BudgetCalculationService;
import org.kuali.kra.external.unit.service.InstitutionalUnitService;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;

import javax.xml.datatype.DatatypeConfigurationException;

public interface BudgetAdjustmentClient {

    void createBudgetAdjustmentDocument(AwardBudgetDocument awardBudgetDocument)throws DatatypeConfigurationException, WorkflowException, Exception;

    void setDocumentService(DocumentService documentService);

    void setParameterService(ParameterService parameterService);

    void setBusinessObjectService(BusinessObjectService businessObjectService);

    void setInstitutionalUnitService(InstitutionalUnitService institutionalUnitService);

    void setBudgetCalculationService(BudgetCalculationService budgetCalculationService);

    void setBudgetAdjustmentServiceHelper(BudgetAdjustmentServiceHelper businessAdjustmentServiceHelper);
    
    void setConfigurationService(ConfigurationService configurationService);
}
