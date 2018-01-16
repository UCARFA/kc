/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package co.kuali.coeus.data.migration.custom.coeus;

import java.sql.Connection;
import java.sql.SQLException;

import co.kuali.coeus.data.migration.custom.RiceAwareSqlExecutor;
import org.kuali.coeus.dc.common.rice.parameter.ParameterDaoImpl;
import org.kuali.coeus.dc.pprole.ProposalPersonRoleDaoImpl;

import co.kuali.coeus.data.migration.custom.CoeusConnectionDao;

public class V600_084__PropAwardPersonRoleConversion extends RiceAwareSqlExecutor {
	
	@Override
	public void execute(Connection connection) throws SQLException {
		ProposalPersonRoleDaoImpl proposalPersonRoleDao = new ProposalPersonRoleDaoImpl();
		proposalPersonRoleDao.setParameterDao(new ParameterDaoImpl());
		try (Connection riceConnection = riceDataSource.getConnection()) {
			riceConnection.setAutoCommit(false);
			proposalPersonRoleDao.setConnectionDaoService(new CoeusConnectionDao(connection, riceConnection));
			riceConnection.commit();
		}
	}

	@Override
	public boolean executeInTransaction() {
		return true;
	}

}
