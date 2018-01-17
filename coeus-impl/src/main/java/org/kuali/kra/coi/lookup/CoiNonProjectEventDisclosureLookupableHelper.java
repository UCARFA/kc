/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.CoiDisclosureEventType;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class CoiNonProjectEventDisclosureLookupableHelper extends CoiDisclosureLookupableHelperBase {


    private static final long serialVersionUID = -8145799265576572663L;

    @Override
    public List<? extends BusinessObject> getLookupSpecificSearchResults(Map<String, String> fieldValues) {
        List<CoiDisclosure> allDisclosures = (List<CoiDisclosure>) super.getResults(fieldValues);
        List<CoiDisclosure> nonProjectEventDisclosures = new ArrayList<CoiDisclosure>();
        //exclude annual, update, manual award, ip and protocol and award, ip and protocol event based disclosures
        for (CoiDisclosure disclosure : allDisclosures) {
            if (!(disclosure.isAnnualEvent() || disclosure.isUpdateEvent() || disclosure.isNonManualProjectEvent()
                   || isManualProjectEvent(disclosure)) && disclosure.isSubmitted()) {
                nonProjectEventDisclosures.add(disclosure);
            }
        }
        return nonProjectEventDisclosures;
    }

    protected boolean isManualProjectEvent(CoiDisclosure disclosure) {
        if (StringUtils.equalsIgnoreCase(CoiDisclosureEventType.MANUAL_AWARD, disclosure.getEventTypeCode()) ||
           StringUtils.equalsIgnoreCase(CoiDisclosureEventType.MANUAL_DEVELOPMENT_PROPOSAL, disclosure.getEventTypeCode()) ||
           StringUtils.equalsIgnoreCase(CoiDisclosureEventType.MANUAL_IRB_PROTOCOL, disclosure.getEventTypeCode())) {
            return true;
        }
        return false;
    }
}
