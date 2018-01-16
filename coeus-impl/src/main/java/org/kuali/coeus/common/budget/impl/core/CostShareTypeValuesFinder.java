/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.core;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.bo.CostShareType;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component("costShareTypeValuesFinder")
public class CostShareTypeValuesFinder extends UifKeyValuesFinderBase {

    private BusinessObjectService businessObjectService;

    @Override
    public List<KeyValue> getKeyValues() {
        final Collection<CostShareType> costSharetypes = getBusinessObjectService().findMatching(CostShareType.class, Collections.singletonMap("active", "true"));
        return Stream.concat(Stream.of(ValuesFinderUtils.getSelectOption()), costSharetypes.stream()
                .map(costShareType -> new ConcreteKeyValue(costShareType.getCostShareTypeCode().toString(), costShareType.getDescription()))
                .sorted(Comparator.comparing(ConcreteKeyValue::getValue, String.CASE_INSENSITIVE_ORDER)))
                .collect(Collectors.toList());
    }

    public BusinessObjectService getBusinessObjectService() {
        if (businessObjectService == null) {
            businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
        }
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

}
