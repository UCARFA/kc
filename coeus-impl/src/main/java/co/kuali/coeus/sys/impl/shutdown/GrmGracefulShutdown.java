package co.kuali.coeus.sys.impl.shutdown;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class GrmGracefulShutdown implements DisposableBean {

    private static final Log LOG = LogFactory.getLog(GrmGracefulShutdown.class);

    @Override
    public void destroy() {
        LOG.info("Shutting down AWS IdleConnectionReaper thread ");
        try {
            Class<?> idleConnectionReaper = Class.forName("com.amazonaws.http.IdleConnectionReaper");
            Method shutdown = idleConnectionReaper.getDeclaredMethod("shutdown");
            shutdown.invoke(null);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
