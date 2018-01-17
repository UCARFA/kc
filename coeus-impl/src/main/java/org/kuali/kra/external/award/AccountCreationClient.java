/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.award;

import org.kuali.kra.award.home.Award;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;

import javax.xml.datatype.DatatypeConfigurationException;

public interface AccountCreationClient {

    /**
     * This method creates and award account.
     * @param award
     * @throws DatatypeConfigurationException
     * @throws WorkflowException
     */
    void createAwardAccount(Award award)throws DatatypeConfigurationException, WorkflowException;
    
    /**
     * This method checks if the financial account number is valid.
     * @param accountNumber
     * @return
     */
    String isValidAccountNumber(String accountNumber);
    
    /**
     * This method checks if the combination of account number and chart is valid.
     * @param chartOfAccountsCode
     * @param accountNumber
     * @return
     */
    String isValidChartAccount(String chartOfAccountsCode, String accountNumber);

    void setDocumentService(DocumentService documentService);

    void setBusinessObjectService(BusinessObjectService businessObjectService);
    
    void setParameterService(ParameterService parameterService);

    void setConfigurationService(ConfigurationService configurationService);
}
