/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s.connect;

import java.security.KeyStore;

public interface S2SConfigurationReader {
    String getKeyStoreLocation();
    String getKeyStorePassword();
    String getTrustStoreLocation();
    String getTrustStorePassword();
    KeyStore getKeyStore() throws S2sCommunicationException;
    KeyStore getKeyStoreAlias(String alias) throws S2sCommunicationException;
    KeyStore getTrustStore() throws S2sCommunicationException;
    String getCertAlgorithm();
    String getServiceHost();
    String getServicePort();
    Boolean getDisableCNCheck();
}
