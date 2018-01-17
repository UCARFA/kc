/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;

import org.kuali.coeus.propdev.impl.attachment.AddNarrativeEvent;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.coeus.propdev.impl.attachment.ReplaceNarrativeRule;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * Event triggered when a Key Person is added to a
 * <code>{@link ProposalDevelopmentDocument}</code>
 *
 * @author $Author: gmcgrego $
 * @version $Revision: 1.2 $
 */
public class ReplaceNarrativeEvent extends AddNarrativeEvent {
    /**
     * Constructs a ReplaceNarrativeEvent with the given errorPathPrefix, document, and narrative.
     * 
     * @param errorPathPrefix
     * @param document
     * @param narrative
     */
    public ReplaceNarrativeEvent(String errorPathPrefix, ProposalDevelopmentDocument document, Narrative narrative) {
        super(errorPathPrefix, document, narrative);
    }

    /**
     * Constructs an AddNarrativeEvent with the given errorPathPrefix, document, and proposalPerson.
     * 
     * @param errorPathPrefix
     * @param document
     * @param narrative
     */
    public ReplaceNarrativeEvent(String errorPathPrefix, Document document, Narrative narrative) {
        this(errorPathPrefix, (ProposalDevelopmentDocument) document, narrative);
    }

    @Override
    public Class getRuleInterfaceClass() {
        return ReplaceNarrativeRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((ReplaceNarrativeRule) rule).processReplaceNarrativeBusinessRules(this);
    }
}
