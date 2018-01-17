/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.unit.service;

import org.kuali.kra.external.HashMapElement;
import org.kuali.kra.external.unit.UnitDTO;
import org.kuali.kra.infrastructure.Constants;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * This is the external service that is published to the service bus for
 * accessing Institutional Unit information stored in the Kuali Coeus system.
 * 
 * @author Kuali Coeus Development Team
 */
@WebService(name = "institutionalUnitService", targetNamespace = Constants.FINANCIAL_INTEGRATION_KC_SERVICE_NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface InstitutionalUnitService {
    
    /**
     * Get the Unit record corresponding to the given unit number.
     * 
     * @param unitNumber
     * @return UnitDTO
     */
    UnitDTO getUnit( @WebParam(name="unitNumber") String unitNumber);
    
    /**
     * Lookup Units according to the given search criteria.
     * 
     * @param criteria Key-value pair map of search criteria.
     * @return List&lt;UnitDTO&gt;
     */
    List<UnitDTO> lookupUnits( @WebParam(name="searchCriteria") List<HashMapElement> criteria);
    
    /**
     * Retrieve the parent units of the given unit number.  The list will be in 
     * the order of ancestry (parent at index 0, grandparent at index 1, etc).
     * 
     * @param unitNumber
     * @return List&lt;String&gt;
     */
    List<String> getParentUnits( @WebParam(name="unitNumber") String unitNumber);
}
