/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.award;

import org.kuali.kra.infrastructure.Constants;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService(name = "awardAccountService", targetNamespace = Constants.FINANCIAL_INTEGRATION_KC_SERVICE_NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface AwardAccountService {

    
    /**
     * This method returns all the awards linked to a financial account number
     * and the chart code
     * @param financialAccountNumber
     * @return
     */    
    List<AwardAccountDTO> getAwardAccounts(
                                          @WebParam(name= "financialAccountNumber") 
                                          String financialAccountNumber,
                                          @WebParam(name="chartOfAccounts")
                                          String chartOfAccounts);

    boolean isFinancialRestApiEnabled();
}
