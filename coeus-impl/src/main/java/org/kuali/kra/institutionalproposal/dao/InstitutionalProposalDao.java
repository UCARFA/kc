/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.dao;

import org.kuali.coeus.sys.framework.rest.SearchResults;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Data access for institutional proposals
 */
public interface InstitutionalProposalDao {
    /**
     * Retrieves the proposal id for the given award
     * @param award the award to find the proposal id for
     * @return the proposal id, or null if nothing can be found
     */
    public Long getProposalId(Award award);

    public SearchResults<InstitutionalProposal> retrievePopulatedInstitutionalProposalByCriteria(Map<String, Object> fieldValues, Date updatedSince, Integer pageNum, Integer numPerPage);
    
    /**
     * 
     * @param startDate optional, can be null
     * @param endDate optional, can be null
     * @return a list of proposals between the dates if provided
     */
    List<InstitutionalProposal> getProposalsModifiedBetween(Date startDate, Date endDate);
}
