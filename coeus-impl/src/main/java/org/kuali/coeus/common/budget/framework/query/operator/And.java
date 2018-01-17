/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.query.operator;



/** This class is a wrapper for and operator ( and ).
 * Takes two Operators as parameters and returs true
 * if both the operators return true as result, else returns false.
 */
public class And extends LogicalOperator {
    
    /** creates new instance of And.
     * @param lhsOperator left hand operator.
     * @param rhsOperator right hand operator.
     */    
    public  And(Operator lhsOperator, Operator rhsOperator) {
        super(lhsOperator, rhsOperator);
    } // end And
    
    /** returs true if both the operators return true as result,
     * else returns false.
     * @param baseBean BaseBean
     * @return returs true if both the operators return true as result,
     * else returns false.
     */    
    @Override
    public boolean getResult(Object baseBean) {
        return (lhsOperator.getResult(baseBean) && rhsOperator.getResult(baseBean));
    }
    
    /** 
     * returns the logical AND condition being checked using left-hand operator(lhsOperator)
     * and right-hand operator(rhsOperator)
     * @return String - AND condition
     */ 
    @Override
    public String toString() {
        return "( " + lhsOperator.toString() + " && " + rhsOperator + " )";
    }
    
    public And and(Operator relatesTo) {
        return new And(this, relatesTo);
    }

    public Or or(Operator relatesTo) {
        return new Or(this, relatesTo);
    }
    
} // end And



