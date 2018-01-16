/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.rolodex;

import org.apache.ojb.broker.query.Criteria;
import org.junit.Test;
import org.kuali.coeus.common.framework.rolodex.Rolodex;
import org.kuali.coeus.common.framework.rolodex.NonOrganizationalRolodex;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.kuali.coeus.sys.framework.service.KcServiceLocator.getService;
/**
 * Test the Data Access Object implementation for <code>{@link Rolodex}</code> business objects
 * 
 */
public class RolodexDaoOjbTest extends KcIntegrationTestBase {
    
    @Test
    public void getNonOrganizationalRolodexCriteriaWithNoName() {
        Map fieldValues = new HashMap();
        fieldValues.put("organization", "National*"); // Search for organizations that start with National
        
        Criteria criteria = getRolodexDao().getNonOrganizationalRolodexCriteria(NonOrganizationalRolodex.class, fieldValues, false);

        assertFalse(-1 == criteria.toString().indexOf("LIKE NATIONAL%"));
        assertFalse(-1 == criteria.toString().indexOf("firstName IS NOT NULL"));
        assertFalse(-1 == criteria.toString().indexOf("lastName IS NOT NULL"));
        assertFalse(-1 == criteria.toString().indexOf("active <> false"));
        
        assertEquals(criteria.toString(), "[UPPER(organization) LIKE NATIONAL%, firstName IS NOT NULL , lastName IS NOT NULL , active <> false]");
    }

    @Test(expected=IllegalArgumentException.class)
    public void getNonOrganizationalRolodexCriteriaNullClass() {
        Map fieldValues = new HashMap();
        fieldValues.put("organization", "National*"); // Search for organizations that start with National
        
        Criteria criteria = getRolodexDao().getNonOrganizationalRolodexCriteria(null, fieldValues, false);
    }
    
    @Test(expected=RuntimeException.class)
    public void getNonOrganizationalRolodexCriteriaPrimaryKeys() {
        Map fieldValues = new HashMap();
        fieldValues.put("organization", "National*"); // Search for organizations that start with National
        
        Criteria criteria = getRolodexDao().getNonOrganizationalRolodexCriteria(NonOrganizationalRolodex.class, fieldValues, true);
    }

    @Test
    public void getNonOrganizationalRolodexCriteriaWithFirstName() {
        Map fieldValues = new HashMap();
        fieldValues.put("organization", "National*"); // Search for organizations that start with National
        fieldValues.put("firstName", "David"); // Search for organizations that start with National
        
        Criteria criteria = getRolodexDao().getNonOrganizationalRolodexCriteria(NonOrganizationalRolodex.class, fieldValues, false);        
        assertNotNull(criteria);
        assertFalse(-1 == criteria.toString().indexOf("LIKE NATIONAL%"));
        assertFalse(-1 == criteria.toString().indexOf("LIKE DAVID"));
        assertFalse(-1 == criteria.toString().indexOf("firstName IS NOT NULL"));
        assertFalse(-1 == criteria.toString().indexOf("lastName IS NOT NULL"));
    }
    
    private RolodexDaoOjb getRolodexDao() {
        return (RolodexDaoOjb) getService(RolodexDao.class);
    }
}
