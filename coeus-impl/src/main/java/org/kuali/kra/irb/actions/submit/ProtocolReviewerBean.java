/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.kra.committee.bo.CommitteeMembership;
import org.kuali.kra.protocol.actions.submit.ProtocolReviewerBeanBase;

/**
 * This class is really just a "form" for the reviewers that
 * are displayed to the user in the Submit for Review Action.
 * It is only displayed from BusinessObject in order to use
 * the Data Dictionary for displaying controls on the web page.
 */
public class ProtocolReviewerBean extends ProtocolReviewerBeanBase {

    
    

    private static final long serialVersionUID = 647867490941129499L;

    public ProtocolReviewerBean() {
        super();
    }

    public ProtocolReviewerBean(CommitteeMembership member) {
        super(member);
    }

}
