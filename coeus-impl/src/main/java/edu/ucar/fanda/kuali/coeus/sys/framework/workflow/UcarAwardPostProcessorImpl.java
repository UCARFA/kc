package edu.ucar.fanda.kuali.coeus.sys.framework.workflow;

import edu.ucar.fanda.kuali.util.UcarHttpUtil;
import org.apache.commons.lang.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.workflow.KcPostProcessor;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.rice.kew.framework.postprocessor.*;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.service.PostProcessorService;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

import java.util.HashMap;

/*
Required Kuali Configuration Parameters:
    Create and enable HTTPPOST_AWARD_INFO Parameter in Kuali.
    Example:
        Namespace: KC-AWARD
        Component: All
        Application ID: KC
        Parameter Name: HTTPPOST_AWARD_INFO
        Parameter Value: true
        Parameter Description: Enable sending of new award information to message queue
        Parameter Type Code: Config
        Parameter Constraint Code: Allowed

    Create ACTIVEMQ_KEYPARTS_URL Parameter in Kuali.
        Example:
        Namespace: KC-GEN
        Component: All
        Application ID: KC
        Parameter Name: ACTIVEMQ_KEYPARTS_URL
        Paramter Value: http://localhost:8161/api/message?destination=KUALIIFASKEYPARTS&type=queue
        Parameter Description: ActiveMQ IFAS Key Parts URL
        Parameter Type Code: Config
        Parameter Constraint Code: Allowed
 */

public class UcarAwardPostProcessorImpl extends KcPostProcessor {

    @Override
    public ProcessDocReport doRouteStatusChange(DocumentRouteStatusChange statusChangeEvent) throws Exception {
        System.out.println(">>>>> UcarAwardPostProcessorImpl::doRouteStatusChange()");
        System.out.println(">>>>> Status Change Event - Old: " + statusChangeEvent.getOldRouteStatus() + ", New: " + statusChangeEvent.getNewRouteStatus());
        ProcessDocReport processDocReport = ((PostProcessorService) KcServiceLocator.getService("kcPostProcessorService")).doRouteStatusChange(statusChangeEvent);
        Boolean httpPostAwardInfo = getParameterService().getParameterValueAsBoolean("KC-AWARD", "All", "HTTPPOST_AWARD_INFO");
        // Document Route Status: I - Initial, S - Saved, P = Processed, F - Final
        if (processDocReport.isSuccess() && ((statusChangeEvent.getOldRouteStatus().equals("I") && statusChangeEvent.getNewRouteStatus().equals("S")) || (statusChangeEvent.getOldRouteStatus().equals("P") && statusChangeEvent.getNewRouteStatus().equals("F"))) && httpPostAwardInfo != null && httpPostAwardInfo) {
            UcarHttpUtil httpUtil = new UcarHttpUtil();
            AwardDocument awardDocument = (AwardDocument) KRADServiceLocatorWeb.getDocumentService().getByDocumentHeaderId(statusChangeEvent.getDocumentId());
            String awardNumber = awardDocument.getAward().getAwardNumber();
            String awardTitle = awardDocument.getAward().getTitle();

            if (awardNumber != null && awardTitle != null) {
                HashMap<String, String> awardPayload = new HashMap<String, String>();
                awardPayload.put("keyPartType", "kualiAwardNum");
                awardPayload.put("keyPartCode", awardNumber);
                awardPayload.put("keyPartDesc",awardTitle);
                httpUtil.httpPost(awardPayload, "ACTIVEMQ_KEYPARTS_URL");
            }

            String sponsorAwardID = awardDocument.getAward().getSponsorAwardNumber();
            if (sponsorAwardID != null) {
                String sponsorAwardCode = sponsorAwardID.replaceAll("[-\\.,/#\\(\\)\\?\\[\\]\\s]", "");
                sponsorAwardCode = StringUtils.right(sponsorAwardCode, 8 );
                HashMap<String, String> awardSponsorIdPayload = new HashMap<String, String>();
                awardSponsorIdPayload.put("keyPartType", "sponsorAwardNum");
                awardSponsorIdPayload.put("keyPartCode", sponsorAwardCode);
                awardSponsorIdPayload.put("keyPartDesc",sponsorAwardID);
                httpUtil.httpPost(awardSponsorIdPayload, "ACTIVEMQ_KEYPARTS_URL");
            }

            String contractId = awardDocument.getAward().getFinancialChartOfAccountsCode();
            if (contractId != null && (statusChangeEvent.getOldRouteStatus().equals("P") && statusChangeEvent.getNewRouteStatus().equals("F"))) {
                String keyPartDesc = "";
                if (sponsorAwardID != null) {
                    keyPartDesc = awardDocument.getAward().getSponsor().getSponsorName();
                } else {
                    keyPartDesc = contractId;
                }
                HashMap<String, String> contractIdPayload = new HashMap<String, String>();
                contractIdPayload.put("keyPartType", "contractId");
                contractIdPayload.put("keyPartCode", contractId);
                contractIdPayload.put("keyPartDesc",keyPartDesc);
                httpUtil.httpPost(contractIdPayload, "ACTIVEMQ_KEYPARTS_URL");
            }
        }
        return processDocReport;
    }

    private ParameterService getParameterService() {
        return KcServiceLocator.getService(ParameterService.class);
    }
}
