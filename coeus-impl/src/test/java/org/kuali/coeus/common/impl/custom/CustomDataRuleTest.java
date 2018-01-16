/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.custom;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.framework.custom.SaveCustomDataEvent;
import org.kuali.coeus.common.framework.custom.arg.ArgValueLookup;
import org.kuali.coeus.common.framework.custom.attr.CustomAttribute;
import org.kuali.coeus.common.framework.custom.attr.CustomAttributeDataType;
import org.kuali.kra.infrastructure.Constants;

import java.util.*;

public class CustomDataRuleTest {

    public static final String PROJECT_DISCIPLINE = "ProjectDiscipline";

    @Test
    public void testValidArgValues() {
        CustomDataRule customDataRule = new CustomDataRule() {
            @Override
            public void addError(CustomAttribute customAttribute, String errorKey, SaveCustomDataEvent event, String attributeValue, String validFormat) {
            }

            @Override
            public Collection<ArgValueLookup> getMatchingArgValues(CustomAttribute customAttribute) {
                List<ArgValueLookup> allArgValues = new ArrayList<>();
                ArgValueLookup argValueLookup1 = new ArgValueLookup();
                argValueLookup1.setArgumentName(PROJECT_DISCIPLINE);
                argValueLookup1.setValue("2866");

                ArgValueLookup argValueLookup2 = new ArgValueLookup();
                argValueLookup2.setArgumentName(PROJECT_DISCIPLINE);
                argValueLookup2.setValue("1855");
                allArgValues.add(argValueLookup2);

                allArgValues.add(argValueLookup1);
                allArgValues.add(argValueLookup2);
                return allArgValues;
            }
        };

        CustomAttributeDataType customAttributeDataType = new CustomAttributeDataType();
        customAttributeDataType.setDescription(Constants.DATA_TYPE_STRING);

        CustomAttribute customAttribute = new CustomAttribute();
        customAttribute.setValue("2388");
        customAttribute.setLookupReturn(PROJECT_DISCIPLINE);
        customAttribute.setDataTypeCode(Constants.DATA_TYPE_STRING);
        Assert.assertFalse(customDataRule.isValidArgValue(customAttribute, "", null, customAttributeDataType));
        customAttribute.setValue("2866");
        Assert.assertTrue(customDataRule.isValidArgValue(customAttribute, "", null, customAttributeDataType));
        customAttribute.setValue("2010");
        Assert.assertFalse(customDataRule.isValidArgValue(customAttribute, "", null, customAttributeDataType));


    }
}
