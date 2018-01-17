/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup.dao;

import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.iacuc.personnel.IacucProtocolPerson;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPerson;
import org.kuali.kra.irb.personnel.ProtocolPerson;

import java.util.List;
import java.util.Map;

public interface CoiDisclosureUndisclosedEventsDao {

    public List<InstitutionalProposalPerson> getInstituteProposalPersons(Map<String,String> fieldValues);
    public List<AwardPerson> getAwardPersons(Map<String,String> fieldValues);
    public List<IacucProtocolPerson> getIacucProtocolPersons(Map<String,String> fieldValues);
    public List<ProtocolPerson> getIrbProtocolPersons(Map<String,String> fieldValues);

}
