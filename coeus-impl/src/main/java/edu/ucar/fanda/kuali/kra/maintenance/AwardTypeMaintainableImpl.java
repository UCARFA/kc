package edu.ucar.fanda.kuali.kra.maintenance;

import netscape.javascript.JSObject;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.util.JSONPObject;
import org.kuali.kra.award.home.AwardType;
import org.kuali.kra.maintenance.KraMaintainableImpl;
import org.kuali.rice.kns.service.KNSServiceLocator;
import sun.net.www.http.HttpClient;

public class AwardTypeMaintainableImpl extends KraMaintainableImpl{

    /**
     *
     * @see KraMaintainableImpl#saveBusinessObject()
     */
    @Override
    public void saveBusinessObject() {
        System.out.println(">>>>>>>>> AwardTypeMaintainableImpl::saveBusinessObject");
        System.out.println(">>>>>>>>> Business Object: " + businessObject.toString());
        KNSServiceLocator.getBusinessObjectService().linkAndSave(businessObject);
        sendToMessageQueue((AwardType)businessObject);
        System.out.println(">>>>>>>>> AwardTypeMaintainableImpl::saveBusinessObject - FINISHED");
    }

    public void sendToMessageQueue(AwardType awardType) {
        System.out.println(">>>>>>>>> AwardTypeMaintainableImpl::sendToMessageQueue");
        System.out.println(">>>>>>>>> Award Type Code: " + awardType.getCode() + ", Award Type Description: " + awardType.getDescription());
        String awardTypeJson = "{\"awardTypeCode\":\"" + awardType.getCode() + ",\"awardTypeDescription\":\"" + awardType.getDescription() + "\"}";
        System.out.println("awardTypeJson: " + awardTypeJson);

    //    HttpClient httpClient = HttpClientBuilder.create().build();
    }

}
