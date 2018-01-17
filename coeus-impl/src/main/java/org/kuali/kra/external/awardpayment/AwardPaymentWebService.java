/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.awardpayment;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.kuali.kra.infrastructure.Constants;

@WebService(name = "awardPaymentWebService", targetNamespace = Constants.FINANCIAL_INTEGRATION_KC_SERVICE_NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface AwardPaymentWebService {

	public AwardBasisOfPaymentDTO getBasisOfPayment(@WebParam(name = "basisOfPaymentCode") String basisOfPaymentCode);
	
	public AwardMethodOfPaymentDTO getMethodOfPayment(@WebParam(name = "methodOfPaymentCode") String methodOfPaymentCode);
	
	public List<AwardBasisOfPaymentDTO> getMatchingBasisOfPayments(@WebParam(name = "searchCriteria") AwardBasisOfPaymentDTO searchCriteria);
	
	public List<AwardMethodOfPaymentDTO> getMatchingMethodOfPayments(@WebParam(name = "searchCriteria") AwardMethodOfPaymentDTO searchCriteria);
	
	public List<AwardMethodOfPaymentDTO> getMatchingMethodOfPaymentsForBasisOfPayment(@WebParam(name = "basisOfPaymentCode") String basisOfPaymentCode);
}
