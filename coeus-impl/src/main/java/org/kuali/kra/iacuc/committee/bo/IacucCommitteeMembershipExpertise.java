/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.bo;

import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipExpertiseBase;
import org.kuali.kra.bo.ResearchAreaBase;
import org.kuali.kra.iacuc.IacucResearchArea;

public class IacucCommitteeMembershipExpertise extends CommitteeMembershipExpertiseBase {


    private static final long serialVersionUID = 865409542244257623L;

    @Override
    protected ResearchAreaBase getNewResearchAreaInstanceHook() {
        return new IacucResearchArea();
    }

}
