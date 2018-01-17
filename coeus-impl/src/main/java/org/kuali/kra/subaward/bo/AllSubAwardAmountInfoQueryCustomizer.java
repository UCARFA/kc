/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.bo;

import java.util.Arrays;
import java.util.List;

import org.apache.ojb.broker.PersistenceBroker;
import org.apache.ojb.broker.accesslayer.QueryCustomizerDefaultImpl;
import org.apache.ojb.broker.metadata.CollectionDescriptor;
import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.Query;
import org.apache.ojb.broker.query.QueryByCriteria;
import org.kuali.coeus.common.framework.version.VersionStatus;

public class AllSubAwardAmountInfoQueryCustomizer extends QueryCustomizerDefaultImpl {

	static final String SUB_AWARD_AMOUNT_INFO_ID = "subAwardAmountInfoId";
	static final String SUB_AWARD_SEQUENCE_NUMBER_PATH = "subAward.sequenceNumber";
	static final List<String> ALLOWED_STATUSES = Arrays.asList(new String[]{VersionStatus.ACTIVE.toString(), VersionStatus.PENDING.toString(), VersionStatus.ARCHIVED.toString()});
	static final String SUB_AWARD_SUB_AWARD_SEQUENCE_STATUS_PATH = "subAward.subAwardSequenceStatus";
	static final String SUB_AWARD_SUB_AWARD_CODE_PATH = "subAward.subAwardCode";

	@Override
    public Query customizeQuery(Object anObject,
            PersistenceBroker aBroker,
            CollectionDescriptor aCod, QueryByCriteria aQuery){
    	Criteria crit = buildCriteria((SubAward)anObject);
        aQuery.setCriteria(crit);
        return aQuery;
    }

	Criteria buildCriteria(SubAward subAward) {
		Criteria crit = new Criteria();
    	crit.addEqualTo(SUB_AWARD_SUB_AWARD_CODE_PATH, subAward.getSubAwardCode());
    	crit.addIn(SUB_AWARD_SUB_AWARD_SEQUENCE_STATUS_PATH, ALLOWED_STATUSES);
    	crit.addLessOrEqualThan(SUB_AWARD_SEQUENCE_NUMBER_PATH, subAward.getSequenceNumber());
    	crit.addOrderByAscending(SUB_AWARD_AMOUNT_INFO_ID);
		return crit;
	}
}
