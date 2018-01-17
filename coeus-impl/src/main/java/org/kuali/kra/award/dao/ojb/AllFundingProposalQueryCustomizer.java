/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.dao.ojb;

import java.util.Arrays;

import org.apache.ojb.broker.PersistenceBroker;
import org.apache.ojb.broker.accesslayer.QueryCustomizerDefaultImpl;
import org.apache.ojb.broker.metadata.CollectionDescriptor;
import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.Query;
import org.apache.ojb.broker.query.QueryByCriteria;
import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.kra.award.home.Award;

public class AllFundingProposalQueryCustomizer extends QueryCustomizerDefaultImpl {
    private static final String ACTIVE = "active";
	private static final String AWARD_SEQUENCE_STATUS = "award.awardSequenceStatus";
	private static final String AWARD_NUMBER = "award.awardNumber";

	@Override
    public Query customizeQuery(Object anObject,
            PersistenceBroker aBroker,
            CollectionDescriptor aCod, QueryByCriteria aQuery){
    	Criteria crit = new Criteria();
    	crit.addEqualTo(AWARD_NUMBER, ((Award)anObject).getAwardNumber());
    	crit.addIn(AWARD_SEQUENCE_STATUS, Arrays.asList(new String[]{VersionStatus.ACTIVE.toString(), VersionStatus.PENDING.toString(), VersionStatus.ARCHIVED.toString()}));
    	crit.addEqualTo(ACTIVE, Boolean.TRUE);
        aQuery.setCriteria(crit);
        return aQuery;
    }
}
