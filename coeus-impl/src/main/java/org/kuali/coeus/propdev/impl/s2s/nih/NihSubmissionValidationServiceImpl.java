/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.propdev.impl.s2s.nih;


import gov.nih.era.svs.SubmissionValidationServiceStub;
import gov.nih.era.svs.ValidateApplicationError;
import gov.nih.era.svs.types.AttachmentMetaData;
import gov.nih.era.svs.types.ValidateApplicationRequest;
import gov.nih.era.svs.types.ValidateApplicationResponse;
import gov.nih.era.svs.types.ValidationMessageList;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.kuali.coeus.propdev.api.s2s.S2SConfigurationService;

import org.kuali.coeus.propdev.impl.s2s.connect.S2sCommunicationException;
import org.kuali.coeus.s2sgen.api.core.ConfigurationConstants;
import org.kuali.coeus.s2sgen.api.generate.AttachmentData;
import org.kuali.kra.infrastructure.KeyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.List;

@Component("nihSubmissionValidationService")
public class NihSubmissionValidationServiceImpl implements NihSubmissionValidationService {

    private static final String KEY_TYPE = "JKS";
    private static final String NIH_GOV_S2S_CN_CHECK = "nih.gov.s2s.cn.check";
    private static final String NIH_GOV_S2S_KEYSTORE_PASSWORD = "nih.gov.s2s.keystore.password";
    private static final String NIH_GOV_S2S_KEYSTORE_LOCATION = "nih.gov.s2s.keystore.location";
    private static final String NIH_GOV_S2S_TRUSTSTORE_LOCATION = "nih.gov.s2s.truststore.location";
    private static final String NIH_GOV_S2S_HOST = "nih.gov.s2s.host";
    private static final String NIH_GOV_S2S_PORT = "nih.gov.s2s.port";
    private static final String NIH_GOV_S2S_TRUSTSTORE_PASSWORD = "nih.gov.s2s.truststore.password";
    private static final String ENABLE_NIH_VALIDATION_SERVICE = "Enable_NIH_Validation_Service";

    @Autowired
    @Qualifier("s2SConfigurationService")
    private S2SConfigurationService s2SConfigurationService;

    @Override
    public ValidateApplicationResponse validateApplication(String xmlText, List<AttachmentData> attachments, String dunsNumber) {

        final ValidateApplicationResponse response;

        if (!s2SConfigurationService.getValueAsBoolean(ENABLE_NIH_VALIDATION_SERVICE)) {
            response = new ValidateApplicationResponse();
        } else {
            final ValidateApplicationRequest parameters = new ValidateApplicationRequest();
            parameters.setGrantApplicationXML(xmlText);
            final List<AttachmentMetaData> attachmentMetaDatas = parameters.getAttachmentMetaData();

            attachments.stream().map(attachment -> {
                final AttachmentMetaData attachmentMetaData = new AttachmentMetaData();
                attachmentMetaData.setFileLocation(attachment.getContentId());
                attachmentMetaData.setFileName(attachment.getFileName());
                attachmentMetaData.setMimeType(attachment.getContentType());
                attachmentMetaData.setSizeInBytes(attachment.getContent().length);
                return attachmentMetaData;
            }).forEach(attachmentMetaDatas::add);

            try {
                response = createConfiguredService(dunsNumber).validateApplication(parameters);
            } catch (ValidateApplicationError validateApplicationError) {
                throw new S2sCommunicationException(validateApplicationError);
            }
        }

        if (response.getValidationMessageList() == null) {
            response.setValidationMessageList(new ValidationMessageList());
        }

        return response;
    }

    private SubmissionValidationServiceStub createConfiguredService(String dunsNumber) {
        final Boolean multiCampusEnabled = s2SConfigurationService.getValueAsBoolean(ConfigurationConstants.MULTI_CAMPUS_ENABLED);

        final SubmissionValidationServiceStub applicantWebService;

        final TLSClientParameters tlsConfig = new TLSClientParameters();
        tlsConfig.setDisableCNCheck(s2SConfigurationService.getValueAsBoolean(NIH_GOV_S2S_CN_CHECK));

        try {
            final String keyStorePassword = s2SConfigurationService.getValueAsString(NIH_GOV_S2S_KEYSTORE_PASSWORD);
            final KeyStore keyStore = KeyStore.getInstance(KEY_TYPE);
            keyStore.load(new FileInputStream(s2SConfigurationService.getValueAsString(NIH_GOV_S2S_KEYSTORE_LOCATION)), keyStorePassword.toCharArray());
            final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

            if (dunsNumber != null && multiCampusEnabled) {
                final KeyStore keyStoreAlias = KeyStore.getInstance(KEY_TYPE);
                final Certificate[] certificates = keyStore.getCertificateChain(dunsNumber);
                final Key key = keyStore.getKey(dunsNumber, keyStorePassword.toCharArray());
                keyStoreAlias.load(null, null);
                keyStoreAlias.setKeyEntry(dunsNumber, key, keyStorePassword.toCharArray(), certificates);
                keyManagerFactory.init(keyStoreAlias, keyStorePassword.toCharArray());
            } else {
                keyManagerFactory.init(keyStore, keyStorePassword.toCharArray());
            }

            final KeyManager[] km = keyManagerFactory.getKeyManagers();
            tlsConfig.setKeyManagers(km);

            final KeyStore trustStore = KeyStore.getInstance(KEY_TYPE);
            trustStore.load(new FileInputStream(s2SConfigurationService.getValueAsString(NIH_GOV_S2S_TRUSTSTORE_LOCATION)), s2SConfigurationService.getValueAsString(NIH_GOV_S2S_TRUSTSTORE_PASSWORD).toCharArray());
            final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);
            final TrustManager[] tm = trustManagerFactory.getTrustManagers();
            tlsConfig.setTrustManagers(tm);
        } catch (KeyStoreException|NoSuchAlgorithmException|CertificateException|IOException|UnrecoverableKeyException e) {
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_UNKNOWN, e);
        }

        final JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress(getSoapHost(s2SConfigurationService.getValueAsString(NIH_GOV_S2S_HOST), s2SConfigurationService.getValueAsString(NIH_GOV_S2S_PORT)));
        factory.setServiceClass(SubmissionValidationServiceStub.class);

        applicantWebService = (SubmissionValidationServiceStub) factory.create();
        final Client client = ClientProxy.getClient(applicantWebService);
        final HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();

        final HTTPConduit conduit = (HTTPConduit) client.getConduit();
        conduit.setClient(httpClientPolicy);
        conduit.setTlsClientParameters(tlsConfig);

        return applicantWebService;
    }

    protected String getSoapHost(String hostStr, String portStr) {
        StringBuilder host = new StringBuilder();
        host.append(hostStr);

        if ((!host.toString().endsWith("/")) && (!portStr.startsWith("/"))) {
            host.append("/");
        }
        host.append(portStr);
        return host.toString();
    }

    public S2SConfigurationService getS2SConfigurationService() {
        return s2SConfigurationService;
    }

    public void setS2SConfigurationService(S2SConfigurationService s2SConfigurationService) {
        this.s2SConfigurationService = s2SConfigurationService;
    }
}
