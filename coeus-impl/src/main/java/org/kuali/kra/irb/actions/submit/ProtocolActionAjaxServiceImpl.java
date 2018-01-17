/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.ProtocolActionAjaxServiceImplBase;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.HashMap;
import java.util.List;

public class ProtocolActionAjaxServiceImpl extends ProtocolActionAjaxServiceImplBase implements ProtocolActionAjaxService {
    

    @Override
    public String getReviewers(String protocolId, String committeeId, String scheduleId) {
        StringBuffer ajaxList = new StringBuffer();
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("protocolId", protocolId);
        Protocol protocol = (Protocol) (getBusinessObjectService().findMatching(Protocol.class, hm).toArray())[0];
        // filter out the protocol personnel; they cannot be reviewers on their own protocol
        List<CommitteeMembershipBase> filteredMembers = protocol.filterOutProtocolPersonnel(getCommitteeService().getAvailableMembers(
                committeeId, scheduleId));

        for (CommitteeMembershipBase filteredMember : filteredMembers) {
            if (StringUtils.isNotBlank(filteredMember.getPersonId())) {
                ajaxList.append(filteredMember.getPersonId() + ";" + filteredMember.getPersonName() + ";N;");
            } else {
                ajaxList.append(filteredMember.getRolodexId() + ";" + filteredMember.getPersonName() + ";Y;");
            }
        }
        return clipLastChar(ajaxList);
    }

    @Override
    public Class getProtocolReviewerTypeClassHook() {
        return ProtocolReviewerType.class;
    }

    @Override
    public Class<? extends ProtocolBase> getProtocolClassHook() {
        return Protocol.class;
    }

    @Override
    public String getValidCommitteeDates(String committeeId, String protocolNumber) {
        StringBuffer ajaxList = new StringBuffer();
        if (isAuthorizedToAccess(protocolNumber)) {
            List<KeyValue> dates = getCommitteeService().getAvailableCommitteeDates(committeeId);
            for (KeyValue date : dates) {
                ajaxList.append(date.getKey() + ";" + date.getValue() + ";");
            }
            return clipLastChar(ajaxList);
        }
        else {
            return ";Not Authorized;";
        }
    }


    
    /*
     * a utility method to check if dwr/ajax call really has authorization
     */
    private boolean isAuthorizedToAccess(String protocolNumber) {
        boolean isAuthorized = true;
        return isAuthorized;
    }
}
