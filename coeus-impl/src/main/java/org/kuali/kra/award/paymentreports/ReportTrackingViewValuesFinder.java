/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.paymentreports.awardreports.reporting.service.ReportTrackingSearchViews;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;


/**
 * ReportTracking views values finder class.
 */
public class ReportTrackingViewValuesFinder extends UifKeyValuesFinderBase {
    
    private ReportTrackingSearchViews reportTrackingSearchViews;
   
    /**
     * Get the report regeneration types and use the name as the key in the label.
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> labels = new ArrayList<KeyValue>();
        for (int i = 0; i < getReportTrackingSearchViews().getReportTrackingViews().size(); i++) {
            labels.add(new ConcreteKeyValue(i+"", getReportTrackingSearchViews().getReportTrackingViews().get(i).getViewName()));
        }
        return labels;
    }

    protected ReportTrackingSearchViews getReportTrackingSearchViews() {
        if (reportTrackingSearchViews == null) {
            reportTrackingSearchViews = KcServiceLocator.getService(ReportTrackingSearchViews.class);
        }
        return reportTrackingSearchViews;
    }

    public void setReportTrackingSearchViews(ReportTrackingSearchViews reportTrackingSearchViews) {
        this.reportTrackingSearchViews = reportTrackingSearchViews;
    }
}
