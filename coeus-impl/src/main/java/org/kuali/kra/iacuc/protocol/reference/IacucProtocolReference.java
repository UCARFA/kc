/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.protocol.reference;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.protocol.protocol.reference.ProtocolReferenceBase;

import java.text.ParseException;

public class IacucProtocolReference extends ProtocolReferenceBase {
    

    private static final long serialVersionUID = -5606862862070468479L;


    public IacucProtocolReference(IacucProtocolReferenceBean bean, IacucProtocol protocol, IacucProtocolReferenceType type) throws ParseException {
        super(bean, protocol, type);                
    }


    public IacucProtocolReference() {
        super();
    }

    
}
