/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.personnel;

import org.kuali.coeus.common.framework.auth.perm.KcAuthorizationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.RoleConstants;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.personnel.*;


public class ProtocolPersonnelServiceImpl extends ProtocolPersonnelServiceImplBase implements ProtocolPersonnelService {
    
    @Override
    protected ProtocolUnitBase createNewProtocolUnitInstanceHook() {
        return new ProtocolUnit();
    }

    @Override
    protected String getSequenceNumberNameHook() {
        return "SEQ_PROTOCOL_ID";
    }

    @Override
    public Class<? extends ProtocolPersonRoleMappingBase> getProtocolPersonRoleMappingClassHook() {
        return ProtocolPersonRoleMapping.class;
    }

    @Override
    public Class<? extends ProtocolPersonRoleBase> getProtocolPersonRoleClassHook() {
        return ProtocolPersonRole.class;
    }

    @Override
    public void setPrincipalInvestigator(ProtocolPersonBase newPrincipalInvestigator, ProtocolBase protocol) {
        if (protocol != null) {
            ProtocolPerson currentPrincipalInvestigator = (ProtocolPerson) getPrincipalInvestigator(protocol.getProtocolPersons());
            
            if (newPrincipalInvestigator != null) {
                newPrincipalInvestigator.setProtocolPersonRoleId(getPrincipalInvestigatorRole());
                if (currentPrincipalInvestigator == null) {
                    protocol.getProtocolPersons().add(newPrincipalInvestigator);
                } else if (!isDuplicatePerson(protocol.getProtocolPersons(), newPrincipalInvestigator)) {
                    protocol.getProtocolPersons().remove(currentPrincipalInvestigator);
                    protocol.getProtocolPersons().add(newPrincipalInvestigator);
                }
                
                // Assign the PI the APPROVER role if PI has a personId (for doc cancel).
                if (newPrincipalInvestigator.getPersonId() != null && shouldPrincipalInvestigatorBeAddedToWorkflow()) {
                    personEditableService.populateContactFieldsFromPersonId(newPrincipalInvestigator);
                    KcAuthorizationService kraAuthService = KcServiceLocator.getService(KcAuthorizationService.class);
                    kraAuthService.addDocumentLevelRole(newPrincipalInvestigator.getPersonId(), RoleConstants.PROTOCOL_APPROVER, protocol);
                } else {
                    personEditableService.populateContactFieldsFromRolodexId(newPrincipalInvestigator);
                }
            }
        }
    }
    
    @Override
    public boolean shouldPrincipalInvestigatorBeAddedToWorkflow() {
    	return getParameterService().getParameterValueAsBoolean(ProtocolDocument.class, ASSIGN_PRINCIPAL_INVESTIGATOR_TO_WORKFLOW);
    }

	@Override
	protected boolean isDuplicatePersonAllowed() {
		return getParameterService().getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_IRB, Constants.PARAMETER_COMPONENT_DOCUMENT, Constants.IRB_PROTOCOL_DUPLICATE_PERSON_ENABLED);
	}
}
