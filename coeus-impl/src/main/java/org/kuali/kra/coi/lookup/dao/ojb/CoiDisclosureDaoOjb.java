/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup.dao.ojb;

import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.QueryByCriteria;
import org.apache.ojb.broker.query.QueryFactory;
import org.kuali.kra.coi.*;
import org.kuali.kra.coi.lookup.dao.CoiDisclosureDao;
import org.kuali.rice.core.framework.persistence.ojb.dao.PlatformAwareDaoBaseOjb;
import org.kuali.rice.krad.service.util.OjbCollectionAware;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CoiDisclosureDaoOjb extends PlatformAwareDaoBaseOjb implements OjbCollectionAware, CoiDisclosureDao {

    @Override
    public List<CoiDisclosureHistory> getApprovedAndDisapprovedDisclosureHistory(String coiDisclosureNumber) {
        
        Criteria crit1 = new Criteria();
        crit1.addEqualTo("coiDisclosureNumber", coiDisclosureNumber);
        crit1.addEqualTo("disclosureStatus", CoiDisclosureStatus.APPROVED);
        
        Criteria crit2 = new Criteria();
        crit2.addEqualTo("coiDisclosureNumber", coiDisclosureNumber);
        crit2.addEqualTo("disclosureStatus", CoiDisclosureStatus.DISAPPROVED);
        
        crit1.addOrCriteria(crit2);
        
        QueryByCriteria query = QueryFactory.newQuery(CoiDisclosureHistory.class, crit1);
        query.addOrderByDescending("sequenceNumber");
        Collection history = new ArrayList();

        history = getPersistenceBrokerTemplate().getCollectionByQuery(query);
        
        return (List<CoiDisclosureHistory>) history;     
    }
        
    @Override
    public List<CoiDisclosure> getReviewsForReviewStatuses(Collection<String> reviewStatusCodes) {
        if (reviewStatusCodes == null || reviewStatusCodes.isEmpty()) {
            return new ArrayList<CoiDisclosure>();
        }
        Criteria crit1 = new Criteria();
        for (String reviewCode : reviewStatusCodes) {
            Criteria crit2 = new Criteria();
            crit2.addEqualTo("reviewStatusCode", reviewCode);
            crit1.addOrCriteria(crit2);
        }
        
        QueryByCriteria query = QueryFactory.newQuery(CoiDisclosure.class, crit1);
        query.addOrderByDescending("sequenceNumber");
        
        Collection<CoiDisclosure> disclosures = getPersistenceBrokerTemplate().getCollectionByQuery(query);
        
        for (CoiDisclosure disclosure : disclosures) {
            List<CoiDisclProject> coiDisclProjects = disclosure.getCoiDisclProjects();
    
            CoiDisclosureEventType coiDisclosureEventType = disclosure.getCoiDisclosureEventType();
            String coiDisclosureModuleItemKey = disclosure.getModuleItemKey();
            for(CoiDisclProject coiDisclProject : coiDisclProjects)
            {
                if ( coiDisclosureEventType.getEventTypeCode().equals(coiDisclProject.getDisclosureEventType()) &&
                            coiDisclosureModuleItemKey.equals(coiDisclProject.getModuleItemKey()) )
                {
                    disclosure.setCoiDisclProjectId(coiDisclProject.getProjectId());
                    disclosure.setCoiDisclProjectTitle(coiDisclProject.getCoiProjectTitle());
                    break;
                }
            }
        }
        
        return new ArrayList<CoiDisclosure>(disclosures);     
        
    }
    
    
}
