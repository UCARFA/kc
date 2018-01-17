/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.session.ser;


public class SerializableUserSessionAttribute extends SerializableSessionAttribute {
    public SerializableUserSessionAttribute() {
        super();
    }

    public SerializableUserSessionAttribute(String sessionId, String name, String type, String value, boolean serializable, int size, String failurePath) {
        super(sessionId, name, type, value, serializable, size, failurePath);
    }
}
