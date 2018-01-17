/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.docperm;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.krad.rules.rule.BusinessRule;

import java.util.List;

/**
 * Defines the Business Rule for processing Proposal Permissions.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface PermissionsRule extends BusinessRule {
    
    /**
     * Determines the legality of adding a proposal user to the
     * given proposal development document.
     * 
     * @param document the proposal development document.
     * @param proposalUserRolesList list of proposal user roles
     * @param proposalUser the proposal user to be added to the document.
     * @return true if the addition is valid; otherwise false.
     */
    public boolean processAddProposalUserBusinessRules(ProposalDevelopmentDocument document,
                                                       List<ProposalUserRoles> proposalUserRolesList,
                                                       ProposalUserRoles proposalUser);
    /**
     * Determines the legality of deleting a proposal user from the
     * given proposal development document.
     * 
     * @param document the proposal development document.
     * @param proposalUserRolesList list of proposal user roles
     * @param index the index into proposalUserRolesList of the user to delete
     * @return true if the addition is valid; otherwise false.
     */
    public boolean processDeleteProposalUserBusinessRules(ProposalDevelopmentDocument document,
                                                          List<ProposalUserRoles> proposalUserRolesList,
                                                          int index);
    
    /**
     * Determines if it is legal to edit the roles for a user.
     * 
     * @param document the proposal development document.
     * @param proposalUserRolesList list of proposal user roles
     * @param editRoles the proposal roles to edit for a user
     * @return true if the addition is valid; otherwise false.
     */
    public boolean processEditProposalUserRolesBusinessRules(ProposalDevelopmentDocument document,
                                                             List<ProposalUserRoles> proposalUserRolesList,
                                                             ProposalUserRoles editRoles);
}
