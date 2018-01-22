/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.impl.s2s.nih;


import gov.nih.era.svs.types.ValidateApplicationResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.s2sgen.api.core.ConfigurationConstants;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.util.Collections;

public class NihSubmissionValidationServiceImplTest extends KcIntegrationTestBase {

    private NihSubmissionValidationService nihSubmissionValidationService;

    @Before
    public void lookupService() {
        nihSubmissionValidationService = KcServiceLocator.getService(NihSubmissionValidationService.class);
    }

    @Test
    public void test_null_xml() {
        updateParameterForTesting("KC-S2S","All","Enable_NIH_Validation_Service", "Y");
        updateParameterForTesting("KC-S2S","All", ConfigurationConstants.MULTI_CAMPUS_ENABLED, "N");
        ValidateApplicationResponse response = nihSubmissionValidationService.validateApplication(null, Collections.emptyList(), "1234");
        assertEmptyResponse(response);
    }

    @Test
    public void test_not_enabled() {
        updateParameterForTesting("KC-S2S","All","Enable_NIH_Validation_Service", "N");
        updateParameterForTesting("KC-S2S","All", ConfigurationConstants.MULTI_CAMPUS_ENABLED, "N");

        ValidateApplicationResponse response = nihSubmissionValidationService.validateApplication("<dummyXml></dummyXml>", Collections.emptyList(), "1234");
        assertEmptyResponse(response);
    }

    private void assertEmptyResponse(ValidateApplicationResponse response) {
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getValidationMessageList());
        Assert.assertNotNull(response.getValidationMessageList().getValidationMessage());
        Assert.assertTrue(response.getValidationMessageList().getValidationMessage().isEmpty());
    }
}
