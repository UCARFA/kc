/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.editable;

import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.rice.kns.datadictionary.validation.charlevel.AlphaNumericValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.charlevel.AlphaValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.charlevel.AnyCharacterValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.charlevel.NumericValidationPattern;
import org.kuali.rice.kns.datadictionary.validation.fieldlevel.DateValidationPattern;

import java.util.HashMap;
import java.util.Map;

public class BudgetColumnsToAlterMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {
    private static Map<String, String> validationClassesMap = new HashMap<String, String>();
    static {
        validationClassesMap.put(AnyCharacterValidationPattern.class.getName(), "STRING");
        validationClassesMap.put(AlphaNumericValidationPattern.class.getName(), "STRING");
        validationClassesMap.put(AlphaValidationPattern.class.getName(), "STRING");
        validationClassesMap.put(DateValidationPattern.class.getName(), "DATE");
        validationClassesMap.put(NumericValidationPattern.class.getName(), "NUMBER");
    }

}
