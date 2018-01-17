/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.dc.common.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceDaoServiceOracleImpl implements SequenceDaoService {

    private ConnectionDaoService connectionDaoService;

    @Override
    public String getNextRiceSequence(String sequenceName, String prefix) {
        Connection connection = connectionDaoService.getRiceConnection();
        try {
            return getNextSequence(sequenceName, prefix, connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getNextCoeusSequence(String sequenceName, String prefix) {
        Connection connection = connectionDaoService.getCoeusConnection();
        try {
            return getNextSequence(sequenceName, prefix, connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected String getNextSequence(String sequenceName, String prefix, Connection connection) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT " + sequenceName + ".NEXTVAL FROM DUAL");
             ResultSet result = stmt.executeQuery()) {
            result.next();
            return prefix + result.getString(1);
        }
    }

    public ConnectionDaoService getConnectionDaoService() {
        return connectionDaoService;
    }

    public void setConnectionDaoService(ConnectionDaoService connectionDaoService) {
        this.connectionDaoService = connectionDaoService;
    }
}
