/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.sys.framework.web;

import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StaticResourceCachingFilter extends ShallowEtagHeaderFilter {

    public static final String CACHE_DURATION_INIT_PARAM = "cacheDuration";
    public static final int DEFAULT_CACHE_DURATION = 300;

    private int cacheDuration = DEFAULT_CACHE_DURATION;

    @Override
    public void initFilterBean() throws ServletException {
        String cacheDurationString = getFilterConfig().getInitParameter(CACHE_DURATION_INIT_PARAM);
        if (cacheDurationString != null) {
            cacheDuration = Integer.parseInt(cacheDurationString);
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        response.setHeader(HttpHeaders.CACHE_CONTROL, String.format("max-age=%d", cacheDuration));
        super.doFilterInternal(request, response, filterChain);
    }

}
