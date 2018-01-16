/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.dao.ojb;

import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.QueryByCriteria;
import org.apache.ojb.broker.query.QueryFactory;
import org.kuali.kra.committee.bo.CommitteeMembershipExpertise;
import org.kuali.kra.committee.bo.CommitteeResearchArea;
import org.kuali.kra.dao.ResearchAreaReferencesDao;
import org.kuali.kra.irb.protocol.research.ProtocolResearchArea;
import org.kuali.rice.core.framework.persistence.ojb.dao.PlatformAwareDaoBaseOjb;

public class ResearchAreaReferencesDaoOjb extends PlatformAwareDaoBaseOjb implements ResearchAreaReferencesDao {

    @Override
    public boolean isResearchAreaReferencedByAnyCommittee(String researchAreaCode) {
        boolean retVal = false;
        Criteria crit = new Criteria();
        crit.addEqualTo("researchAreaCode", researchAreaCode);
        QueryByCriteria q = QueryFactory.newQuery(CommitteeResearchArea.class, crit);
        int count = getPersistenceBrokerTemplate().getCount(q);
        if(count > 0){
            retVal = true;
        }
        return retVal;
    }

    @Override
    public boolean isResearchAreaReferencedByAnyCommitteeMember(String researchAreaCode) {
        boolean retVal = false;
        Criteria crit = new Criteria();
        crit.addEqualTo("researchAreaCode", researchAreaCode);
        QueryByCriteria q = QueryFactory.newQuery(CommitteeMembershipExpertise.class, crit);
        int count = getPersistenceBrokerTemplate().getCount(q);
        if(count > 0){
            retVal = true;
        }
        return retVal;
    }

    @Override
    public boolean isResearchAreaReferencedByAnyProtocol(String researchAreaCode) {
        boolean retVal = false;
        Criteria crit = new Criteria();
        crit.addEqualTo("researchAreaCode", researchAreaCode);
        QueryByCriteria q = QueryFactory.newQuery(ProtocolResearchArea.class, crit);
        int count = getPersistenceBrokerTemplate().getCount(q);
        if(count > 0){
            retVal = true;
        }
        return retVal;
    }
}
