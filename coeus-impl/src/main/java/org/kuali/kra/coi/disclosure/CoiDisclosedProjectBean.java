/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CoiDisclosedProjectBean implements Serializable {


    private static final long serialVersionUID = 7805100701232656867L;
    
    private boolean projectDisclosed;
    List<Award> disclosedAwards = new ArrayList<Award>();
    List<DevelopmentProposal> disclosedDevProposals = new ArrayList<DevelopmentProposal>();
    List<InstitutionalProposal> disclosedInstProposals = new ArrayList<InstitutionalProposal>();
    
    public CoiDisclosedProjectBean() {
        setDisclosedAwards(new ArrayList<Award>());
        setDisclosedDevProposals(new ArrayList<DevelopmentProposal>());
        setDisclosedInstProposals(new ArrayList<InstitutionalProposal>());
    }
    
    public boolean isProjectDisclosed() {
        return projectDisclosed;
    }
    public void setProjectDisclosed(boolean projectDisclosed) {
        this.projectDisclosed = projectDisclosed;
    }
    public List<Award> getDisclosedAwards() {
        return disclosedAwards;
    }
    public void setDisclosedAwards(List<Award> disclosedAwards) {
        this.disclosedAwards = disclosedAwards;
    }
    public List<DevelopmentProposal> getDisclosedDevProposals() {
        return disclosedDevProposals;
    }
    public void setDisclosedDevProposals(List<DevelopmentProposal> disclosedDevProposals) {
        this.disclosedDevProposals = disclosedDevProposals;
    }
    public List<InstitutionalProposal> getDisclosedInstProposals() {
        return disclosedInstProposals;
    }
    public void setDisclosedInstProposals(List<InstitutionalProposal> disclosedInstProposals) {
        this.disclosedInstProposals = disclosedInstProposals;
    }
    

}
