/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.instprop.impl.api.service;

import org.kuali.coeus.instprop.impl.api.dto.InstitutionalProposalDto;
import org.kuali.coeus.instprop.impl.api.dto.IpPersonDto;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPerson;
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.rice.kew.api.exception.WorkflowException;

import java.util.*;

public interface InstitutionalProposalApiService {

    public void addCustomData(InstitutionalProposal institutionalProposal, InstitutionalProposalDto institutionalProposalDto);

    public InstitutionalProposalDocument saveInitialProposal(InstitutionalProposal proposal, String description) throws WorkflowException;

    public void updateProposalLog(String proposalLogNumber, InstitutionalProposalDocument ipDocument);

    public String createProposalLog(InstitutionalProposalDto ipDto, IpPersonDto pi);

    public void addPersons(InstitutionalProposalDocument proposalDocument, List<IpPersonDto> personDtos);

    public InstitutionalProposalPerson addPerson(InstitutionalProposalDocument proposalDocument, IpPersonDto personDto);

    public ArrayList<LinkedHashMap> getProposalPersons(ArrayList<LinkedHashMap> persons, String roleCode);

    public void addRequiredFields(InstitutionalProposal proposal, InstitutionalProposalDocument ipDocument, String proposalNumber);

    public void initializeCostTotals(InstitutionalProposal proposal);

    public void updateDataObjectFromDto(Object existingDataObject, Object input);

    public void initializeData(InstitutionalProposal proposal);

    public void initializeCollections(InstitutionalProposal proposal);

    }
