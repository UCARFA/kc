/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.impl.core;

import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireAuthorizationService;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.rice.kns.lookup.KualiLookupableImpl;
import org.kuali.rice.kns.lookup.LookupableHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * This class is to override 'create new' url.  MODIFY_QUESTIONNAIRE permission is need for this url. 
 */
@Component("questionnaireLookupable")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class QuestionnaireLookupableImpl extends KualiLookupableImpl {

    @Autowired
    @Qualifier("questionnaireAuthorizationService")
    private QuestionnaireAuthorizationService questionnaireAuthorizationService;

    /**
     * new url is redirect to "maintenanceQn", and also need to have MODIFY_QUESTIONNAIRE permission. 
     * @see org.kuali.rice.kns.lookup.KualiLookupableImpl#getCreateNewUrl()
     */
    @Override
    public String getCreateNewUrl() {
        String url = "";
        if (questionnaireAuthorizationService.hasPermission(PermissionConstants.MODIFY_QUESTIONNAIRE)) {
            url = super.getCreateNewUrl();
            url = url.replace("maintenance", "../maintenanceQn");
        }
        return url;
    }

    public void setQuestionnaireAuthorizationService(QuestionnaireAuthorizationService questionnaireAuthorizationService) {
        this.questionnaireAuthorizationService = questionnaireAuthorizationService;
    }

    public QuestionnaireAuthorizationService getQuestionnaireAuthorizationService() {
        return questionnaireAuthorizationService;
    }
    
    @Autowired
    @Qualifier("questionnaireLookupableHelperService")
    @Override
    public void setLookupableHelperService(LookupableHelperService lookupableHelperService) {
        super.setLookupableHelperService(lookupableHelperService);
    }
}
