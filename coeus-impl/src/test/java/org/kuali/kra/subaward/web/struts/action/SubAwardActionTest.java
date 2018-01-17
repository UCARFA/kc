/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.web.struts.action;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubAwardActionTest  {

    SubAwardAction subAwardAction;
    public static final String MOCK_FORWARD_STRING = "FORWARD_STRING";
    public static final String MOCK_DOC_ID_REQUEST_PARAMETER = "21";
    public static final String MOCK_EXPECTED_RESULT_STRING = "FORWARD_STRING?docId=21";

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        subAwardAction = new SubAwardAction();
    }

    /**
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        subAwardAction = null;
    }

    /**
     * 
     * This test tests the SubAwardAction.buildForwardStringForActionListCommand method.
     * @throws Exception
     */
    @Test
    public void testBuildForwardStringForActionListCommand() throws Exception {        
        Assert.assertEquals(
                subAwardAction.buildForwardStringForActionListCommand(MOCK_FORWARD_STRING, 
                        MOCK_DOC_ID_REQUEST_PARAMETER),MOCK_EXPECTED_RESULT_STRING);     
    }

}
