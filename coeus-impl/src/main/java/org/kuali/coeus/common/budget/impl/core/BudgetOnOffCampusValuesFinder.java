/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.core;

import org.kuali.kra.infrastructure.OnOffCampusFlagConstants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

public class BudgetOnOffCampusValuesFinder extends UifKeyValuesFinderBase {
    
    /**
     * Constructs the list of Budget Fiscal Years.  Each entry
     * in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * status code and the "value" is the textual description that is viewed
     * by a user.
     * 
     * Until it's determined if the list should be obtained from a database,
     * the list will be canned, covering 2008 - 2010
     * 
     * @return the list of &lt;key, value&gt; pairs of abstract types.  The first entry
     * is always &lt;"", "select:"&gt;.
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> KeyValues = new ArrayList<KeyValue>();

        for (OnOffCampusFlagConstants onOffCampusFlagConstants : OnOffCampusFlagConstants.values()) {
            KeyValues.add(new ConcreteKeyValue(onOffCampusFlagConstants.getCode(), onOffCampusFlagConstants.getDescription()));
        }
        
        return KeyValues; 
    }
    
}
