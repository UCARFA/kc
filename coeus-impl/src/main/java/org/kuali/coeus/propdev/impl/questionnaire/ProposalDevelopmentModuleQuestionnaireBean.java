/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.questionnaire;

import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.coeus.common.questionnaire.framework.answer.ModuleQuestionnaireBean;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.service.DocumentDictionaryService;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.Optional;

public class ProposalDevelopmentModuleQuestionnaireBean extends ModuleQuestionnaireBean {

    private DataObjectService dataObjectService;
    private DocumentDictionaryService documentDictionaryService;
    private DevelopmentProposal developmentProposal;

    public ProposalDevelopmentModuleQuestionnaireBean(DevelopmentProposal developmentProposal) {
        super(CoeusModule.PROPOSAL_DEVELOPMENT_MODULE_CODE, developmentProposal.getProposalNumber(), CoeusSubModule.ZERO_SUBMODULE, "0", true);
        this.developmentProposal = developmentProposal;
        setFinalDoc(!isProposalEditable(developmentProposal));
    }

    public ProposalDevelopmentModuleQuestionnaireBean(DevelopmentProposal developmentProposal, boolean finalDoc) {
        super(CoeusModule.PROPOSAL_DEVELOPMENT_MODULE_CODE, developmentProposal.getProposalNumber(), CoeusSubModule.ZERO_SUBMODULE, "0", true);
        this.developmentProposal = developmentProposal;
        setFinalDoc(finalDoc);
    }
    
    public ProposalDevelopmentModuleQuestionnaireBean(String moduleItemCode, String moduleItemKey, String moduleSubItemCode, String moduleSubItemKey, boolean finalDoc) {
        super(moduleItemCode, moduleItemKey, moduleSubItemCode, moduleSubItemKey, finalDoc);
    }

    protected boolean isProposalEditable(DevelopmentProposal developmentProposal) {
        ProposalDevelopmentDocument doc = developmentProposal.getProposalDocument();
        return Optional.ofNullable(GlobalVariables.getUserSession())
                .map(UserSession::getPerson)
                .map(user -> getDocumentDictionaryService().getDocumentAuthorizer(doc).canEdit(doc, user))
                .orElse(false);
    }

    @Override
    public KrmsRulesContext getKrmsRulesContextFromBean() {
        if (developmentProposal != null) {
            return developmentProposal.getKrmsRulesContext();
        } else {
            return loadKrmsRulesContext(getModuleItemKey());

        }
    }

    protected KrmsRulesContext loadKrmsRulesContext(String proposalNumber) {
        DevelopmentProposal proposal = getDataObjectService().find(DevelopmentProposal.class, proposalNumber);
        return proposal.getKrmsRulesContext();
    }

    protected DataObjectService getDataObjectService (){
        if (dataObjectService == null)
        dataObjectService = KcServiceLocator.getService(DataObjectService.class);
        return dataObjectService;
    }

    protected DocumentDictionaryService getDocumentDictionaryService() {
        if (documentDictionaryService == null) {
            documentDictionaryService = KcServiceLocator.getService(DocumentDictionaryService.class);
        }
        return documentDictionaryService;
    }

    public DevelopmentProposal getDevelopmentProposal() {
        return developmentProposal;
    }

    public void setDevelopmentProposal(DevelopmentProposal developmentProposal) {
        this.developmentProposal = developmentProposal;
    }
    
}
