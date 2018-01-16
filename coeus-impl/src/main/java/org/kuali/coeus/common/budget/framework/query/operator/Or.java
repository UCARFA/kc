/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.budget.framework.query.operator;


/** This class is a wrapper for or operator ( || ).
 * Takes two Operators as parameters in the constructor and returs true
 * if any one of the operators return true as result, else returns false.
 */
public class Or extends LogicalOperator {

    /** creates new instance of Or
     * @param lhsOperator left hand operator.
     * @param rhsOperator right hand operator.
     */    
    public  Or(Operator lhsOperator, Operator rhsOperator) {        
        super(lhsOperator, rhsOperator);
    } // end Or        

    /** returns true
     * if any one of the operators return true as result, else returns false.
     * @param baseBean BaseBean
     * @return true if any one of the operators return true as result, else returns false.
     */    
    @Override
    public boolean getResult(Object baseBean) {
        return (lhsOperator.getResult(baseBean) || rhsOperator.getResult(baseBean));
    }
    
    /** 
     * returns the logical OR condition being checked using left-hand operator(lhsOperator)
     * and right-hand operator(rhsOperator)
     * @return String - OR condition
     */ 
    @Override
    public String toString() {
        return "( " + lhsOperator.toString() + " || " + rhsOperator + " )";
    }

 // end getResult        

    public And and(Operator relatesTo) {
        return new And(this, relatesTo);
    }

    public Or or(Operator relatesTo) {
        return new Or(this, relatesTo);
    }
    
 } // end Or



