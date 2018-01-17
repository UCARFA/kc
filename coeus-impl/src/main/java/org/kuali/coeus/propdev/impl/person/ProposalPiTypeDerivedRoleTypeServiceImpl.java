/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.person.PropAwardPersonRole;
import org.kuali.kra.bo.AbstractProjectPerson;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("proposalPiTypeDerivedRoleTypeService")
public class ProposalPiTypeDerivedRoleTypeServiceImpl extends ProposalPersonDerivedRoleTypeServiceImpl {

    @Autowired
    @Qualifier("proposalPersonService")
	private ProposalPersonService proposalPersonService;
    
    @Autowired
    @Qualifier("globalVariableService")
    private GlobalVariableService globalVariableService; 
	
	protected List<String> requiredAttributes = new ArrayList<String>();
	{
		requiredAttributes.add(KcKimAttributes.PROPOSAL);
	}

    @Override
    public ProposalPersonService getProposalPersonService() {
        return proposalPersonService;
    }

    @Override
    public void setProposalPersonService(ProposalPersonService proposalPersonService) {
        this.proposalPersonService = proposalPersonService;
    }

    @Override
    protected List<? extends AbstractProjectPerson> getProjectPersons(Map<String, String> qualification) {
    	 String principalId=getGlobalVariableService().getUserSession().getPrincipalId();  
        String proposalNumber = qualification.get(KcKimAttributes.PROPOSAL);
        if (StringUtils.isNotBlank(proposalNumber)) {
        	List<ProposalPerson> propPersons= getProposalPersonService().getProposalKeyPersonnel(proposalNumber);
        	List<AbstractProjectPerson> abstarctProjPersons=new ArrayList<AbstractProjectPerson>();
        	  for (ProposalPerson propPerson : propPersons) {
        	if (propPerson.getProposalPersonRoleId().equals(PropAwardPersonRole.PRINCIPAL_INVESTIGATOR)
	                 && StringUtils.equals(principalId, propPerson.getPersonId())){
        		abstarctProjPersons.add(propPerson);
        		
        	}}
        	return abstarctProjPersons;
        } 
        
        else {
            return new ArrayList<AbstractProjectPerson>();
        }
    }
  
    public GlobalVariableService getGlobalVariableService() {
		return globalVariableService;
	}

	public void setGlobalVariableService(GlobalVariableService globalVariableService) {
		this.globalVariableService = globalVariableService;
	}


}
