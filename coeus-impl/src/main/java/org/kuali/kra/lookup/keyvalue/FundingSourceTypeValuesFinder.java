/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.lookup.keyvalue;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.bo.FundingSourceType;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FundingSourceTypeValuesFinder extends UifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        Collection<FundingSourceType> fundingSourceTypes = (Collection<FundingSourceType>) KcServiceLocator
                .getService(BusinessObjectService.class).findAll(FundingSourceType.class);
        for (FundingSourceType fundingSourceType : fundingSourceTypes) {
            if (fundingSourceType.getFundingSourceTypeFlag()) {
                keyValues.add(new ConcreteKeyValue(fundingSourceType.getFundingSourceTypeCode(), fundingSourceType.getDescription()));
            }
        }
        keyValues.add(0, ValuesFinderUtils.getSelectOption());
        return keyValues;
    }

}
