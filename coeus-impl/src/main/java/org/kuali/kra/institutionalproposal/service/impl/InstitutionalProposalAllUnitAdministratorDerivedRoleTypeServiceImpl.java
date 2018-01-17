/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.framework.unit.admin.AbstractUnitAdministrator;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministrator;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPerson;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPersonUnit;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.service.InstitutionalProposalService;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.coeus.common.framework.unit.admin.AbstractUnitAdministratorDerivedRoleTypeService;
import org.kuali.rice.kim.framework.role.RoleTypeService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class InstitutionalProposalAllUnitAdministratorDerivedRoleTypeServiceImpl extends AbstractUnitAdministratorDerivedRoleTypeService
        implements RoleTypeService {

    private UnitService unitService;
    private InstitutionalProposalService institutionalProposalService;

    public void setUnitService(UnitService unitService) {
        this.unitService = unitService;
    }
    
    protected UnitService getUnitService() {
        return unitService;
    }
    
    @Override
    public List<? extends AbstractUnitAdministrator> getUnitAdministrators(Map<String, String> qualifiers) {
        String proposalId = qualifiers.get(KcKimAttributes.PROPOSAL);
        List<UnitAdministrator> result = new ArrayList<UnitAdministrator>();
        if (StringUtils.isNotBlank(proposalId)) {
            InstitutionalProposal proposal = getInstitutionalProposalService().getInstitutionalProposal(proposalId);
            HashSet<String> units = new HashSet<String>();
            for (InstitutionalProposalPerson person : proposal.getProjectPersons()) {
                for (InstitutionalProposalPersonUnit unit : person.getUnits()) {
                    units.add(unit.getUnitNumber());
                }
            }
        
            for (String unit : units) {
                if (StringUtils.isNotBlank(unit)) {
                    result.addAll(unitService.retrieveUnitAdministratorsByUnitNumber(unit));
                }
            }
        }   
        return result;
    }

    protected InstitutionalProposalService getInstitutionalProposalService() {
        return institutionalProposalService;
    }

    public void setInstitutionalProposalService(InstitutionalProposalService institutionalProposalService) {
        this.institutionalProposalService = institutionalProposalService;
    }

}
