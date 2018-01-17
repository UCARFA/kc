/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.sponsor.form;

import org.kuali.coeus.common.impl.sponsor.SponsorHierarchyMaintenanceService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

public class PrintingHierarchyNameValuesFinder extends UifKeyValuesFinderBase {

    private SponsorHierarchyMaintenanceService sponsorHierarchyMaintenanceService;
    private ParameterService parameterService;

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> result = new ArrayList<KeyValue>();
        String hierarchyName = getParameterService().getParameterValueAsString(
                Constants.KC_GENERIC_PARAMETER_NAMESPACE, Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, 
                Constants.SPONSOR_HIERARCHY_PRINTING_NAME_PARAM);
        List<String> groupNames = getSponsorHierarchyMaintenanceService().getUniqueGroupingNames(hierarchyName, 1);
        for (String group : groupNames) {
            result.add(new ConcreteKeyValue(group, group));
        }
        return result;
    }

    public SponsorHierarchyMaintenanceService getSponsorHierarchyMaintenanceService() {
        if (sponsorHierarchyMaintenanceService == null) {
            sponsorHierarchyMaintenanceService = KcServiceLocator.getService(SponsorHierarchyMaintenanceService.class);
        }
        return sponsorHierarchyMaintenanceService;
    }

    public void setSponsorHierarchyMaintenanceService(SponsorHierarchyMaintenanceService sponsorHierarchyMaintenanceService) {
        this.sponsorHierarchyMaintenanceService = sponsorHierarchyMaintenanceService;
    }

    public ParameterService getParameterService() {
        if (parameterService == null) {
            parameterService = KcServiceLocator.getService(ParameterService.class);
        }
        return parameterService;
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

}
