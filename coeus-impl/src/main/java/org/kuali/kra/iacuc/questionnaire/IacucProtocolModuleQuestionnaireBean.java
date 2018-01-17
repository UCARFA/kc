/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.questionnaire;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.kra.protocol.questionnaire.ProtocolModuleQuestionnaireBeanBase;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IacucProtocolModuleQuestionnaireBean extends ProtocolModuleQuestionnaireBeanBase {

    public IacucProtocolModuleQuestionnaireBean(IacucProtocol protocol) {
        super(CoeusModule.IACUC_PROTOCOL_MODULE_CODE, protocol.getProtocolNumber(), "0", protocol.getSequenceNumber().toString(), 
                protocol.getProtocolDocument().getDocumentHeader().hasWorkflowDocument() ? protocol.getProtocolDocument().getDocumentHeader().getWorkflowDocument().isApproved() : false);
        setProtocol(protocol);
        setProtocolSubItemCode(protocol) ;
    }
    
    public IacucProtocolModuleQuestionnaireBean(String moduleItemCode, String moduleItemKey, String moduleSubItemCode, String moduleSubItemKey, boolean finalDoc) {
        super(moduleItemCode, moduleItemKey, moduleSubItemCode, moduleSubItemKey, finalDoc);
    }
    
    protected void setProtocolSubItemCode(IacucProtocol protocol) {
        if (protocol.isContinuation()) {
            setModuleSubItemCode(CoeusSubModule.CONTINUATION);
        } else {
            super.setProtocolSubItemCode(protocol);
        }
    }

    @Override
    public KrmsRulesContext getKrmsRulesContextFromBean() {
        if (getProtocol() != null) {
            return getProtocol().getKrmsRulesContext();
        } else {
            Map<String, Object> values = new HashMap<String, Object>();
            values.put("protocolNumber", getModuleItemKey());
            values.put("sequenceNumber", getModuleSubItemKey());
            List<IacucProtocol> protocols = (List<IacucProtocol>) KcServiceLocator.getService(BusinessObjectService.class).findMatching(IacucProtocol.class, values);
            if (protocols != null && !protocols.isEmpty()) {
                return protocols.get(0).getIacucProtocolDocument();
            } else {
                return null;
            }
        }
    }
}
