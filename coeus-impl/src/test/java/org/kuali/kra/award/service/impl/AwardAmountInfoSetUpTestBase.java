/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service.impl;

import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.rice.kns.util.MessageList;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.MessageMap;
import org.kuali.rice.krad.web.form.UifFormManager;

import java.util.Map;
import java.util.concurrent.Callable;

public class AwardAmountInfoSetUpTestBase {
    public static class MockUserSession extends UserSession {

        public MockUserSession(String principalName) {
            super(principalName);
        }

        @Override
        public String getPrincipalName() {
            return "quickstart";
        }

        @Override
        protected void initPerson(String principalName) {

        }

    }

    public static class MockGlobalVariableService implements GlobalVariableService {

        UserSession userSession;

        @Override
        public UserSession getUserSession() {
            return userSession;
        }

        @Override
        public void setUserSession(UserSession userSession) {
            this.userSession = userSession;
        }

        @Override
        public MessageMap getMessageMap() {
            return null;
        }

        @Override
        public void setMessageMap(MessageMap messageMap) {

        }

        @Override
        public MessageList getMessageList() {
            return null;
        }

        @Override
        public void setMessageList(MessageList messageList) {

        }

        @Override
        public Map<String, AuditCluster> getAuditErrorMap() {
            return null;
        }

        @Override
        public void setAuditErrorMap(Map<String, AuditCluster> auditMap) {

        }

        @Override
        public UifFormManager getUifFormManager() {
            return null;
        }

        @Override
        public void setUifFormManager(UifFormManager uifFormManager) {

        }

        @Override
        public <T> T doInNewGlobalVariables(Callable<T> callable) {
            return null;
        }

        @Override
        public <T> T doInNewGlobalVariables(UserSession userSession, Callable<T> callable) {
            return null;
        }
    }
}
