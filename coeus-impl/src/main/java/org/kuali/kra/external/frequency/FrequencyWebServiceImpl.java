/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.frequency;

import org.kuali.kra.award.paymentreports.Frequency;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTrackingConstants;
import org.kuali.kra.external.service.KcDtoService;
import org.kuali.rice.krad.service.BusinessObjectService;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyWebServiceImpl implements FrequencyWebService {
	
	private BusinessObjectService businessObjectService;
	private KcDtoService<FrequencyDto, Frequency> frequencyDtoService;
	

	@Override
	public FrequencyDto getFrequency(
			@WebParam(name = ReportTrackingConstants.FREQUENCY_CODE) String frequencyCode) {
		return frequencyDtoService.buildDto(getBusinessObjectService().findBySinglePrimaryKey(Frequency.class, frequencyCode));
	}

	@Override
	public List<FrequencyDto> findMatching(
			@WebParam(name = ReportTrackingConstants.FREQUENCY_CODE) String frequencyCode,
			@WebParam(name = "description") String description) {
		Map<String, String> values = new HashMap<String, String>();
		if (frequencyCode != null) {
			values.put(ReportTrackingConstants.FREQUENCY_CODE, frequencyCode);
		}
		if (description != null) {
			values.put("description", description);
		}
		return frequencyDtoService.buildDtoList(getBusinessObjectService().findMatching(Frequency.class, values));
	}

	@Override
	public List<FrequencyDto> findAll() {
		return frequencyDtoService.buildDtoList(getBusinessObjectService().findAll(Frequency.class));
	}

	public BusinessObjectService getBusinessObjectService() {
		return businessObjectService;
	}

	public void setBusinessObjectService(BusinessObjectService businessObjectService) {
		this.businessObjectService = businessObjectService;
	}

	public KcDtoService<FrequencyDto, Frequency> getFrequencyDtoService() {
		return frequencyDtoService;
	}

	public void setFrequencyDtoService(
			KcDtoService<FrequencyDto, Frequency> frequencyDtoService) {
		this.frequencyDtoService = frequencyDtoService;
	}

}
