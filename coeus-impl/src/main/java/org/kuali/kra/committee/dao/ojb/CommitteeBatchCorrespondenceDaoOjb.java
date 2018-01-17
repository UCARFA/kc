/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.dao.ojb;

import org.kuali.coeus.common.committee.impl.dao.ojb.CommitteeBatchCorrespondenceDaoOjbBase;
import org.kuali.kra.committee.bo.CommitteeBatchCorrespondence;
import org.kuali.kra.committee.dao.CommitteeBatchCorrespondenceDao;

/**
 * 
 * This class is the OJB implementation of CommitteeBatchCorrespondenceDao 
 * which provides enhanced database access functionality.
 */
public class CommitteeBatchCorrespondenceDaoOjb extends CommitteeBatchCorrespondenceDaoOjbBase<CommitteeBatchCorrespondence> implements CommitteeBatchCorrespondenceDao {

    @Override
    protected Class<CommitteeBatchCorrespondence> getCommitteeBatchCorrespondenceBOClassHook() {
        return CommitteeBatchCorrespondence.class;
    }
}
