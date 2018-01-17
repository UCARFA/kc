/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.service.impl;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipExpertiseBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeResearchAreaBase;
import org.kuali.kra.bo.ResearchAreaBase;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeMembership;
import org.kuali.kra.committee.bo.CommitteeMembershipExpertise;
import org.kuali.kra.committee.bo.CommitteeResearchArea;
import org.kuali.kra.irb.ResearchArea;
import org.kuali.kra.irb.protocol.research.ProtocolResearchArea;
import org.kuali.kra.irb.service.ResearchAreasService;
import org.kuali.kra.protocol.protocol.research.ProtocolResearchAreaBase;
import org.kuali.kra.service.impl.ResearchAreasServiceBaseImpl;


public class ResearchAreasServiceImpl extends ResearchAreasServiceBaseImpl implements ResearchAreasService {

    @Override
    protected Class<? extends CommitteeMembershipExpertiseBase> getCommitteeMembershipExpertiseClassHook() {
        return CommitteeMembershipExpertise.class;
    }

    @Override
    protected Class<? extends ProtocolResearchAreaBase> getProtocolResearchAreaBOClassHook() {
        return ProtocolResearchArea.class;
    }

    @Override
    protected Class<? extends ResearchAreaBase> getResearchAreaBOClassHook() {
        return ResearchArea.class;
    }

    @Override
    protected ResearchAreaBase getNewResearchAreaInstanceHook(String researchAreaCode, String parentResearchAreaCode,
            String description, boolean active) {
        return new ResearchArea(researchAreaCode, parentResearchAreaCode, 
                description, active);
    }

    @Override
    protected Class<? extends CommitteeMembershipBase> getCommitteeMembershipBOClassHook() {
        return CommitteeMembership.class;
    }

    @Override
    protected Class<? extends CommitteeBase> getCommitteeBOClassHook() {
        return Committee.class;
    }

    @Override
    protected Class<? extends CommitteeResearchAreaBase> getCommitteeResearchAreaBOClassHook() {
        return CommitteeResearchArea.class;
    }
}
