/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.lookup.keyvalue;

import org.kuali.coeus.common.committee.impl.bo.CommitteeType;
import org.kuali.coeus.common.committee.impl.lookup.keyvalue.CommitteeIdByUnitValuesFinderServiceImplBase;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;

public class IacucCommitteeIdByUnitValuesFinderServiceImpl extends CommitteeIdByUnitValuesFinderServiceImplBase<IacucCommittee> implements IacucCommitteeIdByUnitValuesFinderService {

    @Override
    protected String getCommitteeTypeCodeHook() {
        return CommitteeType.IACUC_TYPE_CODE;
    }

    @Override
    protected Class<IacucCommittee> getCommitteeBOClassHook() {
        return IacucCommittee.class;
    }

    @Override
    protected String getAssignCommitteePermissionNamespaceHook() {
        return Constants.MODULE_NAMESPACE_IACUC;
    }

    @Override
    protected String getAssignCommitteePermissionNameHook() {
        return PermissionConstants.ASSIGN_IACUC_COMMITTEE;
    }
}
