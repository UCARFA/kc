/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.helpers;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncChange;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncType;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardSponsorTerm;
import org.kuali.rice.krad.bo.PersistableBusinessObject;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * Award Hierarchy Sync Helper for Terms.
 */
public class AwardSyncTermHelper extends AwardSyncHelperBase {
    
    @SuppressWarnings("unchecked")
    @Override
    public void applySyncChange(Award award, AwardSyncChange change) 
        throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, 
        ClassNotFoundException, NoSuchMethodException, InstantiationException {
        Collection awardTerms = award.getAwardSponsorTerms();
        AwardSponsorTerm term = (AwardSponsorTerm) getAwardSyncUtilityService().findMatchingBo(awardTerms, change.getXmlExport().getKeys());
        if (StringUtils.equals(change.getSyncType(), AwardSyncType.ADD_SYNC.getSyncValue())) {
            if (term != null) {
                this.setValuesOnSyncable(term, change.getXmlExport().getValues(), change);
            } else {
                term = new AwardSponsorTerm();
                setValuesOnSyncable(term, change.getXmlExport().getKeys(), change);
                setValuesOnSyncable(term, change.getXmlExport().getValues(), change);
                award.add(term);
            }
            //sponsorTerm might be null otherwise and this will generate an error during validation
            term.refreshReferenceObject("sponsorTerm");
        } else {
            if (term != null) {
                awardTerms.remove(term);
            }
        }
    }
    
    @Override
    protected String getObjectDesc(PersistableBusinessObject syncableObject, String attrName) {
        return "Term";
    }
    
    @Override
    protected String getDataDesc(PersistableBusinessObject syncableObject, String attrName) {
        AwardSponsorTerm term = (AwardSponsorTerm) syncableObject;
        return term.getSponsorTerm().getSponsorTermType().getDescription() + " : " + term.getSponsorTerm().getDescription();
    }     
}
