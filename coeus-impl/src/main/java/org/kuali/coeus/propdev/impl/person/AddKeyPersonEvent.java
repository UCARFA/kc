/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * Event triggered when a Key Person is added to a
 * <code>{@link ProposalDevelopmentDocument}</code>
 *
 * @author $Author: gmcgrego $
 * @version $Revision: 1.4 $
 */
public class AddKeyPersonEvent extends KeyPersonEventBase implements KeyPersonEvent {
    /**
     * Constructs an AddKeyPersonEvent with the given errorPathPrefix, document, and proposalPerson.
     * 
     * @param document
     * @param person
     */
    public AddKeyPersonEvent(ProposalDevelopmentDocument document, ProposalPerson person) {
        super("adding key person to document " + getDocumentId(document), document, person);
    }

    /**
     * Constructs an AddKeyPersonEvent with the given errorPathPrefix, document, and proposalPerson.
     * 
     * @param document
     * @param person
     */
    public AddKeyPersonEvent(Document document, ProposalPerson person) {
        this((ProposalDevelopmentDocument) document, person);
    }

    @Override
    public Class getRuleInterfaceClass() {
        return AddKeyPersonRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddKeyPersonRule) rule).processAddKeyPersonBusinessRules((ProposalDevelopmentDocument) getDocument(), getProposalPerson());
    }
}
