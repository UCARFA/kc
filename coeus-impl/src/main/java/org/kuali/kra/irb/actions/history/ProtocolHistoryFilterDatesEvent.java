/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.history;


import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.rice.krad.document.Document;

import java.util.Date;

/**
 * Encapsulates the history filter event on the Protocol Actions panel.
 */
public class ProtocolHistoryFilterDatesEvent extends KcDocumentEventBaseExtension {
    
    private Date startDate;
    private Date endDate;

    /**
     * Constructs a ProtocolHistoryFilterDatesEvent.
     * @param document
     * @param startDate
     * @param endDate
     */
    public ProtocolHistoryFilterDatesEvent(Document document, Date startDate, Date endDate) {
        super("Filter protocol history", "", document);
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new ProtocolHistoryFilterDatesRule();
    }

}
