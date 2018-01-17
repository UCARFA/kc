/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.unit;

import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.Query;
import org.apache.ojb.broker.query.QueryFactory;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.rice.core.framework.persistence.ojb.dao.PlatformAwareDaoBaseOjb;

public class UnitLookupDaoOjb extends PlatformAwareDaoBaseOjb implements UnitLookupDao {

    @Override
    public Unit findUnitbyNumberCaseInsensitive(String unitNumber) {
        Criteria crit = new Criteria();
        crit.addEqualTo(getDbPlatform().getUpperCaseFunction() + "(UNIT_NUMBER)", unitNumber.toUpperCase());
        Query q = QueryFactory.newQuery(Unit.class, crit);
        return (Unit) getPersistenceBrokerTemplate().getObjectByQuery(q);
    }
    
    @Override
    public Unit getTopUnit() {
        Criteria crit = new Criteria();
        crit.addIsNull("parentUnitNumber");
        Query q = QueryFactory.newQuery(Unit.class, crit);
        return (Unit) getPersistenceBrokerTemplate().getObjectByQuery(q);
    	
    }

}
