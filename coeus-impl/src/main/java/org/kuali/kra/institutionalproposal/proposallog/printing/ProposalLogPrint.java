/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.proposallog.printing;

import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.util.PrintingUtils;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.institutionalproposal.proposallog.service.ProposalLogPrintingService;

import javax.xml.transform.Source;
import java.util.List;

/**
 * This class provides the implementation for printing Print Certification
 * Report. It generates XML that conforms with Certification Report XSD, fetches
 * XSL style-sheets applicable to this XML, returns XML and XSL for any consumer
 * that would use this XML and XSls for any purpose like report generation, PDF
 * streaming etc.
 * 
 */
public class ProposalLogPrint extends AbstractPrint {

    @Override
	public List<Source> getXSLTemplates() {
		List<Source> sourceList = PrintingUtils
				.getXSLTforReport(ProposalLogPrintingService.PROPOSAL_LOG_REPORT_TYPE);
		return sourceList;
	}

    @Override
    public KcPersistableBusinessObjectBase getPrintableBusinessObject() {
        return null;
    }

}
