package org.kuali.coeus.award.api;

import org.apache.commons.lang.StringUtils;
import org.kuali.coeus.award.dto.AwardDto;
import org.kuali.coeus.award.dto.AwardNotepadDto;
import org.kuali.coeus.award.dto.AwardPersonDto;
import org.kuali.coeus.award.finance.AwardUnitContactDto;
import org.kuali.coeus.common.api.document.service.CommonApiService;
import org.kuali.coeus.sys.framework.rest.ResourceNotFoundException;
import org.kuali.kra.award.dao.AwardDao;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.notesandattachments.notes.AwardNotepad;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.datetime.DateTimeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value="/api/v2")
@Controller("awardUcarController")
public class AwardUcarController extends AwardControllerBase {

    @Autowired
    @Qualifier("awardDao")
    private AwardDao awardDao;

    @Autowired
    @Qualifier("commonApiService")
    private CommonApiService commonApiService;

    @Autowired
    @Qualifier("documentService")
    private DocumentService documentService;

    @RequestMapping(method= RequestMethod.GET, value="/award_named_user", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    AwardDto getAwardByUser(@RequestParam(value = "awardNumber", required = true) String awardNumber,
                                  @RequestParam(value = "includeBudgets", required = false) boolean includeBudgets,
                                  @RequestHeader(value="userName", required = true) String userName
    ) {
        // Check if the user is named on the award (i.e. PI, CO-I, Unit Contact)
        assertUserHasReadAccess();
        commonApiService.clearErrors();
        List<Award> awards = getAwardDao().getAwardByAwardNumber(awardNumber);
        List<AwardDto> awardDtos = translateAwards(includeBudgets, awards);
        Boolean userFound = false;
        AwardDto activeAwardDto = new AwardDto();
        for (AwardDto awardDto : awardDtos) {
            if (awardDto.getAwardSequenceStatus().equals("ACTIVE")) {
                List<AwardPersonDto> projectPersonList = awardDto.getProjectPersons();
                for (AwardPersonDto projectPerson : projectPersonList) {
                    String projectPersonUserName = StringUtils.substringBefore(projectPerson.getEmailAddress(), "@");
                    if(projectPersonUserName.equals(userName) && (projectPerson.getRoleCode().equals("PI") || projectPerson.getRoleCode().equals("COI"))) {
                        userFound = true;
                        activeAwardDto = awardDto;
                        break;
                    }
                }
                if (!userFound) {
                    List<AwardUnitContactDto> awardUnitContacts = awardDto.getAwardUnitContacts();
                    for (AwardUnitContactDto unitContact : awardUnitContacts) {
                        if (unitContact.getPerson().getUserName().equals(userName)) {
                            activeAwardDto = awardDto;
                            break;
                        }
                    }
                }
            }
        }
        return activeAwardDto;
    }

    // Add award note
    @RequestMapping(method= RequestMethod.POST, value="/awardnote", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public List<AwardNotepadDto> addAwardNote(@RequestParam(value = "awardId", required = true) Long awardId,
                                                @RequestBody AwardNotepadDto awardNotepadDto,
                                                @RequestHeader(value="userName", required = true) String userName) throws WorkflowException {
        assertUserHasAwardPersonWriteAccess();
        commonApiService.clearErrors();
        AwardNotepad awardNotepad = commonApiService.convertObject(awardNotepadDto, AwardNotepad.class);
        AwardDocument awardDocument = getAwardDocumentById(awardId);
        Award award = awardDocument.getAward();
        awardNotepad.setCreateTimestamp(KcServiceLocator.getService(DateTimeService.class).getCurrentTimestamp());
        awardNotepad.setUpdateTimestamp(awardNotepad.getCreateTimestamp());
        awardNotepad.setCreateUser(userName);
        awardNotepad.setUpdateUser(userName);
        awardNotepad.setAward(award);
        awardDocument.getAward().add(awardNotepad);
        AwardDocument newAwardDocument = (AwardDocument) documentService.saveDocument(awardDocument);
        List<AwardNotepadDto> awardNotepadDtos = getAwardNotepadDtos(newAwardDocument);
        return awardNotepadDtos;
    }

    protected List<AwardNotepadDto> getAwardNotepadDtos(AwardDocument awardDocument) {
        List<AwardNotepadDto> awardNotepadDtos = awardDocument.getAward().getAwardNotepads().stream().map(awardNotepad -> commonApiService.convertObject(awardNotepad, AwardNotepadDto.class)).collect(Collectors.toList());
        return awardNotepadDtos;
    }

    public AwardDocument getAwardDocumentById(Long awardId) {
        Award award = awardDao.getAward(awardId);
        if(award == null) {
            throw new ResourceNotFoundException("Award with award id " + awardId + " not found.");
        }
        return (AwardDocument) commonApiService.getDocumentFromDocId(Long.parseLong(award.getAwardDocument().getDocumentNumber()));
    }

    protected List<AwardDto> translateAwards(boolean includeBudgets, List<Award> awards) {
        List<AwardDto> awardDtos = awards.stream().map(award -> {
            AwardDto awardDto = commonApiService.convertAwardToDto(award);
            if (!includeBudgets) {
                awardDto.setBudgets(new ArrayList<>());
            }
            awardDto.setDocNbr(award.getAwardDocument().getDocumentNumber());
            awardDto.setStatusCode(award.getStatusCode());
            return awardDto;
        }).collect(Collectors.toList());
        return awardDtos;
    }
    public AwardDao getAwardDao() {
        return awardDao;
    }
}
