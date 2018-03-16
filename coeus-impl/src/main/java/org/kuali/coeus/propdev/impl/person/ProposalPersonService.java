/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;

import java.util.List;

public interface ProposalPersonService {
    String getPersonName(ProposalDevelopmentDocument doc, String userId);

    List<ProposalPerson> getProposalKeyPersonnel(String proposalNumber);


    /**
     * This method is to get list of ProposalPersons by matching partial name.
     * Wildcards work as well.
     *
     * @param partialName String representing partial name from search screen
     */
    List<ProposalPerson> getProposalPersonsByPartialName(String partialName);
}
