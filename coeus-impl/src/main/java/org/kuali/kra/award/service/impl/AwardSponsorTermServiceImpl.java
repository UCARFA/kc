/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service.impl;

import org.kuali.coeus.common.framework.sponsor.term.SponsorTerm;
import org.kuali.coeus.common.framework.sponsor.term.SponsorTermType;
import org.kuali.kra.award.service.AwardSponsorTermService;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.PersistableBusinessObjectValuesFinder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
/**
 * This is the service class for Term tab in Award Payments Reports and Terms page.
 */
@Transactional
public class AwardSponsorTermServiceImpl implements AwardSponsorTermService {

    
    /**
     * 
     * This method retrieves the list of Sponsor Term types from Database.
     * 
     * @param
     */
    @Override
    public List<KeyValue> retrieveSponsorTermTypesToAwardFormForPanelHeaderDisplay(){
        PersistableBusinessObjectValuesFinder persistableBusinessObjectValuesFinder = new PersistableBusinessObjectValuesFinder();
        persistableBusinessObjectValuesFinder.setBusinessObjectClass(SponsorTermType.class);
        persistableBusinessObjectValuesFinder.setKeyAttributeName("sponsorTermTypeCode");
        persistableBusinessObjectValuesFinder.setLabelAttributeName("description");
        return persistableBusinessObjectValuesFinder.getKeyValues();
    }
    
    /**
     * 
     * This method creates and returns a list of empty Sponsor Terms
     * 
     * @param awardForm
     * @param reportClasses
     */
    @Override
    public List<SponsorTerm> getEmptyNewSponsorTerms(List<KeyValue> sponsorTermTypes){
        List<SponsorTerm> sponsorTerms = new ArrayList<SponsorTerm>();
        for(int i=0;i<sponsorTermTypes.size();i++){
            sponsorTerms.add(new SponsorTerm());
        }
        return sponsorTerms;
    }

}
