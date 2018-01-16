/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.sponsor;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.lookup.KcKualiLookupableHelperServiceImpl;
import org.kuali.rice.kns.web.ui.Field;
import org.kuali.rice.kns.web.ui.Row;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sponsorLookupableHelperService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SponsorLookupableHelperServiceImpl  extends KcKualiLookupableHelperServiceImpl {
    private static final String CONVERSION_FIELD_PARAM_NAME = "conversionFields";

    @Override
    public List<Row> getRows() {
    	List<Row> rows = super.getRows();
    	//if this is coming from a form of some sort, conversion fields are supplied.
    	//if this is the case, we don't want to allow the user to search for inactive sponsors.
    	if (getParameters().containsKey(CONVERSION_FIELD_PARAM_NAME) && !getParameters().get(CONVERSION_FIELD_PARAM_NAME)[0].isEmpty()) {
    		Iterator<Row> i = rows.iterator();
    		while (i.hasNext()) {
    			Row row = i.next();
    			boolean removeRow = false;
    			for (Field field : row.getFields()) {
        			if (StringUtils.equalsIgnoreCase("Active", field.getFieldLabel())) {
        				removeRow = true;
        				break;
        			}
        		}
    			if (removeRow) {
    				i.remove();
    			}
    		}
    	}
    	return rows;
    }
    
}
