/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.permissions.impl;

public final class PermissionableKeys {

    private PermissionableKeys () {
        throw new UnsupportedOperationException("do not call");
    }

    public static final String PROPOSAL_KEY = "proposal";
    public static final String AWARD_KEY = "award";
    public static final String TIME_AND_MONEY_KEY = "timeandmoney";
    
    //these keys dont seem to be used now
    public static final String AWARD_BUDGET_KEY = "awardbudget";
    public static final String PROPOSAL_BUDGET_KEY = "proposalbudget";

    public static final String PROTOCOL_KEY = "protocol";
    public static final String IACUC_PROTOCOL_KEY = "iacuc";
    public static final String COMMITTEE_KEY = "committee";
    public static final String COMMITTEE_SCHEDULE_KEY="committeeSchedule";
    public static final String PROTOCOL_ONLINE_REVIEW_KEY="protocolOnlineReview";
    public static final String IACUC_PROTOCOL_ONLINE_REVIEW_KEY="iacucOnlineReview";

    public static final String NEGOTIATION_KEY = "negotiation";
    public static final String COI_DISCLOSURE_KEY = "coiDisclosure";

    public static final String SPONSOR_HIREARCHY_KEY = "sponsorhirearchy";

    public static final String SUBAWARD_KEY = "SubAwardDocument";

    public static final String INSTITUTIONAL_PROPOSAL_KEY = "institutionalProposal";
}
