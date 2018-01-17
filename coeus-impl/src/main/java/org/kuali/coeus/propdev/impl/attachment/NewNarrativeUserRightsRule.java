/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.attachment.NarrativeUserRights;
import org.kuali.rice.krad.rules.rule.BusinessRule;

import java.util.List;

/**
 * Defines the Business Rule for processing modifications to the narrative user rights.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface NewNarrativeUserRightsRule extends BusinessRule {
    
    /**
     * Determines the legality of editing a Narrative's user rights.
     * 
     * @param document the proposal development document.
     * @param newNarrativeUserRights the new narrative user rights
     * @param narrativeIndex the index of the narrative in the document
     * @return true if the modification is valid; otherwise false.
     */
    public boolean processNewNarrativeUserRightsBusinessRules(ProposalDevelopmentDocument document, 
                                                              List<NarrativeUserRights> newNarrativeUserRights,
                                                              int narrativeIndex);
}
