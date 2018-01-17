/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.core.category;

import com.codiform.moo.annotation.Ignore;
import org.kuali.coeus.sys.framework.controller.rest.PrimaryKeyDto;

public class BudgetCategoryDto implements PrimaryKeyDto {

	private String code;
	private String budgetCategoryTypeCode;
	private String description;
	@Ignore
	private String _primaryKey;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBudgetCategoryTypeCode() {
		return budgetCategoryTypeCode;
	}
	public void setBudgetCategoryTypeCode(String budgetCategoryTypeCode) {
		this.budgetCategoryTypeCode = budgetCategoryTypeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String get_primaryKey() {
		return _primaryKey;
	}

	@Override
	public void set_primaryKey(String _primaryKey) {
		this._primaryKey = _primaryKey;
	}
}
