/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.lookup.keyvalue;

import org.kuali.coeus.common.committee.impl.bo.CommitteeType;
import org.kuali.coeus.common.committee.impl.lookup.keyvalue.CommitteeIdByUnitValuesFinderServiceImplBase;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;

public class IrbCommitteeIdByUnitValuesFinderServiceImpl extends CommitteeIdByUnitValuesFinderServiceImplBase<Committee> implements IrbCommitteeIdByUnitValuesFinderService {

    @Override
    protected String getCommitteeTypeCodeHook() {
        return CommitteeType.IRB_TYPE_CODE;
    }

    @Override
    protected Class<Committee> getCommitteeBOClassHook() {
        return Committee.class;
    }

    @Override
    protected String getAssignCommitteePermissionNamespaceHook() {
        return Constants.MODULE_NAMESPACE_IRB;
    }

    @Override
    protected String getAssignCommitteePermissionNameHook() {
        return PermissionConstants.ASSIGN_IRB_COMMITTEE;
    }

}
