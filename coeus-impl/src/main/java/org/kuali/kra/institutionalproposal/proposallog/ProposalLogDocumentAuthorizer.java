/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.proposallog;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.kns.document.authorization.MaintenanceDocumentAuthorizer;
import org.kuali.rice.kns.document.authorization.MaintenanceDocumentAuthorizerBase;

import java.util.Map;

public class ProposalLogDocumentAuthorizer extends MaintenanceDocumentAuthorizerBase implements MaintenanceDocumentAuthorizer {
    
    @Override
    protected void addRoleQualification(Object primaryBusinessObjectOrDocument, Map<String, String> attributes) {
        super.addRoleQualification(primaryBusinessObjectOrDocument, attributes);
        ProposalLog proposalLog;
        if (primaryBusinessObjectOrDocument instanceof MaintenanceDocument) {
            MaintenanceDocument maintenanceDocument = (MaintenanceDocument) primaryBusinessObjectOrDocument;
            proposalLog = (ProposalLog) maintenanceDocument.getDocumentBusinessObject();
        } else {
            proposalLog = (ProposalLog) primaryBusinessObjectOrDocument;
        }
        
        if (!StringUtils.isBlank(proposalLog.getLeadUnit()) && proposalLog.isPersisted()) {
            attributes.put(KcKimAttributes.UNIT_NUMBER, proposalLog.getLeadUnit());
        } else {
            attributes.put(KcKimAttributes.UNIT_NUMBER, "*");
        }
        attributes.put("piId", proposalLog.getPiId());
    }
    
    @Override
    public boolean canInitiate(String documentTypeName, Person user) {
        boolean retVal = this.isAuthorized(new ProposalLog(), Constants.INSTITUTIONAL_PROPOSAL_NAMESPACE,  "Create Proposal Log", user.getPrincipalId());        
        return retVal;
    }   
    
    public boolean canOpen(ProposalLog proposalLog, Person user) {
    	return isAuthorized(proposalLog, Constants.INSTITUTIONAL_PROPOSAL_NAMESPACE, "Open Proposal Log", user.getPrincipalId());
    }
}
