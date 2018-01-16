/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.correspondence;

import org.kuali.kra.irb.correspondence.ProtocolCorrespondenceType;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionTypeToCorrespondenceTemplateServiceImplBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTypeBase;
import org.kuali.kra.protocol.correspondence.ValidProtoActionCoresp;

/**
 * 
 * This class simply maps a protocol action type to a protocol correspondence template, and returns a list of ProtocolCorrespondenceTemplate objects.
 */
public class ProtocolActionTypeToCorrespondenceTemplateServiceImpl 
    extends ProtocolActionTypeToCorrespondenceTemplateServiceImplBase implements ProtocolActionTypeToCorrespondenceTemplateService {
    
    @Override
    protected Class<? extends ProtocolCorrespondenceTypeBase> getProtocolCorrespondenceTypeClassHook() {
        return ProtocolCorrespondenceType.class;
    }

    @Override
    protected Class<? extends ValidProtoActionCoresp> getProtocolActionCorrespondenceMappingClassHook() {
        return org.kuali.kra.irb.correspondence.ValidProtoActionCoresp.class;
    }
}
