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
import java.util.Collection;

import org.kuali.coeus.dc.access.kim.KimTypeDaoImpl;
import org.kuali.coeus.dc.access.kim.RoleDaoImpl;
import org.kuali.coeus.dc.access.proposal.KimAttributeDefnDaoImpl;
import org.kuali.coeus.dc.access.proposal.ProposalKimAttributeDocumentValueHandler;
import org.kuali.coeus.dc.access.proposal.ProposalRoleDaoImpl;
import org.kuali.coeus.dc.common.db.SequenceDaoService;
import org.kuali.coeus.dc.common.db.SequenceDaoServiceMySqlImpl;
import org.kuali.coeus.dc.common.db.SequenceDaoServiceOracleImpl;

import co.kuali.coeus.data.migration.MigrationUtils;
import co.kuali.coeus.data.migration.custom.CoeusConnectionDao;
import co.kuali.coeus.data.migration.custom.RiceAwareSqlExecutor;

public class V600_085__ProposalRoleConversion extends RiceAwareSqlExecutor {

	@Override
	public void execute(Connection connection) throws SQLException {
		try (Connection riceConnection = riceDataSource.getConnection()){
			riceConnection.setAutoCommit(false);
			CoeusConnectionDao connDao = new CoeusConnectionDao(connection, riceConnection);
			ProposalRoleDaoImpl proposalRoleDao = new ProposalRoleDaoImpl();
			proposalRoleDao.setConnectionDaoService(connDao);
			Collection<String> roleIds = proposalRoleDao.getRoleIdsToConvert();
			
			RoleDaoImpl roleDao = new RoleDaoImpl();
			roleDao.setConnectionDaoService(new CoeusConnectionDao(connection, riceConnection));
			
			KimTypeDaoImpl kimTypeDao = new KimTypeDaoImpl();
			kimTypeDao.setConnectionService(connDao);
			roleDao.setKimTypeDao(kimTypeDao);
			
			SequenceDaoService sequenceDaoService = null;
			MigrationUtils.DatabaseType type = MigrationUtils.getDatabaseTypeFromConnection(connection);
			if (type == MigrationUtils.DatabaseType.Mysql) {
				sequenceDaoService = new SequenceDaoServiceMySqlImpl();
				((SequenceDaoServiceMySqlImpl) sequenceDaoService).setConnectionDaoService(connDao);
			} else if (type == MigrationUtils.DatabaseType.Oracle) {
				sequenceDaoService = new SequenceDaoServiceOracleImpl();
				((SequenceDaoServiceOracleImpl) sequenceDaoService).setConnectionDaoService(connDao);
			}
			roleDao.setSequenceDaoService(sequenceDaoService);
			
			KimAttributeDefnDaoImpl kimAttributeDefn = new KimAttributeDefnDaoImpl();
			kimAttributeDefn.setConnectionDaoService(connDao);
			
			ProposalKimAttributeDocumentValueHandler kimDocValueHandler = new ProposalKimAttributeDocumentValueHandler();
			kimDocValueHandler.setConnectionDaoService(connDao);
			kimDocValueHandler.setProposalKimAttributeDefnDao(kimAttributeDefn);
			kimDocValueHandler.setDelete(true);
			
			roleDao.copyRoleMembersToDocAccessType(roleIds, kimDocValueHandler);
			riceConnection.commit();
		}
	}

	@Override
	public boolean executeInTransaction() {
		return true;
	}

}
