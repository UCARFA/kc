/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.propdev.impl.s2s.connect;

import org.kuali.kra.infrastructure.KeyConstants;

public class S2sCommunicationException extends RuntimeException {

    private String errorMessage;
    private String errorKey = KeyConstants.ERROR_S2S_UNKNOWN;
    private String tabErrorKey;
    private int messageType;
    private String[] params = new String[0];

    public S2sCommunicationException() {
        super();
    }

    public S2sCommunicationException(Exception ex) {
        super(ex);
        this.errorMessage = ex.getMessage();
    }

    public S2sCommunicationException(String errorKey, Exception ex) {
        super(ex);
        this.errorKey = errorKey;
        this.errorMessage = ex.getMessage();
    }

    public S2sCommunicationException(String msg) {
        super(msg);
        this.errorMessage = msg;
    }

    public S2sCommunicationException(String errorKey, String msg) {
        super(msg);
        this.errorMessage = msg;
        this.errorKey = errorKey;
    }
    public S2sCommunicationException(String errorKey, String msg, String... params) {
        super(msg);
        this.errorMessage = msg;
        this.errorKey = errorKey;
        this.params = params;
    }
    public S2sCommunicationException(String msg, int messageType) {
        super();
        this.errorMessage = msg;
        this.messageType = messageType;
    }

    public String getMessage() {
        return errorMessage;
    }

    public String[] getMessageWithParams() {
        String[] messageWithParams = new String[getParams().length+1];
        messageWithParams[0]=errorMessage;
        System.arraycopy(params, 0, messageWithParams, 1, messageWithParams.length - 1);
        return messageWithParams;
    }

    public void setMessage(String msg) {
        this.errorMessage = msg;
    }

    public String getUserMessage() {
        return errorMessage;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public void setErrorKey(String errorKey) {
        this.errorKey = errorKey;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public String getTabErrorKey() {
        return tabErrorKey;
    }

    public void setTabErrorKey(String tabErrorKey) {
        this.tabErrorKey = tabErrorKey;
    }
}
