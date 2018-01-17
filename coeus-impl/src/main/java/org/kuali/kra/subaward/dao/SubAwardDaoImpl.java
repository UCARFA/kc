/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubAwardDaoImpl implements SubAwardDao {

    public static final String QUERY = "select max(sequence_number) from subaward where subaward_code = ?";
    private DataSource dataSource;

    @Override
    public int getNextSequenceNumber(String subawardCode) {
        try (Connection connection = getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            stmt.setString(1, subawardCode);
            try  (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) + 1;
                } else {
                    return 1;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
