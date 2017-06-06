/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.common.budget.impl.core;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
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

    private static final ConcreteKeyValue SELECT = new ConcreteKeyValue("", "select");
    private BusinessObjectService businessObjectService;

    @Override
    public List<KeyValue> getKeyValues() {
        final Collection<CostShareType> costSharetypes = getBusinessObjectService().findMatching(CostShareType.class, Collections.singletonMap("active", "true"));
        return Stream.concat(Stream.of(SELECT), costSharetypes.stream()
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
