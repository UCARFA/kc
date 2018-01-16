/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions;

import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.kra.committee.service.CommitteeService;
import org.kuali.kra.protocol.actions.ProtocolActionsKeyValuesBase;

/**
 * 
 * This class should be extended by IRB  values finder classes.  It creates a single function to get a 
 * BusinessObjectService, so each class need not do that it self.
 */
public abstract class IrbActionsKeyValuesBase extends ProtocolActionsKeyValuesBase {

    private static final long serialVersionUID = 3859318308316835838L;

    @Override
    public CommitteeService getCommitteeService() {
        return (CommitteeService) super.getCommitteeService();
    }

    @Override
    protected Class<? extends CommitteeServiceBase> getCommitteeServiceClassHook() {
        return CommitteeService.class;
    }

}
