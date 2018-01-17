/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.service;

import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;
import org.kuali.rice.kew.api.exception.WorkflowException;

public interface TimeAndMoneyVersionService {
    
    public TimeAndMoneyDocument findOpenedTimeAndMoney(String awardNumber) throws WorkflowException;

    public void updateDocumentStatus(TimeAndMoneyDocument document, VersionStatus status);
    
    public String getCurrentTimeAndMoneyDocumentNumber(String awardNumber);
    
    public boolean validateCreateNewTimeAndMoneyDocument(String awardNumber);
}
