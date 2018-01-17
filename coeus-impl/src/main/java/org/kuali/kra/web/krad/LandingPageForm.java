/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.web.krad;

import org.kuali.rice.krad.web.bind.RequestAccessible;
import org.kuali.rice.krad.web.form.UifFormBase;

public class LandingPageForm extends UifFormBase {

    private static final long serialVersionUID = 304896781932966963L;
    
    @RequestAccessible
    private String href;
    
    private String selectedMenuItem;

	public LandingPageForm() {
        setViewId("Kc-LandingPage-DefaultView");
    }

	public String getHref() {
		return href;
	}

	/**
	 * Href is used for CustomLinkIframeView. Avoids needing to create custom views for each link
	 * @param href
	 */
	public void setHref(String href) {
		this.href = href;
	}
	
    public String getSelectedMenuItem() {
		return selectedMenuItem;
	}

	public void setSelectedMenuItem(String selectedMenuItem) {
		this.selectedMenuItem = selectedMenuItem;
	}


}
