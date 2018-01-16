/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.api.unit;

import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.sys.framework.controller.rest.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codiform.moo.curry.Translate;

@Controller("unitRestController")
public class UnitRestController extends RestController {
	
	@Autowired
	@Qualifier("unitService")
	private UnitService unitService;
	
	@RequestMapping(value="/api/v1/units/top-unit", method=RequestMethod.GET)
	public @ResponseBody UnitDto getTopUnit() {
		return Translate.to(UnitDto.class).from(getUnitService().getTopUnit());
	}

	public UnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(UnitService unitService) {
		this.unitService = unitService;
	}
	
}
