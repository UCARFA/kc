/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.dc;

import org.kuali.coeus.dc.access.kim.*;
import org.kuali.coeus.dc.common.rice.parameter.ParameterDao;
import org.kuali.coeus.dc.common.rice.parameter.ParameterDaoImpl;
import org.kuali.coeus.dc.access.proposal.*;
import org.kuali.coeus.dc.award.amntinfo.AwardAmountInfoDuplicatesDao;
import org.kuali.coeus.dc.award.amntinfo.AwardAmountInfoDuplicatesDaoImpl;
import org.kuali.coeus.dc.common.db.*;
import org.kuali.coeus.dc.pprole.ProposalPersonRoleDao;
import org.kuali.coeus.dc.pprole.ProposalPersonRoleDaoImpl;
import org.kuali.coeus.dc.proposalpersons.ProposalPersonsDao;
import org.kuali.coeus.dc.proposalpersons.ProposalPersonsDaoImpl;
import org.kuali.coeus.dc.propynq.ProposalYnqConversionDao;
import org.kuali.coeus.dc.propynq.ProposalYnqConversionDaoImpl;
import org.kuali.coeus.dc.questreseq.QuestReseqDao;
import org.kuali.coeus.dc.questreseq.QuestReseqDaoImpl;
import org.kuali.coeus.dc.questseq.QuestSeqDao;
import org.kuali.coeus.dc.questseq.QuestSeqDaoImpl;
import org.kuali.coeus.dc.subaward.amntinfo.SubAwardAmountInfoDao;
import org.kuali.coeus.dc.subaward.amntinfo.SubAwardAmountInfoDaoImpl;
import org.kuali.coeus.dc.subaward.status.SubawardStatusDao;
import org.kuali.coeus.dc.subaward.status.SubawardStatusDaoImpl;
import org.kuali.coeus.dc.tm.KewDocHeaderDao;
import org.kuali.coeus.dc.tm.KewDocHeaderDaoImpl;
import org.kuali.coeus.dc.tm.TimeAndMoneyDocumentStatusDao;
import org.kuali.coeus.dc.tm.TimeAndMoneyDocumentStatusDaoImpl;
import org.kuali.coeus.dc.updateuser.LastActionUserDao;
import org.kuali.coeus.dc.updateuser.LastActionUserDaoImpl;
import org.kuali.coeus.dc.updateuser.UpdateUserDao;
import org.kuali.coeus.dc.updateuser.award.AwardUpdateUserDaoImpl;
import org.kuali.coeus.dc.updateuser.ip.InstitutionalProposalUpdateUserDaoImpl;
import org.kuali.coeus.dc.updateuser.subaward.SubawardUpdateUserDaoImpl;
import org.kuali.coeus.dc.updateuser.tm.TimeAndMoneyUpdateUserDaoImpl;

public final class CliOptionsBasedDaoFactory {

    private CliOptions cliOptions;

    public DbValidatorDaoService getDbValidatorDaoService(){
        if (cliOptions.isMySql()) {
            DbValidatorDaoServiceMySqlImpl service = new DbValidatorDaoServiceMySqlImpl();
            service.setConnectionService(getConnectionDaoService());
            return service;
        } else if(cliOptions.isOracle()) {
            DbValidatorDaoServiceOracleImpl service = new DbValidatorDaoServiceOracleImpl();
            service.setConnectionService(getConnectionDaoService());
            return service;
        }
        return null;
    }

    public ConnectionDaoService getConnectionDaoService() {
        if (cliOptions.isMySql()) {
            ConnectionDaoServiceMySqlImpl connectionService = new ConnectionDaoServiceMySqlImpl();
            connectionService.setCoeusConnectionString(cliOptions.getCoeusConnectionString());
            connectionService.setRiceConnectionString(cliOptions.getRiceConnectionString());
            connectionService.setCoeusUser(cliOptions.getCoeusUser());
            connectionService.setRiceUser(cliOptions.getRiceUser());
            connectionService.setCoeusPassword(cliOptions.getCoeusPassword());
            connectionService.setRicePassword(cliOptions.getRicePassword());
            return connectionService;
        } else if(cliOptions.isOracle()) {
            ConnectionDaoServiceOracleImpl connectionService = new ConnectionDaoServiceOracleImpl();
            connectionService.setCoeusConnectionString(cliOptions.getCoeusConnectionString());
            connectionService.setRiceConnectionString(cliOptions.getRiceConnectionString());
            connectionService.setCoeusUser(cliOptions.getCoeusUser());
            connectionService.setRiceUser(cliOptions.getRiceUser());
            connectionService.setCoeusPassword(cliOptions.getCoeusPassword());
            connectionService.setRicePassword(cliOptions.getRicePassword());
            return connectionService;
        }
        return null;
    }

    public RoleDao getRoleDao() {
        RoleDaoImpl dao = new RoleDaoImpl();
        dao.setConnectionDaoService(getConnectionDaoService());
        dao.setKimTypeDao(getKimTypeDao());
        dao.setSequenceDaoService(getSequenceDaoService());

        return dao;
    }

    public KimTypeDao getKimTypeDao() {
        KimTypeDaoImpl dao = new KimTypeDaoImpl();
        dao.setConnectionService(getConnectionDaoService());
        return dao;
    }

    public SequenceDaoService getSequenceDaoService() {
        if (cliOptions.isMySql()) {
            SequenceDaoServiceMySqlImpl sequenceDaoService = new SequenceDaoServiceMySqlImpl();
            sequenceDaoService.setConnectionDaoService(getConnectionDaoService());
            return sequenceDaoService;
        } else if(cliOptions.isOracle()) {
            SequenceDaoServiceOracleImpl sequenceDaoService = new SequenceDaoServiceOracleImpl();
            sequenceDaoService.setConnectionDaoService(getConnectionDaoService());
            return sequenceDaoService;
        }
        return null;
    }

