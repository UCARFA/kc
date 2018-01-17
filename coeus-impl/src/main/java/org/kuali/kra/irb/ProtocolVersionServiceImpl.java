/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb;

import java.util.List;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.questionnaire.ProtocolModuleQuestionnaireBean;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.ProtocolVersionServiceImplBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.kra.protocol.questionnaire.ProtocolModuleQuestionnaireBeanBase;


/**
 * Protocol Version Service Implementation.
 */
public class ProtocolVersionServiceImpl extends ProtocolVersionServiceImplBase implements ProtocolVersionService {

    @Override
    protected String getProtocolDocumentTypeHook() {
        return "ProtocolDocument";
    }

    @Override
    protected ProtocolDocumentBase createNewProtocolDocumentInstanceHook() {
        return new ProtocolDocument();
    }

    @Override
    protected ProtocolBase createProtocolNewVersionHook(ProtocolBase protocol) throws Exception {
        Protocol irbProtocol = (Protocol)protocol;
        irbProtocol = versioningService.createNewVersion(irbProtocol);
        return irbProtocol;
    }

    @Override
    protected String getProtocolSequenceIdHook() {
        return "SEQ_PROTOCOL_ID";
    }

    @Override
    protected Class<? extends ProtocolBase> getProtocolBOClassHook() {
        return Protocol.class;
    }

    @Override
    protected ProtocolModuleQuestionnaireBeanBase getNewInstanceProtocolModuleQuestionnaireBeanHook(ProtocolBase protocol) {
        return new ProtocolModuleQuestionnaireBean((Protocol) protocol);
    }

    @Override
    protected ProtocolBase getNewProtocolVersion(ProtocolDocumentBase protocolDocument) throws Exception {
    	Protocol newProtocol = (Protocol)super.getNewProtocolVersion(protocolDocument);
    	setExpeditedAndExemptCheckListReferences(newProtocol.getProtocolSubmissions(), newProtocol);
    	return newProtocol;
    }
    
    @Override
    public void setExpeditedAndExemptCheckListReferences(List<ProtocolSubmissionBase> protocolSubmissions, ProtocolBase newProtocol) {
    	protocolSubmissions.forEach(protocolSubmissionBase -> {
    		ProtocolSubmission protocolSubmission = (ProtocolSubmission)protocolSubmissionBase;
    		protocolSubmission.getExpeditedReviewCheckList().forEach(expeditedCheckList -> {
    			expeditedCheckList.resetPersistenceState();
    			expeditedCheckList.setProtocolId(newProtocol.getProtocolId());
            });
    		protocolSubmission.getExemptStudiesCheckList().forEach(exemptCheckList -> {
    			exemptCheckList.resetPersistenceState();
    			exemptCheckList.setProtocolId(newProtocol.getProtocolId());
            });
        });
        
    }
    	  
}
