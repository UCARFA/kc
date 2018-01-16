/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.dc;


import org.kuali.coeus.dc.common.db.DbValidatorDaoService;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * The main driver program that runs this conversion program.
 *
 * Example arguments:
 *
 * {@code
 * -debug -dbcoeuscon jdbc:mysql://localhost/kcbnd?user=kcbnd&password=bndpass -dbricecon jdbc:mysql://localhost/kcbnd?user=kcbnd&password=bndpass proposal
 * }
 */
public final class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        initLogging("/org/kuali/coeus/dc/jul-default.properties");

        CliOptions options = new CliOptions(args);

        if (!options.isValid()) {
            System.out.println(options.getCliHelpString());
            return;
        }

        if (options.containsDebug()) {
            initLogging("/org/kuali/coeus/dc/jul-debug.properties");
        }

        if (options.containsHelp()) {
            System.out.println(options.getCliHelpString());
            return;
        }

        if (options.containsVersion()) {
            Properties buildProperties = new Properties();
            try(InputStream stream = Main.class.getResourceAsStream("/META-INF/org/kuali/coeus/coeus-data-conv/project.properties")) {
                if (stream != null) {
                    buildProperties.load(stream);
                }
            } catch (IOException e) {
                LOG.log(Level.WARNING, e.getMessage(), e);
            }
            final String version = buildProperties.getProperty("project.version");

            System.out.println(version != null && !version.trim().equals("") ? version : "UNKNOWN");
            return;
        }

        CliOptionsBasedDaoFactory factory = new CliOptionsBasedDaoFactory();
        factory.setCliOptions(options);

        if (options.containsValidate()) {
            DbValidatorDaoService validator = factory.getDbValidatorDaoService();

            if (validator.isValidCoeusConnection()) {
                System.out.println("COEUS SUCCESS: " + options.getCoeusConnectionString());
            } else {
                System.out.println("COEUS FAILED: " + options.getCoeusConnectionString());
            }

            if (validator.isValidRiceConnection()) {
                System.out.println("RICE SUCCESS: " + options.getRiceConnectionString());
            } else {
                System.out.println("RICE FAILED: " + options.getRiceConnectionString());
            }
            return;
        }

        try (Connection coeusConnection = factory.getConnectionDaoService().getCoeusConnection();
            Connection riceConnection = factory.getConnectionDaoService().getRiceConnection()) {

            if(options.containsProposalPersonRole()) {
                factory.getProposalPersonRoleDao().convertParameterValues();
            }

            if (options.containsProposal()) {
                Collection<String> roleIds = factory.getProposalRoleDao().getRoleIdsToConvert();
                factory.getRoleDao().copyRoleMembersToDocAccessType(roleIds, factory.getProposalKimAttributeDocumentValueHandler());
            }

            if (options.containsIrb()) {
                System.out.println("IRB Conversion not supported");
            }

            if (options.containsIacuc()) {
                System.out.println("IACUC Conversion not supported");
            }

            if (options.containsQuestSeq()) {
                factory.getQuestSeqDao().convertQuestSeqKrmsValues();
            }

            if (options.containsQuestReseq()) {
                factory.getQuestReseqDao().resequenceQuestions();
            }
            
            if (options.containsTimeAndMoneyDocStatus()) {
            	factory.getTimeAndMoneyDocumentStatusDao().updateTimeAndMoneyDocumentStatusFromKew();
            }
            
            if (options.containsSubawardAmountInfo()) {
            	factory.getSubAwardAmountInfoDao().fixSubAwardAmountInfoHistory();
            }
            
            if (options.containsTimeAndMoneyDups()) {
            	factory.getAwardAmountInfoDuplicatesDao().fixAwardAmountInfoDuplicates();
            }
            
            if (options.containsProposalYnq()) {
            	factory.getProposalYnqConversionDao().convertProposalYnqs();
            }

            if (options.containsProposalPersonNames()) {
                factory.getProposalPersonDao().fixFullNames();
            }

            if (options.containsAwardUpdateUser()) {
                factory.getAwardUpdateUserDao().fixUpdateUsers();
            }

            if (options.containsIpUpdateUser()) {
                factory.getIpUpdateUserDao().fixUpdateUsers();
            }

            if (options.containsSubawardUpdateUser()) {
                factory.getSubawardUpdateUserDao().fixUpdateUsers();
            }

            if (options.containsTmUpdateUser()) {
                factory.getTimeAndMoneyUpdateUserDao().fixUpdateUsers();
            }

            if (options.containsSubawardStatus()) {
                factory.getSubawardStatusDao().fixSubawardStatus();
            }

            if (options.containsDryRun()) {
                coeusConnection.rollback();
                riceConnection.rollback();
            } else {
                coeusConnection.commit();
                riceConnection.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.exit(0);
    }

    private static void initLogging(String file) {
        final String fname = System.getProperty("java.util.logging.config.file");

        try (InputStream in = (fname != null ? new FileInputStream(fname) : Main.class.getResourceAsStream(file)); BufferedInputStream bin = new BufferedInputStream(in)) {
            LogManager.getLogManager().readConfiguration(bin);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
