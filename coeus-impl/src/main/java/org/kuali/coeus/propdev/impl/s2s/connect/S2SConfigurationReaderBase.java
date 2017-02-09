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
package org.kuali.coeus.propdev.impl.s2s.connect;

import org.kuali.coeus.propdev.api.s2s.S2SConfigurationService;
import org.kuali.kra.infrastructure.KeyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class S2SConfigurationReaderBase implements S2SConfigurationReader {

    private static final String JKS_TYPE = "JKS";

    @Autowired
    @Qualifier("s2SConfigurationService")
    private S2SConfigurationService s2SConfigurationService;

    private String keyStoreLocationProperty;
    private String keyStorePasswordProperty;
    private String trustStoreLocationProperty;
    private String trustStorePasswordProperty;
    private String certAlgorithmProperty;
    private String serviceHostProperty;
    private String servicePortProperty;
    private String disableCNCheckProperty;

    private KeyStore keyStore = null;
    private KeyStore trustStore = null;

    @Override
    public String getKeyStoreLocation() {
        return getS2SConfigurationService().getValueAsString(keyStoreLocationProperty);
    }

    @Override
    public String getKeyStorePassword() {
        return getS2SConfigurationService().getValueAsString(keyStorePasswordProperty);
    }

    @Override
    public String getTrustStoreLocation() {
        return getS2SConfigurationService().getValueAsString(trustStoreLocationProperty);
    }

    @Override
    public String getTrustStorePassword() {
        return getS2SConfigurationService().getValueAsString(trustStorePasswordProperty);
    }

    @Override
    public KeyStore getKeyStore() throws S2sCommunicationException {
        if(keyStore!=null) {
            return keyStore;
        }
        try {
            keyStore = KeyStore.getInstance(JKS_TYPE);
            keyStore.load(new FileInputStream(getKeyStoreLocation()), getKeyStorePassword().toCharArray());
        }catch (KeyStoreException e) {
            keyStore = null;
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_KEYSTORE_CREATION,e);
        }catch (NoSuchAlgorithmException e) {
            keyStore = null;
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_KEYSTORE_NO_ALGORITHM,e);
        }catch (CertificateException e) {
            keyStore = null;
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_KEYSTORE_BAD_CERTIFICATE,e);
        }catch (FileNotFoundException e) {
            keyStore = null;
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_KEYSTORE_NOT_FOUND,e);
        }catch (IOException e) {
            keyStore = null;
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_KEYSTORE_CANNOT_READ,e);
        }
        return keyStore;
    }

    @Override
    public KeyStore getKeyStoreAlias(String alias) throws S2sCommunicationException {
        KeyStore keyStoreAlias;
        try {
            keyStoreAlias = KeyStore.getInstance(JKS_TYPE);
            Certificate[] certificates = getKeyStore().getCertificateChain(alias);
            Key key = getKeyStore().getKey(alias, getKeyStorePassword().toCharArray());
            keyStoreAlias.load(null, null);
            keyStoreAlias.setKeyEntry(alias, key, getKeyStorePassword().toCharArray(), certificates);
        }catch (KeyStoreException e) {
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_KEYSTORE_CREATION,e);
        }catch (NoSuchAlgorithmException e) {
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_KEYSTORE_NO_ALGORITHM,e);
        }catch (CertificateException e) {
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_KEYSTORE_BAD_CERTIFICATE,e);
        }catch (FileNotFoundException e) {
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_KEYSTORE_NOT_FOUND,e);
        }catch (IOException e) {
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_KEYSTORE_CANNOT_READ,e);
        } catch (UnrecoverableKeyException e) {
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_KEYSTORE_CREATION,e);
        }
        return null;
    }

    @Override
    public KeyStore getTrustStore() throws S2sCommunicationException {
        if (trustStore!=null) {
            return trustStore;
        }

        try {
            trustStore = KeyStore.getInstance(JKS_TYPE);
            trustStore.load(new FileInputStream(getTrustStoreLocation()), getTrustStorePassword().toCharArray());
        }catch (KeyStoreException e) {
            trustStore = null;
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_TRUSTSTORE_CREATION,e);
        }catch (NoSuchAlgorithmException e) {
            trustStore = null;
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_TRUSTSTORE_NO_ALGORITHM,e);
        }catch (CertificateException e) {
            trustStore = null;
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_TRUSTSTORE_BAD_CERTIFICATE,e);
        }catch (FileNotFoundException e) {
            trustStore = null;
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_TRUSTSTORE_NOT_FOUND,e);
        }catch (IOException e) {
            trustStore = null;
            throw new S2sCommunicationException(KeyConstants.ERROR_S2S_TRUSTSTORE_CANNOT_READ,e);
        }
        return trustStore;
    }

    @Override
    public String getServiceHost() {
        return getS2SConfigurationService().getValueAsString(serviceHostProperty);
    }

    @Override
    public String getServicePort() {
        return getS2SConfigurationService().getValueAsString(servicePortProperty);
    }

    @Override
    public Boolean getDisableCNCheck() {
        return getS2SConfigurationService().getValueAsBoolean(disableCNCheckProperty);
    }

    @Override
    public String getCertAlgorithm() {
        return getS2SConfigurationService().getValueAsString(certAlgorithmProperty);
    }

    public String getKeyStoreLocationProperty() {
        return keyStoreLocationProperty;
    }

    public void setKeyStoreLocationProperty(String keyStoreLocationProperty) {
        this.keyStoreLocationProperty = keyStoreLocationProperty;
    }

    public String getKeyStorePasswordProperty() {
        return keyStorePasswordProperty;
    }

    public void setKeyStorePasswordProperty(String keyStorePasswordProperty) {
        this.keyStorePasswordProperty = keyStorePasswordProperty;
    }

    public String getTrustStoreLocationProperty() {
        return trustStoreLocationProperty;
    }

    public void setTrustStoreLocationProperty(String trustStoreLocationProperty) {
        this.trustStoreLocationProperty = trustStoreLocationProperty;
    }

    public String getTrustStorePasswordProperty() {
        return trustStorePasswordProperty;
    }

    public void setTrustStorePasswordProperty(String trustStorePasswordProperty) {
        this.trustStorePasswordProperty = trustStorePasswordProperty;
    }

    public String getCertAlgorithmProperty() {
        return certAlgorithmProperty;
    }

    public void setCertAlgorithmProperty(String certAlgorithmProperty) {
        this.certAlgorithmProperty = certAlgorithmProperty;
    }

    public String getServiceHostProperty() {
        return serviceHostProperty;
    }

    public void setServiceHostProperty(String serviceHostProperty) {
        this.serviceHostProperty = serviceHostProperty;
    }

    public String getServicePortProperty() {
        return servicePortProperty;
    }

    public void setServicePortProperty(String servicePortProperty) {
        this.servicePortProperty = servicePortProperty;
    }

    public String getDisableCNCheckProperty() {
        return disableCNCheckProperty;
    }

    public void setDisableCNCheckProperty(String disableCNCheckProperty) {
        this.disableCNCheckProperty = disableCNCheckProperty;
    }

    public S2SConfigurationService getS2SConfigurationService() {
        return s2SConfigurationService;
    }

    public void setS2SConfigurationService(S2SConfigurationService s2SConfigurationService) {
        this.s2SConfigurationService = s2SConfigurationService;
    }
}
