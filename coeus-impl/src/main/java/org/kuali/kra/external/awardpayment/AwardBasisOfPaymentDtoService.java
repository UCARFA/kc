/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.awardpayment;

import org.kuali.kra.award.home.AwardBasisOfPayment;
import org.kuali.kra.external.service.KcDtoServiceBase;

public class AwardBasisOfPaymentDtoService extends KcDtoServiceBase<AwardBasisOfPaymentDTO, AwardBasisOfPayment> {

	@Override
	public AwardBasisOfPaymentDTO buildDto(AwardBasisOfPayment basisOfPayment) {
    	AwardBasisOfPaymentDTO dto = new AwardBasisOfPaymentDTO();
    	if (basisOfPayment != null) {
	    	dto.setBasisOfPaymentCode(basisOfPayment.getBasisOfPaymentCode());
	    	dto.setDescription(basisOfPayment.getDescription());
	    	return dto;
    	} else {
    		return null;
    	}
	}
}
