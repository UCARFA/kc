/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.bo;

import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipExpertiseBase;
import org.kuali.kra.irb.ResearchArea;

/**
 * 
 * This class implements the committee membership expertise business object.
 * 
 */
public class CommitteeMembershipExpertise extends CommitteeMembershipExpertiseBase {



    private static final long serialVersionUID = -1713544776094954622L;

    @Override
    protected ResearchArea getNewResearchAreaInstanceHook() {
        return new ResearchArea();
    }
}
