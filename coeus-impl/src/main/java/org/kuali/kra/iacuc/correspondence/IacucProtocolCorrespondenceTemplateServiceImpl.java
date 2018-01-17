/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.correspondence;

import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateServiceImpl;

public class IacucProtocolCorrespondenceTemplateServiceImpl extends ProtocolCorrespondenceTemplateServiceImpl implements IacucProtocolCorrespondenceTemplateService {

    @Override
    protected Class<? extends ProtocolCorrespondenceTemplateBase> getProtocolCorrespondenceTemplateBOClassHook() {
        return IacucProtocolCorrespondenceTemplate.class;
    }

}
