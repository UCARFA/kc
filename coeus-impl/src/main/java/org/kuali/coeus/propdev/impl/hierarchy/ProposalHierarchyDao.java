/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.hierarchy;

import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.propdev.impl.person.ProposalPersonDegree;
import org.kuali.coeus.propdev.impl.state.ProposalState;

import java.util.List;


public interface ProposalHierarchyDao {
	List<DevelopmentProposal> getHierarchyChildProposals(String parentProposalNumber);
    List<String> getHierarchyChildProposalNumbers(String proposalNumber);
    boolean employeePersonInMultipleChildProposals(String personId, String hierarchyProposalNumber);
    boolean nonEmployeePersonInMultipleChildProposals(Integer rolodexId, String hierarchyProposalNumber);
    DevelopmentProposal getDevelopmentProposal(String proposalNumber);
    ProposalState getProposalState(String proposalNumber);
    List<ProposalPerson> isEmployeePersonOnProposal(String proposalNumber, String personId);
    List<ProposalPerson> isNonEmployeePersonOnProposal(String proposalNumber, Integer rolodexId);
    void deleteDegreeInfo(String proposalNumber, Integer proposalPersonNumber, ProposalPerson person);
    List<ProposalPersonDegree> getDegreeInformation(String proposalNumber, ProposalPerson person);
}
