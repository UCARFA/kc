/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.dc.access.proposal;

import org.kuali.coeus.dc.common.db.ConnectionDaoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ProposalRoleDaoImpl implements ProposalRoleDao {

    private ConnectionDaoService connectionDaoService;

    @Override
    public Collection<String> getRoleIdsToConvert() {
        Connection connection = connectionDaoService.getRiceConnection();
        try (PreparedStatement stmt = connection.prepareStatement("select ROLE_ID from krim_role_t where NMSPC_CD = 'KC-PD'");
            ResultSet result = stmt.executeQuery()) {

            final Collection<String> roleIds = new ArrayList<>();
            while (result.next()) {
                roleIds.add(result.getString(1));
            }
            return roleIds;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ConnectionDaoService getConnectionDaoService() {
        return connectionDaoService;
    }

    public void setConnectionDaoService(ConnectionDaoService connectionDaoService) {
        this.connectionDaoService = connectionDaoService;
    }
}
