/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.finance;

import org.kuali.coeus.common.framework.person.KcPersonDto;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministratorTypeDto;

import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;

public class AwardUnitContactDto {

	@Property(translate = true)
	private UnitAdministratorTypeDto unitAdministratorType;
	@Property(source = "unitAdministratorUnitNumber")
	private String unitNumber;
	@Property(translate = true, optionality = Optionality.OPTIONAL)
	private KcPersonDto person;
	public UnitAdministratorTypeDto getUnitAdministratorType() {
		return unitAdministratorType;
	}
	public void setUnitAdministratorType(UnitAdministratorTypeDto unitAdministratorType) {
		this.unitAdministratorType = unitAdministratorType;
	}
	public String getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	public KcPersonDto getPerson() {
		return person;
	}
	public void setPerson(KcPersonDto person) {
		this.person = person;
	}
}
