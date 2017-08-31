package co.kuali.coeus.db.lambda;

import co.kuali.coeus.data.migration.FlywayMigrator;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;


/**
 * JSON sample config:
 * <p>
 * {
 * "coeusDataSource": {
 * "driverName": "com.mysql.jdbc.Driver",
 * "url": "jdbc:mysql://localhost/kcbnd",
 * "username": "kcbnd",
 * "password": "kcbnd"
 * },
 * "riceDataSource": {
 * "driverName": "com.mysql.jdbc.Driver",
 * "url": "jdbc:mysql://localhost/kcbnd",
 * "username": "kcbnd",
 * "password": "kcbnd"
 * },
 * "applyDemo": true,
 * "applyStaging": true,
 * "grm": true,
 * "enabled": true,
 * "sqlMigrationPath": "co/kuali/coeus/data/migration/sql/mysql",
 * "javaMigrationPath": "co/kuali/coeus/data/migration/custom/coeus",
 * "initVersion": "0"
 * }
 */
public class FlywayLambda {
    private static final String COEUS_DATASOURCE = "coeusDataSource";
    private static final String RICE_DATASOURCE = "riceDataSource";
    private static final String DRIVER_NAME = "driverName";
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String APPLY_DEMO = "applyDemo";
    private static final String APPLY_STAGING = "applyStaging";
    private static final String GRM = "grm";
    private static final String ENABLED = "enabled";
    private static final String SQL_MIGRATION_PATH = "sqlMigrationPath";
    private static final String JAVA_MIGRATION_PATH = "javaMigrationPath";
    private static final String INIT_VERSION = "initVersion";

    @SuppressWarnings("unchecked")
    public String apply(Map<String, Object> input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Stating Flyway Migrator with config: " + input);

        final Map<String, String> coeusDataSourceInput = (Map<String, String>) input.get(COEUS_DATASOURCE);
        final String coeusDriverName = coeusDataSourceInput.get(DRIVER_NAME);
        final String coeusUrl = coeusDataSourceInput.get(URL);
        final String coeusUsername = coeusDataSourceInput.get(USERNAME);
        final String coeusPassword = coeusDataSourceInput.get(PASSWORD);
        final Map<String, String> riceDataSourceInput = (Map<String, String>) input.get(RICE_DATASOURCE);
        final String riceDriverName = riceDataSourceInput.get(DRIVER_NAME);
        final String riceUrl = riceDataSourceInput.get(URL);
        final String riceUsername = riceDataSourceInput.get(USERNAME);
        final String ricePassword = riceDataSourceInput.get(PASSWORD);

        final Boolean applyDemo = (Boolean) input.get(APPLY_DEMO);
        final Boolean applyStaging = (Boolean) input.get(APPLY_STAGING);
        final Boolean grm = (Boolean) input.get(GRM);
        final Boolean enabled = (Boolean) input.get(ENABLED);
        final String sqlMigrationPath = (String) input.get(SQL_MIGRATION_PATH);
        final String javaMigrationPath = (String) input.get(JAVA_MIGRATION_PATH);
        final String initVersion = (String) input.get(INIT_VERSION);

        final FlywayMigrator migrator = new FlywayMigrator();
        migrator.setDataSource(retrieveDataSource(coeusDriverName, coeusUrl, coeusUsername, coeusPassword));
        migrator.setRiceDataSource(retrieveDataSource(riceDriverName, riceUrl, riceUsername, ricePassword));
        migrator.setManageRice(true);
        migrator.setEmbeddedMode(false);
        migrator.setApplyDemo(applyDemo);
        migrator.setApplyStaging(applyStaging);
        migrator.setGrm(grm);
        migrator.setEnabled(enabled);
        migrator.setSqlMigrationPath(sqlMigrationPath);
        migrator.setJavaMigrationPath(javaMigrationPath);
        migrator.setInitVersion(initVersion);

        try {
            migrator.migrate();
            return "SUCCESS";
        } catch (SQLException e) {
            logger.log(ExceptionUtils.getStackTrace(e));
            return "FAIL";
        } finally {
            logger.log("Ending Flyway Migrator with config: " + input);
        }
    }

    private DataSource retrieveDataSource(String driverName, String url, String username, String password) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDefaultAutoCommit(false);
        dataSource.setEnableAutoCommitOnReturn(false);

        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}