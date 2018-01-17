/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.state;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.api.state.KcStateService;
import org.kuali.coeus.common.api.state.StateContract;
import org.kuali.rice.location.api.state.State;
import org.kuali.rice.location.api.state.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("kcStateService")
public class KcStateServiceImpl implements KcStateService {

    @Autowired
    @Qualifier("stateService")
    private StateService stateService;

    @Override
    public StateContract getState(String countryCode, String code) {
        if (StringUtils.isBlank(countryCode)) {
            throw new IllegalArgumentException("countryCode is blank");
        }

        if (StringUtils.isBlank(countryCode)) {
            throw new IllegalArgumentException("code is blank");
        }

        return toDto(stateService.getState(countryCode, code));
    }

    protected StateDto toDto(State state) {
        if (state != null) {
            final StateDto dto = new StateDto();
            dto.setName(state.getName());
            dto.setCode(state.getCode());
            dto.setCountryCode(state.getCountryCode());
            return dto;
        }
        return null;
    }
    public StateService getStateService() {
        return stateService;
    }

    public void setStateService(StateService stateService) {
        this.stateService = stateService;
    }
}
