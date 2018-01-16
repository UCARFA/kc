/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.proposallog.service;

import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.kra.institutionalproposal.proposallog.ProposalLog;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;

public interface ProposalLogPrintingService {

    public final static String PROPOSAL_LOG_REPORT_TYPE = "Proposal Log Report";
    public final static String PROPOSAL_LOG_KEY = "proposalLogToPrint";
    
    /**
     * 
     * Print proposal log report
     * @param proposalLogNumber
     * @return
     * @throws PrintingException
     */
    public AttachmentDataSource printProposalLog(String proposalLogNumber) throws PrintingException;
    
    /**
     * 
     * Print proposal log report
     * @param log
     * @return
     * @throws PrintingException 
     */
    public AttachmentDataSource printProposalLog(ProposalLog log) throws PrintingException;
}
