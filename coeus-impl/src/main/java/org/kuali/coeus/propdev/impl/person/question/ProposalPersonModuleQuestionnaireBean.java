/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.question;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.propdev.impl.questionnaire.ProposalDevelopmentModuleQuestionnaireBean;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;


public class ProposalPersonModuleQuestionnaireBean extends ProposalDevelopmentModuleQuestionnaireBean {

    public static final String MODULE_SUB_ITEM_CODE_PI_CERTIFICATION = "MODULE_SUB_ITEM_CODE_PI_CERTIFICATION";
    public static final String MODULE_SUB_ITEM_CODE_COI_CERTIFICATION = "MODULE_SUB_ITEM_CODE_COI_CERTIFICATION";
    public static final String MODULE_SUB_ITEM_CODE_KP_CERTIFICATION = "MODULE_SUB_ITEM_CODE_KP_CERTIFICATION";

    /**
     * 
     * Constructs a ProposalPersonModuleQuestionnaireBean.java.
     * @param developmentProposal
     * @param person
     */
    public ProposalPersonModuleQuestionnaireBean(DevelopmentProposal developmentProposal, ProposalPerson person) {
        super(CoeusModule.PROPOSAL_DEVELOPMENT_MODULE_CODE, person.getUniqueId(), 
                CoeusSubModule.PROPOSAL_PERSON_CERTIFICATION, "0", true);
        setDevelopmentProposal(developmentProposal);
        setFinalDoc(!isProposalEditable(developmentProposal));
    }
    
    public ProposalPersonModuleQuestionnaireBean(String moduleItemCode, String moduleItemKey, String moduleSubItemCode, String moduleSubItemKey, boolean finalDoc) {
        super(moduleItemCode, moduleItemKey, moduleSubItemCode, moduleSubItemKey, finalDoc);
    }
    
    @Override
    public KrmsRulesContext getKrmsRulesContextFromBean() {
        if (getDevelopmentProposal() != null) {
            return getDevelopmentProposal().getKrmsRulesContext();
        } else if (getModuleItemKey().contains("|")) {
            return loadKrmsRulesContext(getModuleItemKey().split("\\|")[0]);
        } else {
            return super.getKrmsRulesContextFromBean();
        }
    }
    
    private static String getSubModuleItemCode(String roleId){

    	if(roleId.equals(Constants.PRINCIPAL_INVESTIGATOR_ROLE)){
    		return  KcServiceLocator.getService(ParameterService.class).getParameterValueAsString(Constants.KC_GENERIC_PARAMETER_NAMESPACE,
    	            Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, MODULE_SUB_ITEM_CODE_PI_CERTIFICATION);
    	}else if(roleId.equals(Constants.CO_INVESTIGATOR_ROLE) || roleId.equals(Constants.MULTI_PI_ROLE)){
    		return  KcServiceLocator.getService(ParameterService.class).getParameterValueAsString(Constants.KC_GENERIC_PARAMETER_NAMESPACE, 
    	            Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, MODULE_SUB_ITEM_CODE_COI_CERTIFICATION);
    	}else {
    		return  KcServiceLocator.getService(ParameterService.class).getParameterValueAsString(Constants.KC_GENERIC_PARAMETER_NAMESPACE, 
    	            Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, MODULE_SUB_ITEM_CODE_KP_CERTIFICATION);
    	}
    }
}
