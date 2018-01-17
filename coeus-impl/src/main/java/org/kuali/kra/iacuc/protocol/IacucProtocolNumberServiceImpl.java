/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.protocol;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.protocol.protocol.ProtocolNumberServiceImplBase;

public class IacucProtocolNumberServiceImpl extends ProtocolNumberServiceImplBase implements IacucProtocolNumberService {

    @Override
    protected String getSequenceNameHook() {
        return "SEQ_IACUC_PROTOCOL_ID";
    }
    
    @Override
    protected Class getSequenceOwnerClass() {
        return IacucProtocol.class;
    }

}
