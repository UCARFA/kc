/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.sys.framework.view;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.kns.web.servlet.dwr.GlobalResourceDelegatingSpringCreator;

public class KcResourceDelegatingSpringCreator extends GlobalResourceDelegatingSpringCreator {
	
	@Override
	public Object getInstance() throws InstantiationException {
		Object bean = KcServiceLocator.getService(this.getBeanName());
		if (bean == null) {
			bean = super.getInstance();
			if (bean == null) {
				throw new InstantiationException("Unable to find bean " + this.getBeanName() + " in Global Resource Loader");
			}
		}
		return bean;
	}

}
