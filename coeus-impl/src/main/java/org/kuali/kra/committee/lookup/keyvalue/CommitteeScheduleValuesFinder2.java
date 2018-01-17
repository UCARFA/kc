/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.lookup.keyvalue;

import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.committee.service.CommitteeService;
import org.kuali.kra.irb.ProtocolForm;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.List;

/**
 * Finds the available set of dates where a protocol can be scheduled
 * for a review by a committee.  This values finder is almost exactly 
 * the same as CommitteeScheduleValuesFinder, except that the committee
 * information comes from the AssignCmtSchedBean.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class CommitteeScheduleValuesFinder2 extends FormViewAwareUifKeyValuesFinderBase {
    
    /**
     * @return the list of &lt;key, value&gt; pairs of committees.  The first entry
     * is always &lt;"", "select:"&gt;.
     */
    @Override
    public List<KeyValue> getKeyValues() {
        return getCommitteeService().getAvailableCommitteeDates(getCommitteeId());
    }
    
    /**
     * Get the Committee Service.
     * @return the Committee Service
     */
    private CommitteeService getCommitteeService() {
        return KcServiceLocator.getService(CommitteeService.class);
    }

    /**
     * Get the committee id.  Currently we are only concerned with
     * scheduling protocols.  The committee id is found in via the ProtocolForm.
     * Keep in mind that the user selects the committee via a drop-down and
     * thus the selected committee id is placed into the form.
     * @return
     */
    private String getCommitteeId() {
        String committeeId = "";
        Object form = getFormOrView();
        if (form instanceof ProtocolForm) {
            ProtocolForm protocolForm = (ProtocolForm) form;
            committeeId = protocolForm.getActionHelper().getAssignCmtSchedBean().getCommitteeId();
        }
        return committeeId;
    }
}
