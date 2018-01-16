/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.bo;

import java.io.Serializable;

/**
 * 
 * This class maintains the association type of a negotiation.
 */
public class NegotiationAssociationType  extends NegotiationsGroupingBase implements Serializable {
    
    public static final String NONE_ASSOCIATION = "NO";
    public static final String PROPOSAL_LOG_ASSOCIATION = "PL";
    public static final String INSTITUATIONAL_PROPOSAL_ASSOCIATION = "IP";
    public static final String AWARD_ASSOCIATION = "AWD";
    public static final String SUB_AWARD_ASSOCIATION = "SWD";


    private static final long serialVersionUID = 8163060629967261671L;
    

    public NegotiationAssociationType() {
        super();
    }
}
