/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.abstrct;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.abstrct.ProposalAbstract;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * Defines the Business Rule for processing Proposal Abstracts.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface AbstractsRule extends BusinessRule {
    
    /**
     * Determines the legality of adding an abstract to the
     * given proposal development document.
     * 
     * @param document the proposal development document.
     * @param proposalAbstract the abstract to be added to the document.
     * @return true if the addition is valid; otherwise false.
     */
    public boolean processAddAbstractBusinessRules(ProposalDevelopmentDocument document, 
                                                   ProposalAbstract proposalAbstract);
}
