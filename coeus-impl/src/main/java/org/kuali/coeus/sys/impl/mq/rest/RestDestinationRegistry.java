/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.sys.impl.mq.rest;

/**
 * This registry resolves concrete urls for abstract destinations.
 */
public interface RestDestinationRegistry {

    /**
     * Retrieves a url for an abstract destination.
     *
     * @param destination an abstract destination. cannot be null or blank.
     * @return a Url or null if not found.
     * @throws IllegalArgumentException if the destination is null or blank
     */
    String findUrl(String destination);

    /**
     * Determines if a destination is enabled.
     *
     * @param destination an abstract destination. cannot be null or blank.
     * @return if enabled or not.
     * @throws IllegalArgumentException if the destination is null or blank
     */
    boolean isEnabled(String destination);
}
