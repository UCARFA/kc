/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.shortUrl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.shortUrl.ShortUrlDao;
import org.kuali.coeus.common.framework.version.VersionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component("shortUrlDao")
public class ShortUrlDaoImpl implements ShortUrlDao {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Override
    public String getDocId(String id, String table, String column) {
        String sql = "select document_number from " + table + " where " + column + " = ?";
        return runQuery(sql, id);
    }

    @Override
    public String getDocIdByVersionStatus(String id, String table, String column) {
        String docId = getPendingDocId(id, table, column);
        if (StringUtils.isEmpty(docId)) {
            return getActiveDocId(id, table, column);
        }
        return docId;
    }

    protected String getActiveDocId(String id, String table, String column) {
        String versionStatus = VersionStatus.ACTIVE.toString();
        return getDocIdForVersionStatus(id, table, column, versionStatus);
    }

    protected String getPendingDocId(String id, String table, String column) {
        String versionStatus = VersionStatus.PENDING.toString();
        return getDocIdForVersionStatus(id, table, column, versionStatus);
    }

    protected String getDocIdForVersionStatus(String id, String table, String column, String versionStatus) {
        String sql = "select document_number from " + table +" where " + table + "_sequence_status = '" + versionStatus + "' and " +column+" = ?";
        return runQuery(sql, id);
    }

    @Override
    public String getDocIdByVersionHistory(String id, String table, String column) {
        String docId = getPendingDocIdByVersionHistory(id, table, column);
        if (StringUtils.isEmpty(docId)) {
            return getActiveDocIdByVersionHistory(id, table, column);
        }
           return docId;
    }

    protected String getActiveDocIdByVersionHistory(String id, String table, String column) {
        String versionStatus = VersionStatus.ACTIVE.toString();
        return getDocIdByVersionHistoryForVersionStatus(id, table, column, versionStatus);
    }

    protected String getPendingDocIdByVersionHistory(String id, String table, String column) {
        String versionStatus = VersionStatus.PENDING.toString();
        return getDocIdByVersionHistoryForVersionStatus(id, table, column, versionStatus);
    }

    private String getDocIdByVersionHistoryForVersionStatus(String id, String table, String column, String versionStatus) {
        String sql = "select document_number from " + table + " as t, version_history as v where t." + column +
                " = v.seq_owner_version_name_value and t.sequence_number = v.seq_owner_seq_number and v.version_status = '" +
                versionStatus + "' and t." + column + " = ?";
        return runQuery(sql, id);
    }

    @Override
    public String getDocIdByMaxSequenceNumber(String id, String table, String column) {
        String sql = "select document_number from " + table + " where " + column + " = ? and sequence_number = (select max(sequence_number) from " + table + " where " + column + " = ?)";
        return runQuery(sql, id, id);
    }

    private String runQuery(String sql, String ... ids ) {
        try(Connection connection = getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            setQueryParameters(stmt, ids);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(1);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setQueryParameters(PreparedStatement stmt, String[] ids) throws SQLException {
        for (int i = 0; i < ids.length; i++) {
            stmt.setString(i+1,ids[i]);
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
