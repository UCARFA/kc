/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.gv;

import org.kuali.rice.kns.util.MessageList;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.MessageMap;
import org.kuali.rice.krad.web.form.UifFormManager;

import java.util.Map;
import java.util.concurrent.Callable;

public interface GlobalVariableService {

    UserSession getUserSession();

    void setUserSession(UserSession userSession);

    MessageMap getMessageMap();

    void setMessageMap(MessageMap messageMap);

    @SuppressWarnings("deprecation")
    MessageList getMessageList();

    @SuppressWarnings("deprecation")
    void setMessageList(MessageList messageList);
    
    Map<String, AuditCluster> getAuditErrorMap();
    
    void setAuditErrorMap(Map<String, AuditCluster> auditMap);

    UifFormManager getUifFormManager();

    void setUifFormManager(UifFormManager uifFormManager);

    <T> T doInNewGlobalVariables(Callable<T> callable);

    <T> T doInNewGlobalVariables(UserSession userSession, Callable<T> callable);
}
