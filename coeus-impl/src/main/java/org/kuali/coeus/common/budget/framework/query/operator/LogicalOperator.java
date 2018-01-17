/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.query.operator;

/** implements Operator and holds left hand and right hand values
 * which are instances of Operators (Since Logical Operators operate on two Relational, Logical Operators).
 */
public abstract class LogicalOperator implements Operator {
    
    /** holds left hand Operator.
     */    
    protected Operator lhsOperator;
    /** holds right hand operator.
     */    
    protected Operator rhsOperator;
    
    /**
     * @param lhsOperator left hand Operator.
     * @param rhsOperator right hand operator.
     */    
    public  LogicalOperator(Operator lhsOperator, Operator rhsOperator) {
        this.lhsOperator = lhsOperator;
        this.rhsOperator = rhsOperator;
    } // end LogicalOperator
    
} // end LogicalOperator



