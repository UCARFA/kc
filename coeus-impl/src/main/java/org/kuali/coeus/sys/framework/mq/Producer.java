/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.mq;

import java.io.Serializable;

/**
 * This interface describes a message producer for a specific message type.
 * @param <T> the message type.
 */
public interface Producer<T extends Serializable> {

    /**
     * Sends a message of type type.  The message cannot be null.
     * @param message The message object.  This object is not a JMS type but rather the pieve of the message that is
     *                 wrapped by a JMS type
     *
     * @throws IllegalArgumentException if the message is null or not valid
     */
    void sendMessage(final T message);
}