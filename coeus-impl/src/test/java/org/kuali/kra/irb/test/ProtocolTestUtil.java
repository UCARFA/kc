/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.test;

import org.jmock.Mockery;
import org.kuali.kra.irb.Protocol;

/**
 * Utility for working with Protocol objects for testing.
 */
public final class ProtocolTestUtil {
    
    /** private ctor for utility class. */
    private ProtocolTestUtil() {
        throw new UnsupportedOperationException("do not call");
    }
    
    /**
     * Gets a Protocol that does try to access Spring services.
     * @param context a JMock context used for mocking used services.
     * @return a protocol
     */
    public static Protocol getProtocol(final Mockery context) {
        
        final Protocol protocol = new Protocol() {
            
            @Override
            public void refreshReferenceObject(String referenceObjectName) {
                //do nothing
            }
        };
        
        return protocol;
    }
}
