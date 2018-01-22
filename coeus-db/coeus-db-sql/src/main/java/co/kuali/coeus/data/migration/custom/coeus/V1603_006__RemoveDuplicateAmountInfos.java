/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package co.kuali.coeus.data.migration.custom.coeus;


import co.kuali.coeus.data.migration.custom.CoeusConnectionDao;
import co.kuali.coeus.data.migration.custom.RiceAwareSqlExecutor;

import java.sql.Connection;
import java.sql.SQLException;

import org.kuali.coeus.dc.award.amntinfo.AwardAmountInfoDuplicatesDaoImpl;

public class V1603_006__RemoveDuplicateAmountInfos extends RiceAwareSqlExecutor {
    @Override
    public boolean executeInTransaction() {
        return true;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        try (Connection riceConnection = riceDataSource.getConnection()){
            CoeusConnectionDao connDao = new CoeusConnectionDao(connection, riceConnection);
	    	AwardAmountInfoDuplicatesDaoImpl amountInfoDao = new AwardAmountInfoDuplicatesDaoImpl();
	    	amountInfoDao.setConnectionDaoService(connDao);
	        amountInfoDao.fixAwardAmountInfoDuplicates();
        }
    }
}
