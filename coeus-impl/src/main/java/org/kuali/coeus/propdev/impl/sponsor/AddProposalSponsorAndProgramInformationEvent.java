/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.sponsor;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBase;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class AddProposalSponsorAndProgramInformationEvent extends KcDocumentEventBase {

    public AddProposalSponsorAndProgramInformationEvent(String errorPathPrefix, ProposalDevelopmentDocument document) {
        super("adding site to document " + getDocumentId(document), errorPathPrefix, document);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class getRuleInterfaceClass() {
        return AddProposalSponsorAndProgramInformationRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddProposalSponsorAndProgramInformationRule) rule).
                processAddProposalSponsorAndProgramInformationRules((ProposalDevelopmentDocument) this.getDocument());
    }

    @Override
    protected void logEvent() {

    }
}
