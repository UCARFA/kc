/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.proposaldevelopment.service;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.exception.RiceIllegalArgumentException;
import org.kuali.rice.kew.service.KEWServiceLocator;
import org.kuali.rice.kim.api.identity.Person;
import static org.junit.Assert.*;
public class QuickStartUserLookupTest extends KcIntegrationTestBase {

    /*
     * re: JIRA KRACOEUS-635
     */
    @Test(expected=RiceIllegalArgumentException.class)
    public void testFindingQuickstartUser_TruncatedUserId() throws Exception {
        Person user = KEWServiceLocator.getIdentityHelperService().getPersonByPrincipalName("quicksta");
        fail("We should get an exception");
    }
    
    /*
     * re: JIRA KRACOEUS-635
     */
    @Test
    public void testFindingQuickstartUser_CompleteUserId() throws Exception {
        Person user = KEWServiceLocator.getIdentityHelperService().getPersonByPrincipalName("quickstart");
        Assert.assertNotNull(user);
    }
}
