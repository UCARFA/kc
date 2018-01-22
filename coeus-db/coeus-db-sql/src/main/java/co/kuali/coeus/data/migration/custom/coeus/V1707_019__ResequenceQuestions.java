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
import org.kuali.coeus.dc.common.rice.parameter.ParameterDaoImpl;
import org.kuali.coeus.dc.questreseq.QuestReseqDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class V1707_019__ResequenceQuestions extends RiceAwareSqlExecutor {
    @Override
    public boolean executeInTransaction() {
        return true;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        try (Connection riceConnection = riceDataSource.getConnection()){
            final CoeusConnectionDao connDao = new CoeusConnectionDao(connection, riceConnection);

            final ParameterDaoImpl parameterDao = new ParameterDaoImpl();
            parameterDao.setConnectionDaoService(connDao);

            final QuestReseqDaoImpl qrd = new QuestReseqDaoImpl();
            qrd.setConnectionDaoService(connDao);
            qrd.setParameterDao(parameterDao);
            qrd.resequenceQuestions();
        }
    }
}
