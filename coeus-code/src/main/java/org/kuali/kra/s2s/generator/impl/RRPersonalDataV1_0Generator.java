/*
 * Copyright 2005-2014 The Kuali Foundation.
 * 
 * Licensed under the Educational Community License, Version 1.0 (the "License");
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
package org.kuali.kra.s2s.generator.impl;

import gov.grants.apply.forms.rrPersonalDataV10.DirectorType;
import gov.grants.apply.forms.rrPersonalDataV10.RRPersonalDataDocument;
import gov.grants.apply.forms.rrPersonalDataV10.RRPersonalDataDocument.RRPersonalData;
import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.propdev.api.person.ProposalPersonContract;
import org.kuali.coeus.propdev.api.core.ProposalDevelopmentDocumentContract;
import org.kuali.kra.s2s.generator.FormGenerator;
import org.kuali.kra.s2s.util.S2SConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for generating the XML object for grants.gov RRPersonalDataV1.0. Form is generated using XMLBean classes and is based on
 * RRPersonalData schema.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
@FormGenerator("RRPersonalDataV1_0Generator")
public class RRPersonalDataV1_0Generator extends RRPersonalDataBaseGenerator {


    /**
     * 
     * This method gives the personal information of ProjectDirector and CoProjectDirector
     * 
     * @return rrPersonalDataDocument {@link XmlObject} of type RRPersonalDataDocument.
     */
    private RRPersonalDataDocument getRRPersonalData() {
        RRPersonalDataDocument rrPersonalDataDocument = RRPersonalDataDocument.Factory.newInstance();
        RRPersonalData rrPersonalData = RRPersonalData.Factory.newInstance();
        rrPersonalData.setFormVersion(S2SConstants.FORMVERSION_1_0);
        rrPersonalData.setProjectDirector(getProjectDirectorType());
        rrPersonalData.setCoProjectDirectorArray(getCoProjectDirectoryType());
        rrPersonalDataDocument.setRRPersonalData(rrPersonalData);
        return rrPersonalDataDocument;
    }

    /**
     * 
     * This method is used to get Personal details of Principal Investigator
     * 
     * @return DirectorType principal investigator details.
     */
    private DirectorType getProjectDirectorType() {

        DirectorType directorType = DirectorType.Factory.newInstance();
        ProposalPersonContract PI = s2sUtilService.getPrincipalInvestigator(pdDoc);
        if (PI != null) {
            directorType.setName(globLibV10Generator.getHumanNameDataType(PI));
        }
        return directorType;
    }

    /**
     * 
     * This method is used to get List of Personal details of Co-Investigator
     * 
     * @return DirectorType[] Array of director types.
     */
    private DirectorType[] getCoProjectDirectoryType() {
        DirectorType[] directorTypes = new DirectorType[0];
        List<DirectorType> directorTypeList = new ArrayList<DirectorType>();
        if (pdDoc.getDevelopmentProposal().getProposalPersons() != null) {
            ProposalPersonContract CoPI = null;
            for (ProposalPersonContract proposalPerson : pdDoc.getDevelopmentProposal().getProposalPersons()) {
                DirectorType coDirectorType = DirectorType.Factory.newInstance();
                if (proposalPerson.getProposalPersonRoleId() != null) {
                    if (KEYPERSON_TYPE_C0_INVESTIGATOR.equals(proposalPerson.getProposalPersonRoleId())) {
                        CoPI = proposalPerson;
                        coDirectorType.setName(globLibV10Generator.getHumanNameDataType(CoPI));
                        directorTypeList.add(coDirectorType);
                    }
                }
            }
        }
        directorTypes = directorTypeList.toArray(directorTypes);
        return directorTypes;
    }

    /**
     * This method creates {@link XmlObject} of type {@link RRPersonalDataDocument} by populating data from the given
     * {@link ProposalDevelopmentDocumentContract}
     * 
     * @param ProposalDevelopmentDocumentContract for which the {@link XmlObject} needs to be created
     * @return {@link XmlObject} which is generated using the given {@link ProposalDevelopmentDocumentContract}
     * @see org.kuali.kra.s2s.generator.S2SFormGenerator#getFormObject(ProposalDevelopmentDocumentContract)
     */
    public XmlObject getFormObject(ProposalDevelopmentDocumentContract ProposalDevelopmentDocumentContract) {
        this.pdDoc = ProposalDevelopmentDocumentContract;
        return getRRPersonalData();
    }

}