    public ProposalKimAttributeDefnDao getProposalKimAttributeDefnDao() {
        KimAttributeDefnDaoImpl dao = new KimAttributeDefnDaoImpl();
        dao.setConnectionDaoService(getConnectionDaoService());
        return dao;
    }

    public KimAttributeDocumentValueHandler getProposalKimAttributeDocumentValueHandler() {
        ProposalKimAttributeDocumentValueHandler handler = new ProposalKimAttributeDocumentValueHandler();
        handler.setProposalKimAttributeDefnDao(getProposalKimAttributeDefnDao());
        handler.setConnectionDaoService(getConnectionDaoService());
        handler.setDelete(cliOptions.deleteCleanupPolicy());
        return handler;
    }

    public ProposalRoleDao getProposalRoleDao() {
        ProposalRoleDaoImpl rs = new ProposalRoleDaoImpl();
        rs.setConnectionDaoService(getConnectionDaoService());
        return rs;
    }

    public ParameterDao getParameterDao() {
        ParameterDaoImpl ps = new ParameterDaoImpl();
        ps.setConnectionDaoService(getConnectionDaoService());
        return ps;
    }

    public ProposalPersonRoleDao getProposalPersonRoleDao() {
        ProposalPersonRoleDaoImpl ps = new ProposalPersonRoleDaoImpl();
        ps.setConnectionDaoService(getConnectionDaoService());
        ps.setParameterDao(getParameterDao());
        return ps;
    }

    public QuestSeqDao getQuestSeqDao() {
        QuestSeqDaoImpl qsd = new QuestSeqDaoImpl();
        qsd.setConnectionDaoService(getConnectionDaoService());
        return qsd;
    }

    public QuestReseqDao getQuestReseqDao() {
        QuestReseqDaoImpl qrd = new QuestReseqDaoImpl();
        qrd.setConnectionDaoService(getConnectionDaoService());
        qrd.setParameterDao(getParameterDao());
        return qrd;
    }
    
    public KewDocHeaderDao getKewDocHeaderDao() {
    	KewDocHeaderDaoImpl docHeaderDao = new KewDocHeaderDaoImpl();
    	docHeaderDao.setConnectionDaoService(getConnectionDaoService());
    	return docHeaderDao;
    }
    
    public TimeAndMoneyDocumentStatusDao getTimeAndMoneyDocumentStatusDao() {
    	TimeAndMoneyDocumentStatusDaoImpl dao = new TimeAndMoneyDocumentStatusDaoImpl();
    	dao.setConnectionDaoService(getConnectionDaoService());
    	dao.setKewDocHeaderDao(getKewDocHeaderDao());
    	return dao;
    }
    
    public SubAwardAmountInfoDao getSubAwardAmountInfoDao() {
    	SubAwardAmountInfoDaoImpl dao = new SubAwardAmountInfoDaoImpl();
    	dao.setConnectionDaoService(getConnectionDaoService());
    	return dao;
    }
    
    public AwardAmountInfoDuplicatesDao getAwardAmountInfoDuplicatesDao() {
    	AwardAmountInfoDuplicatesDaoImpl dao = new AwardAmountInfoDuplicatesDaoImpl();
    	dao.setConnectionDaoService(getConnectionDaoService());
    	return dao;
    }
    
    public ProposalYnqConversionDao getProposalYnqConversionDao() {
    	ProposalYnqConversionDaoImpl dao = new ProposalYnqConversionDaoImpl();
    	dao.setConnectionDaoService(getConnectionDaoService());
    	return dao;
    }

    public ProposalPersonsDao getProposalPersonDao() {
        ProposalPersonsDaoImpl dao = new ProposalPersonsDaoImpl();
        dao.setConnectionDaoService(getConnectionDaoService());
        return dao;
    }

    public LastActionUserDao getLastActionUserDao() {
        LastActionUserDaoImpl dao = new LastActionUserDaoImpl();
        dao.setConnectionDaoService(getConnectionDaoService());
        return dao;
    }

    public UpdateUserDao getAwardUpdateUserDao() {
        AwardUpdateUserDaoImpl dao = new AwardUpdateUserDaoImpl();
        dao.setConnectionDaoService(getConnectionDaoService());
        dao.setLastActionUserDao(getLastActionUserDao());
        return dao;
    }

    public UpdateUserDao getTimeAndMoneyUpdateUserDao() {
        TimeAndMoneyUpdateUserDaoImpl dao = new TimeAndMoneyUpdateUserDaoImpl();
        dao.setConnectionDaoService(getConnectionDaoService());
        dao.setLastActionUserDao(getLastActionUserDao());
        return dao;
    }

    public UpdateUserDao getIpUpdateUserDao() {
        InstitutionalProposalUpdateUserDaoImpl dao = new InstitutionalProposalUpdateUserDaoImpl();
        dao.setConnectionDaoService(getConnectionDaoService());
        dao.setLastActionUserDao(getLastActionUserDao());
        return dao;
    }

    public UpdateUserDao getSubawardUpdateUserDao() {
        SubawardUpdateUserDaoImpl dao = new SubawardUpdateUserDaoImpl();
        dao.setConnectionDaoService(getConnectionDaoService());
        dao.setLastActionUserDao(getLastActionUserDao());
        return dao;
    }

    public SubawardStatusDao getSubawardStatusDao() {
        SubawardStatusDaoImpl dao = new SubawardStatusDaoImpl();
        dao.setConnectionDaoService(getConnectionDaoService());
        return dao;
    }

    public CliOptions getCliOptions() {
        return cliOptions;
    }

    public void setCliOptions(CliOptions cliOptions) {
        this.cliOptions = cliOptions;
    }
}
