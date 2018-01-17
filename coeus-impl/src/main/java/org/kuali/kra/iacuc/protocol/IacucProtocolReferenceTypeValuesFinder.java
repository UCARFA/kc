/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.protocol;

import org.kuali.kra.iacuc.protocol.reference.IacucProtocolReferenceType;
import org.kuali.kra.protocol.protocol.ProtocolReferenceTypeValuesFinderBase;
import org.kuali.kra.protocol.protocol.reference.ProtocolReferenceTypeBase;

public class IacucProtocolReferenceTypeValuesFinder extends ProtocolReferenceTypeValuesFinderBase {


    private static final long serialVersionUID = 809031604590465735L;

    @Override
    protected Class<? extends ProtocolReferenceTypeBase> getProtocolReferenceTypeBOClassHook() {
        return IacucProtocolReferenceType.class;
    }

}
