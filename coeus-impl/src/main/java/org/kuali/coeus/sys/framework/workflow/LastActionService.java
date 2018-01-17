/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.workflow;

import org.kuali.rice.kew.api.action.ActionTaken;

public interface LastActionService {

    /**
     * This method finds the last user action taken.  It will ignore actions take by the system user 'kr'.
     * If no actions are found then null is returned.
     *
     * @param routeHeaderId the document id.  if blank is passed in then null is returned.
     * @return the last user action taken or null.
     */
    ActionTaken findLastUserActionTaken(String routeHeaderId);

    /**
     * This method finds the last user action taken's principal id.  It will ignore actions take by the system user 'kr'.
     * If no actions are found then null is returned.
     *
     * @param routeHeaderId the document id.  if blank is passed in then null is returned.
     * @return the last user action taken's principal id or null.
     */
    String findLastUserActionTakenPrincipalId(String routeHeaderId);
}
