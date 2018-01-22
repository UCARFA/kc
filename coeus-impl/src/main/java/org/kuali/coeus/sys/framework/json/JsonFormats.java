/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.sys.framework.json;

public final class JsonFormats {

    public static final String SERIALIZED_SQL_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DESERIALIZED_SQL_DATE_FORMAT = "MM/dd/yyyy";

    private JsonFormats() {
        throw new UnsupportedOperationException("do not call");
    }
}
