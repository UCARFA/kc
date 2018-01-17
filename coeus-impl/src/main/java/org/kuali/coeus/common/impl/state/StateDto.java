/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.state;

import org.kuali.coeus.common.api.state.StateContract;

public class StateDto implements StateContract {

    private String name;
    private String countryCode;
    private String code;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
