/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.ynq;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.ynq.ProposalYnq;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;

import java.util.List;

public interface YnqService {
    /**
     * This method returns list of YNQ Explanation Types.
     * @return List of explanation types.
     */
    public List<YnqExplanationType> getYnqExplanationTypes();

    /**
     * This method returns list of YNQ - filter by question type.
     * @return List of questions.
     */
    public List<Ynq> getYnq(String questionType);

    /**
     * This method is used to populate questions.
     * 
     */
    public void populateProposalQuestions(List<ProposalYnq> proposalYnqs, List<YnqGroupName> ynqGroupNames, ProposalDevelopmentDocument document);
    
    public ProposalPerson getPersonYNQ(ProposalPerson proposalPerson, ProposalDevelopmentDocument document);

}
