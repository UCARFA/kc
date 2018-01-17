/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.print;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;

public class ProtocolActionPrintRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<ProtocolActionPrintEvent> {
    private static final String PROTOCOL_PRINT_TYPE_FIELD = "actionHelper.reportType";

    @Override
    public boolean processRules(ProtocolActionPrintEvent event) {
        
        boolean valid = true;
        
        if (!event.getFullReport() && !event.getSummaryReport() && !event.getHistoryReport() && !event.getReviewCommentsReport()) {
                reportError(PROTOCOL_PRINT_TYPE_FIELD, KeyConstants.ERROR_COMMITTEE_ACTION_PRINT_REPORT_NOT_SPECIFIED);
                valid = false;
        }
        
        return valid;
    }
}
