/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.lookup.keyvalue;

import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.protocol.ProtocolFormBase;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.List;

/**
 * Finds the available set of dates where a protocol can be scheduled
 * for a review by a committee.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public abstract class CommitteeScheduleValuesFinderBase extends FormViewAwareUifKeyValuesFinderBase {
    

    private static final long serialVersionUID = 1914558119859827942L;

    /**
     * @return the list of &lt;key, value&gt; pairs of committees.  The first entry
     * is always &lt;"", "select:"&gt;.
     */
    @Override
    public List<KeyValue> getKeyValues() {
        return getCommitteeService().getAvailableCommitteeDates(getCommitteeId());
    }
    
    /**
     * Get the CommitteeBase Service.
     * @return the CommitteeBase Service
     */
    private CommitteeServiceBase getCommitteeService() {
        return KcServiceLocator.getService(getCommitteeServiceClassHook());
    }

    protected abstract Class<? extends CommitteeServiceBase> getCommitteeServiceClassHook();

    /**
     * Get the committee id.  Currently we are only concerned with
     * scheduling protocols.  The committee id is found in via the ProtocolFormBase.
     * Keep in mind that the user selects the committee via a drop-down and
     * thus the selected committee id is placed into the form.
     * @return
     */
    private String getCommitteeId() {
        String committeeId = "";
        Object formOrView = getFormOrView();
        if (formOrView instanceof ProtocolFormBase) {
            ProtocolFormBase protocolForm = (ProtocolFormBase) formOrView;
            committeeId = protocolForm.getActionHelper().getProtocolSubmitAction().getCommitteeId();
        }
        return committeeId;
    }
}
