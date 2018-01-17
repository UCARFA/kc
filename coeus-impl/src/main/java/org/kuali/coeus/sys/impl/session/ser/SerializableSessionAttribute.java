/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.session.ser;


import org.kuali.rice.krad.bo.BusinessObject;

import java.io.Serializable;

public class SerializableSessionAttribute implements Serializable, BusinessObject {

    private String sessionId;
    private String name;
    private String type;
    private String value;
    private boolean serializable;
    private int size;
    private String failurePath;

    public SerializableSessionAttribute() {
        super();
    }

    public SerializableSessionAttribute(String sessionId, String name, String type, String value, boolean serializable, int size, String failurePath) {
        this.sessionId = sessionId;
        this.name = name;
        this.type = type;
        this.value = value;
        this.serializable = serializable;
        this.size = size;
        this.failurePath = failurePath;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSerializable() {
        return serializable;
    }

    public void setSerializable(boolean serializable) {
        this.serializable = serializable;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFailurePath() {
        return failurePath;
    }

    public void setFailurePath(String failurePath) {
        this.failurePath = failurePath;
    }

    @Override
    public void refresh() {
        //no op
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "sessionId='" + sessionId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", serializable=" + serializable +
                ", size=" + size +
                ", failurePath='" + failurePath + '\'' +
                '}';
    }
}
