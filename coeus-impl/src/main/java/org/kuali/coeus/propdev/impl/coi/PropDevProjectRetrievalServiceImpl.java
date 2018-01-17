/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.coi;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.coi.framework.*;
import org.kuali.coeus.propdev.impl.hierarchy.HierarchyStatusConstants;
import org.kuali.kra.infrastructure.Constants;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component("propDevProjectRetrievalService")
public class PropDevProjectRetrievalServiceImpl extends AbstractProjectRetrievalService {

    private static final String PD_ALL_PROJECT_QUERY = "SELECT t.TITLE, t.PROPOSAL_NUMBER, t.STATUS_CODE, t.REQUESTED_START_DATE_INITIAL, t.REQUESTED_END_DATE_INITIAL, t.SPONSOR_CODE, u.SPONSOR_NAME FROM EPS_PROPOSAL t LEFT OUTER JOIN SPONSOR u ON t.SPONSOR_CODE = u.SPONSOR_CODE " +
            "WHERE t.IS_HIERARCHY in ('" + HierarchyStatusConstants.None.code() + "', '" + HierarchyStatusConstants.Child.code() + "')";

    private static final String PD_ALL_PROJECT_PERSON_QUERY = "SELECT t.PROPOSAL_NUMBER, t.PERSON_ID, t.ROLODEX_ID, t.PROP_PERSON_ROLE_ID FROM EPS_PROP_PERSON t INNER JOIN EPS_PROPOSAL u ON t.PROPOSAL_NUMBER = u.PROPOSAL_NUMBER " +
            "WHERE u.IS_HIERARCHY in ('" + HierarchyStatusConstants.None.code() + "', '" + HierarchyStatusConstants.Child.code() + "')";

    private static final String PD_PROJECT_QUERY = PD_ALL_PROJECT_QUERY + " AND t.PROPOSAL_NUMBER = ?";
    private static final String PD_PROJECT_PERSON_QUERY = PD_ALL_PROJECT_PERSON_QUERY + " AND t.PROPOSAL_NUMBER = ?";

    @Override
    protected Project toProject(ResultSet rs) throws SQLException {
        final Project project = new Project();
        project.setTitle(rs.getString(1));
        project.setTypeCode(ProjectTypeCode.PROPOSAL.getId());
        project.setSourceSystem(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT);
        final String sourceIdentifier = rs.getString(2);
        project.setSourceIdentifier(sourceIdentifier);
        project.setSourceStatus(rs.getString(3));
        project.setStartDate(rs.getDate(4));
        project.setEndDate(rs.getDate(5));

        final Map<String, String> metadata = new HashMap<>();
        metadata.put(SOURCE_UNIQUE_IDENTIFIER_METADATA, sourceIdentifier);
        project.setMetadata(metadata);

        setSponsorFields(Collections.singletonList(new ProjectSponsor(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, sourceIdentifier, rs.getString(6), rs.getString(7), new HashMap<>(metadata))), project);

        return project;
    }

    @Override
    protected ProjectPerson toProjectPerson(ResultSet rs) throws SQLException {
        final ProjectPerson person = new ProjectPerson();
        person.setSourceSystem(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT);
        person.setSourceIdentifier(rs.getString(1));
        final String personId = rs.getString(2);
        final String rolodexId = rs.getString(3);
        person.setPersonId(StringUtils.isNotBlank(personId) ? personId : rolodexId);
        person.setSourcePersonType(StringUtils.isNotBlank(personId) ? PersonType.EMPLOYEE.toString() : PersonType.NONEMPLOYEE.toString());
        person.setRoleCode(rs.getString(4));

        final Map<String, String> metadata = new HashMap<>();
        metadata.put(SOURCE_UNIQUE_IDENTIFIER_METADATA, person.getSourceIdentifier());
        person.setMetadata(metadata);

        return person;
    }

    @Override
    protected String allProjectQuery() {
        return PD_ALL_PROJECT_QUERY;
    }

    @Override
    protected String allProjectPersonQuery() {
        return PD_ALL_PROJECT_PERSON_QUERY;
    }

    @Override
    protected String projectQuery() {
        return PD_PROJECT_QUERY;
    }

    @Override
    protected String projectPersonQuery() {
        return PD_PROJECT_PERSON_QUERY;
    }
}
