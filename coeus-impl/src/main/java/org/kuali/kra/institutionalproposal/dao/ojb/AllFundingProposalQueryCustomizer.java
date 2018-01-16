/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.dao.ojb;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.ojb.broker.PersistenceBroker;
import org.apache.ojb.broker.accesslayer.QueryCustomizerDefaultImpl;
import org.apache.ojb.broker.metadata.CollectionDescriptor;
import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.Query;
import org.apache.ojb.broker.query.QueryByCriteria;
import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;

public class AllFundingProposalQueryCustomizer extends QueryCustomizerDefaultImpl {
    private static final String ACTIVE = "active";
	private static final String PROPOSAL_SEQUENCE_STATUS = "proposal.proposalSequenceStatus";
    private static final String PROPOSAL_NUMBER = "proposal.proposalNumber";


    @Override
    public Query customizeQuery(Object anObject,
            PersistenceBroker aBroker,
            CollectionDescriptor aCod, QueryByCriteria aQuery){
    	final Criteria crit = new Criteria();
    	crit.addEqualTo(PROPOSAL_NUMBER, ((InstitutionalProposal) anObject).getProposalNumber());
     	crit.addIn(PROPOSAL_SEQUENCE_STATUS, Stream.of(VersionStatus.ACTIVE.toString(), VersionStatus.PENDING.toString(), VersionStatus.ARCHIVED.toString()).collect(Collectors.toList()));
    	crit.addEqualTo(ACTIVE, Boolean.TRUE);
        aQuery.setCriteria(crit);
        return aQuery;
    }
}
