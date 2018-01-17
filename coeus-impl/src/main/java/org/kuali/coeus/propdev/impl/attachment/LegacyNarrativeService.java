/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;

import java.util.List;


public interface LegacyNarrativeService {
    public void populatePersonNameForNarrativeUserRights(ProposalDevelopmentDocument proposaldevelopmentDocument,Narrative narrative);
    public void populateNarrativeRightsForLoggedinUser(ProposalDevelopmentDocument proposaldevelopmentDocument);
    
    /**
     * Delete a person from all of the narratives.  When a user is removed from the Permissions
     * page, that user must also be removed from the narratives.
     * @param userId the id of the user
     * @param proposalDevelopmentDocument the Proposal Development Document
     */
    public void deletePerson(String userId, ProposalDevelopmentDocument proposalDevelopmentDocument);
    
    /**
     * Re-adjust the narrative rights for a user.  If the user has lost some
     * permissions regarding narratives, his/her narrative rights may need to
     * be down-graded.
     * @param userId the id of the user
     * @param proposalDevelopmentDocument the Proposal Development Document
     * @param roleNames the roles the user is in
     */
    public void readjustRights(String userId, ProposalDevelopmentDocument proposalDevelopmentDocument, List<String> roleNames);
    
    /**
     * Add a person to all of the Narratives in a proposal.  When a new user is granted
     * access to a proposal via the Permissions page, that user must be added to all of
     * the narratives with the appropriate default narrative right based upon their permissions.
     * @param userId the id of the user
     * @param proposalDevelopmentDocument the Proposal Development Document
     * @param roleNames the initial proposal role of the user
     */
    public void addPerson(String userId, ProposalDevelopmentDocument proposalDevelopmentDocument, List<String> roleNames);
    
    public void prepareNarrative(ProposalDevelopmentDocument document, Narrative narrative);

    public boolean doesProposalHaveNarrativeType(DevelopmentProposal proposal, NarrativeType narrativeType);

    public Integer getNextModuleNumber(ProposalDevelopmentDocument proposaldevelopmentDocument);
    
    public Integer getNextModuleSequenceNumber(ProposalDevelopmentDocument proposaldevelopmentDocument);

    }
