/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.motd;

import java.util.List;


public interface MessageOfTheDayService {

    /**
     * The method gets the message of the day.  Only active messages are returned.  Will never return null.
     * The messages will be sorted ascending by display order.
     *
     * @return a list of active messages or an empty list if none are found.
     */
    List<MessageOfTheDay> getMessagesOfTheDay();

 }
