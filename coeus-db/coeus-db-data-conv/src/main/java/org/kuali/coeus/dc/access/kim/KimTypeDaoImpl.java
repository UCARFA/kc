/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.dc.access.kim;

import org.kuali.coeus.dc.common.db.ConnectionDaoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KimTypeDaoImpl implements KimTypeDao {

    private ConnectionDaoService connectionService;

    @Override
    public String getDocAccessKimTypeId() {
        Connection connection = connectionService.getRiceConnection();
        try (PreparedStatement stmt = connection.prepareStatement("select KIM_TYP_ID from KRIM_TYP_T WHERE NM = 'Derived Role: Document Access' AND NMSPC_CD = 'KC-SYS'");
             ResultSet result = stmt.executeQuery()) {
            if (result.next()) {
                return result.getString(1);
            } else {
                throw new IllegalStateException("can't find document access kim type");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ConnectionDaoService getConnectionService() {
        return connectionService;
    }

    public void setConnectionService(ConnectionDaoService connectionService) {
        this.connectionService = connectionService;
    }
}
