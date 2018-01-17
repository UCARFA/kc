/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.sponsor.hierarchy;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.api.sponsor.hierarchy.SponsorHierarchyService;
import org.kuali.coeus.common.framework.sponsor.hierarchy.SponsorHierarchy;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("sponsorHierarchyService")
public class SponsorHierarchyServiceImpl implements SponsorHierarchyService {

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Autowired
    @Qualifier("parameterService")
    private ParameterService parameterService;

    @Override
    public boolean isSponsorInHierarchy(String sponsorCode, String hierarchyName, int level, String levelName) {
        if (StringUtils.isBlank(sponsorCode)) {
            throw new IllegalArgumentException("The sponsorCode cannot be blank");
        }

        if (StringUtils.isBlank(hierarchyName)) {
            throw new IllegalArgumentException("The hierarchyName cannot be blank");
        }

        if (level < 1 || level > 10) {
            throw new IllegalArgumentException("The level must be between 1 and 10 inclusive");
        }

        if (StringUtils.isBlank(levelName)) {
            throw new IllegalArgumentException("The levelName cannot be blank");
        }

        final Map<String, String> valueMap = new HashMap<String, String>();
        valueMap.put("sponsorCode", sponsorCode);
        valueMap.put("hierarchyName", hierarchyName);
        valueMap.put("level" + level, levelName);
        return businessObjectService.countMatching(SponsorHierarchy.class, valueMap) > 0;
    }

    @Override
    public boolean isSponsorInHierarchy(String sponsorCode, String hierarchyName) {
        if (StringUtils.isBlank(sponsorCode)) {
            throw new IllegalArgumentException("The sponsorCode cannot be blank");
        }

        if (StringUtils.isBlank(hierarchyName)) {
            throw new IllegalArgumentException("The hierarchyName cannot be blank");
        }

        final Map<String, String> valueMap = new HashMap<String, String>();
        valueMap.put("sponsorCode", sponsorCode);
        valueMap.put("hierarchyName", hierarchyName);
        return businessObjectService.countMatching(SponsorHierarchy.class, valueMap) > 0;
    }

    @Override
    public boolean isSponsorNihMultiplePi(String sponsorCode) {
        return areAllSponsorsMultiPi() || isSponsorInHierarchy(sponsorCode, SPONSOR_HIERARCHY_NIH_MULT_PI);
    }

    @Override
    public boolean isSponsorNihOsc(String sponsorCode) {
        return isSponsorInHierarchy(sponsorCode, SPONSOR_HIERARCHY_NIH_OSC);
    }

    protected Boolean areAllSponsorsMultiPi() {
        return getParameterService().getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, Constants.PARAMETER_COMPONENT_DOCUMENT, Constants.ALL_SPONSOR_HIERARCHY_AS_NIH);
    }

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    public ParameterService getParameterService() {
        return parameterService;
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }
}
