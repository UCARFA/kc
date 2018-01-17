/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup;

import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class CoiAnnualEventDisclosureLookupableHelper extends CoiDisclosureLookupableHelperBase {


    private static final long serialVersionUID = 1985148959992419923L;

    @Override
    public List<? extends BusinessObject> getLookupSpecificSearchResults(Map<String, String> fieldValues) {
        List<CoiDisclosure> allDisclosures = (List<CoiDisclosure>) super.getResults(fieldValues);
        List<CoiDisclosure> annualEventDisclosures = new ArrayList<CoiDisclosure>();
        for (CoiDisclosure disclosure : allDisclosures) {
            if (disclosure.isAnnualEvent() && disclosure.isSubmitted()) {
                annualEventDisclosures.add(disclosure);
            }
        }
        return annualEventDisclosures;
    }

    
}
