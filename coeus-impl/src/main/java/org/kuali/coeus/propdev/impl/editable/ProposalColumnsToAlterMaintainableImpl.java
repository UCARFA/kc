/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.editable;

import org.kuali.coeus.sys.framework.persistence.KcPersistenceStructureService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.maintenance.KraMaintainableImpl;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.rice.kns.datadictionary.validation.charlevel.AlphaNumericValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.charlevel.AlphaValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.charlevel.AnyCharacterValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.charlevel.NumericValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.fieldlevel.DateValidationPattern;
import org.kuali.rice.kns.service.DataDictionaryService;
import org.kuali.rice.krad.datadictionary.AttributeDefinition;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.HashMap;
import java.util.Map;

public class ProposalColumnsToAlterMaintainableImpl extends KraMaintainableImpl {

    private static Map<String, String> validationClassesMap = new HashMap<String, String>();
    static {
        validationClassesMap.put(AnyCharacterValidationPattern.class.getName(), "STRING");
        validationClassesMap.put(AlphaNumericValidationPattern.class.getName(), "STRING");
        validationClassesMap.put(AlphaValidationPattern.class.getName(), "STRING");
        validationClassesMap.put(DateValidationPattern.class.getName(), "DATE");
        validationClassesMap.put(NumericValidationPattern.class.getName(), "NUMBER");
    }    
    @Override
    public void prepareForSave() {
        super.prepareForSave();
        ProposalColumnsToAlter proposalCol = (ProposalColumnsToAlter)businessObject;
        
        KcPersistenceStructureService persistenceStructureService =
            KcServiceLocator.getService(KcPersistenceStructureService.class);
        Map<String, String> columnToAttrMap = persistenceStructureService.getDBColumnToObjectAttributeMap(DevelopmentProposal.class);
        
        DataDictionaryService dataDictionaryService = KcServiceLocator.getService(DataDictionaryService.class);
        AttributeDefinition attrDefinition = dataDictionaryService.getDataDictionary().
            getBusinessObjectEntry(DevelopmentProposal.class.getName()).
            getAttributeDefinition(columnToAttrMap.get(proposalCol.getColumnName()));
        
        if (attrDefinition == null) {
            GlobalVariables.getMessageMap().putError("document.newMaintainableObject.columnName", "error.proposalcolumnstoalter.attributeNotFound");
            return;
        } else {
            if (attrDefinition.getLabel().length() > 30) {
                proposalCol.setColumnLabel(attrDefinition.getLabel().substring(0, 29));
            } else {
                proposalCol.setColumnLabel(attrDefinition.getLabel());
            }
            proposalCol.setDataLength(attrDefinition.getMaxLength());
            String dataType = null;
            if (attrDefinition.getValidationPattern() != null) {
                String validationPattern = attrDefinition.getValidationPattern().getClass().getName();
                if ((dataType = validationClassesMap.get(validationPattern)) == null) {
                    dataType = "STRING";
                }
            } else {
                dataType = "STRING";
            }
            proposalCol.setDataType(dataType);
        }
    }
}
