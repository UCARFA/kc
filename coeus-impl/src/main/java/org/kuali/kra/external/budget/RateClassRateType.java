/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.budget;

public class RateClassRateType {
    String rateClass;
    String rateType;

    public RateClassRateType(String rateClass, String rateType) {
        this.rateClass = rateClass;
        this.rateType = rateType;
    }
    
    public String getRateClass() {
        return rateClass;
    }
    public void setRateClass(String rateClass) {
        this.rateClass = rateClass;
    }
    
    public String getRateType() {
        return rateType;
    }
    
    public void setRateType(String rateType) {
        this.rateType = rateType;
    }
    
    @Override
    public int hashCode() {
        final int multiplier = 23;
        int code = 133;
        code = multiplier * code + ((rateType == null) ? 0 : rateType.hashCode());
        code = multiplier * code + ((rateClass == null) ? 0 : rateClass.hashCode());
       
        return code;
    }
    
    @Override
    public boolean equals(Object o) {
        RateClassRateType current = (RateClassRateType) o;
        if (this == current) return true;
        if (current == null) return false;
        if (this.getClass() != current.getClass()) return false;
        if (current.rateClass.equals(rateClass) && current.rateType.equals(rateType)) {
            return true;
        } 
        return false;
    }
    
    
}
