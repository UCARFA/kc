/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.web.krad;

import org.apache.commons.lang3.StringUtils;
import org.kuali.rice.krad.uif.view.IframeView;

public class CustomHrefIframeView extends IframeView {

    @Override
    public void performInitialization(Object model) {
        super.performInitialization(model);
        if (model instanceof LandingPageForm
        		&& StringUtils.isNotBlank(((LandingPageForm) model).getHref())) {
        	setHref(((LandingPageForm) model).getHref());
        }
    }
}
