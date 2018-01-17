/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.util;

import javax.servlet.http.HttpServletResponse;

public final class HttpUtils {

    private HttpUtils() {
        throw new RuntimeException("do not call");
    }

    /**
     * This method sets headers on a response to disable caching. If the response has already been committed this method
     * will do nothing.
     *
     * @param response the http response. cannot be null.
     * @throws IllegalArgumentException if the response is null.
     */
    public static void disableCache(HttpServletResponse response) {
        if (response == null) {
            throw new IllegalArgumentException("response is null");
        }

        if (!response.isCommitted()) {
            response.setHeader("Expires", "-1");
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
        }
    }
}
