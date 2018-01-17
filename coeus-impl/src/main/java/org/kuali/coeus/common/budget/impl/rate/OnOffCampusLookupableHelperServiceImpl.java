/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.rate;

import org.kuali.coeus.sys.framework.lookup.KcKualiLookupableHelperServiceImpl;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.bo.BusinessObject;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("onOffCampusLookupableHelperService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OnOffCampusLookupableHelperServiceImpl extends KcKualiLookupableHelperServiceImpl {

    /**
     * 
     * This is for onoffcampusflag.  It's boolean, but saved as 'N/F'.  So, it caused trouble for lookup 
     */
    @Override
    public List<? extends BusinessObject> getSearchResults(Map<String, String> fieldValues) {
        if (fieldValues.get(Constants.ON_OFF_CAMPUS_FLAG).equalsIgnoreCase("Y")) {
             fieldValues.put(Constants.ON_OFF_CAMPUS_FLAG, "N");
        } else if (fieldValues.get(Constants.ON_OFF_CAMPUS_FLAG).equalsIgnoreCase("N")) {
             fieldValues.put(Constants.ON_OFF_CAMPUS_FLAG, "F");
        }
        return super.getSearchResults(fieldValues);
    }

}
