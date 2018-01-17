/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.protocol.protocol.ProtocolNumberServiceImplBase;

/**
 * ProtocolNumberService Implementation.
 */
public class ProtocolNumberServiceImpl extends ProtocolNumberServiceImplBase implements ProtocolNumberService {

    private static final String ZERO = "0";
    private static final String SEQUENCE_NAME = "SEQ_PROTOCOL_ID";
    private static final int MAX_NUMBER = 1000000;

    @Override
    protected String getSequenceNameHook() {
        return SEQUENCE_NAME;
    }
    
    @Override
    protected Class getSequenceOwnerClass() {
        return Protocol.class;
    }
    
    
}
