/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.dao;

import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.Query;
import org.apache.ojb.broker.query.QueryByCriteria;
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.rice.core.framework.persistence.ojb.dao.PlatformAwareDaoBaseOjb;
import org.kuali.rice.kns.service.DataDictionaryService;
import org.kuali.rice.krad.bo.PersistableBusinessObject;
import org.kuali.rice.krad.dao.LookupDao;
import org.kuali.rice.krad.service.util.OjbCollectionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AwardPersonDaoOjb extends PlatformAwareDaoBaseOjb implements OjbCollectionAware, AwardPersonDao {
    private LookupDao lookupDao;
    private DataDictionaryService dataDictionaryService;
    
    @Override
    @SuppressWarnings("unchecked")
    public List<AwardPerson> getAwardPersons(Map<String, String> fieldValues) {
        Query query = new QueryByCriteria(AwardPerson.class, getCollectionCriteriaFromMap(fieldValues));
        return new ArrayList<AwardPerson>(super.getPersistenceBrokerTemplate().getCollectionByQuery(query));
    }
    
    /**
     * @param dataDictionaryService
     */
    public void setDataDictionaryService(DataDictionaryService dataDictionaryService) {
        this.dataDictionaryService = dataDictionaryService;
    }
    
    /**
     * @param lookupDao
     */
    public void setLookupDao(LookupDao lookupDao) {
        this.lookupDao = lookupDao;
    }
    
    /*
     * 
     * Builds up criteria object based on the object and map.
     * This method is copied from lookDaoOjb, but not published in lookupdao, so can't access it directly.
     * @param businessObject
     * @param formProps
     * @return
     */ 
    private Criteria getCollectionCriteriaFromMap(Map<String, String> fieldValues) {
        AwardPerson awardPerson = new AwardPerson();
        Criteria criteria = new Criteria();
        for(String fieldName: fieldValues.keySet()) {
            String fieldValue = (String) fieldValues.get(fieldName);
            if (!lookupDao.createCriteria(awardPerson, fieldValue, fieldName, isCaseSensitive(awardPerson,  fieldName), false, criteria)) {
                continue;
            }
        }
        return criteria;
    }
    
    /*
     * extract method for casesensitive in method getCollectionCriteriaFromMap
     */
    private boolean isCaseSensitive(PersistableBusinessObject persistBo, String  propertyName) {     
        boolean caseInsensitive = false;
        if (dataDictionaryService.isAttributeDefined(persistBo.getClass(), propertyName)) {
            caseInsensitive = !dataDictionaryService.getAttributeForceUppercase(persistBo.getClass(), propertyName);
        }
        return caseInsensitive;
    }
}
