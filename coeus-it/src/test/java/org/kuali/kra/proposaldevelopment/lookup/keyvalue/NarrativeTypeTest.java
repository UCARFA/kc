/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.proposaldevelopment.lookup.keyvalue;

import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.coeus.propdev.impl.attachment.NarrativeType;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.dao.BusinessObjectDao;

import java.util.Collection;

import static org.junit.Assert.*;
import static org.kuali.coeus.sys.framework.service.KcServiceLocator.getService;

public class NarrativeTypeTest extends KcIntegrationTestBase {

    @Test public void testGetKeyValues() throws Exception {
        BusinessObjectDao businessObjectDao = (BusinessObjectDao) KcServiceLocator.getService(Constants.BUSINESS_OBJECT_DAO_NAME);

        String paramValue = getService(ParameterService.class).getParameterValueAsString(
                Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, ParameterConstants.DOCUMENT_COMPONENT, Constants.PROPOSAL_NARRATIVE_TYPE_GROUP);
        assertNotNull(paramValue);
        assertNotSame("System Parameter for "+Constants.PROPOSAL_NARRATIVE_TYPE_GROUP+ " not loaded...","", paramValue);
        Collection<NarrativeType> narrativeTypes = businessObjectDao.findAll(NarrativeType.class);
        assertTrue("Narrative Types not loaded",narrativeTypes.size()>0);
        for (NarrativeType narrativeType : narrativeTypes) {
            boolean propNarrLoaded = false;
            if(propNarrLoaded = narrativeType.getCode().equals(paramValue)){
                assertTrue(propNarrLoaded);
                break;
            }
        }
    }

}
