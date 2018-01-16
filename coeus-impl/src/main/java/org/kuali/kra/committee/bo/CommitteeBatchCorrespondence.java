/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.bo;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBatchCorrespondenceBase;

import java.sql.Date;

/**
 * 
 * This class implements the CommitteeBatchCorrespondence business object.
 */
public class CommitteeBatchCorrespondence extends CommitteeBatchCorrespondenceBase {


    private static final long serialVersionUID = 7368044642475233153L;

    
    public CommitteeBatchCorrespondence() {
        super();
    }
    
    
    public CommitteeBatchCorrespondence(String batchCorrespondenceTypeCode, String committeeId, Date startDate, Date endDate) {
        super(batchCorrespondenceTypeCode, committeeId, startDate, endDate);
    }
}
