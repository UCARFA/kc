package edu.ucar.fanda.kuali.kra.maintenance;


// import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.kuali.kra.award.home.AwardType;
import org.kuali.kra.maintenance.KraMaintainableImpl;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.apache.http.entity.StringEntity;
import sun.misc.BASE64Encoder;

import java.util.Base64;
// import sun.net.www.http.HttpClient;


public class UcarAwardTypeMaintainableImpl extends KraMaintainableImpl{

    /**
     *
     * @see KraMaintainableImpl#saveBusinessObject()
     */
    @Override
    public void saveBusinessObject() {
        System.out.println(">>>>>>>>> UcarAwardTypeMaintainableImpl::saveBusinessObject");
        System.out.println(">>>>>>>>> Business Object: " + businessObject.toString());
        KNSServiceLocator.getBusinessObjectService().linkAndSave(businessObject);
        sendToMessageQueue((AwardType)businessObject);
        System.out.println(">>>>>>>>> UcarAwardTypeMaintainableImpl::saveBusinessObject - FINISHED");
    }

    public void sendToMessageQueue(AwardType awardType) {
        System.out.println(">>>>>>>>> UcarAwardTypeMaintainableImpl::sendToMessageQueue");
        System.out.println(">>>>>>>>> Award Type Code: " + awardType.getCode() + " , Award Type Description: " + awardType.getDescription());
        String awardTypeJson = "{\"awardTypeCode\":\"" + awardType.getCode() + "\",\"awardTypeDescription\":\"" + awardType.getDescription() + "\"}";
        System.out.println("awardTypeJson: " + awardTypeJson);

        String payload = "{\"awardTypeCode\":\"" + awardType.getCode() + "\",\"awardTypeDescription\":\"" + awardType.getDescription() + "\"}";
        System.out.println("Award Type Payload: " + payload);
        StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_FORM_URLENCODED);
        entity.setContentType("application/json");

        HttpClient httpClient = HttpClientBuilder.create().build();

        String credentials = Base64.getEncoder().encodeToString(("admin:admin").getBytes());
        try {
            HttpPost request = new HttpPost("http://localhost:8161/api/message?destination=KUALIAWARDTYPEKEY&type=queue");
            request.setHeader("Authorization", "Basic " + credentials);
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);
            System.out.println(response.getStatusLine().getStatusCode());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.toString());
        }
    }
}
