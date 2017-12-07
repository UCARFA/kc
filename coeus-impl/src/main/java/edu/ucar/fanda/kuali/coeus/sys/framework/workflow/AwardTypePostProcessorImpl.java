package edu.ucar.fanda.kuali.coeus.sys.framework.workflow;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.workflow.KcPostProcessor;
import org.kuali.rice.kew.api.action.ActionType;
import org.kuali.rice.kew.framework.postprocessor.*;
import org.kuali.rice.krad.service.PostProcessorService;

import java.util.List;

public class AwardTypePostProcessorImpl extends KcPostProcessor {

    @Override
    public ProcessDocReport doRouteStatusChange(DocumentRouteStatusChange statusChangeEvent) throws Exception {
        System.out.println(">>>>>>>>> AwardtypePostProcessor::doRouteStatusChange");
        if (statusChangeEvent.getOldRouteStatus().equals("P") && statusChangeEvent.getNewRouteStatus().equals("F")) {
            System.out.println("Status Change Event: " + statusChangeEvent.toString());
        }

       // if (statusChangeEvent.)
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).doRouteStatusChange(statusChangeEvent);
    }

    @Override
    public ProcessDocReport doRouteLevelChange(final DocumentRouteLevelChange levelChangeEvent) throws Exception {
        System.out.println(">>>>>>>>> AwardtypePostProcessor::doRouteLevelChange");
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).doRouteLevelChange(levelChangeEvent);
    }

    @Override
    public ProcessDocReport doDeleteRouteHeader(DeleteEvent event) throws Exception {
        System.out.println(">>>>>>>>> AwardtypePostProcessor::doDeleteRouteHeader");
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).doDeleteRouteHeader(event);
    }

    @Override
    public ProcessDocReport doActionTaken(final ActionTakenEvent event) throws Exception {
        System.out.println(">>>>>>>>> AwardtypePostProcessor::doActionTaken");
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).doActionTaken(event);
    }

    @Override
    public ProcessDocReport afterActionTaken(ActionType actionPerformed, ActionTakenEvent event) throws Exception{
        System.out.println(">>>>>>>>> AwardtypePostProcessor::afterActionTaken");
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).afterActionTaken(actionPerformed,event);
    }

    @Override
    public ProcessDocReport beforeProcess(BeforeProcessEvent processEvent) throws Exception {
        System.out.println(">>>>>>>>> AwardtypePostProcessor::beforeProcess");
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).beforeProcess(processEvent);
    }

    @Override
    public ProcessDocReport afterProcess(AfterProcessEvent processEvent) throws Exception {
        System.out.println(">>>>>>>>> AwardtypePostProcessor::afterProcess");
        if (processEvent.isSuccessfullyProcessed()) {
            System.out.println(">>>>>>>>> AwardtypePostProcessor::afterProcess - processed = TRUE");
        }
        PostProcessorService kcPostProcService = ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService"));
        System.out.println("kcPostProcService: " + kcPostProcService.toString());
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).afterProcess(processEvent);
    }

    @Override
    public List<String> getDocumentIdsToLock(DocumentLockingEvent lockingEvent) throws Exception {
        System.out.println(">>>>>>>>> AwardtypePostProcessor::getDocumentIdsToLock");
        return ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).getDocumentIdsToLock(lockingEvent);
    }
}
