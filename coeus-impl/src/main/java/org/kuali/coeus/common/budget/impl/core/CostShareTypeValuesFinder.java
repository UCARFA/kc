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

import java.util.List;
import java.util.stream.Collectors;

@Component("costShareTypeValuesFinder")
public class CostShareTypeValuesFinder extends UifKeyValuesFinderBase {

    BusinessObjectService businessObjectService;

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValuesList;
        List<CostShareType> costSharetypes = (List<CostShareType>) getBusinessObjectService().findAll(CostShareType.class);
        keyValuesList = costSharetypes.stream().map(costShareType -> {
            return new ConcreteKeyValue(costShareType.getCostShareTypeCode().toString(), costShareType.getDescription());
        }).collect(Collectors.toList());

        return keyValuesList;

    }

    public BusinessObjectService getBusinessObjectService() {
        if (businessObjectService == null) {
            businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
        }
        return businessObjectService;
    }

    public void setDataObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

}
