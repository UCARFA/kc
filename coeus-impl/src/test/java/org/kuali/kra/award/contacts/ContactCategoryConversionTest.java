/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.apache.ojb.broker.accesslayer.conversions.ConversionException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.unit.UnitContactType;

/**
 * This class tests ContactCategoryConverter
 */
public class ContactCategoryConversionTest {
    private static final String UNSUPPORTED_ENUM_VALUE = "FOO_BAR";
    private UnitContactTypeConverter converter;
    
    @Before
    public void setUp() {
        converter = new UnitContactTypeConverter();
    }
    
    @After
    public void tearDown() {
        converter = null;
    }
    
    @Test(expected=ConversionException.class)
    public void testConvertingRoleToSqlString_ConversionException() {
        converter.javaToSql("Bad Type");
    }
    
    @Test
    public void testConvertingContactCategoryToSqlString() {
        for(UnitContactType unitContactType: UnitContactType.values()) {
            Assert.assertEquals(unitContactType.name(), converter.javaToSql(unitContactType));
        }
    }
    
    @Test(expected=ConversionException.class)
    public void testConvertingSqlValueToContactRole_ConversionException_BadType() {
        converter.sqlToJava(Long.MAX_VALUE);
    }
    
    @Test(expected=ConversionException.class)
    public void testConvertingSqlValueToContactRole_ConversionException_InvalidValue() {
        converter.sqlToJava(UNSUPPORTED_ENUM_VALUE);
    }
    
    @Test
    public void testConvertingSqlValueToContactCategory() {
        for(UnitContactType unitContactType: UnitContactType.values()) {
            Assert.assertEquals(unitContactType, converter.sqlToJava(unitContactType.name()));
        }
    }
}
