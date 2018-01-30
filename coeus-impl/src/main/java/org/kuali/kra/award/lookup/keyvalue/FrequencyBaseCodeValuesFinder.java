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
import org.kuali.kra.award.paymentreports.FrequencyBase;
import org.kuali.kra.award.paymentreports.ValidFrequencyBase;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTrackingConstants;
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
public class FrequencyBaseCodeValuesFinder extends UifKeyValuesFinderBase {

    private static final Comparator<KeyValue> COMPARATOR = new FrequenceBaseComparator();

    private String frequencyCode;
    private KeyValuesService keyValuesService;

    public FrequencyBaseCodeValuesFinder() {
        super();
    }

    /**
     * 
     * Constructs a CopyOfFrequencyBaseCodeValuesFinder.java.
     * 
     * @param frequencyCode
     */
    public FrequencyBaseCodeValuesFinder(String frequencyCode) {
        super();
        this.frequencyCode = frequencyCode;
    }

    /**
     * Constructs the list of Frequency Bases. Each entry in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * frequency base code and the "value" is the textual description that is viewed by a user.
     * 
     * @return the list of &lt;key, value&gt; pairs of abstract types. The first entry is always &lt;"", "select:"&gt;.
     *
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        if (getFrequencyCode() != null) {
            keyValues.addAll(getKeyValues(getValidFrequencyBaseCodes()));
        }
        return keyValues;
    }

    protected List<String> getValidFrequencyBaseCodes() {
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(ReportTrackingConstants.FREQUENCY_CODE, getFrequencyCode());
        return getKeyValuesService().findMatching(ValidFrequencyBase.class, criteria).stream()
                .map(ValidFrequencyBase::getFrequencyBaseCode)
                .collect(Collectors.toList());
    }

    protected List<KeyValue> getKeyValues(List<String> validFrequencyBaseCodes) {
        return CollectionUtils.isEmpty(validFrequencyBaseCodes) ? Collections.emptyList() :
                getKeyValuesService().findMatching(FrequencyBase.class, Collections.singletonMap(ReportTrackingConstants.FREQUENCY_BASE_CODE, validFrequencyBaseCodes))
                        .stream()
                        .map(freqBase -> new ConcreteKeyValue(freqBase.getFrequencyBaseCode(), freqBase.getDescription()))
                        .sorted(COMPARATOR)
                        .collect(Collectors.toList());
    }

    public String getFrequencyCode() {
        return frequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
    }

    /**
     * Wrapper method for retrieval of KeyValuesService.
     * 
     * @return
     */
    protected KeyValuesService getKeyValuesService() {
        if (keyValuesService == null) {
            keyValuesService = KcServiceLocator.getService("keyValuesService");
        }
        return keyValuesService;
    }
    
    /**
     * 
     * This class does the comparator for the FrequencyBase object.
     */
    static class FrequenceBaseComparator implements Comparator<KeyValue> {
        /**
         * 
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
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
