/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller.rest;

import org.springframework.beans.BeansException;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

public class RestSimpleUrlHandlerMapping extends SimpleUrlHandlerMapping {

    //making public for external access
    @Override
    public void registerHandler(String urlPath, Object handler) throws BeansException, IllegalStateException {
        super.registerHandler(urlPath, handler);
    }
}