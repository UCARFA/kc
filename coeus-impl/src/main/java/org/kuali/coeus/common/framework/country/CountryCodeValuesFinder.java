/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.country;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.location.api.country.Country;
import org.kuali.rice.location.api.country.CountryService;

import java.util.ArrayList;
import java.util.List;

public class CountryCodeValuesFinder extends UifKeyValuesFinderBase {

    private CountryService countryService;

    @Override
    public List<KeyValue> getKeyValues() {
            final List<Country> countries = getCountryService().findAllCountries();
            final Country defaultCountry = getCountryService().getDefaultCountry();
            final List<KeyValue> keyValues = new ArrayList<KeyValue>();
            if (defaultCountry != null) {
                keyValues.add(new ConcreteKeyValue(defaultCountry.getAlternateCode(), defaultCountry.getName()));
            }
            for (Country country : countries) {
                keyValues.add(new ConcreteKeyValue(country.getAlternateCode(), country.getName()));
             }
            return keyValues;
        }

    public CountryService getCountryService() {
        if (countryService == null) {
            countryService = KcServiceLocator.getService(CountryService.class);
        }

        return countryService;
    }

    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }
}
