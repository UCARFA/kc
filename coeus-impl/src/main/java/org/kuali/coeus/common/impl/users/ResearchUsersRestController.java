/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.users;

import com.codiform.moo.curry.Translate;
import org.kuali.coeus.common.api.person.KcPersonContract;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.sys.framework.controller.rest.RestController;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("researchUsersRestController")
public class ResearchUsersRestController extends RestController{

    @Autowired
    @Qualifier("globalVariableService")
    private GlobalVariableService globalVariableService;

    @Autowired
    @Qualifier("kcPersonService")
    private KcPersonService kcPersonService;

    @RequestMapping(value="/api/v1/research-users/current/", method= RequestMethod.GET)
    public @ResponseBody UserDTO getCurrentResearchUser() throws Exception {
        String principalId = globalVariableService.getUserSession().getPrincipalId();
        KcPerson kcPerson = getKcPersonService().getKcPersonByPersonId(principalId);
        return convertToUserDTO(kcPerson);
    }

    protected UserDTO convertToUserDTO(KcPersonContract kcPerson) {
      return Translate.to(UserDTO.class).from(kcPerson);
    }

    public GlobalVariableService getGlobalVariableService() {
        return globalVariableService;
    }

    public void setGlobalVariableService(GlobalVariableService globalVariableService) {
        this.globalVariableService = globalVariableService;
    }

    public KcPersonService getKcPersonService() {
        return kcPersonService;
    }

    public void setKcPersonService(KcPersonService kcPersonService) {
        this.kcPersonService = kcPersonService;
    }
}
