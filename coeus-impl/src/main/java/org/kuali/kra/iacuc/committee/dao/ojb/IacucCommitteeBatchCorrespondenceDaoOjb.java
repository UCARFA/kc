/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.dao.ojb;

import org.kuali.coeus.common.committee.impl.dao.ojb.CommitteeBatchCorrespondenceDaoOjbBase;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeBatchCorrespondence;
import org.kuali.kra.iacuc.committee.dao.IacucCommitteeBatchCorrespondenceDao;

public class IacucCommitteeBatchCorrespondenceDaoOjb extends CommitteeBatchCorrespondenceDaoOjbBase<IacucCommitteeBatchCorrespondence> implements IacucCommitteeBatchCorrespondenceDao {

    @Override
    protected Class<IacucCommitteeBatchCorrespondence> getCommitteeBatchCorrespondenceBOClassHook() {
        return IacucCommitteeBatchCorrespondence.class;
    }

}
