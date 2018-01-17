/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.test.infrastructure.lifecycle;

/**
 * This interface models a unit test lifecycle which has a "per test" component, a "per class" component and a "per suite" component.
 */
public interface KcIntegrationTestLifecycle {
    /**
     * This method starts the "per test" portion of the lifecycle.
     */
    void startPerTest(boolean transactional);

    /**
     * This method stops the "per test" portion of the lifecycle
     */
    void stopPerTest();

    /**
     * This method starts the "per class" portion of the lifecycle
     */
    void startPerClass();

    /**
     * This method stops the "per class" portion of the lifecycle
     */
    void stopPerClass();

    /**
     * This method starts the "per suite" portion of the lifecycle
     */
    void startPerSuite();

    /**
     * This method stops the "per suite" portion of the lifecycle
     */
    void stopPerSuite();

    /**
     * This method indicates whether the "per test" portion of the lifecycle is running
     * 
     * @return the state of the "per test" portion of the lifecycle
     */
    boolean isPerTestStarted();

    /**
     * This method indicates whether the "per class" portion of the lifecycle is running
     * 
     * @return the state of the "per class" portion of the lifecycle
     */
    boolean isPerClassStarted();

    /**
     * This method indicates whether the "per suite" portion of the lifecycle is running
     * 
     * @return the state of the "per suite" portion of the lifecycle
     */
    boolean isPerSuiteStarted();

}
