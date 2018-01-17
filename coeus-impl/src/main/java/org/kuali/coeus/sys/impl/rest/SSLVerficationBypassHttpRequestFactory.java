/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class SSLVerficationBypassHttpRequestFactory extends SimpleClientHttpRequestFactory {
	
	@Override
	protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
		if (connection instanceof HttpsURLConnection) {
			((HttpsURLConnection) connection).setHostnameVerifier(new HostnameVerifier() {
				@Override
                public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});
			((HttpsURLConnection) connection).setSSLSocketFactory(trustSelfSignedSSLContext().getSocketFactory());
		}
		super.prepareConnection(connection, httpMethod);
	}
	
	final private SSLContext trustSelfSignedSSLContext() {
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException { }
                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException { }
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLContext.setDefault(ctx);
            return ctx;
		} catch (NoSuchAlgorithmException|KeyManagementException e) {
			throw new RuntimeException(e);
		}
	}
}
