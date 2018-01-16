/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.coi.framework;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractMultiSponsorProjectRetrievalService extends AbstractProjectRetrievalService {

    @Override
    public Collection<Project> retrieveProjects() {
        final Map<String, Project> projects = getProjectsMap();

        if (!projects.isEmpty()) {
            final Map<String, List<ProjectPerson>> persons = getPersonsMap();
            persons.forEach((k,v) -> projects.get(k).setPersons(v));

            final Map<String, List<ProjectSponsor>> sponsors = getJdbcOperations().query(c -> c.prepareStatement(allProjectSponsorQuery()),
                    (rs, rowNum) -> toProjectSponsor(rs)).stream().collect(Collectors.groupingBy(ProjectSponsor::getSourceIdentifier));
            sponsors.forEach((k, v) -> setSponsorFields(v, projects.get(k)));
        }

        return projects.values();
    }

    @Override
    public Project retrieveProject(String sourceIdentifier) {
        final Project project = super.retrieveProject(sourceIdentifier);

        if (project != null) {
            final List<ProjectSponsor> sponsors = getJdbcOperations().query(c -> {
                PreparedStatement statement = c.prepareStatement(projectSponsorQuery());
                statement.setString(1, sourceIdentifier);
                return statement;
            }, (rs, rowNum) -> toProjectSponsor(rs));
            setSponsorFields(sponsors, project);
        }

        return project;
    }

    protected abstract ProjectSponsor toProjectSponsor(ResultSet rs) throws SQLException;
    protected abstract String allProjectSponsorQuery();
    protected abstract String projectSponsorQuery();
}
