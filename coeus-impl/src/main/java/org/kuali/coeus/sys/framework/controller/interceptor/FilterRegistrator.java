/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller.interceptor;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.util.*;

public class FilterRegistrator implements InitializingBean, ServletContextAware {

    private ServletContext servletContext;
    private Filter filter;
    private String filterName;
    private boolean asyncSupported;
    private Map<String, String> initParameters;
    private Mapping servletMapping;
    private Mapping urlMapping;

    @Override
    public void afterPropertiesSet() throws Exception {
        FilterRegistration.Dynamic fr = servletContext.addFilter(filterName, filter);
        fr.setAsyncSupported(asyncSupported);

        if (initParameters != null) {
            fr.setInitParameters(initParameters);
        }

        if (servletMapping != null) {
            fr.addMappingForServletNames(servletMapping.dispatcherTypes != null ? EnumSet.copyOf(servletMapping.dispatcherTypes) : null, servletMapping.matchAfter, servletMapping.maps.toArray(new String[] {}));
        }

        if (urlMapping != null && urlMapping.enabled) {
            fr.addMappingForUrlPatterns(urlMapping.dispatcherTypes != null ? EnumSet.copyOf(urlMapping.dispatcherTypes) : null, urlMapping.matchAfter, urlMapping.maps.toArray(new String[] {}));
        }
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public boolean isAsyncSupported() {
        return asyncSupported;
    }

    public void setAsyncSupported(boolean asyncSupported) {
        this.asyncSupported = asyncSupported;
    }

    public Map<String, String> getInitParameters() {
        return initParameters;
    }

    public void setInitParameters(Map<String, String> initParameters) {
        this.initParameters = initParameters;
    }

    public Mapping getServletMapping() {
        return servletMapping;
    }

    public void setServletMapping(Mapping servletMapping) {
        this.servletMapping = servletMapping;
    }

    public Mapping getUrlMapping() {
        return urlMapping;
    }

    public void setUrlMapping(Mapping urlMapping) {
        this.urlMapping = urlMapping;
    }

    public static class Mapping {
        private Set<DispatcherType> dispatcherTypes;
        private boolean matchAfter;
        List<String> maps;
        private boolean enabled = true;

        public Set<DispatcherType> getDispatcherTypes() {
            return dispatcherTypes;
        }

        public void setDispatcherTypes(Set<DispatcherType> dispatcherTypes) {
            this.dispatcherTypes = dispatcherTypes;
        }

        public boolean isMatchAfter() {
            return matchAfter;
        }

        public void setMatchAfter(boolean matchAfter) {
            this.matchAfter = matchAfter;
        }

        public List<String> getMaps() {
            return maps;
        }

        public void setMaps(List<String> maps) {
            this.maps = maps;
        }

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
    }
}
