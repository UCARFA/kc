/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.rest;

public class RestServiceConstants {
	
	public final class Configuration {
		public static final String AUTH_USERS_URL = "auth.users.url";
		public static final String AUTH_BASE_URL = "auth.base.url";
		public static final String CATEGORIES_URL = "core.categories.url";
		public static final String GROUPS_URL = "core.groups.url";
	}
	
	private RestServiceConstants() {
		throw new RuntimeException("constants class. cannot be instantiated.");
	}
}
