/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.workflow;

import org.kuali.rice.kew.actionlist.CustomActionListAttribute;
import org.kuali.rice.kew.api.action.ActionItem;
import org.kuali.rice.kew.api.action.ActionSet;
import org.kuali.rice.kew.api.actionlist.DisplayParameters;


/**
 * This class is our custom action list for Notifications in KEW.  It's wired in as the implementation to use as part of the NotificationData.xml 
 * bootstrap file for KEW.
 * @author Kuali Rice Team (kuali-rice@googlegroups.com)
 */
public class CopyCustomActionListAttribute implements CustomActionListAttribute {
    private static final String CUSTOM_COPY_ACTION = "P";

    @Override
    public DisplayParameters getDocHandlerDisplayParameters(String principalId, ActionItem actionItem) throws Exception {
    	DisplayParameters dp = DisplayParameters.Builder.create(new Integer(300)).build();
    	return dp;
    }

    @Override
    public ActionSet getLegalActions(String principalId, ActionItem actionItem) throws Exception {
    	ActionSet as = ActionSet.Builder.create().build();
    	as.addAction(CUSTOM_COPY_ACTION);
        as.addFyi();
        as.addAcknowledge();
    	return as;
    }
}
