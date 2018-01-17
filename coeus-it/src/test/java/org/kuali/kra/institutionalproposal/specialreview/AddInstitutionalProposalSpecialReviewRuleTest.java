/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.specialreview;

import org.kuali.kra.common.specialreview.rules.AddSpecialReviewRuleTestBase;
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.util.GlobalVariables;

public class AddInstitutionalProposalSpecialReviewRuleTest extends AddSpecialReviewRuleTestBase<InstitutionalProposalSpecialReview> {

    @Override
    public Document getDocument() throws WorkflowException {
        GlobalVariables.setUserSession(new UserSession("quickstart"));
        Document document = KRADServiceLocatorWeb.getDocumentService().getNewDocument(InstitutionalProposalDocument.class);
        return document;
    }

    @Override
    public InstitutionalProposalSpecialReview getSpecialReview() {
        return new InstitutionalProposalSpecialReview();
    }

}
