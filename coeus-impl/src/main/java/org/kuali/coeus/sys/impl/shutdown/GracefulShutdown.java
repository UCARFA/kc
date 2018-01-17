package org.kuali.coeus.sys.impl.shutdown;

import co.kuali.coeus.sys.impl.shutdown.GrmGracefulShutdown;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;


@Component("gracefulShutdown")
public class GracefulShutdown implements DisposableBean {

    private static final Log LOG = LogFactory.getLog(GrmGracefulShutdown.class);

    @Override
    public void destroy() throws Exception {
        try {
            Class<?> abandonedConnectionCleanupThread = Class.forName("com.mysql.jdbc.AbandonedConnectionCleanupThread");
            Method shutdown = abandonedConnectionCleanupThread.getDeclaredMethod("shutdown");
            shutdown.invoke(null);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            LOG.info(e);
        }

        Collections.list(java.sql.DriverManager.getDrivers()).forEach(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                LOG.info(e);
            }
        });
    }
}
