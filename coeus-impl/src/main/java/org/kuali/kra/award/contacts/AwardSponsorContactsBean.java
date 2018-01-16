/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.award.home.ContactType;

import java.util.List;

/**
 * This class provides support for the Award Contacts Project Personnel panel
 */
public class AwardSponsorContactsBean extends AwardContactsBean {
    private static final long serialVersionUID = -5443573805950047573L;

    public AwardSponsorContactsBean(AwardForm awardForm) {
        super(awardForm);
    }

    public AwardSponsorContact addSponsorContact() {
        boolean success = new AwardSponsorContactAddRuleImpl().processAddAwardSponsorContactBusinessRules(getAward(), getSponsorContact());
        if(success){
            AwardSponsorContact contact = getSponsorContact();
            getAward().add(contact);
            init();
            return contact;
        }
        return null;
    }


    public AwardSponsorContact getSponsorContact() {
        return (AwardSponsorContact) newAwardContact;
    }

    public void deleteSponsorContact(int lineToDelete) {
        List<AwardSponsorContact> awardSponsorContacts = getSponsorContacts();
        if(awardSponsorContacts.size() > lineToDelete) {
            awardSponsorContacts.remove(lineToDelete);
        }
    }

    /**
     * This method finds the count of AwardContacts in the "Sponsor Contacts" category
     * @return The list; may be empty
     */
    public List<AwardSponsorContact> getSponsorContacts() {
        return getAward().getSponsorContacts();
    }

    /**
     * This method finds the count of AwardContacts in the "Unit Contacts" category
     * @return The count; may be 0
     */
    public int getSponsorContactsCount() {
        return getSponsorContacts().size();
    }

    @Override
    protected AwardContact createNewContact() {
        return new AwardSponsorContact();
    }

    @Override
    protected Class<? extends ContactRole> getContactRoleType() {
        return ContactType.class;
    }
}
