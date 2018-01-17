/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package co.kuali.coeus.data.migration.custom;

import java.sql.Connection;
import java.sql.SQLException;

public interface SqlExecutor {
    boolean executeInTransaction();
    void execute(Connection connection) throws SQLException;
}
