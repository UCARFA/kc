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
