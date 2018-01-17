/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.correspondence;

import org.kuali.kra.iacuc.correspondence.IacucProtocolCorrespondenceType;
import org.kuali.kra.iacuc.correspondence.ValidIacucProtoActionCoresp;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionTypeToCorrespondenceTemplateServiceImplBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTypeBase;
import org.kuali.kra.protocol.correspondence.ValidProtoActionCoresp;

public class IacucProtocolActionTypeToCorrespondenceTemplateServiceImpl 
    extends ProtocolActionTypeToCorrespondenceTemplateServiceImplBase implements IacucProtocolActionTypeToCorrespondenceTemplateService {
    
    public IacucProtocolActionTypeToCorrespondenceTemplateServiceImpl() {
    }

    @Override
    protected Class<? extends ValidProtoActionCoresp> getProtocolActionCorrespondenceMappingClassHook() {
        return ValidIacucProtoActionCoresp.class;
    }

    @Override
    protected Class<? extends ProtocolCorrespondenceTypeBase> getProtocolCorrespondenceTypeClassHook() {
        return IacucProtocolCorrespondenceType.class;
    }
}
