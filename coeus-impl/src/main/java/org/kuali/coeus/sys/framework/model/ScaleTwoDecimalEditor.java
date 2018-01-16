/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.model;

import java.beans.PropertyEditorSupport;
import java.text.DecimalFormat;
import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

public class ScaleTwoDecimalEditor extends PropertyEditorSupport {

	private DecimalFormat numberFormat;
	private boolean allowEmpty;

	public ScaleTwoDecimalEditor(DecimalFormat numberFormat, boolean allowEmpty) {
		this.numberFormat = numberFormat;
		this.numberFormat.setGroupingUsed(true);
		this.numberFormat.setGroupingSize(3);
		this.allowEmpty = allowEmpty;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && StringUtils.isBlank(text)) {
			setValue(null);
		} else if (this.numberFormat != null) {
			try {
				setValue(new ScaleTwoDecimal(numberFormat.parse(text).toString()));
			} catch (ParseException e) {
				throw new IllegalArgumentException(text + " is not parsable by the NumberFormat provided(" + numberFormat.toString() + ")");
			}
		} else {
			setValue(new ScaleTwoDecimal(text));
		}
	}

	@Override
	public String getAsText() {
		String strValue = "";
		Object value = getValue();
		if (value == null) {
			if (numberFormat != null) {
				strValue = numberFormat.format(0);
			}
		} else if (numberFormat != null) {
			strValue = numberFormat.format(value);
		}else {
			strValue = value.toString();
		}
		return strValue;
	}

	@Override
	public ScaleTwoDecimal getValue() {
		final Object o = super.getValue();
		return o instanceof ScaleTwoDecimal ? (ScaleTwoDecimal) o :
				o != null ? new ScaleTwoDecimal(o.toString()) : null;
	}

	public DecimalFormat getNumberFormat() {
		return numberFormat;
	}

	public void setNumberFormat(DecimalFormat numberFormat) {
		this.numberFormat = numberFormat;
	}

	public boolean isAllowEmpty() {
		return allowEmpty;
	}

	public void setAllowEmpty(boolean allowEmpty) {
		this.allowEmpty = allowEmpty;
	}
	

}
