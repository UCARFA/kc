/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.common.notification;

import org.junit.Test;
import org.kuali.coeus.common.notification.impl.NotificationRendererBase;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;
/**
 * This class contains tests for NotificationRendererBase
 */
public class NotificationRendererBaseTest extends KcIntegrationTestBase {
    
    private static final String USER_FULLNAME_VAL = "Geoff McGregor";
    
    @SuppressWarnings("serial")
    @Test
    public void testRender() {
        String inputText = "The {Q} brown {F} {J} over the lazy {D}.";
    
        NotificationRendererBase renderer = new NotificationRendererBase() {
            
            // mocking this method; we are testing it below
            @Override
            public Map<String, String> getDefaultReplacementParameters() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("{J}", "jumps");
                params.put("{Q}", "quick");
                params.put("{D}", "dog");
                params.put("{F}", "fox");
                return params;
            }
            
        };
        String outputText = renderer.render(inputText);
        assertEquals("The quick brown fox jumps over the lazy dog.", outputText);
    
        // test with null parameter values
        renderer = new NotificationRendererBase() {
            
            // return a couple of null values in the map
            @Override
            public Map<String, String> getDefaultReplacementParameters() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("{J}", null);
                params.put("{Q}", null);
                params.put("{D}", "dog");
                params.put("{F}", "fox");
                return params;
            }
            
        };
        outputText = renderer.render(inputText);
        assertEquals("The {Q} brown fox {J} over the lazy dog.", outputText);
    }
    
    @Test
    public void testGetDefaultReplacementParameters() {
        // we will test an anonymous instance of the abstract renderer
        @SuppressWarnings("serial")
        NotificationRendererBase renderer = new NotificationRendererBase() {};
        Map<String, String> nameValueMap = renderer.getDefaultReplacementParameters();
        
        assertEquals(3, nameValueMap.size());
        assertEquals(USER_FULLNAME_VAL, nameValueMap.get(NotificationRendererBase.USER_FULLNAME));
        // not testing actual value of the application URL since that would make this test quite fragile
        assertTrue(nameValueMap.containsKey(NotificationRendererBase.DOCHANDLER_PREFIX));
        assertTrue(nameValueMap.containsKey(NotificationRendererBase.APP_LINK_PREFIX));
    }
    
}
