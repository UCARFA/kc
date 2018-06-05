package edu.ucar.fanda.kuali.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.json.JSONObject;
import java.util.Base64;
import java.util.HashMap;

public class UcarHttpUtil {

    private static final String DOCUMENT_COMPONENT_NAME = "All";
    private static final String KC_GENERAL_NAMESPACE = "KC-GEN";

    /**
     * Perform HTTP Post
     * @param payload
     * @param msgQueueUrlParm
     */
    public void httpPost (HashMap payload, String msgQueueUrlParm) {
        JSONObject jsonPayload = new JSONObject(payload);
        System.out.println("JSON Payload: " + jsonPayload);
        // Add Logger
        HttpClient httpClient = HttpClientBuilder.create().build();
        String credentials = Base64.getEncoder().encodeToString(("admin:admin").getBytes());
        String messageQueueUrl = getParameterService().getParameterValueAsString(KC_GENERAL_NAMESPACE, DOCUMENT_COMPONENT_NAME, msgQueueUrlParm);
        if (messageQueueUrl != null) {
            try {
                StringEntity entity = new StringEntity(jsonPayload.toString());
                HttpPost request = new HttpPost(messageQueueUrl);
                request.setHeader("Authorization", "Basic " + credentials);
                request.setHeader("Content-Type", "application/json");
                request.setEntity(entity);
                HttpResponse response = httpClient.execute(request);
            } catch (Exception ex) {
                System.err.println("Connection to Message Queue Failed: " + ex.getMessage());
            }
        }
    }

    private ParameterService getParameterService() {
        return KcServiceLocator.getService(ParameterService.class);
    }
}
