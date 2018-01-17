/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;

import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.actions.amendrenew.IacucProtocolModule;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionType;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolJavaFunctionKrmsTermServiceBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IacucJavaFunctionKrmsTermServiceImpl extends ProtocolJavaFunctionKrmsTermServiceBase implements IacucJavaFunctionKrmsTermService {

    @Override
    protected ProtocolBase getActiveProtocol(String protocolNumber) {
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("protocolNumber", protocolNumber);
        List<IacucProtocol> protocols = (List <IacucProtocol>)getBusinessObjectService().findMatchingOrderBy(
                            IacucProtocol.class, keyMap, "sequenceNumber", false);
        return protocols.get(0);
    }

    @Override
    public String getRenewalActionTypeCode() {
        return IacucProtocolActionType.RENEWAL_CREATED;
    }

    @Override
    public String getProtocolPersonnelModuleTypeCode() {
        return IacucProtocolModule.PROTOCOL_PERSONNEL;
    }

    @Override
    public String getProtocolOrganizationModuleTypeCode() {
        return IacucProtocolModule.PROTOCOL_ORGANIZATIONS;
    }

    @Override
    public String getNotifySubmissionTypeCode() {
        return IacucProtocolSubmissionType.FYI;
    }
}
