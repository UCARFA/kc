/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.infrastructure;

/**
 * Tasks are placed into groups corresponding to the object they
 * relate to.  For example, the "saveProposal" task corresponds to
 * the "proposal" group.  This file contains the constants for the
 * names of the Task Groups.  The group names must correspond to the 
 * values in the SpringBeans.xml.
 */
public interface TaskGroupName {

    public static final String AWARD_BUDGET = "awardBudget";
    public static final String PROTOCOL = "protocol";
    public static final String IACUC_PROTOCOL = "iacucProtocol";
    public static final String COMMITTEE = "committee";
    public static final String AWARD = "award";
    public static final String TIME_AND_MONEY = "timeAndMoney";
    public static final String PROTOCOL_ONLINEREVIEW = "protocolOnlineReview";
    public static final String NEGOTIATION = "negotiation";
    public static final String COIDISCLOSURE = "coiDisclosure";
    public static final String SUBAWARD = "subAward";
    public static final String IACUC_PROTOCOL_ONLINEREVIEW = "iacucProtocolOnlineReview";
    public static final String IACUC_COMMITTEE = "iacucCommittee";

}
