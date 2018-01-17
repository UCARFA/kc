/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.protocol.location;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.protocol.protocol.location.ProtocolLocationBase;
import org.kuali.kra.protocol.protocol.location.ProtocolLocationServiceImplBase;

public class IacucProtocolLocationServiceImpl extends ProtocolLocationServiceImplBase implements IacucProtocolLocationService {

    @Override
    protected ProtocolLocationBase getNewProtocolLocationInstanceHook() {
        return new IacucProtocolLocation();
    }

    @Override
    protected String getDefaultProtocolOrganizationTypeCodeHook() {
        return Constants.DEFAULT_PROTOCOL_ORGANIZATION_TYPE_CODE;
    }

    @Override
    protected String getDefaultProtocolOrganizationIdHook() {
        return Constants.DEFAULT_PROTOCOL_ORGANIZATION_ID;
    }

}
