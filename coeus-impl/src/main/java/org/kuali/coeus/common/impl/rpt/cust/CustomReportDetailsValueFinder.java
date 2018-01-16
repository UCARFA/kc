/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.rpt.cust;

import org.kuali.coeus.common.impl.rpt.BirtReportService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

public class CustomReportDetailsValueFinder extends UifKeyValuesFinderBase {

    private static final long serialVersionUID = 1L;
    private BirtReportService birtReportService;
    private BirtReportService getBirtReportService() {
        if (birtReportService == null) {
            birtReportService = KcServiceLocator.getService(BirtReportService.class);
        }
        return birtReportService;
    }

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyLabels = new ArrayList<KeyValue>();
        keyLabels.add(new ConcreteKeyValue("0","select"));
        List<CustReportDetails> results = getBirtReportService().getReports();
        for (CustReportDetails custReportDetails : results) {
            keyLabels.add(new ConcreteKeyValue(custReportDetails.getReportId().toString() , custReportDetails.getReportLabel()));
        }            
        return keyLabels;
    }

}
