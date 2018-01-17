/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.awardpayment;

import org.kuali.kra.award.home.AwardMethodOfPayment;
import org.kuali.kra.external.service.KcDtoServiceBase;

public class AwardMethodOfPaymentDtoService extends KcDtoServiceBase<AwardMethodOfPaymentDTO, AwardMethodOfPayment> {

	@Override
	public AwardMethodOfPaymentDTO buildDto(AwardMethodOfPayment methodOfPayment) {
		AwardMethodOfPaymentDTO dto = new AwardMethodOfPaymentDTO();
    	if (methodOfPayment != null) {
    		dto.setMethodOfPaymentCode(methodOfPayment.getMethodOfPaymentCode());
    		dto.setDescription(methodOfPayment.getDescription());
	    	return dto;
    	} else {
    		return null;
    	}
	}
}
