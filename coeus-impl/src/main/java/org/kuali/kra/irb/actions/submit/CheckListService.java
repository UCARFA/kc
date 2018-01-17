/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import java.util.List;


/**
 * The Check List Service is responsible for handling
 * queries related to Check List Items for submitting a protocol for review.
 */
public interface CheckListService {

    /**
     * Get the check list for an expedited review.
     * @return the check list items
     */
    public List<ExpeditedReviewCheckListItem> getExpeditedReviewCheckList();
    
    /**
     * Get the check list for an exempt study.
     * @return the check list items
     */
    public List<ExemptStudiesCheckListItem> getExemptStudiesCheckList();
}
