/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.award.paymentreports.Frequency;
import org.kuali.kra.award.paymentreports.ValidClassReportFrequency;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * This class is a values finder for <code>Frequency</code> business object.
 */
public class FrequencyCodeValuesFinder extends UifKeyValuesFinderBase {

    private static final Comparator<KeyValue> COMPARATOR = new FrequenceComparator();

    private String reportClassCode;
    private String reportCode;
    private KeyValuesService keyValuesService;

    public FrequencyCodeValuesFinder() {
        super();
    }
    
    /**
     * 
     * Constructs a FrequencyCodeValuesFinder.java.
     * @param reportClassCode
     * @param reportCode
     */
    public FrequencyCodeValuesFinder(String reportClassCode, String reportCode) {
        super();
        this.reportClassCode = reportClassCode;
        this.reportCode = reportCode;
    }
    
    /**
     * Constructs the list of Reports.  Each entry
     * in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * frequency code and the "value" is the textual description that is viewed
     * by a user. 
     * 
     * @return the list of &lt;key, value&gt; pairs of abstract types.  The first entry
     * is always &lt;"", "select"&gt;.
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        if (getReportClassCode() != null && getReportCode() != null) {
            keyValues.addAll(getKeyValues(getValidFrequencyCodes()));
        }
        return keyValues;
    }

    protected List<String> getValidFrequencyCodes() {
        Map<String, Object> criteria = new HashMap<>();
        criteria.put("reportClassCode", getReportClassCode());
        criteria.put("reportCode", getReportCode());
        return getKeyValuesService().findMatching(ValidClassReportFrequency.class, criteria).stream()
                .map(ValidClassReportFrequency::getFrequencyCode)
                .collect(Collectors.toList());
    }

    protected List<KeyValue> getKeyValues(List<String> validFrequencyCodes) {
        return getKeyValuesService().findMatching(Frequency.class, Collections.singletonMap("frequencyCode", validFrequencyCodes))
                .stream()
                .map(frequency -> new ConcreteKeyValue(frequency.getFrequencyCode(), frequency.getDescription()))
                .sorted(COMPARATOR)
                .collect(Collectors.toList());
    }

    public String getReportClassCode() {
        return reportClassCode;
    }

    public void setReportClassCode(String reportClassCode) {
        this.reportClassCode = reportClassCode;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }    
    
    /**
     * 
     * Wrapper method for retrieval of KeyValuesService
     * @return
     */
    protected KeyValuesService getKeyValuesService(){
        if(keyValuesService == null){
            keyValuesService = KcServiceLocator.getService(KeyValuesService.class);
        }
        return keyValuesService;
    }
    
    static class FrequenceComparator implements Comparator<KeyValue> {
        @Override
        public int compare(KeyValue kv1, KeyValue kv2 )
        {    
            try
            {
                String desc1 = kv1.getValue();
                String desc2 = kv2.getValue();
                if (desc1 == null)
                {
                    desc1 = "";
                }
                if (desc2 == null)
                {
                    desc2 = "";
                }
                return desc1.compareTo(desc2);  
            }
            catch (Exception e)
            {
                return 0;
            }
        }
        
    }
}
