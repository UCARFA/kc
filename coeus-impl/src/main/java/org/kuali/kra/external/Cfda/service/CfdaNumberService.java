/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.Cfda.service;

import org.kuali.kra.external.Cfda.CfdaDTO;
import org.kuali.kra.external.HashMapElement;
import org.kuali.kra.infrastructure.Constants;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * This is the external service that is published to the service bus for
 * accessing effort reporting information stored in the Kuali Coeus system.
 * 
 * @author Kuali Coeus Development Team
 */
@WebService(name = "CfdaNumberService", targetNamespace = Constants.FINANCIAL_INTEGRATION_KC_SERVICE_NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CfdaNumberService {
    
    /**
     * This method returns the cfda numbers of the awards that are linked to
     * the financial account number and chart.
     * @param financialAccountNumber
     * @param chartOfAccounts
     * @return
     */
    public List<CfdaDTO> getCfdaNumber( @WebParam(name= "financialAccountNumber") 
                                  String financialAccountNumber,
                                  @WebParam(name="chartOfAccounts")
                                  String chartOfAccounts);
    
    /**
     * Lookup units based on the search criteria. 
     * @param criteria
     * @return
     */
    List<CfdaDTO> lookupCfda( @WebParam(name="searchCriteria") List<HashMapElement> criteria);

}


