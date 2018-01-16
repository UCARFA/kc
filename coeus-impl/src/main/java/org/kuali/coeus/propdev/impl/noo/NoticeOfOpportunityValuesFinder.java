/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.noo;

import org.kuali.coeus.common.framework.noo.NoticeOfOpportunity;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * This class is the Values Finder for Notice of Opportunity.
 */
public class NoticeOfOpportunityValuesFinder extends UifKeyValuesFinderBase {

    /**
     * Returns the key/values list (code/description) for Notice of Opportunity.
     *
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        KeyValuesService keyValuesService = (KeyValuesService) KcServiceLocator.getService("keyValuesService");
        Collection noticesOfOpportunity = keyValuesService.findAll(NoticeOfOpportunity.class);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        for (Iterator iter = noticesOfOpportunity.iterator(); iter.hasNext();) {
            NoticeOfOpportunity noticeOfOpportunity = (NoticeOfOpportunity) iter.next();
            keyValues.add(new ConcreteKeyValue(noticeOfOpportunity.getCode(), noticeOfOpportunity.getDescription()));
        }
        return keyValues;
    }
}
