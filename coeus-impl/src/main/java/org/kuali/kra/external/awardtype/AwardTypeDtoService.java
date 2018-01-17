/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.awardtype;

import org.kuali.kra.award.home.AwardType;
import org.kuali.kra.external.service.KcDtoServiceBase;

public class AwardTypeDtoService extends KcDtoServiceBase<AwardTypeDTO, AwardType> {

	@Override
	public AwardTypeDTO buildDto(AwardType awardType) {
		if (awardType != null) {
			AwardTypeDTO dto = new AwardTypeDTO();
			dto.setAwardTypeCode(awardType.getCode());
			dto.setDescription(awardType.getDescription());
			return dto;
		} else {
			return null;
		}	}

}
