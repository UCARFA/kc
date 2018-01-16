/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.auth;

import org.kuali.coeus.common.framework.unit.Unit;
import org.springframework.stereotype.Component;

@Component("collegeLevelUnitHeadDerivedRoleTypeService")
public class CollegeLevelUnitHeadDerivedRoleTypeServiceImpl extends DepartmentLevelUnitHeadDerivedRoleTypeServiceImpl {

	@Override
	protected String getUnitNumberForPersonUnit(Unit unit) {
		return unit.getParentUnitNumber();
	}
}
