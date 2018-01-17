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
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.krad.bo.PersistableBusinessObject;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * 
 * Award Hierarchy Sync Helper for AwardPersons.
 */
public class AwardSyncPersonHelper extends AwardSyncHelperBase {
    
    @SuppressWarnings("unchecked")
    @Override
    public void applySyncChange(Award award, AwardSyncChange change) 
        throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, 
        ClassNotFoundException, NoSuchMethodException, InstantiationException {
        Collection awardPersons = award.getProjectPersons();
        AwardPerson person = (AwardPerson) getAwardSyncUtilityService().findMatchingBo(awardPersons, change.getXmlExport().getKeys());
        if (StringUtils.equals(change.getSyncType(), AwardSyncType.ADD_SYNC.getSyncValue())) {
            if (person != null) {
                this.setValuesOnSyncable(person, change.getXmlExport().getValues(), change);
            } else {
                person = new AwardPerson();
                setValuesOnSyncable(person, change.getXmlExport().getKeys(), change);
                setValuesOnSyncable(person, change.getXmlExport().getValues(), change);
                award.add(person);
            }
        } else {
            if (person != null) {
                awardPersons.remove(person);
            }
        }
    }

    @Override
    protected String getObjectDesc(PersistableBusinessObject syncableObject, String attrName) {
        AwardPerson person = (AwardPerson) syncableObject;
        return person.getContactRole().getRoleDescription();
    }

    @Override
    protected String getDataDesc(PersistableBusinessObject syncableObject, String attrName) {
        AwardPerson person = (AwardPerson) syncableObject;
        return person.getFullName();
    }     
}
