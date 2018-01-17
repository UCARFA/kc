/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.query.operator;

/** The Operator interface should be implemented by any class whose instances are intended to be executed as an Operator. The class must define a method of boolean argument called getResult.
 *
 * This interface is designed to provide a common protocol for objects that wish be recognised as Operators. For example, Operator is implemented by class GreaterThan which is a wrapper for greater than ( &gt; ) operator.
 *
 */
public interface Operator {

    /** true if operation succeeds, else return false.
     * @param baseBean BaseBean
     * @return true if operation succeeds, else return false.
     */    
    public boolean getResult(Object baseBean);

}





