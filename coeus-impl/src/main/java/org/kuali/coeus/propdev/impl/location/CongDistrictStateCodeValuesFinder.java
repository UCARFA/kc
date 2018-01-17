/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.location;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.location.framework.state.StateValuesFinder;

import java.util.List;

public class CongDistrictStateCodeValuesFinder extends UifKeyValuesFinderBase {

    private String countryCode = "";

    @Override
    public List<KeyValue> getKeyValues() {
        StateValuesFinder svf = new StateValuesFinder();
        svf.setCountryCode(countryCode);

        List<KeyValue> labels = svf.getKeyValues();
        labels.add(1, new ConcreteKeyValue("US", "US"));
        labels.add(2, new ConcreteKeyValue("00", "00"));
        
        return labels;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
