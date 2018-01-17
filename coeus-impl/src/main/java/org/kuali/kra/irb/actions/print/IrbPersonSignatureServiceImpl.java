/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.print;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.impl.person.signature.PersonSignatureServiceImpl;
import org.kuali.kra.infrastructure.Constants;

public class IrbPersonSignatureServiceImpl extends PersonSignatureServiceImpl implements IrbPersonSignatureService {

    @Override
    protected String getModuleCodeHook() {
        return CoeusModule.IRB_MODULE_CODE;
    }

    @Override
    protected String getModuleNameSpaceHook() {
        return Constants.MODULE_NAMESPACE_IRB;
    }


}
