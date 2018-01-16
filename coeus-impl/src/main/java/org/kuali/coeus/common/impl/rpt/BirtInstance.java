/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.rpt;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;

class BirtInstance {

    private static BirtInstance birtInstance;
    private IReportEngine engine; 
    private EngineConfig config; 
   

    private BirtInstance()throws Exception {
        init();
    }

    public void init() throws BirtException {
        config = new EngineConfig();
        Platform.startup(config);
        IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
        engine = factory.createReportEngine(config); 
        engine.changeLogLevel(java.util.logging.Level.WARNING);
    }

    private void shutdown() {
        engine.destroy();
        Platform.shutdown();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        shutdown();
    }

    public static synchronized BirtInstance getInstance()throws Exception {
        if (birtInstance == null) {
            birtInstance = new BirtInstance();
        }
        return birtInstance;
    }

    public IReportEngine getIReportEngine() {
        return engine;
    }

    public EngineConfig getEngineConfig() {
        return config;
    }
}
