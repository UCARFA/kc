/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.auth;

import java.util.HashMap;
import java.util.Map;

import org.kuali.coeus.common.impl.workflow.KcPeopleFlowTypeServiceImpl;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.kew.api.document.Document;
import org.kuali.rice.kew.api.document.DocumentContent;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("proposalPeopleFlowTypeService")
public class ProposalPeopleFlowTypeServiceImpl extends KcPeopleFlowTypeServiceImpl {

	private static final String PROPOSAL_DOCUMENT_NUMBER = "proposalDocument.documentNumber";
	@Autowired
	@Qualifier("dataObjectService")
	private DataObjectService dataObjectService;
	
    @Override
    public Map<String, String> resolveRoleQualifiers(String kewTypeId, String roleId, Document document,
            DocumentContent documentContent) {
    	Map<String, String> qualifiers = new HashMap<>();
    	DevelopmentProposal proposal = getDataObjectService().findUnique(DevelopmentProposal.class, QueryByCriteria.Builder.forAttribute(PROPOSAL_DOCUMENT_NUMBER, document.getDocumentId()).build());
    	qualifiers.put(KcKimAttributes.PROPOSAL, proposal.getProposalNumber());
    	qualifiers.put(KcKimAttributes.DOCUMENT_NUMBER, document.getDocumentId());
    	return qualifiers;   
    }

	public DataObjectService getDataObjectService() {
		return dataObjectService;
	}

	public void setDataObjectService(DataObjectService dataObjectService) {
		this.dataObjectService = dataObjectService;
	}
	
}
