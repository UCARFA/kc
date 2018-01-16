/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.dao.ojb;

import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.QueryByCriteria;
import org.apache.ojb.broker.query.QueryFactory;
import org.apache.ojb.broker.query.ReportQueryByCriteria;
import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.coeus.sys.framework.rest.SearchResults;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.institutionalproposal.dao.InstitutionalProposalDao;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.rice.krad.dao.impl.LookupDaoOjb;

import java.util.*;

/**
 * Default implementation of the institutional proposal dao
 */
public class InstitutionalProposalDaoOjb extends LookupDaoOjb implements InstitutionalProposalDao {
    private static final String ACTIVE = "active";
    private static final String UPDATE_TIMESTAMP = "updateTimestamp";
    private static final String PROPOSAL_SEQUENCE_STATUS = "proposalSequenceStatus";
    /**
     * Finds the proposal for the award &amp; returns only the id
     * @param award the award to find the proposal id for
     * @return hte proposal id
     */
    @Override
    public Long getProposalId(Award award) {
        Criteria crit = new Criteria();
        crit.addEqualTo("proposalNumber", award.getProposalNumber());
        ReportQueryByCriteria q = QueryFactory.newReportQuery(InstitutionalProposal.class, crit);
        q.setAttributes(new String[] { "proposalId" });
        Iterator<Object> resultsIter = getPersistenceBrokerTemplate().getIteratorByQuery(q);
        if (!resultsIter.hasNext()) {
            return null;
        }
        final Long proposalId = (Long)resultsIter.next();
        while (resultsIter.hasNext()) {
            resultsIter.next(); // exhaust the iterator so the result set can be returned
        }
        return proposalId;
    }

    @Override
    public SearchResults<InstitutionalProposal> retrievePopulatedInstitutionalProposalByCriteria(
            Map<String, Object> fieldValues, Date updatedSince, Integer page,
            Integer numberPerPage) {
        SearchResults<InstitutionalProposal> result = new SearchResults<>();
        Criteria origCrit = getCollectionCriteriaFromMap(new InstitutionalProposal(), fieldValues);
        Criteria crit = new Criteria();
        crit.addEqualTo(PROPOSAL_SEQUENCE_STATUS, VersionStatus.ACTIVE.toString());
        if (updatedSince != null) {
            crit.addGreaterOrEqualThan(UPDATE_TIMESTAMP, new java.sql.Date(updatedSince.getTime()));
        }
        crit.addAndCriteria(origCrit);
        final QueryByCriteria newCrit = QueryFactory.newQuery(InstitutionalProposal.class, crit);
        if (page != null) {
            result.setTotalResults(getPersistenceBrokerTemplate().getCount(newCrit));
			newCrit.setStartAtIndex((page-1)*numberPerPage);
			newCrit.setEndAtIndex(page*numberPerPage);
        }

        result.setResults(getPersistenceBrokerTemplate().getCollectionByQuery(newCrit));
        if (page == null) {
            result.setTotalResults(result.getResults().size());
        }
        return result;
    }
    
    @Override
    public List<InstitutionalProposal> getProposalsModifiedBetween(Date startDate, Date endDate) {
        Criteria crit = new Criteria();
        if (startDate != null) {
        	crit.addGreaterOrEqualThan(UPDATE_TIMESTAMP, new java.sql.Date(startDate.getTime()));
        }
        if (endDate != null) {
        	crit.addLessOrEqualThan(UPDATE_TIMESTAMP, new java.sql.Date(endDate.getTime()));
        }
        final QueryByCriteria finalCriteria = QueryFactory.newQuery(InstitutionalProposal.class, crit);
        return new ArrayList<>(getPersistenceBrokerTemplate().getCollectionByQuery(finalCriteria));
    }
}
