/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.rice.krad.bo.BusinessObject;

/**
 * Interface for rule implementations to go from where an action changes a <code>{@link ProposalPerson}</code>
 */
public interface ChangeKeyPersonRule extends org.kuali.rice.krad.rules.rule.BusinessRule {

    /**
     * To process Change event business rules for <code>{@link ProposalPerson}</code> instances. Any <code>{@link BusinessObject}</code>
     * can change the state of a <code>{@link ProposalPerson}</code> instance. This <code>{@link BusinessObject}</code> instance is considered
     *  to be the <code>source</code> of the event.
     * 
     * @param proposalPerson
     * @param source the event source acting on the rule
     * @return boolean pass or fail
     */
    public boolean processChangeKeyPersonBusinessRules(ProposalPerson proposalPerson, BusinessObject source,int index);

}
