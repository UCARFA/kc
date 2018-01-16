/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol;

import org.kuali.kra.protocol.protocol.ProtocolNumberServiceBase;

/**
 * ProtocolNumberService.
 */
public interface ProtocolNumberService extends ProtocolNumberServiceBase {

    /**
     * Generate a unique Protocol Number.  The Protocol Number
     * has the following format:
     * 
     *     YYDDxxxxxx
     *     
     * where YY is the year, e.g. 09.
     *       MM is the month, e.g. 03 for March
     *       xxxxxx is a sequence number
     *       
     * @return a protocol number
     */
    @Override
    public String generateProtocolNumber();
}
