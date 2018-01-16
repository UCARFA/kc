/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.rice.coreservice.api.parameter.Parameter;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.coreservice.api.component.ComponentService;
import org.kuali.rice.coreservice.api.parameter.ParameterQueryResults;
import org.kuali.rice.coreservice.api.parameter.ParameterRepositoryService;

import java.util.Collection;
import java.util.stream.Collectors;

public class ValidComponentTest extends KcIntegrationTestBase {

    private ParameterRepositoryService parameterRepositoryService;
    private ComponentService componentService;

    @Before
    public void initServices() {
        parameterRepositoryService = KcServiceLocator.getService(ParameterRepositoryService.class);
        componentService = KcServiceLocator.getService(ComponentService.class);
    }

    @Test
    public void test_all_parameters_have_valid_components() {
        final QueryByCriteria emptyCriteria = QueryByCriteria.Builder.create().build();
        final ParameterQueryResults allParameters = parameterRepositoryService.findParameters(emptyCriteria);
        final Collection<Parameter> withInvalidComponents = allParameters.getResults().stream().filter(p -> componentService.getComponentByCode(p.getNamespaceCode(), p.getComponentCode()) == null).collect(Collectors.toList());
        Assert.assertTrue("The following parameters do not have valid components " + withInvalidComponents, withInvalidComponents.isEmpty());
    }
}
