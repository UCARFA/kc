/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.print;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.protocol.actions.print.ProtocolQuestionnairePrintingServiceImplBase;


public class ProtocolQuestionnairePrintingServiceImpl extends ProtocolQuestionnairePrintingServiceImplBase implements ProtocolQuestionnairePrintingService {

    @Override
    protected Class<ProtocolAction> getProtocolActionBOClassHook() {
        return ProtocolAction.class;
    }

    @Override
    protected Class<ProtocolSubmission> getProtocolSubmissionBOClassHook() {
        return ProtocolSubmission.class;
    }

    @Override
    protected Class<Protocol> getProtocolBOClassHook() {
        return Protocol.class;
    }

    @Override
    protected String getCoeusModuleCode() {
        return CoeusModule.IRB_MODULE_CODE;
    }

}
