/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.state;

import org.kuali.coeus.propdev.api.state.ProposalStateContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Proposal State represents the current state of a proposal.
 */
@Entity
@Table(name = "PROPOSAL_STATE")
public class ProposalState extends KcPersistableBusinessObjectBase implements ProposalStateContract {

    public static final String IN_PROGRESS = "1";

    public static final String APPROVAL_PENDING = "2";

    public static final String APPROVAL_GRANTED = "3";

    public static final String APPROVAL_NOT_INITIATED_SUBMITTED = "4";

    public static final String APPROVAL_PENDING_SUBMITTED = "5";

    public static final String APPROVED_AND_SUBMITTED = "6";

    public static final String DISAPPROVED = "7";

    public static final String APPROVED_POST_SUBMISSION = "8";

    public static final String DISAPPROVED_POST_SUBMISSION = "9";

    public static final String CANCELED = "10";

    public static final String DOCUMENT_ERROR = "11";

    public static final String REVISIONS_REQUESTED = "12";

    public static final String APPROVED = "13";

    @Id
    @Column(name = "STATE_TYPE_CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
