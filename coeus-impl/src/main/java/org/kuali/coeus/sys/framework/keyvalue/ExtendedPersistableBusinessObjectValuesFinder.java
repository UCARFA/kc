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
package org.kuali.coeus.sys.framework.keyvalue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.PersistableBusinessObjectValuesFinder;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class extends the PersistableBusinessObjectValuesFinder - the Generic ValuesFinder - 
 * to add a "select" entry.
 * 
 * <p>
 * It's a shame that rice is so tightly coupled to {@link PersistableBusinessObjectValuesFinder PersistableBusinessObjectValuesFinder}
 * It makes the design of these value finders very rigid.
 * </p>
 */
public class ExtendedPersistableBusinessObjectValuesFinder extends PersistableBusinessObjectValuesFinder {

    private static final Comparator<KeyValue> PBO_COMPARATOR = new PBOComparator();
    private static final ConcreteKeyValue SELECT_PREFIX = new ConcreteKeyValue(PrefixValuesFinder.getPrefixKey(), PrefixValuesFinder.getDefaultPrefixValue());
    private static final Log LOG = LogFactory.getLog(ExtendedPersistableBusinessObjectValuesFinder.class);

    private static class PBOComparator implements Comparator<KeyValue>
    {    
        @Override
        public int compare(KeyValue kv1, KeyValue kv2 )
        {    
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
            } catch (RuntimeException e) {
                LOG.error("Exception sorting KeyValues", e);
                return 0;
            }
        }
        
    }
    /**
     * Build the list of KeyValues using the key (keyAttributeName) and
     * label (labelAttributeName) of the list of all business objects found
     * for the BO class specified along with a "select" entry.
     */
    @Override
    public List<KeyValue> getKeyValues(){
        final List<KeyValue> labels = super.getKeyValues();
        labels.sort(PBO_COMPARATOR);
        labels.add(0, SELECT_PREFIX);
        return labels;
    }
}
