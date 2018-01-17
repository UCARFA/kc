/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package co.kuali.coeus.data.migration.custom;

import javax.sql.DataSource;

public abstract class RiceAwareSqlExecutor implements SqlExecutor, RiceDataSourceAware {

	protected DataSource riceDataSource;

    @Override
	public DataSource getRiceDataSource() {
		return riceDataSource;
	}

    @Override
	public void setRiceDataSource(DataSource riceDataSource) {
		this.riceDataSource = riceDataSource;
	}
}
