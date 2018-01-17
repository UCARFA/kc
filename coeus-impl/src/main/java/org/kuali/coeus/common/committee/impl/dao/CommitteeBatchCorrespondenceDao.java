/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.dao;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBatchCorrespondenceBase;

import java.sql.Date;
import java.util.List;

/**
 * 
 * This class provides enhanced database access functionality.
 */
public interface CommitteeBatchCorrespondenceDao<CBC extends CommitteeBatchCorrespondenceBase> {
    
    /**
     * This method returns all CommitteeBatchCorrespondenceBase of the specified type.  Optionally a date range may be specified to further
     * narrow the result set.
     * @param batchCorrespondenceTypeCode
     * @param startDate - optional, if specified the CommitteeBatchCorrespondenceBase must be created on or after this date.
     * @param endDate - optional, if specified the CommitteeBatchCorrespondenceBase must be created on or before this date.
     * @return List of the requested CommitteeBatchCorrespondenceBase
     */
    List<CBC> getCommitteeBatchCorrespondence(String batchCorrespondenceTypeCode, Date startDate, Date endDate);

}
