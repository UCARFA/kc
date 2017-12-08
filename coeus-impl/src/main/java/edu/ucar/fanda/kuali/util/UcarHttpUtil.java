package edu.ucar.fanda.kuali.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.Base64;

public class UcarHttpUtil {

    public void httpPost (String payload) {
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
