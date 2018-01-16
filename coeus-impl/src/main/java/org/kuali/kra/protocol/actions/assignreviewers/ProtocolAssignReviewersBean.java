/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.assignreviewers;

import org.kuali.kra.protocol.actions.ProtocolActionBean;
import org.kuali.kra.protocol.actions.submit.ProtocolReviewerBeanBase;

import java.io.Serializable;
import java.util.List;

/**
 * This class is really just a "form" for assigning a protocol
 * to one or more reviewers.
 */
public interface ProtocolAssignReviewersBean extends ProtocolActionBean, Serializable {
    
    /**
     * Create the list of reviewers based upon the current committee
     * and schedule, and assigns their reviewer types if any have been saved in the past
     */
    public void prepareView();
    
    public List<ProtocolReviewerBeanBase> getReviewers();
    
    public ProtocolReviewerBeanBase getReviewer(int i);
    
    /**
     * We display the reviewers in two columns.  These are the
     * reviewers in the left column.
     * @return
     */
    public List<ProtocolReviewerBeanBase> getLeftReviewers();
    
    /**
     * We display the reviewers in two columns.  These are the
     * reviewers in the right column.
     * @return
     */
    public List<ProtocolReviewerBeanBase> getRightReviewers();
    
}
