/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl;

import java.util.Map;

/**
 * Defines the text renderer for Notifications.
 */
public interface NotificationRenderer {

    /**
     * Renders the message in {@code text} using default replacement parameters.
     * 
     * @param text the message to be rendered
     * @return the message with all possible search and replace parameters filled in
     */
    String render(String text);
    
    /**
     * Returns the default replacement parameters for the renderer.
     * 
     * @return the default replacement parameters for the renderer
     */
    Map<String, String> getDefaultReplacementParameters();

}
