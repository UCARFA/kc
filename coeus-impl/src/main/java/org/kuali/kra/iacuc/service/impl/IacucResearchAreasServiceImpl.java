/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.service.impl;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipExpertiseBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeResearchAreaBase;
import org.kuali.kra.bo.ResearchAreaBase;
import org.kuali.kra.iacuc.IacucResearchArea;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeMembership;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeMembershipExpertise;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeResearchArea;
import org.kuali.kra.iacuc.protocol.research.IacucProtocolResearchArea;
import org.kuali.kra.iacuc.service.IacucResearchAreasService;
import org.kuali.kra.protocol.protocol.research.ProtocolResearchAreaBase;
import org.kuali.kra.service.impl.ResearchAreasServiceBaseImpl;

public class IacucResearchAreasServiceImpl extends ResearchAreasServiceBaseImpl implements IacucResearchAreasService {

    @Override
    protected Class<? extends ProtocolResearchAreaBase> getProtocolResearchAreaBOClassHook() {
        return IacucProtocolResearchArea.class;
    }

    @Override
    protected Class<? extends ResearchAreaBase> getResearchAreaBOClassHook() {
        return IacucResearchArea.class;
    }

    @Override
    protected ResearchAreaBase getNewResearchAreaInstanceHook(String researchAreaCode, String parentResearchAreaCode,
            String description, boolean active) {
        return new IacucResearchArea(researchAreaCode, parentResearchAreaCode, 
                description, active);
    }

    @Override
    protected Class<? extends CommitteeMembershipExpertiseBase> getCommitteeMembershipExpertiseClassHook() {
        return IacucCommitteeMembershipExpertise.class;
    }

    @Override
    protected Class<? extends CommitteeMembershipBase> getCommitteeMembershipBOClassHook() {
        return IacucCommitteeMembership.class;
    }

    @Override
    protected Class<? extends CommitteeBase> getCommitteeBOClassHook() {
        return IacucCommittee.class;
    }

    @Override
    protected Class<? extends CommitteeResearchAreaBase> getCommitteeResearchAreaBOClassHook() {
        return IacucCommitteeResearchArea.class;
    }

}
