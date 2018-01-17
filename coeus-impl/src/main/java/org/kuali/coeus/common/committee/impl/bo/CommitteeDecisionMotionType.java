/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * Defines the type of motion (approve, disapprove, etc.) that the committee voted to enact.
 */
@SuppressWarnings("serial")
public class CommitteeDecisionMotionType extends KcPersistableBusinessObjectBase {

    /**
     * The committee decision to approve the protocol.
     */
    public static final String APPROVE = "1";

    /**
     * The committee decision to disapprove the protocol.
     */
    public static final String DISAPPROVE = "2";

    /**
     * The committee decision to return the protocol to the PI with minor revisions requested.
     */
    public static final String SPECIFIC_MINOR_REVISIONS = "3";

    /**
     * The committee decision to return the protocol to the PI with substantive revisions requested.
     */
    public static final String SUBSTANTIVE_REVISIONS_REQUIRED = "4";

    private String motionTypeCode;

    private String description;


    public CommitteeDecisionMotionType() {
    }

    public String getMotionTypeCode() {
        return motionTypeCode;
    }

    public void setMotionTypeCode(String motionTypeCode) {
        this.motionTypeCode = motionTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
