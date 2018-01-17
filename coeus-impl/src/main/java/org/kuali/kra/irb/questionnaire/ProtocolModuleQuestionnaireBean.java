/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.questionnaire;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.irb.Protocol;
import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.kra.protocol.questionnaire.ProtocolModuleQuestionnaireBeanBase;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtocolModuleQuestionnaireBean extends ProtocolModuleQuestionnaireBeanBase {

    public ProtocolModuleQuestionnaireBean(Protocol protocol) {
        super(CoeusModule.IRB_MODULE_CODE, protocol.getProtocolNumber(), "0", protocol.getSequenceNumber().toString(), 
                                protocol.getProtocolDocument().getDocumentHeader().hasWorkflowDocument() ? protocol.getProtocolDocument().getDocumentHeader().getWorkflowDocument().isApproved() : false);
        setProtocolSubItemCode(protocol) ;
    }
    
    public ProtocolModuleQuestionnaireBean(String moduleItemCode, String moduleItemKey, String moduleSubItemCode, String moduleSubItemKey, boolean finalDoc) {
        super(moduleItemCode, moduleItemKey, moduleSubItemCode, moduleSubItemKey, finalDoc);
    }
    
    @Override
    public KrmsRulesContext getKrmsRulesContextFromBean() {
        if (getModuleItemKey() != null && getModuleSubItemKey() != null) {
            String protocolNumber = getModuleItemKey().indexOf("|")==-1 ? getModuleItemKey() : getModuleItemKey().substring(0, getModuleItemKey().indexOf("|"));
            Integer sequenceNumber = Integer.valueOf(getModuleSubItemKey());
            Map<String, Object> values = new HashMap<String, Object>();
            values.put("protocolNumber", protocolNumber);
            values.put("sequenceNumber", sequenceNumber);
            List<Protocol> protocols = 
                    (List<Protocol>) KcServiceLocator.getService(BusinessObjectService.class).findMatching(Protocol.class, values);
            if (protocols != null && !protocols.isEmpty()) {
                return protocols.get(0).getKrmsRulesContext();
            } 
        }
        
        return null;
    }

    private void setProtocolSubItemCode(Protocol protocol) {
        // For now check renewal/amendment.  will add 'Protocol Submission' when it is cleared
        String subModuleCode = CoeusSubModule.ZERO_SUBMODULE;
        
        if (protocol.isRenewal()) {
            subModuleCode = CoeusSubModule.AMENDMENT_RENEWAL;
            if (protocol.isRenewalWithoutAmendment()) {
                subModuleCode = CoeusSubModule.RENEWAL;
            }
        }
        if (protocol.isFYI()) {
            subModuleCode = CoeusSubModule.FYI;
        }
        if (protocol.isAmendment()) {
            subModuleCode = CoeusSubModule.AMENDMENT;
        }
        
        setModuleSubItemCode(subModuleCode);
    }
    
    @Override
    public boolean equals(Object o) {
        boolean retVal = false;
        if( (o != null) && (o instanceof ProtocolModuleQuestionnaireBean) ) {
            ProtocolModuleQuestionnaireBean pmqb = (ProtocolModuleQuestionnaireBean)o;
            retVal = (  (this.getModuleItemCode().equals(pmqb.getModuleItemCode()))
                     && (this.getModuleItemKey().equals(pmqb.getModuleItemKey()))
                     && (this.getModuleSubItemCode().equals(pmqb.getModuleSubItemCode()))  
                     && (this.getModuleSubItemKey().equals(pmqb.getModuleSubItemKey()))
                     && (this.isFinalDoc() == pmqb.isFinalDoc()) );
        }
        return retVal;
    }

}
