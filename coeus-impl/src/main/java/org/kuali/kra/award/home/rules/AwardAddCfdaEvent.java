package org.kuali.kra.award.home.rules;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBase;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class AwardAddCfdaEvent extends KcDocumentEventBase {

    private static final org.apache.commons.logging.Log LOG =
            org.apache.commons.logging.LogFactory.getLog(AwardAddCfdaEvent.class);

    private Award award;

    public AwardAddCfdaEvent(AwardDocument document) {
        super("adding cfda number" + getDocumentId(document), "", document);
        logEvent();
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AwardCfdaRule) rule).processAddCfdaRules(this);
    }

    public Class<AwardCfdaRule> getRuleInterfaceClass() {
        return AwardCfdaRule.class;
    }

    @Override
    protected void logEvent() {
        LOG.info("Logging AwardAddCfdaEvent");
    }

    public Award getAward() {
        return award;
    }
}
