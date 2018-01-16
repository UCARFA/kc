/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.coi.framework;

import java.util.Collection;

public interface ProjectRetrievalService {

    /**
     * Retrieves all the available projects in a system.
     *
     * @return a list of available projects or an empty collection.  Will never return null.
     */
    Collection<Project> retrieveProjects();

    /**
     * Retrieves project by source identifier.
     *
     * @param sourceIdentifier the identifier of a project.  cannot be blank or null.
     * @return A project or null.
     * @throws IllegalArgumentException if the sourceIdentifier is blank or null
     */
    Project retrieveProject(String sourceIdentifier);
}
