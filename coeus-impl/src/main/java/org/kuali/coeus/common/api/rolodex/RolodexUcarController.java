package org.kuali.coeus.common.api.rolodex;

import org.kuali.coeus.award.dto.RolodexDto;
import org.kuali.coeus.common.api.document.service.CommonApiService;
import org.kuali.coeus.common.framework.rolodex.Rolodex;
import org.kuali.coeus.sys.framework.controller.rest.RestController;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.data.platform.MaxValueIncrementerFactory;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RequestMapping(value="/api/v2")
@Controller("rolodexUcarController")
public class RolodexUcarController extends RestController {

    public static final String ROLODEX_ID_SEQUENCE_NAME = "SEQ_ROLODEX_ID";

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Autowired
    @Qualifier("commonApiService")
    private CommonApiService commonApiService;


    @Autowired
    @Qualifier("kradApplicationDataSource")
    private DataSource kradApplicationDataSource;

    // Add rolodex record
    @RequestMapping(method= RequestMethod.POST, value="/rolodexes", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public RolodexDto addAwardNote(@RequestBody RolodexDto rolodexDto) throws WorkflowException {
        commonApiService.clearErrors();
        Rolodex rolodex = commonApiService.convertObject(rolodexDto, Rolodex.class);
        rolodex.setRolodexId(Integer.parseInt(Long.valueOf(MaxValueIncrementerFactory.getIncrementer(getKradApplicationDataSource(), ROLODEX_ID_SEQUENCE_NAME).nextLongValue()).toString()));
        rolodex.setActive(true);
        getBusinessObjectService().save(rolodex);
        RolodexDto newRolodexDto = commonApiService.convertObject(rolodex, RolodexDto.class);
        return newRolodexDto;
    }

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public DataSource getKradApplicationDataSource() {
        if(kradApplicationDataSource == null) {
            kradApplicationDataSource = KcServiceLocator.getService("kradApplicationDataSource");
        }
        return kradApplicationDataSource;
    }
}
