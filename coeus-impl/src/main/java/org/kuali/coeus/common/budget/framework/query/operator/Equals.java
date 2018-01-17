/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.budget.framework.query.operator;


/** This class is a wrapper for equals operator ( == ).
 * Takes field and Comparable objects as parameters in the constructor and returs true
 * if the field of the Object object is equal to the Comparable object, else returns false.
 */

public class Equals extends RelationalOperator {
    
    /** creates a new Equals object.
     * @param fieldName field which has to be compared.
     * @param fixedData compare value.
     */  
    public  Equals(String fieldName, Comparable fixedData) {
        super(fieldName, fixedData);
    }
    
    /** creates a new Equals object.
     * Since Boolean object is not Comparable, use this constructor to check boolean values.
     * @param fieldName field which has to be compared.
     * @param booleanFixedData compare value.
     */  
    public  Equals(String fieldName, boolean booleanFixedData) {
        super(fieldName, booleanFixedData);
    }
    
    /** returns true if the field of the Object object is equal to the Comparable object/boolean data, else returns false.
     * @param baseBean Object
     * @return true if the field of the Object object is equal to the Comparable object/boolean data, else returns false.
     */ 
    @Override
    public boolean getResult(Object baseBean) {
        try{
            return compare(baseBean) == 0;
        }catch (Exception exception) {
            return false;
        }
    } // end getResult
    
    /**
     * returns the equality condition being checked using fieldName and fixedData
     * @return String - Equality condition
     */
    @Override
    public String toString() {
        if (! isBoolean) {
            return "( " + fieldName + " == " + fixedData + " )";
        } else {
            return "( " + fieldName + " == " + booleanFixedData + " )";
        }
    }
    
} // end Equals



