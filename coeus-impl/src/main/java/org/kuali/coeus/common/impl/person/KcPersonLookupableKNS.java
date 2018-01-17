/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.person;

import org.kuali.rice.kns.lookup.KualiLookupableImpl;
import org.kuali.rice.kns.lookup.LookupableHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("kcPersonLookupableKNS")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class KcPersonLookupableKNS extends KualiLookupableImpl {
	
	@Override
    @Autowired
    @Qualifier("kcPersonLookupableHelperServiceKNS")
	public void setLookupableHelperService(LookupableHelperService lookupableHelperService){
		super.setLookupableHelperService(lookupableHelperService);
	}

}
