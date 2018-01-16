/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.unit;

import org.kuali.coeus.common.framework.unit.Unit;

public interface UnitLookupDao {
    
    /**
     * This method finds the unit object whose number matches the argument <code>unitNumber</code>. The lookup logic is 
     * case insensitive i.e. the return value is the same irrespective of the case of the characters in the argument. 
     * @param unitNumber
     * @return the matching unit object or null if no match was found.
     */
    public Unit findUnitbyNumberCaseInsensitive(String unitNumber);
    
    /**
     * Return the top unit in the hierarchy, or the one with a NULL parent unit
     */
    public Unit getTopUnit();

}
