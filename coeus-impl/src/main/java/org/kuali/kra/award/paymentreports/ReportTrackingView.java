/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports;

import java.util.ArrayList;
import java.util.List;

/**
 * Report tracking view non-persisted BO. This BO is created via Spring injection of the
 * ReportTrackingSearchViews class. This allows easy configuration of the supported views via
 * Spring.
 */
public class ReportTrackingView extends org.kuali.rice.krad.bo.BusinessObjectBase {

    private String viewName;
    private List<String> groupByCols;
    private List<String> groupByDisplayCols;
    private List<String> detailCols;

    public ReportTrackingView() {
        groupByCols = new ArrayList<String>();
        groupByDisplayCols = new ArrayList<String>();
        detailCols = new ArrayList<String>();
    }
    
    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public List<String> getGroupByCols() {
        return groupByCols;
    }

    public void setGroupByCols(List<String> groupByCols) {
        this.groupByCols = groupByCols;
    }

    public List<String> getDetailCols() {
        return detailCols;
    }

    public void setDetailCols(List<String> detailCols) {
        this.detailCols = detailCols;
    }

    @Override
    public void refresh() {

    }

    public List<String> getGroupByDisplayCols() {
        return groupByDisplayCols;
    }

    public void setGroupByDisplayCols(List<String> groupByDisplayCols) {
        this.groupByDisplayCols = groupByDisplayCols;
    }    
    
}
