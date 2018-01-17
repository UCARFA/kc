/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.proposallog;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kns.web.struts.form.KualiMaintenanceForm;
import org.kuali.rice.krad.service.KeyValuesService;

import java.util.*;


public class ProposalLogStatusValuesFinder extends FormViewAwareUifKeyValuesFinderBase {

    /**
     * Returns valid status choices based on the current ProposalLog's Type.  Choices are selected as follows:<br />
     * Temporary:
     * <ul>
     * <li>Temporary</li>
     * <li>Void</li>
     * </ul>
     * Permanent (and Disclosure):
     * <ul>
     * <li>Pending</li>
     * <li>Void</li>
     * </ul>
     * When Disclosure type is implemented Permanent and Disclosure may need to be separated.
     * 
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> retval = new ArrayList<KeyValue>(); 
        KeyValuesService keyValuesService = (KeyValuesService) KcServiceLocator.getService("keyValuesService");
        Collection<ProposalLogStatus> statuses = keyValuesService.findAll(ProposalLogStatus.class);
        Set<String> validStatuses = new HashSet<String>();
        Object form = getFormOrView();
        retval.add(ValuesFinderUtils.getSelectOption());
        boolean filterResults = true;       
        if (form instanceof KualiMaintenanceForm) {
        	ProposalLog proposalLog = (ProposalLog)(((KualiMaintenanceForm)form).getDocument().getNoteTarget());
            
            if (proposalLog == null || proposalLog.getProposalLogType() == null) {
                filterResults = false;
            } else if (StringUtils.equalsIgnoreCase(proposalLog.getProposalLogType().getProposalLogTypeCode(), ProposalLogUtils.getProposalLogTemporaryTypeCode())) {
                // valid user choices are Temporary and Void
                validStatuses.add(ProposalLogUtils.getProposalLogTemporaryStatusCode());
                validStatuses.add(ProposalLogUtils.getProposalLogVoidStatusCode());
            } else {
                // valid user choices are Pending and Void
                validStatuses.add(ProposalLogUtils.getProposalLogPendingStatusCode());
                validStatuses.add(ProposalLogUtils.getProposalLogVoidStatusCode());
            }
            // when Disclosure Type is implemented, the above else might need to be separated into 2 different options
        } else {
        	filterResults = false;
        }       
        for (ProposalLogStatus status : statuses) {
            if (!filterResults || validStatuses.contains(status.getProposalLogStatusCode())) {
                retval.add(new ConcreteKeyValue(status.getProposalLogStatusCode(), status.getDescription()));
            }
        }
        return retval;
    }
}
