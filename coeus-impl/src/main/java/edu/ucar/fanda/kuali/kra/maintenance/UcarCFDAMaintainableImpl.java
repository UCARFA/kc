package edu.ucar.fanda.kuali.kra.maintenance;


import edu.ucar.fanda.kuali.util.UcarHttpUtil;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.CFDA;
import org.kuali.kra.maintenance.KraMaintainableImpl;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kns.maintenance.KualiMaintainableImpl;
import org.kuali.rice.kns.service.KNSServiceLocator;

import java.util.HashMap;

/*
Required Kuali Configuration Parameters:
    Create and enable HTTPPOST_CFDA_INFO Parameter in Kuali.
    Example:
        Namespace: KC-AWARD
        Component: All
        Application ID: KC
        Parameter Name: HTTPPOST_CFDA_INFO
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
        Parameter Value: http://localhost:8161/api/message?destination=KUALIIFASKEYPARTS&type=queue
        Parameter Description: ActiveMQ IFAS Key Parts URL
        Parameter Type Code: Config
        Parameter Constraint Code: Allowed
 */

public class UcarCFDAMaintainableImpl extends KraMaintainableImpl{

    /**
     * @see KualiMaintainableImpl#saveBusinessObject()
     */
    @Override
    public void saveBusinessObject() {
        KNSServiceLocator.getBusinessObjectService().linkAndSave(businessObject);
        if (this.getMaintenanceAction().equals("Delete")) {
            System.out.println(">>> UcarCFDAMaintainableImpl::saveBusinessObject - Maintenance Action = Delete.  Do nothing.");
        } else {
            System.out.println(">>> UcarCFDAMaintainableImpl::saveBusinessObject - Maintenance Action != Delete.  Send to message queue.");
            Boolean httpPostCFDAInfo = getParameterService().getParameterValueAsBoolean("KC-AWARD", "All", "HTTPPOST_CFDA_INFO");
            if (httpPostCFDAInfo != null && httpPostCFDAInfo) {
                sendToMessageQueue((CFDA) businessObject);
            }
        }
    }

    /**
     * Prepare Json String and send to UcarHttpUtil HTTP Post
     * @param cfda
     */
    public void sendToMessageQueue(CFDA cfda) {
        UcarHttpUtil httpUtil = new UcarHttpUtil();
        HashMap<String, String> payload = new HashMap<String, String>();
        payload.put("keyPartType", "cfda");
        payload.put("keyPartCode", cfda.getCfdaNumber());
        payload.put("keyPartDesc", cfda.getCfdaProgramTitleName());
        httpUtil.httpPost(payload, "ACTIVEMQ_KEYPARTS_URL");
    }

    private ParameterService getParameterService() {
        return KcServiceLocator.getService(ParameterService.class);
    }
}
