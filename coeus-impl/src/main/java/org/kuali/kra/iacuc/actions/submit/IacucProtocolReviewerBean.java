/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.submit;

import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.kra.protocol.actions.submit.ProtocolReviewerBeanBase;

public class IacucProtocolReviewerBean extends ProtocolReviewerBeanBase {


    private static final long serialVersionUID = 1L;

    public IacucProtocolReviewerBean() {
        super();
    }

    public IacucProtocolReviewerBean(CommitteeMembershipBase member) {
        super(member);
    }
    
}
