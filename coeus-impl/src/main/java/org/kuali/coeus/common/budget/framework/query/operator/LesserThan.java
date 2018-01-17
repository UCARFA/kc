/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.query.operator;



/** This class is a wrapper for lesser than operator ( &lt; ).
 * Takes field and Comparable object as parameters in the constructor and returs true
 * if the field of the Object object is lesser than the Comparable object, else returns false.
 */
public class LesserThan extends RelationalOperator {


    /** creates new instance of LesserThan.
     * @param fieldName field which has to be compared.
     * @param fixedData compare value.
     */    
    public  LesserThan(String fieldName, Comparable fixedData) {        
        super(fieldName, fixedData);
    } // end LesserThan        

    /** rreturs true if the field of the CoeusBean object is lesser than the Comparable object, else returns false.
     * @param baseBean Object
     * @return true if the field of the CoeusBean object is lesser than the Comparable object, else returns false.
     */    
    @Override
    public boolean getResult(Object baseBean) {
        if(fixedData == null) return false; //cannot query property < null. will always return false
        try{
            return compare(baseBean) < 0;
        }catch (Exception exception) {
            return false;
        }
    }
    
    /** 
     * returns the lesser than condition being checked using fieldName and fixedData
     * @return String - Lesser than condition
     */
    @Override
    public String toString() {
        return "( " + fieldName + " < " + fixedData + " )";
    }

 } // end LesserThan



