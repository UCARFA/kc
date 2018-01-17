/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.dc.common.db;

public class DbValidatorDaoServiceMySqlImpl extends AbstractDbValidatorDaoService {

    public static final String VALIDATION_QUERY = "select 1";

    @Override
    public String getValidationQuery() {
        return VALIDATION_QUERY;
    }
}
