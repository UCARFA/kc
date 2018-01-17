/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class KcDtoServiceBase<T, S> implements KcDtoService<T, S> {
	@Override
    public List<T> buildDtoList(Collection<S> items) {
		List<T> result = new ArrayList<T>();
		if (items != null) {
			for (S item : items) {
				result.add(buildDto(item));
			}
		}
		return result;
	}

	@Override
	public abstract T buildDto(S dataObject);
}
