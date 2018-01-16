/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorMessageMap {
    private Map<String, List<String>> errors;

    public ErrorMessageMap() {
        super();
    }

    public ErrorMessageMap(Map<String, List<String>> errors) {
        this.errors = errors;
    }

	public Map<String, List<String>> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, List<String>> errors) {
		this.errors = errors;
	}

    public void addError(String key, String value) {
        if (errors == null) {
            errors = new HashMap<>();
        }

        List<String> values = errors.get(key);
        if (values == null) {
            values = new ArrayList<>();
            errors.put(key, values);
        }

        values.add(value);
    }

    public ErrorMessageMap merge(ErrorMessageMap errorMessageMap) {
        errorMessageMap.errors.entrySet().forEach(entry -> {
            List<String> values = errors.get(entry.getKey());
            if (values == null) {
                values = new ArrayList<>();
                errors.put(entry.getKey(), values);
            }

            values.addAll(entry.getValue());
        });
        return this;
    }
}
