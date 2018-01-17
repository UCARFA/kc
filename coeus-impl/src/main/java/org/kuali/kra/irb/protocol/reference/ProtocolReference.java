/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.reference;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.protocol.protocol.reference.ProtocolReferenceBase;

import java.text.ParseException;


public class ProtocolReference extends ProtocolReferenceBase {


    private static final long serialVersionUID = 7610203950849323256L;
    
    /**
     * 
     * Constructs a ProtocolReferenceBase.java.
     * @param bean
     * @param protocol
     * @param protocolReferenceType
     * @throws ParseException
     */
    public ProtocolReference(ProtocolReferenceBean bean, Protocol protocol, ProtocolReferenceType protocolReferenceType) throws ParseException {
        super(bean, protocol, protocolReferenceType);
    }
    

    /**
	 * 
	 * Constructs a ProtocolReference.java.
	 */
    public ProtocolReference() {
    }
}
