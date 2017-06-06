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
package org.kuali.kra.questionnaire;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuestionnaireServiceTest  extends KcIntegrationTestBase {
    
        private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};
        private Set<String> expectedModules;
        @Before
        public void setUp() throws Exception {
            expectedModules = new HashSet<>();
            expectedModules.add("3");
            expectedModules.add("7");
            expectedModules.add("2");
            expectedModules.add("8");
            expectedModules.add("9");
        }  

        /**
         *
         * This method valid module code to Associate a Questionnaire.
         * This method can't be done with mock, so has to use get real service call.
         * Mock has problem with setusersession
         */
        @Test
        public void testValidCodes() {
            GlobalVariables.setUserSession(new UserSession("quickstart"));

            List<String> modules = KcServiceLocator.getService(QuestionnaireService.class).getAssociateModules();
            assertEquals(modules.size(), expectedModules.size());
            for (String module : modules ) {
                assertTrue(expectedModules.contains(module));
            }
            context.assertIsSatisfied();
        }
        
}


