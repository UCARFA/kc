/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.coi.framework;

/**
 * Publishes a COI project.
 */
public interface ProjectPublisher {

    /**
     * Publishes a project to the COI system.
     *
     * @param project a project.  Cannot be null.  Must be in a valid state.
     * @throws IllegalArgumentException if the project is null or invalid.
     */
    void publishProject(Project project);
}
