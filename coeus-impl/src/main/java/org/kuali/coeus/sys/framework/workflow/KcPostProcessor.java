/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.workflow;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.kew.api.action.ActionType;
import org.kuali.rice.kew.framework.postprocessor.*;
import org.kuali.rice.krad.service.PostProcessorService;

import java.util.List;

/**
 * Extends the {@code KualiPostProcessor} to record the actual user performing an action on a workflow status change.
 */
public class KcPostProcessor implements PostProcessor {
    
    @Override
    public ProcessDocReport doRouteStatusChange(DocumentRouteStatusChange statusChangeEvent) throws Exception {
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).doRouteStatusChange(statusChangeEvent);
    }

    @Override
    public ProcessDocReport doRouteLevelChange(final DocumentRouteLevelChange levelChangeEvent) throws Exception {
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).doRouteLevelChange(levelChangeEvent);
    }

    @Override
    public ProcessDocReport doDeleteRouteHeader(DeleteEvent event) throws Exception {
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).doDeleteRouteHeader(event);
    }

    @Override
    public ProcessDocReport doActionTaken(final ActionTakenEvent event) throws Exception {
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).doActionTaken(event);
    }

    @Override
    public ProcessDocReport afterActionTaken(ActionType actionPerformed, ActionTakenEvent event) throws Exception{
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).afterActionTaken(actionPerformed,event);
    }

    @Override
    public ProcessDocReport beforeProcess(BeforeProcessEvent processEvent) throws Exception {
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).beforeProcess(processEvent);
    }

    @Override
    public ProcessDocReport afterProcess(AfterProcessEvent processEvent) throws Exception {
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).afterProcess(processEvent);
    }

    @Override
    public List<String> getDocumentIdsToLock(DocumentLockingEvent lockingEvent) throws Exception {
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).getDocumentIdsToLock(lockingEvent);
    }
}
