/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.sponsor.hierarchy;

import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.ReportQueryByCriteria;
import org.kuali.coeus.common.framework.sponsor.hierarchy.SponsorHierarchy;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.core.framework.persistence.ojb.dao.PlatformAwareDaoBaseOjb;
import org.kuali.rice.krad.service.util.OjbCollectionAware;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SponsorHierarchyDaoOjb extends PlatformAwareDaoBaseOjb implements OjbCollectionAware, SponsorHierarchyDao {
    
    @Override
    public Iterator getTopSponsorHierarchy() {
        
      Criteria criteriaID = new Criteria();
      ReportQueryByCriteria queryID = new ReportQueryByCriteria(SponsorHierarchy.class,criteriaID);
      queryID.setAttributes(new String[] {Constants.HIERARCHY_NAME});
      queryID.setDistinct(true);
      
      return getPersistenceBrokerTemplate().getReportQueryIteratorByQuery(queryID);
      
  }
    
    /**
     * This is much faster than use 'businessobjectservice.findmatching, and then loop thru bo.
     * @see org.kuali.coeus.common.impl.sponsor.hierarchy.SponsorHierarchyDao#getAllSponsors(java.lang.String)
     */
    @Override
    public Iterator getAllSponsors(String hierarchyName) {
        
      Criteria criteriaID = new Criteria();
      criteriaID.addEqualTo(Constants.HIERARCHY_NAME, hierarchyName);
      ReportQueryByCriteria queryID = new ReportQueryByCriteria(SponsorHierarchy.class,criteriaID);
      queryID.setAttributes(new String[] {Constants.SPONSOR_CODE});
      
      return getPersistenceBrokerTemplate().getReportQueryIteratorByQuery(queryID);
      
   }

    /**
     * Appears to need to be transactional when this is called during the maint doc page rendering.
     * @see org.kuali.coeus.common.impl.sponsor.hierarchy.SponsorHierarchyDao#getUniqueNamesAtLevel(java.lang.String, int)
     */
    @Override
    @Transactional
    public List<String> getUniqueNamesAtLevel(String hierarchyName, int depth) {
        Criteria criteriaID = new Criteria();
        criteriaID.addEqualTo(Constants.HIERARCHY_NAME, hierarchyName);
        ReportQueryByCriteria queryID = new ReportQueryByCriteria(SponsorHierarchy.class,criteriaID);
        queryID.setAttributes(new String[] {"level" + depth});
        queryID.setDistinct(true);
        
        Iterator iter = getPersistenceBrokerTemplate().getReportQueryIteratorByQuery(queryID);
        List<String> result = new ArrayList<String>();
        while (iter.hasNext()) {
            Object[] objects = (Object[]) iter.next();
            result.add((String) objects[0]);
        }
        return result;
    }
}
