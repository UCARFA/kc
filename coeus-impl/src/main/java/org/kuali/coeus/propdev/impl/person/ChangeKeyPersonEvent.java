/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.rules.rule.BusinessRule;
import org.kuali.rice.krad.rules.rule.event.DocumentEvent;


/**
 * Event class for actions that trigger modification of a <code>{@link ProposalPerson}</code> added to a <code>{@link ProposalDevelopmentDocument}</code>
 * 
 */
public class ChangeKeyPersonEvent extends KeyPersonEventBase implements DocumentEvent {
    
    private BusinessObject source;
    private int index;

    public ChangeKeyPersonEvent(ProposalDevelopmentDocument document, ProposalPerson person, BusinessObject source, int index) {
        this("", document, person, source ,index);
    }

    public ChangeKeyPersonEvent(String errorPathPrefix, ProposalDevelopmentDocument document, ProposalPerson person, BusinessObject source,int index) {
        super("add BusinessObject to person " + person, errorPathPrefix, document, person);
        setSource(source);
        this.index=index;
       
    }

    /**
     * Read access to source
     * 
     * @return source of the event
     */
    public BusinessObject getSource() {
        return source;
    }

    /**
     * Write access to source
     * 
     * @param source
     */
    public void setSource(BusinessObject source) {
        this.source = source;
    }

    @Override
    public Class<ChangeKeyPersonRule> getRuleInterfaceClass() {
        return ChangeKeyPersonRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        //GlobalVariables.getMessageMap().addToErrorPath(getErrorPathPrefix());
        boolean retval = ((ChangeKeyPersonRule) rule).processChangeKeyPersonBusinessRules(getProposalPerson(), getSource(),index);
       // GlobalVariables.getMessageMap().removeFromErrorPath(getErrorPathPrefix());
        
        return retval;
    }
}
