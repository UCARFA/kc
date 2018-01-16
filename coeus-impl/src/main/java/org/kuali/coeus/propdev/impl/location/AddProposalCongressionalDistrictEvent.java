/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.location;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.krad.rules.rule.BusinessRule;

import java.util.List;

/**
 * This class represents the "add congressional district to a proposal site" event.
 */
public class AddProposalCongressionalDistrictEvent extends BasicProposalSiteEvent {
    private List<CongressionalDistrict> congressionalDistricts;
    private CongressionalDistrict congressionalDistrict;
    private String collectionId;
    private String collectionLabel;
    
    public AddProposalCongressionalDistrictEvent(ProposalDevelopmentDocument proposalDevelopmentDocument, List<CongressionalDistrict> congressionalDistricts, CongressionalDistrict congressionalDistrict,
    	String collectionId,String collectionLabel) {
        super(getEventDescription(proposalDevelopmentDocument),proposalDevelopmentDocument,congressionalDistricts);
        this.congressionalDistricts = congressionalDistricts;
        this.congressionalDistrict = congressionalDistrict;
        this.collectionId = collectionId;
        this.collectionLabel = collectionLabel;
    }

    private static String getEventDescription(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        return "adding congressional district to document " + getDocumentId(proposalDevelopmentDocument);
    }

    public List<CongressionalDistrict> getCongressionalDistricts() {
		return congressionalDistricts;
	}

	public CongressionalDistrict getCongressionalDistrict() {
		return congressionalDistrict;
	}

	public String getCollectionId() {
		return collectionId;
	}

	public String getCollectionLabel() {
		return collectionLabel;
	}

    @Override
    @SuppressWarnings("unchecked")
    public Class getRuleInterfaceClass() {
        return AddCongressionalDistrictRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddCongressionalDistrictRule)rule).processAddCongressionalDistrictRules(this);
    }
}
