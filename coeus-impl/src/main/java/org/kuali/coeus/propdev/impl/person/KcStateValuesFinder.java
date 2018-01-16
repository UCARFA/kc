/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import org.apache.commons.lang3.StringUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.krad.uif.field.InputField;
import org.kuali.rice.krad.uif.util.ObjectPropertyUtils;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.kuali.rice.location.api.services.LocationApiServiceLocator;
import org.kuali.rice.location.api.state.State;
import org.kuali.rice.location.api.state.StateService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KcStateValuesFinder extends UifKeyValuesFinderBase {

	private static final long serialVersionUID = 3624265421997217342L;
	
	private StateService stateService;

	@Override
    public List<KeyValue> getKeyValues(ViewModel model, InputField field) {
        List<KeyValue> labels = new ArrayList<KeyValue>();
        List<State> baseCodes;
        ProposalPerson person = ObjectPropertyUtils.getPropertyValue(model, field.getBindingInfo().getBindByNamePrefix());
        if (person == null || StringUtils.isEmpty(person.getCountryCode())) {
            baseCodes = getStateService().findAllStatesInCountry("US");
        } else { 
            baseCodes = getStateService().findAllStatesInCountryByAltCode(person.getCountryCode());
        }
        
        List<State> codes = new ArrayList<State>( baseCodes );
        Collections.sort(codes, new Comparator<State> () {
            @Override
            public int compare(State o1, State o2) {
                int countryCompare = o1.getCountryCode().compareTo(o2.getCountryCode());
                if (countryCompare == 0) {
                    int stateCompare = o1.getName().compareTo(o2.getName());
                    return stateCompare;
                } else {
                    return countryCompare;
                }
            }
        });
        
        List<KeyValue> newLabels = new ArrayList<KeyValue>();
        newLabels.add(new ConcreteKeyValue("", ""));
        for (State state : codes) {
            if(state.isActive()) {
                newLabels.add(new ConcreteKeyValue(state.getCode(), state.getCountryCode() + " - " + state.getName()));
            }
        }
        labels = newLabels;
        
        clearInternalCache();
        return labels;
    }

	protected StateService getStateService() {
		if (stateService == null) {
			stateService = LocationApiServiceLocator.getStateService();
		}
		return stateService;
	}

	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}
}
