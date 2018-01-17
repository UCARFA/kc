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
import org.kuali.kra.award.contacts.AwardSponsorContact;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.krad.bo.PersistableBusinessObject;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * Award Hierarchy Sync Helper for Sponsor Contacts.
 */
public class AwardSyncSponsorContactHelper extends AwardSyncHelperBase {
    
    @SuppressWarnings("unchecked")
    @Override
    public void applySyncChange(Award award, AwardSyncChange change) 
        throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, 
        ClassNotFoundException, NoSuchMethodException, InstantiationException {
        Collection sponsorContacts = award.getSponsorContacts();
        AwardSponsorContact sponsorContact = (AwardSponsorContact) getAwardSyncUtilityService().findMatchingBo(sponsorContacts, change.getXmlExport().getKeys());
        if (StringUtils.equals(change.getSyncType(), AwardSyncType.ADD_SYNC.getSyncValue())) {
            if (sponsorContact != null) {
                this.setValuesOnSyncable(sponsorContact, change.getXmlExport().getValues(), change);
            } else {
                sponsorContact = new AwardSponsorContact();
                setValuesOnSyncable(sponsorContact, change.getXmlExport().getKeys(), change);
                setValuesOnSyncable(sponsorContact, change.getXmlExport().getValues(), change);
                award.add(sponsorContact);
            }
        } else {
            if (sponsorContact != null) {
                sponsorContacts.remove(sponsorContact);
            }
        }
    }
    
    @Override
    protected String getObjectDesc(PersistableBusinessObject syncableObject, String attrName) {
        return "Sponsor Contact";
    }
    
    @Override
    protected String getDataDesc(PersistableBusinessObject syncableObject, String attrName) {
        AwardSponsorContact sponsorContact = (AwardSponsorContact) syncableObject;
        String retval = sponsorContact.getContactType().getDescription() + " : ";
        if (sponsorContact.getRolodex().getFullName() != null) {
            retval += sponsorContact.getFullName();
        } else {
            retval += sponsorContact.getContactOrganizationName();
        }
        return retval;
    }     
}
