/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.security;

import org.apache.commons.lang3.StringUtils;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter.XFrameOptionsMode;

import java.util.stream.Stream;

@Configuration
@EnableWebMvcSecurity
@Deprecated
public class SpringRestSecurity extends WebSecurityConfigurerAdapter {

	private static final String ADMIN_ROLE = "ADMIN";
	private static final String KC_REST_ADMIN_PASSWORD = "kc.rest.admin.password";
	private static final String KC_REST_ADMIN_USERNAME = "kc.rest.admin.username";
	private static final String AUTH_REST_URLS_REGEX = "auth.rest.urls.regex";
	@Autowired
	@Qualifier("kualiConfigurationService")
	private ConfigurationService configurationService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		String userName = configurationService.getPropertyValueAsString(KC_REST_ADMIN_USERNAME);
		String password = configurationService.getPropertyValueAsString(KC_REST_ADMIN_PASSWORD);
		if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)) {
			auth.inMemoryAuthentication().withUser(userName).password(password).roles(ADMIN_ROLE);
		}
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().xssProtection().and().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsMode.SAMEORIGIN));

		final String authRestUrlsRegex = configurationService.getPropertyValueAsString(AUTH_REST_URLS_REGEX);
		if (StringUtils.isNotBlank(authRestUrlsRegex)) {
			Stream.of(authRestUrlsRegex.split(","))
					.map(String::trim)
					.forEach(regex -> {
				try {
					http.authorizeRequests().regexMatchers(regex).hasRole(ADMIN_ROLE).and().httpBasic();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});
		}
	}

	public ConfigurationService getConfigurationService() {
		return configurationService;
	}

	public void setConfigurationService(ConfigurationService configurationService) {
		this.configurationService = configurationService;
	}
}
