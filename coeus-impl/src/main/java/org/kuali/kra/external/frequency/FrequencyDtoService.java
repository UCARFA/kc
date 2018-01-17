/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.frequency;

import org.kuali.kra.award.paymentreports.Frequency;
import org.kuali.kra.external.service.KcDtoServiceBase;

public class FrequencyDtoService extends KcDtoServiceBase<FrequencyDto, Frequency> {

	@Override
	public FrequencyDto buildDto(Frequency dataObject) {
		if (dataObject != null) {
			FrequencyDto dto = new FrequencyDto();
			dto.setFrequencyCode(dataObject.getFrequencyCode());
			dto.setDescription(dataObject.getDescription());
			return dto;
		} else {
			return null;
		}
	}


}
