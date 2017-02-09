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
