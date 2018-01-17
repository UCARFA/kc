/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.compliance.exemption;

import org.kuali.coeus.sys.framework.keyvalue.SortedValuesFinder;
import org.kuali.coeus.common.framework.compliance.exemption.ExemptionType;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesFinder;
import org.kuali.rice.krad.keyvalues.PersistableBusinessObjectValuesFinder;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * See {@link #getKeyValues()}.
 */
public class SpecialReviewExemptionValuesFinder extends UifKeyValuesFinderBase {

    private final KeyValuesFinder finder;
    
    /**
     * Creates the ProtocolSpecialReviewValuesFinder setting any internal dependencies to defaults.
     */
    public SpecialReviewExemptionValuesFinder() {
        PersistableBusinessObjectValuesFinder boFinder = new PersistableBusinessObjectValuesFinder();
        boFinder.setBusinessObjectClass(ExemptionType.class);
        boFinder.setKeyAttributeName("code");
        boFinder.setLabelAttributeName("description");
        
        this.finder = new SortedValuesFinder(boFinder);
    }
    
    /**
     * Creates the ProtocolSpecialReviewValuesFinder setting the wrapped finder.
     * @param finder The finder
     * @throws NullPointerException if the finder is null
     */
    SpecialReviewExemptionValuesFinder(final KeyValuesFinder finder) {
        if (finder == null) {
            throw new NullPointerException("the finder is null");
        }
        
        this.finder = finder;
    }
    
    /**
     * Gets the keyvalue pair for {@link ExemptionType ExemptionType}.
     * The key is the exemptionTypeCode and the value is the description.
     * @return a list of {@link KeyValue KeyValue}
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyPair = new ArrayList<KeyValue>();
        keyPair.add(new ConcreteKeyValue("", ""));
        keyPair.addAll(finder.getKeyValues());
        return keyPair;
    }
}

