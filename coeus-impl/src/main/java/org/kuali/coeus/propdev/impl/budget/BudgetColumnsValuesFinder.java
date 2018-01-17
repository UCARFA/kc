/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
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
