/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.budget.framework.query.operator;



/** This class is a wrapper for equals operator ( != ).
 * Takes field and Comparable objects as parameters in the constructor and returns true
 * if the field of the BaseBean object is not equal to the Comparable object, else returns false.
 */

public class NotEquals extends RelationalOperator {
    
    /** creates a new NotEquals object.
     * @param fieldName field which has to be compared.
     * @param fixedData compare value.
     */  
    public  NotEquals(String fieldName, Comparable fixedData) {        
        super(fieldName, fixedData);
    } // end NotEquals   
    
    /** creates a new NotEquals object.
     * Since Boolean object is not Comparable, use this constructor to check boolean values.
     * @param fieldName field which has to be compared.
     * @param booleanFixedData compare value.
     */  
    public  NotEquals(String fieldName, boolean booleanFixedData) {        
        super(fieldName, booleanFixedData);
    }     

     /** returns true if the field of the BaseBean object is not equal to the Comparable object/boolean data, else returns false.
     * @param baseBean BaseBean
     * @return true if the field of the BaseBean object is not equal to the Comparable object/boolean data, else returns false.
     */ 
    @Override
    public boolean getResult(Object baseBean) {
        try{
            return compare(baseBean) != 0;
        }catch (Exception exception) {
            return false;
        }
    } // end getResult 
    
    /** 
     * returns the inequality condition being checked using fieldName and fixedData
     * @return String - Inequality condition
     */ 
    @Override
    public String toString() {
        if (! isBoolean) {
            return "( " + fieldName + " != " + fixedData + " )";
        } else {
            return "( " + fieldName + " != " + booleanFixedData + " )";
        }
    }

 } // end NotEquals



