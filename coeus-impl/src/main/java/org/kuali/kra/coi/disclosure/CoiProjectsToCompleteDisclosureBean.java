/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.irb.Protocol;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CoiProjectsToCompleteDisclosureBean implements Serializable {


    private static final long serialVersionUID = 7805100701232656867L;
    
    private String personId;
    private String personName;
    List<Award> awardsToDisclose;
    List<DevelopmentProposal> devProposalsToDisclose;
    List<InstitutionalProposal> instituteProposalsToDisclose;
    List<Protocol> irbProtocolsToDisclose;
    List<IacucProtocol> iacucProtocolsToDisclose;
    
    public CoiProjectsToCompleteDisclosureBean() {
        setAwardsToDisclose(new ArrayList<Award>());
        setDevProposalsToDisclose(new ArrayList<DevelopmentProposal>());
        setInstituteProposalsToDisclose(new ArrayList<InstitutionalProposal>());
        setIrbProtocolsToDisclose(new ArrayList<Protocol>());
        setIacucProtocolsToDisclose(new ArrayList<IacucProtocol>());
    }

    public List<Award> getAwardsToDisclose() {
        return awardsToDisclose;
    }

    public void setAwardsToDisclose(List<Award> awardsToDisclose) {
        this.awardsToDisclose = awardsToDisclose;
    }

    public List<DevelopmentProposal> getDevProposalsToDisclose() {
        return devProposalsToDisclose;
    }

    public void setDevProposalsToDisclose(List<DevelopmentProposal> devProposalsToDisclose) {
        this.devProposalsToDisclose = devProposalsToDisclose;
    }

    public List<InstitutionalProposal> getInstituteProposalsToDisclose() {
        return instituteProposalsToDisclose;
    }

    public void setInstituteProposalsToDisclose(List<InstitutionalProposal> instituteProposalsToDisclose) {
        this.instituteProposalsToDisclose = instituteProposalsToDisclose;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public List<Protocol> getIrbProtocolsToDisclose() {
        return irbProtocolsToDisclose;
    }

    public void setIrbProtocolsToDisclose(List<Protocol> irbProtocolsToDisclose) {
        this.irbProtocolsToDisclose = irbProtocolsToDisclose;
    }

    public List<IacucProtocol> getIacucProtocolsToDisclose() {
        return iacucProtocolsToDisclose;
    }

    public void setIacucProtocolsToDisclose(List<IacucProtocol> iacucProtocolsToDisclose) {
        this.iacucProtocolsToDisclose = iacucProtocolsToDisclose;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
    
    

}
