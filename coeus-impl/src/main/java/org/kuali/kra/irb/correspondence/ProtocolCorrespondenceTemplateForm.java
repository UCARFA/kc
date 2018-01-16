/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.correspondence;

import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateFormBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTypeBase;

/**
 * 
 * Form of the ProtocolCorrespondenceTemplate.
 */
public class ProtocolCorrespondenceTemplateForm extends ProtocolCorrespondenceTemplateFormBase {

    

    private static final long serialVersionUID = 998818088363924442L;

    @Override
    protected ProtocolCorrespondenceTemplateBase getNewProtocolCorrespondenceTemplateInstanceHook() {
        return new ProtocolCorrespondenceTemplate();
    }
    
    @Override
    protected Class<? extends ProtocolCorrespondenceTypeBase> getProtocolCorrespondenceTypeBOClassHook() {
        return ProtocolCorrespondenceType.class;
    }
}
