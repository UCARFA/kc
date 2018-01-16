/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.attachment;

import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;

public interface ProposalPersonBiographyService {
    /**
     * 
     * This method to add personnel attachment
     * @param proposaldevelopmentDocument
     * @param proposalPersonBiography
     */
    public void addProposalPersonBiography(ProposalDevelopmentDocument proposaldevelopmentDocument,ProposalPersonBiography proposalPersonBiography);
    
    /**
     * 
     * This method to delete personnel attachment when the key personnel is deleted
     * @param proposaldevelopmentDocument
     * @param person
     */
    public void removePersonnelAttachmentForDeletedPerson(ProposalDevelopmentDocument proposaldevelopmentDocument, ProposalPerson person);

    /**
     * 
     * This method to delete personnel attachment from the list.  ALso, remove it from DB.
     * @param proposaldevelopmentDocument
     * @param lineToDelete
     */
    public void deleteProposalPersonBiography(ProposalDevelopmentDocument proposaldevelopmentDocument, int lineToDelete);

    public void prepareProposalPersonBiographyForSave(DevelopmentProposal developmentProposal, ProposalPersonBiography biography);
    public PropPerDocType findPropPerDocTypeForOther();
}
