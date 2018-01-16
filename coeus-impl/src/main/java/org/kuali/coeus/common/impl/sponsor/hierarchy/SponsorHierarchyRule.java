/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.sponsor.hierarchy;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.sponsor.hierarchy.SponsorHierarchy;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.util.HashMap;
import java.util.Map;

public class SponsorHierarchyRule {
    
    public boolean newHierarchyNameRequired(SponsorHierarchyForm sponsorHierarchyForm) {
        boolean valid = true;
        
        MessageMap errorMap = GlobalVariables.getMessageMap();
        if (StringUtils.isBlank(sponsorHierarchyForm.getNewHierarchyName())) {
            errorMap.putError("newHierarchyName", RiceKeyConstants.ERROR_REQUIRED, "New Hierarchy Name");
            valid = false;
        } else {
            Map fieldValues = new HashMap();
            fieldValues.put("hierarchyName", sponsorHierarchyForm.getNewHierarchyName());
            if (KcServiceLocator.getService(BusinessObjectService.class).countMatching(SponsorHierarchy.class, fieldValues) > 0) {
                errorMap.putError("newHierarchyName", KeyConstants.ERROR_SPONSOR_HIERARCHY_EXISTS, sponsorHierarchyForm.getNewHierarchyName());
                valid = false;
                
            }
        }
        return valid;
    }

}
