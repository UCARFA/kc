/*
 * Copyright 2005-2010 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.s2s.keycontacts;

import gov.grants.apply.forms.keyContactsV10.KeyContactsDocument;
import gov.grants.apply.forms.keyContactsV10.KeyContactsDocument.KeyContacts;
import gov.grants.apply.forms.keyContactsV10.KeyContactsDocument.KeyContacts.RoleOnProject;
import gov.grants.apply.system.globalLibraryV20.AddressDataType;
import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.api.org.OrganizationContract;
import org.kuali.coeus.common.api.org.OrganizationRepositoryService;
import org.kuali.coeus.propdev.api.core.ProposalDevelopmentDocumentContract;
import org.kuali.kra.s2s.S2SException;
import org.kuali.kra.s2s.generator.FormGenerator;
import org.kuali.kra.s2s.generator.S2SBaseFormGenerator;
import org.kuali.kra.s2s.generator.bo.DepartmentalPerson;
import org.kuali.kra.s2s.service.S2SUtilService;
import org.kuali.kra.s2s.util.S2SConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
@FormGenerator("KeyContactsV1_0Generator")
public class KeyContactsV1_0Generator extends S2SBaseFormGenerator {
    
    public static final String AUTHORIZED_REPRESENTATIVE = "auth";

    @Autowired
    @Qualifier("s2SUtilService")
    private S2SUtilService s2SUtilService;

    private OrganizationRepositoryService organizationRepositoryService;

    /**
     * 
     * This method returns KeycontContactsDocument object based on proposal development document which contains the KeycontContactsDocument information
     * for a particular proposal
     *      
     * @return KeyContactsDocument {@link XmlObject} of type KeyContactsDocument.
     */
    private KeyContactsDocument getKeyContactsDocument() {        
        KeyContactsDocument keycontContactsDocument = KeyContactsDocument.Factory.newInstance();
        keycontContactsDocument.setKeyContacts(getKeyContacts());
        return keycontContactsDocument;
    }   
    
    /**
     * 
     * This method gets KeyContacts information.
     *      
     * @return KeyContacts.
     */
    private KeyContacts getKeyContacts() {
        KeyContacts keyContacts = KeyContacts.Factory.newInstance();      
        keyContacts.setFormVersion(S2SConstants.FORMVERSION_1_0);
        
        List<RoleOnProject> roleOnProjectList = new ArrayList<RoleOnProject>();        
        setAuthorizedRepresentative(roleOnProjectList);        
        
        keyContacts.setRoleOnProjectArray(roleOnProjectList.toArray(new RoleOnProject[0]));
        if(pdDoc.getDevelopmentProposal().getOwnedByUnit() != null &&
                pdDoc.getDevelopmentProposal().getOwnedByUnit().getOrganizationId() != null) {

            final OrganizationContract organization = organizationRepositoryService.getOrganization(pdDoc.getDevelopmentProposal().getOwnedByUnit().getOrganizationId());
            keyContacts.setApplicantOrganizationName(organization.getOrganizationName());
        }        
        return keyContacts;
    }
    
    /**
     * 
     * This method sets Authorized Representative information.
     *  
     * @param roleOnProjectList (RoleOnProject).
     * @return RoleOnProject.
     */
    private void setAuthorizedRepresentative(List<RoleOnProject> roleOnProjectList) {
        RoleOnProject roleOnProject = null;
        DepartmentalPerson aorInfo = s2SUtilService.getDepartmentalPerson(pdDoc);
        if (aorInfo != null) {
            roleOnProject = RoleOnProject.Factory.newInstance();
            
            roleOnProject.setContactTitle(aorInfo.getPrimaryTitle());
            roleOnProject.setContactPhone(aorInfo.getOfficePhone());
            roleOnProject.setContactEmail(aorInfo.getEmailAddress());
            roleOnProject.setContactFax(aorInfo.getFaxNumber());
            roleOnProject.setContactName(globLibV20Generator.getHumanNameDataType(aorInfo));
            roleOnProject.setContactProjectRole(AUTHORIZED_REPRESENTATIVE);
            
            
            
            AddressDataType address = (AddressDataType) globLibV20Generator.getAddressDataType(aorInfo);
            roleOnProject.setContactAddress((gov.grants.apply.system.globalLibraryV20.AddressDataType) address);
        }
        if (roleOnProject != null) {
            roleOnProjectList.add(roleOnProject);
        }
    }

    @Override
    public XmlObject getFormObject(ProposalDevelopmentDocumentContract ProposalDevelopmentDocumentContract) throws S2SException {

        this.pdDoc = ProposalDevelopmentDocumentContract;
        return getKeyContactsDocument();
    }

    public S2SUtilService getS2SUtilService() {
        return s2SUtilService;
    }

    public void setS2SUtilService(S2SUtilService s2SUtilService) {
        this.s2SUtilService = s2SUtilService;
    }

    public OrganizationRepositoryService getOrganizationRepositoryService() {
        return organizationRepositoryService;
    }

    public void setOrganizationRepositoryService(OrganizationRepositoryService organizationRepositoryService) {
        this.organizationRepositoryService = organizationRepositoryService;
    }
}
