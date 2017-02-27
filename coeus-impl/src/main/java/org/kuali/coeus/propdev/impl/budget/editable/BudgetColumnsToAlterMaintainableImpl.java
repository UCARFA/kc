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
package org.kuali.coeus.propdev.impl.budget.editable;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.sys.framework.persistence.KcPersistenceStructureService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.maintenance.KraMaintainableImpl;
import org.kuali.rice.kns.datadictionary.validation.charlevel.AlphaNumericValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.charlevel.AlphaValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.charlevel.AnyCharacterValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.charlevel.NumericValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.fieldlevel.DateValidationPattern;
import org.kuali.rice.krad.datadictionary.AttributeDefinition;
import org.kuali.rice.krad.datadictionary.validation.ValidationPattern;

import java.util.HashMap;
import java.util.Map;

public class BudgetColumnsToAlterMaintainableImpl  extends KraMaintainableImpl {
    private static final String STRING = "STRING";
    private static final String DATE = "DATE";
    private static final String NUMBER = "NUMBER";
    private static final String DOCUMENT_NEW_MAINTAINABLE_OBJECT_COLUMN_NAME = "document.newMaintainableObject.columnName";
    private static final String ERROR_PROPOSALCOLUMNSTOALTER_ATTRIBUTE_NOT_FOUND = "error.proposalcolumnstoalter.attributeNotFound";

    private static final Map<Class<? extends ValidationPattern>, String> VALIDATION_CLASSES_MAP = new HashMap<>();
    static {
        VALIDATION_CLASSES_MAP.put(AnyCharacterValidationPattern.class, STRING);
        VALIDATION_CLASSES_MAP.put(AlphaNumericValidationPattern.class, STRING);
        VALIDATION_CLASSES_MAP.put(AlphaValidationPattern.class, STRING);
        VALIDATION_CLASSES_MAP.put(DateValidationPattern.class, DATE);
        VALIDATION_CLASSES_MAP.put(NumericValidationPattern.class, NUMBER);
    }

    private transient KcPersistenceStructureService kcPersistenceStructureService;

    public void prepareForSave() {
        super.prepareForSave();
        final BudgetColumnsToAlter budgetCol = (BudgetColumnsToAlter)businessObject;
        final Map<String, String> columnToAttrMap = getKcPersistenceStructureService().getDBColumnToObjectAttributeMap(Budget.class);
        final AttributeDefinition attrDefinition = getDataDictionaryService().getDataDictionary().getBusinessObjectEntry(Budget.class.getName()).
                getAttributeDefinition(columnToAttrMap.get(budgetCol.getColumnName()));
        
        if (attrDefinition == null) {
            getGlobalVariableService().getMessageMap().putError(DOCUMENT_NEW_MAINTAINABLE_OBJECT_COLUMN_NAME, ERROR_PROPOSALCOLUMNSTOALTER_ATTRIBUTE_NOT_FOUND);
        } else {
            if (attrDefinition.getLabel().length() > 30) {
                budgetCol.setColumnLabel(attrDefinition.getLabel().substring(0, 29));
            } else {
                budgetCol.setColumnLabel(attrDefinition.getLabel());
            }
            budgetCol.setDataLength(attrDefinition.getMaxLength());
            String dataType;
            if (attrDefinition.getValidationPattern() != null) {
                final Class<? extends ValidationPattern> validationPattern = attrDefinition.getValidationPattern().getClass();
                if ((dataType = VALIDATION_CLASSES_MAP.get(validationPattern)) == null) {
                    dataType = STRING;
                }
            } else {
                dataType = STRING;
            }
            budgetCol.setDataType(dataType);
        }
    }

    protected KcPersistenceStructureService getKcPersistenceStructureService() {
        if (kcPersistenceStructureService == null) {
            kcPersistenceStructureService = KcServiceLocator.getService(KcPersistenceStructureService.class);
        }

        return kcPersistenceStructureService;
    }
}
