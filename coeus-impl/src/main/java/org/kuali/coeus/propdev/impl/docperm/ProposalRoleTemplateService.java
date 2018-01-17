/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.docperm;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;

/**
 * The Proposal Role Template Service.
 */
public interface ProposalRoleTemplateService {

    /**
     * Adds users to the proposal giving them proposal roles based upon a set
     * of templates.  Administrators can assign users to proposal roles within
     * a specific unit.  When a proposal is created, those users are added to
     * the proposal corresponding to the proposal's lead unit.
     * @param doc
     */
    public void addUsers(ProposalDevelopmentDocument doc);
}
