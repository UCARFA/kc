/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller.rest.editor;

import java.beans.PropertyEditorSupport;
import java.time.Instant;

public class InstantCustomPropertyEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		if (getValue() != null && getValue() instanceof Instant) {
			return String.valueOf(((Instant)getValue()).toEpochMilli());
		} else {
			return super.getAsText();
		}
	}

	@Override
	public void setAsText(String value) {
		setValue(Instant.ofEpochMilli(Long.parseLong(value)));
	}
}
