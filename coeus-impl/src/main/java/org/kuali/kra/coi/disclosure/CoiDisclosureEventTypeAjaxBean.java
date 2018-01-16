/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.kuali.kra.coi.CoiDisclosureEventType;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.List;

public class CoiDisclosureEventTypeAjaxBean {

    private CoiDisclosureEventType disclosureEventType;
    private List<KeyValue> keyValues;
    
    public CoiDisclosureEventType getDisclosureEventType() {
        return disclosureEventType;
    }
    public void setDisclosureEventType(CoiDisclosureEventType disclosureEventType) {
        this.disclosureEventType = disclosureEventType;
    }
    public List<KeyValue> getKeyValues() {
        return keyValues;
    }
    public void setKeyValues(List<KeyValue> keyValues) {
        this.keyValues = keyValues;
    }
}
