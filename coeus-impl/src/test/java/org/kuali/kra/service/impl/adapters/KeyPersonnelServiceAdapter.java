/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl.adapters;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.common.framework.type.InvestigatorCreditType;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.propdev.impl.person.ProposalPersonUnit;
import org.kuali.coeus.propdev.impl.person.KeyPersonnelService;
import org.kuali.coeus.propdev.impl.person.creditsplit.ProposalCreditSplitListDto;
import org.kuali.coeus.propdev.impl.person.creditsplit.ProposalUnitCreditSplit;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class KeyPersonnelServiceAdapter implements KeyPersonnelService {
    @Override
    public void populateDocument(ProposalDevelopmentDocument document) {
        
    }
    @Override
    public void populateProposalPerson(ProposalPerson person, ProposalDevelopmentDocument document) {
        
    }
    @Override
    public Collection<InvestigatorCreditType> getInvestigatorCreditTypes() {
        return null;  
    }
    @Override
    public void addUnitToPerson(ProposalPerson person, ProposalPersonUnit unit) {
        
    }
    @Override
    public Map calculateCreditSplitTotals(ProposalDevelopmentDocument document) {
        return null;
    }

    @Override
    public ProposalPersonUnit createProposalPersonUnit(String unitId, ProposalPerson person) {
        return null;  
    }
    @Override
    public boolean isCreditSplitEnabled() {
        return false;  
    }
    @Override
    public void assignLeadUnit(ProposalPerson person, String unitNumber) {
        
    }

    @Override
    public void saveCertDetails(ProposalPerson person, String certifiedBy, Timestamp certifiedTime) {

    }

    @Override
    public void addProposalPerson(ProposalPerson proposalPerson, ProposalDevelopmentDocument document) {
        
    }
    @Override
    public List<ProposalCreditSplitListDto> createCreditSplitListItems(ProposalDevelopmentDocument document) {
        return null;
    }
    @Override
    public List<ProposalUnitCreditSplit> createCreditSplits(ProposalPersonUnit unit){
        return null;
    }

    @Override
    public void populateCreditSplit(ProposalDevelopmentDocument document) {}
    
}
