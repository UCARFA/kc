/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.apache.commons.collections4.CollectionUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.award.paymentreports.Report;
import org.kuali.kra.award.paymentreports.ValidClassReportFrequency;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTrackingConstants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * This class is a values finder for <code>Report</code> business object.
 */
public class ReportCodeValuesFinder extends UifKeyValuesFinderBase {

    private static final Comparator<KeyValue> COMPARATOR = new ReportCodeComparator();

    KeyValuesService keyValuesService;
    private String reportClassCode;

    public ReportCodeValuesFinder() {
        
    }
    
    /**
     * 
     * Constructs a ReportCodeValuesFinder.java.
     * @param reportClassCode
     */
    public ReportCodeValuesFinder(String reportClassCode){
        this.reportClassCode=reportClassCode;
    }
    
    /**
     * Constructs the list of Reports.  Each entry
     * in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * report code and the "value" is the textual description that is viewed
     * by a user. 
     * 
     * @return the list of &lt;key, value&gt; pairs of abstract types.  The first entry
     * is always &lt;"", "select:"&gt;.
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        if (getReportClassCode() != null) {
            keyValues.addAll(getKeyValues(getValidReportCodes()));
        }
        return keyValues;
    }

    protected List<String> getValidReportCodes() {
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(ReportTrackingConstants.REPORT_CLASS_CODE, getReportClassCode());
        return getKeyValuesService().findMatching(ValidClassReportFrequency.class, criteria).stream()
                .map(ValidClassReportFrequency::getReportCode)
                .collect(Collectors.toList());
    }

    protected List<KeyValue> getKeyValues(List<String> validFrequencyCodes) {
        return CollectionUtils.isEmpty(validFrequencyCodes) ? Collections.emptyList() :
                getKeyValuesService().findMatching(Report.class, Collections.singletonMap(ReportTrackingConstants.REPORT_CODE, validFrequencyCodes))
                        .stream()
                        .map(this::createKeyValue)
                        .sorted(COMPARATOR)
                .collect(Collectors.toList());
    }

    protected KeyValue createKeyValue(Report report) {
        String description = report.getDescription();
        if (report.getFinalReportFlag()) {
            description = String.format("%s (Final Report)", description);
        }
        return new ConcreteKeyValue(report.getReportCode(), description);
    }
    
    public String getReportClassCode() {
        return reportClassCode;
    }

    public void setReportClassCode(String reportClassCode) {
        this.reportClassCode = reportClassCode;
    }

    protected KeyValuesService getKeyValuesService(){
        if(keyValuesService == null){
            keyValuesService = KcServiceLocator.getService(KeyValuesService.class);
        }
        return keyValuesService;
    }

    static class ReportCodeComparator implements Comparator<KeyValue> {
        @Override
        public int compare(KeyValue kv1, KeyValue kv2) {
            try {
                String desc1 = kv1.getValue();
                String desc2 = kv2.getValue();
                if (desc1 == null) {
                    desc1 = "";
                }
                if (desc2 == null) {
                    desc2 = "";
                }
                return desc1.compareTo(desc2);
            } catch (Exception e) {
                return 0;
            }
        }
    }
   
}
