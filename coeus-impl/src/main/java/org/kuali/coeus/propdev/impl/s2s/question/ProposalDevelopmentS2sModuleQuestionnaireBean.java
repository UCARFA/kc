/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s.question;

import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.questionnaire.ProposalDevelopmentModuleQuestionnaireBean;

public class ProposalDevelopmentS2sModuleQuestionnaireBean extends ProposalDevelopmentModuleQuestionnaireBean {
    
    public ProposalDevelopmentS2sModuleQuestionnaireBean(DevelopmentProposal developmentProposal) {
        super(developmentProposal);
        this.setModuleSubItemCode(CoeusSubModule.PROPOSAL_S2S_SUBMODULE);
        this.setModuleSubItemKey("0");      
    }
    
    public ProposalDevelopmentS2sModuleQuestionnaireBean(String moduleItemCode, String moduleItemKey, String moduleSubItemCode, String moduleSubItemKey, boolean finalDoc) {
        super(moduleItemCode, moduleItemKey, moduleSubItemCode, moduleSubItemKey, finalDoc);
    }
}
