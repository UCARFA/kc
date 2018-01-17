/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.proposaldevelopment.document;


import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.editable.ProposalColumnsToAlterMaintainableImpl;
import org.kuali.coeus.sys.framework.persistence.KcPersistenceStructureService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.editable.ProposalColumnsToAlter;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.Map;

import static org.junit.Assert.assertTrue;
public class ProposalColumnsToAlterMaintainableImplTest extends KcIntegrationTestBase {

    private ProposalColumnsToAlterMaintainableImpl columnsToAlterMaintainable;
    private Map<String, String> columnToAttrMap;
    
    @Before
    public void setUp() throws Exception {
        KcPersistenceStructureService persistenceStructureService =
            KcServiceLocator.getService(KcPersistenceStructureService.class);
        columnToAttrMap = persistenceStructureService.getDBColumnToObjectAttributeMap(DevelopmentProposal.class);
        
        columnsToAlterMaintainable = new ProposalColumnsToAlterMaintainableImpl();
        
        GlobalVariables.setUserSession(new UserSession("admin"));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAllProposalDevColumns() throws Exception {
        for (String cols : columnToAttrMap.keySet()) {
            ProposalColumnsToAlter testBo = new ProposalColumnsToAlter();
            testBo.setColumnName(cols);
            columnsToAlterMaintainable.setBusinessObject(testBo);
            columnsToAlterMaintainable.prepareForSave();
            //no exception was thrown which means it worked well enough
        }
    }
    
    @Test
    public void testSpecificProposalColumns() throws Exception {
        ProposalColumnsToAlter testBo = new ProposalColumnsToAlter();
        testBo.setColumnName("MAIL_BY");
        columnsToAlterMaintainable.setBusinessObject(testBo);
        columnsToAlterMaintainable.prepareForSave();
        assertTrue("Label was not set as expected", StringUtils.isNotBlank(testBo.getColumnLabel()));
        assertTrue("Data length not set properly", testBo.getDataLength() > 0);
        testBo.setColumnName("TITLE");
        columnsToAlterMaintainable.setBusinessObject(testBo);
        columnsToAlterMaintainable.prepareForSave();
        assertTrue("Label was not set as expected", StringUtils.isNotBlank(testBo.getColumnLabel()));
        assertTrue("Data length not set properly", testBo.getDataLength() > 0);
        testBo.setColumnName("ACTIVITY_TYPE_CODE");
        columnsToAlterMaintainable.setBusinessObject(testBo);
        columnsToAlterMaintainable.prepareForSave();
        assertTrue("Label was not set as expected", StringUtils.isNotBlank(testBo.getColumnLabel()));
        assertTrue("Data length not set properly", testBo.getDataLength() > 0);        
    }
}
