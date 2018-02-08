/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.subaward;

import com.lowagie.text.pdf.PdfReader;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

public interface PropDevBudgetSubAwardService {

    void populateBudgetSubAwardFiles(Budget budget, BudgetSubAwards budgetSubAwards, String newFileName, byte[] newFileData);

    void populateBudgetSubAwardAttachments(Budget budget);

    void removeSubAwardAttachment(BudgetSubAwards subAward);
    
    void generateSubAwardLineItems(BudgetSubAwards subAward, ProposalDevelopmentBudgetExt budget);
    
    void prepareBudgetSubAwards(Budget budget);
    
    /**
     * Reads the XML from the PDF and parses out amounts from the budget periods. Returns true if the process succeeded, possibly with warnings.
     * Returns false if the process failed for any reason. The required list, errors, will be populated by a list of String arrays. Each array
     * will contain at least one string, the error key for the message. Any other Strings in the array should be considered message parameters 
     * for that error message.
     */
    void updateSubAwardBudgetDetails(Budget budget, BudgetSubAwards budgetSubAward, List<String[]> errors) throws Exception;

    byte[] getXMLFromPDF(PdfReader reader) throws IOException, XPathExpressionException;

    }
