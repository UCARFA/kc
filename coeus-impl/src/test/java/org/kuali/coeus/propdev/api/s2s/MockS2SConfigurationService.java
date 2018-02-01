/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.api.s2s;

import org.kuali.coeus.propdev.impl.s2s.S2SConfigurationServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class MockS2SConfigurationService extends S2SConfigurationServiceImpl {

    final Map<String, String> values = new HashMap<>();

    @Override
    public String getValueAsString(String name) {
        return values.get(name);
    }

    public void setValueAsString(String name, String value) {
        values.put(name, value);
    }
}
