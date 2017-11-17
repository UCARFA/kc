/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.common.impl.attachment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.coeus.common.framework.attachment.KcAttachmentDataDao;
import org.kuali.coeus.common.framework.attachment.KcAttachmentDataDaoConversion;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class KcAttachmentDataDaoConversionImpl extends QuartzJobBean implements KcAttachmentDataDaoConversion {

	private static final Log LOG = LogFactory.getLog(KcAttachmentDataDaoConversionImpl.class);

	private KcAttachmentDataDao kcAttachmentDataDao;

	private String tableName;
	private String blobColumn;
	private String fileDataIdColumn;
	private String primaryKeyColumn;
	private Integer fetchSize = 5;
	private DataSource dataSource;

	/**
	 * defaults to select [primaryKeyColumn], [blobColumn] from [tableName] where [blobColumn] is not null;
	 */
	private String querySql;
	/**
	 * defaults to update [tableName] set [fileDataIdColumn] = (newFileId), [blobColumn] = null where [primaryKeyColumn] = (primaryKey)
	 * but the fileDataId must be id 1 in the resultSet and the primary key must be id 2
	 */
	private String updateSql;

	@Override
	public void executeInternal(JobExecutionContext context) throws JobExecutionException {
		LOG.info("Starting attachment conversion job for " + tableName);

		if (querySql == null) {
			querySql = "select " + primaryKeyColumn + ", " + blobColumn + " from " + tableName + " where " + blobColumn + " is not null";
		}
		if (updateSql == null) {
			updateSql = "update " + tableName + " set " + fileDataIdColumn + " = ?, " + blobColumn + " = null where " + primaryKeyColumn + " = ?";
		}

		boolean hasResults = true;
		while (hasResults) {
			try (Connection conn = dataSource.getConnection();

				 PreparedStatement queryStmt = conn.prepareStatement(querySql);
				 PreparedStatement updateStmt = conn.prepareStatement(updateSql);) {
				conn.setAutoCommit(false);
				hasResults = false;
				queryStmt.setFetchSize(fetchSize);
				try (ResultSet rs = queryStmt.executeQuery()) {
					for (int i = 0; i < fetchSize && rs.next(); i++) {
						String fileDataId = kcAttachmentDataDao.saveData(rs.getBytes(blobColumn), null);
						updateStmt.setString(1, fileDataId);
						updateStmt.setObject(2, rs.getObject(primaryKeyColumn));
						int numUpdated = updateStmt.executeUpdate();
						if (numUpdated != 1) {
							LOG.error("Expected to update a single row, but instead updated " + numUpdated + ". Job exiting.");
							conn.rollback();
							return;
						}
						hasResults = true;
					}
				} catch (SQLException e) {
					conn.rollback();
					throw e;
				}
				conn.commit();

				Thread.sleep(500);

			} catch (SQLException e) {
				LOG.error("Got sql exception in attachment conversion, job exiting.", e);
				return;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
		LOG.info("Finishing attachment conversion job for " + tableName);
	}

	public KcAttachmentDataDao getKcAttachmentDataDao() {
		return kcAttachmentDataDao;
	}

	public void setKcAttachmentDataDao(KcAttachmentDataDao kcAttachmentDataDao) {
		this.kcAttachmentDataDao = kcAttachmentDataDao;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getBlobColumn() {
		return blobColumn;
	}

	public void setBlobColumn(String blobColumn) {
		this.blobColumn = blobColumn;
	}

	public String getFileDataIdColumn() {
		return fileDataIdColumn;
	}

	public void setFileDataIdColumn(String fileDataIdColumn) {
		this.fileDataIdColumn = fileDataIdColumn;
	}

	public String getQuerySql() {
		return querySql;
	}

	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}

	public String getUpdateSql() {
		return updateSql;
	}

	public void setUpdateSql(String updateSql) {
		this.updateSql = updateSql;
	}

	public String getPrimaryKeyColumn() {
		return primaryKeyColumn;
	}

	public void setPrimaryKeyColumn(String primaryKeyColumn) {
		this.primaryKeyColumn = primaryKeyColumn;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Integer getFetchSize() {
		return fetchSize;
	}

	public void setFetchSize(Integer fetchSize) {
		this.fetchSize = fetchSize;
	}


}
