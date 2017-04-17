package org.kuali.kra.award.home.rules.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.rules.AwardAddCfdaEvent;
import org.kuali.kra.award.home.rules.AwardCfdaRule;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;

public class AwardCfdaRuleImpl implements AwardCfdaRule {

    private GlobalVariableService globalVariableService;

    @Override
    public boolean processAddCfdaRules(AwardAddCfdaEvent awardAddCfdaEvent) {
        AwardDocument awardDocument = (AwardDocument) awardAddCfdaEvent.getDocument();
        if (isValidCfda(awardDocument.getAward().getCfdaNumber()) &&
                getGlobalVariableService().getMessageMap().getMessages(Constants.DOCUMENT_DEVELOPMENT_PROPOSAL_CFDA_NUMBER) == null) {
            getGlobalVariableService().getMessageMap().putWarning(Constants.DOCUMENT_AWARD_CFDA_NUMBER, KeyConstants.CFDA_INVALID,
                    awardDocument.getAward().getCfdaNumber());
        }
        return Boolean.TRUE;
    }

    public boolean isValidCfda(String cfdaNumber) {
        return StringUtils.isNotBlank(cfdaNumber) && !(cfdaNumber.matches(Constants.CFDA_REGEX));
    }

    public GlobalVariableService getGlobalVariableService() {
        if (globalVariableService == null) {
            globalVariableService = KcServiceLocator.getService(GlobalVariableService.class);
        }
        return globalVariableService;
    }
}
