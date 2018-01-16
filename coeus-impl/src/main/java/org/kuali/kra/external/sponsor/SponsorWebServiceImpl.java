/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.sponsor;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.sponsor.Sponsor;
import org.kuali.kra.external.service.KcDtoService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.LegacyDataAdapter;
import org.kuali.rice.krad.util.ObjectUtils;

public class SponsorWebServiceImpl implements SponsorWebService {

	private BusinessObjectService businessObjectService;
    private LegacyDataAdapter legacyDataAdapter;
	private KcDtoService<SponsorDTO, Sponsor> sponsorDtoService;
	
	@Override
    public SponsorDTO getSponsor(String sponsorCode) {
		if (StringUtils.isNotBlank(sponsorCode)) {
			Sponsor sponsor = getBusinessObjectService().findBySinglePrimaryKey(Sponsor.class, sponsorCode);
			if (sponsor != null) {
				SponsorDTO result = sponsorDtoService.buildDto(sponsor);
				return result;
			}
		}
		return null;
	}

	@Override
    public List<SponsorDTO> getMatchingSponsors(SponsorCriteriaDto searchCriteria) {
		List<SponsorDTO> results = new ArrayList<SponsorDTO>();
		Collection<Sponsor> sponsors;
		if (ObjectUtils.isNull(searchCriteria) ||
				(StringUtils.isEmpty(searchCriteria.getSponsorCode())
				&& StringUtils.isEmpty(searchCriteria.getCustomerNumber()))) {
			sponsors = getBusinessObjectService().findAll(Sponsor.class);
		} else if (StringUtils.isNotEmpty(searchCriteria.getSponsorCode())) {
            sponsors = legacyDataAdapter.findCollectionBySearchHelper(Sponsor.class, Collections.singletonMap("sponsorCode", searchCriteria.getSponsorCode()), Collections.<String>emptyList(), true, false, 0);
		} else {
			sponsors = legacyDataAdapter.findCollectionBySearchHelper(Sponsor.class, Collections.singletonMap("customerNumber", searchCriteria.getCustomerNumber()), Collections.<String>emptyList(), true, false, 0);
		}
		if (sponsors != null && !sponsors.isEmpty()) {
			for (Sponsor sponsor : sponsors) {
				results.add(sponsorDtoService.buildDto(sponsor));
			}
		}
		return results;
	}

	protected BusinessObjectService getBusinessObjectService() {
		return businessObjectService;
	}

	public void setBusinessObjectService(BusinessObjectService businessObjectService) {
		this.businessObjectService = businessObjectService;
	}

    public LegacyDataAdapter getLookupService() {
        return legacyDataAdapter;
    }

    public void setLegacyDataAdapter(LegacyDataAdapter legacyDataAdapter) {
        this.legacyDataAdapter = legacyDataAdapter;
    }

    public KcDtoService<SponsorDTO, Sponsor> getSponsorDtoService() {
		return sponsorDtoService;
	}

	public void setSponsorDtoService(
			KcDtoService<SponsorDTO, Sponsor> sponsorDtoService) {
		this.sponsorDtoService = sponsorDtoService;
	}

}
