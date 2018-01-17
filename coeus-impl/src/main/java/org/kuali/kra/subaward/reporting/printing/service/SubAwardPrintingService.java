/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.reporting.printing.service;

import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.kra.subaward.reporting.printing.SubAwardPrintType;
import org.kuali.kra.subaward.bo.SubAwardPrintAgreement;

import java.util.Map;

public interface SubAwardPrintingService {

    String SELECTED_TEMPLATES = "Selected Templates";
    
	AttachmentDataSource printSubAwardReport(
			KcPersistableBusinessObjectBase awardDocument, SubAwardPrintType subAwardPrintType,
			Map<String, Object> reportParameters) throws PrintingException;

	AttachmentDataSource printSubAwardFDPReport(SubAwardPrintAgreement agreement, SubAward subAward);

	boolean isPdf(byte[] data);
}
