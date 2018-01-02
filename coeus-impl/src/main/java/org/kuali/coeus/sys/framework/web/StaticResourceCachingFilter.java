/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2017 Kuali, Inc.
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
