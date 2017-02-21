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
package org.kuali.coeus.propdev.impl.budget;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.sys.framework.persistence.KcPersistenceStructureService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.datadictionary.BusinessObjectEntry;
import org.kuali.rice.kns.service.DataDictionaryService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BudgetColumnsValuesFinder extends UifKeyValuesFinderBase {
    private transient DataDictionaryService dataDictionaryService;
    private transient KcPersistenceStructureService kcPersistenceStructureService;

    private static final Set<String> EXCLUDED_ATTRIBUTES = Stream.of("parentDocumentTypeCode", "budgetAdjustmentDocumentNumber", "residualFunds", "endDate", "documentNumber",
            "totalDirectCostLimit", "totalDirectCost", "ohRateClassCode", "underrecoveryAmount", "updateUser", "updateTimestamp", "versionNumber", "objectId", "budgetId",
            "urRateClassCode", "totalIndirectCost", "totalCostLimit", "onOffCampusFlag", "ohRateTypeCode", "startDate", "totalCost", "budgetVersionNumber").collect(Collectors.toSet());

    @Override
    public List<KeyValue> getKeyValues() {
        final BusinessObjectEntry entry = getDataDictionaryService().getDataDictionary().getBusinessObjectEntry(Budget.class.getName());
        final Map<String, String> attrToColumnMap = getKcPersistenceStructureService().getPersistableAttributesColumnMap(Budget.class);

        return entry.getAttributes().stream()
                .filter(attr -> !EXCLUDED_ATTRIBUTES.contains(attr.getName()))
                .filter(attr -> attrToColumnMap.containsKey(attr.getName()))
                .map(attr -> new ConcreteKeyValue(attrToColumnMap.get(attr.getName()), attr.getLabel()))
                .sorted(Comparator.comparing(ConcreteKeyValue::getValue, String::compareToIgnoreCase))
                .collect(Collectors.toList());
    }

    private KcPersistenceStructureService getKcPersistenceStructureService() {
        if (kcPersistenceStructureService == null)
            kcPersistenceStructureService = KcServiceLocator.getService(KcPersistenceStructureService.class);
        return kcPersistenceStructureService;
    }

    private DataDictionaryService getDataDictionaryService() {
        if (dataDictionaryService == null) {
            dataDictionaryService = KcServiceLocator.getService(DataDictionaryService.class);
        }
        return dataDictionaryService;
    }
}
