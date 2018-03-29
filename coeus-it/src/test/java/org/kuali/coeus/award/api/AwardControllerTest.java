/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.api;

import org.junit.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.award.dto.AwardDto;
import org.kuali.coeus.award.dto.AwardPersonDto;
import org.kuali.coeus.award.finance.timeAndMoney.api.TimeAndMoneyController;
import org.kuali.coeus.award.finance.timeAndMoney.dto.TimeAndMoneyDto;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.rest.ResourceNotFoundException;
import org.kuali.coeus.sys.framework.rest.UnauthorizedAccessException;
import org.kuali.coeus.sys.framework.rest.UnprocessableEntityException;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.award.contacts.AwardPersonCreditSplit;
import org.kuali.kra.award.contacts.AwardPersonUnitCreditSplit;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.FeatureFlagConstants;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.exception.AuthorizationException;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class AwardControllerTest extends AwardControllerTestBase {


    @Before
    public void beforeTest() {
        updateParameterForTesting(Constants.MODULE_NAMESPACE_SYSTEM, ParameterConstants.DOCUMENT_COMPONENT,
                FeatureFlagConstants.ENABLE_API_AUTHORIZATION, "true");
    }

    @Test
    public void testAwardCreationGoodJson() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useAuthorizedUser();
        // POST
        String jsonInString = getCorrectJson();
        ObjectMapper mapper = new ObjectMapper();

        AwardDto awardDto = mapper.readValue(jsonInString, AwardDto.class);
        AwardDto newAwardDto = getAwardController().createAward(awardDto);
        Assert.assertTrue(newAwardDto.getPrimeSponsorCode() == null);
        Assert.assertTrue(newAwardDto.getUnitNumber().equalsIgnoreCase("000001"));
        Assert.assertTrue(newAwardDto.getSponsorCode().equalsIgnoreCase("000340"));
        Assert.assertTrue(newAwardDto.getAccountNumber().equalsIgnoreCase("123456"));
        Calendar cal = Calendar.getInstance();
        Assert.assertTrue(newAwardDto.getAwardEffectiveDate().compareTo(getDate(2008, 2, 11)) == 0);
        Assert.assertTrue(newAwardDto.getAwardExecutionDate().compareTo(getDate(2008, cal.MARCH, 11)) == 0);
        Assert.assertTrue(newAwardDto.getBeginDate().compareTo(getDate(2008, cal.MARCH, 11)) == 0);
        Assert.assertTrue(newAwardDto.getNoticeDate().compareTo(getDate(2008, cal.MARCH, 11)) == 0);
        Assert.assertTrue(newAwardDto.getProjectEndDate().compareTo(getDate(2008, cal.MARCH, 11)) == 0);
        Assert.assertTrue(newAwardDto.getSponsorAwardNumber() == null);
        Assert.assertTrue(newAwardDto.getAccountTypeCode().toString().equalsIgnoreCase("1"));
        Assert.assertTrue(newAwardDto.getActivityTypeCode().toString().equalsIgnoreCase("1"));
        Assert.assertTrue(newAwardDto.getCfdaNumber().equalsIgnoreCase("00.000"));
        Assert.assertTrue(newAwardDto.getMethodOfPaymentCode().equalsIgnoreCase("1"));
        Assert.assertTrue(newAwardDto.getTitle().equalsIgnoreCase("APPLICATION OF MECHANICAL VIBRATION TO ENHANCE ORTHODONTIC TOOTH MOVEMENT"));
        Assert.assertTrue(newAwardDto.getBasisOfPaymentCode().equalsIgnoreCase("1"));
        Assert.assertTrue(newAwardDto.getAwardTransactionTypeCode().toString().equalsIgnoreCase("1"));
        Assert.assertTrue(newAwardDto.getLeadUnitNumber().equalsIgnoreCase("000001"));
        Assert.assertTrue(newAwardDto.getProjectPersons().size() == 3);
        Assert.assertTrue(newAwardDto.getProjectPersons().get(0).getPersonId().equalsIgnoreCase("10000000018"));
        Assert.assertTrue(newAwardDto.getProjectPersons().get(0).getRoleCode().equalsIgnoreCase("PI"));
        Assert.assertTrue(newAwardDto.getProjectPersons().get(1).getPersonId().equalsIgnoreCase("10000000017"));
        Assert.assertTrue(newAwardDto.getProjectPersons().get(1).getRoleCode().equalsIgnoreCase("COI"));
        Assert.assertTrue(newAwardDto.getProjectPersons().get(2).getPersonId().equalsIgnoreCase("10000000030"));
        Assert.assertTrue(newAwardDto.getProjectPersons().get(2).getRoleCode().equalsIgnoreCase("KP"));
        Assert.assertTrue(newAwardDto.getProjectPersons().get(2).getKeyPersonRole().equalsIgnoreCase("Postdoc"));
        Assert.assertTrue(newAwardDto.getAwardCustomDataList().size() == 2);
        Assert.assertTrue(newAwardDto.getAwardCustomDataList().get(0).getCustomAttributeId().toString().equalsIgnoreCase("1"));
        Assert.assertTrue(newAwardDto.getAwardCustomDataList().get(0).getValue().toString().equalsIgnoreCase("2"));
        Assert.assertTrue(newAwardDto.getAwardCustomDataList().get(1).getCustomAttributeId().toString().equalsIgnoreCase("4"));
        Assert.assertTrue(newAwardDto.getAwardCustomDataList().get(1).getValue().toString().equalsIgnoreCase("2"));
        Assert.assertTrue(newAwardDto.getAwardSponsorTerms().size() == 9);
        Assert.assertTrue(newAwardDto.getAwardSponsorContacts().size() == 1);
        Assert.assertTrue(newAwardDto.getAwardSponsorContacts().get(0).getRolodexId() == 132);
        Assert.assertTrue(newAwardDto.getAwardSponsorContacts().get(0).getOrgName().equalsIgnoreCase("NIH-NI AAA"));
        Assert.assertNotNull(newAwardDto.getProjectPersons().get(0).getEmailAddress());
        Assert.assertNotNull(newAwardDto.getProjectPersons().get(1).getEmailAddress());
        Assert.assertNotNull(newAwardDto.getProjectPersons().get(2).getEmailAddress());
        Assert.assertTrue(newAwardDto.getProjectPersons().get(0).getPhoneNumber().equalsIgnoreCase("321-321-1214"));


        ArrayList<Long> termIds = new ArrayList<>();
        termIds.add(307L); termIds.add(308L); termIds.add(309L); termIds.add(310L);
        termIds.add(311L); termIds.add(312L); termIds.add(313L); termIds.add(314L);
        termIds.add(314L); termIds.add(315L);
        List<Long> sponsorTermIds = newAwardDto.getAwardSponsorTerms().stream().map(p -> p.getSponsorTermId()).collect(Collectors.toList());
        sponsorTermIds.removeAll(termIds);
        Assert.assertTrue(newAwardDto.getAwardReportTerms().size() == 2);
        Assert.assertTrue(sponsorTermIds.size() == 0);

        // GET PERSONS
        Assert.assertTrue(getAwardController().getAwardPersons(newAwardDto.getAwardId()).size() == 3);
        final Long awardContactId = newAwardDto.getProjectPersons().get(1).getAwardContactId();
        // DELETE PERSONS
        getAwardController().deletePerson(newAwardDto.getAwardId(), awardContactId);
        Assert.assertTrue(getAwardController().getAwardPersons(newAwardDto.getAwardId()).size() == 2);

        // DELETE AWARD
        getAwardController().deleteAward(newAwardDto.getAwardId());
        AwardDto fetchedAwardDto = getAwardController().getAward(newAwardDto.getAwardId(), Boolean.FALSE);
        AwardDocument document = getAwardController().getAwardDocumentById(fetchedAwardDto.getAwardId());
        Assert.assertTrue(document.getDocumentHeader().getWorkflowDocument().getStatus().getLabel().equalsIgnoreCase(KewApiConstants.ROUTE_HEADER_CANCEL_LABEL));

    }

    @Test
    public void testAwardVersioningAndRouting() throws Exception {
        useAuthorizedUser();
        // POST
        String jsonInString = getAwardOnePerson();
        ObjectMapper mapper = new ObjectMapper();

        AwardDto awardDto = mapper.readValue(jsonInString, AwardDto.class);
        AwardDto newAwardDto = getAwardController().createAward(awardDto);
        AwardDocument document = getAwardController().getAwardDocumentById(newAwardDto.getAwardId());

        AwardPerson person = document.getAward().getProjectPerson(0);
        setupCreditSplits(person);

        KcServiceLocator.getService(DocumentService.class).saveDocument(document);
        Assert.assertTrue(document.getAward().getAwardSequenceStatus().toString().equalsIgnoreCase("PENDING"));

        getAwardController().submitDocument(document.getAward().getAwardId());
        document = getAwardController().getAwardDocumentById(document.getAward().getAwardId());
        Assert.assertTrue(document.getDocumentHeader().getWorkflowDocument().getStatus().getLabel().equalsIgnoreCase(KewApiConstants.ROUTE_HEADER_FINAL_LABEL));
        Assert.assertTrue(document.getAward().getAwardSequenceStatus().toString().equalsIgnoreCase("ACTIVE"));

        jsonInString = getCorrectAwardJsonDifferentNoticeDate();
        AwardDto differentAwardDto = mapper.readValue(jsonInString, AwardDto.class);
        AwardDto differentAwardDtoResponse = getAwardController().versionAward(differentAwardDto, document.getAward());
        Assert.assertTrue(differentAwardDtoResponse.getNoticeDate().compareTo(new Date(115, 2, 5)) == 0);

    }

    @Test(expected = UnprocessableEntityException.class)
    public void testAwardVersioningFailure() throws Exception {
        useAuthorizedUser();
        // POST
        String jsonInString = getAwardOnePerson();
        ObjectMapper mapper = new ObjectMapper();

        AwardDto awardDto = mapper.readValue(jsonInString, AwardDto.class);
        AwardDto newAwardDto = getAwardController().createAward(awardDto);
        AwardDocument document = getAwardController().getAwardDocumentById(newAwardDto.getAwardId());

        AwardPerson person = document.getAward().getProjectPerson(0);
        setupCreditSplits(person);

        KcServiceLocator.getService(DocumentService.class).saveDocument(document);
        Assert.assertTrue(document.getAward().getAwardSequenceStatus().toString().equalsIgnoreCase("PENDING"));

        jsonInString = getCorrectAwardJsonDifferentNoticeDate();
        AwardDto differentAwardDto = mapper.readValue(jsonInString, AwardDto.class);
        AwardDto differentAwardDtoResponse = getAwardController().versionAward(differentAwardDto, document.getAward());
        Assert.assertTrue(differentAwardDtoResponse.getNoticeDate().compareTo(new Date(115, 2, 5)) == 0);

    }

    @Override
    public void setupCreditSplits(AwardPerson person) {
        List<AwardPersonCreditSplit> creditSplits = new ArrayList<>();

        AwardPersonCreditSplit awardCreditSplit0 = new AwardPersonCreditSplit();
        awardCreditSplit0.setCredit(new ScaleTwoDecimal(100));
        awardCreditSplit0.setInvCreditTypeCode("0");
        awardCreditSplit0.setAwardPerson(person);
        creditSplits.add(awardCreditSplit0);

        AwardPersonCreditSplit awardCreditSplit = new AwardPersonCreditSplit();
        awardCreditSplit.setCredit(new ScaleTwoDecimal(100));
        awardCreditSplit.setInvCreditTypeCode("1");
        awardCreditSplit.setAwardPerson(person);
        creditSplits.add(awardCreditSplit);

        AwardPersonCreditSplit awardCreditSplit2 = new AwardPersonCreditSplit();
        awardCreditSplit2.setCredit(new ScaleTwoDecimal(100));
        awardCreditSplit2.setInvCreditTypeCode("2");
        awardCreditSplit2.setAwardPerson(person);
        creditSplits.add(awardCreditSplit2);

        AwardPersonCreditSplit awardCreditSplit3 = new AwardPersonCreditSplit();
        awardCreditSplit3.setCredit(new ScaleTwoDecimal(100));
        awardCreditSplit3.setInvCreditTypeCode("3");
        awardCreditSplit3.setAwardPerson(person);
        creditSplits.add(awardCreditSplit3);
        person.setCreditSplits(creditSplits);

        List<AwardPersonUnitCreditSplit> unitCreditSplits = new ArrayList<>();


        AwardPersonUnitCreditSplit awardUnitCreditSplit8 = new AwardPersonUnitCreditSplit();
        awardUnitCreditSplit8.setCredit(new ScaleTwoDecimal(100));
        awardUnitCreditSplit8.setInvCreditTypeCode("0");
        unitCreditSplits.add(awardUnitCreditSplit8);

        AwardPersonUnitCreditSplit awardUnitCreditSplit5 = new AwardPersonUnitCreditSplit();
        awardUnitCreditSplit5.setCredit(new ScaleTwoDecimal(100));
        awardUnitCreditSplit5.setInvCreditTypeCode("1");
        unitCreditSplits.add(awardUnitCreditSplit5);

        AwardPersonUnitCreditSplit awardUnitCreditSplit6 = new AwardPersonUnitCreditSplit();
        awardUnitCreditSplit6.setCredit(new ScaleTwoDecimal(100));
        awardUnitCreditSplit6.setInvCreditTypeCode("2");
        unitCreditSplits.add(awardUnitCreditSplit6);

        AwardPersonUnitCreditSplit awardUnitCreditSplit7 = new AwardPersonUnitCreditSplit();
        awardUnitCreditSplit7.setCredit(new ScaleTwoDecimal(100));
        awardUnitCreditSplit7.setInvCreditTypeCode("3");
        unitCreditSplits.add(awardUnitCreditSplit7);

        person.getUnit(0).setCreditSplits(unitCreditSplits);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testWrongDocumentError() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useAuthorizedUser();
        class AwardControllerMock extends AwardController {
           @Override
           protected Document getDocument(Long documentNumber) {
              return new ProtocolDocument();
           }
       }
        AwardControllerMock mockController = new AwardControllerMock();
        AwardDocument document = mockController.getAwardDocument(12L);
    }

    @Test
    public void testRightDocumentError() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useAuthorizedUser();
        class AwardControllerMock extends AwardController {
            @Override
            protected Document getDocument(Long documentNumber) {
                return new AwardDocument();
            }
        }
        AwardControllerMock mockController = new AwardControllerMock();
        AwardDocument document = mockController.getAwardDocument(12L);
        Assert.assertTrue(document != null);

    }

    @Test
    public void testAwardCreationNoCollections() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useAuthorizedUser();
        String json = getJsonWithoutCollections();
        ObjectMapper mapper = new ObjectMapper();
        AwardDto awardDto = mapper.readValue(json, AwardDto.class);

        AwardDto newAwardDto = getAwardController().createAward(awardDto);
        Assert.assertTrue(newAwardDto.getPrimeSponsorCode() == null);
        Assert.assertTrue(newAwardDto.getUnitNumber().equalsIgnoreCase("000001"));
        Assert.assertTrue(newAwardDto.getSponsorCode().equalsIgnoreCase("000340"));
        Assert.assertTrue(newAwardDto.getAccountNumber().equalsIgnoreCase("123456"));
        Calendar cal = Calendar.getInstance();
        Assert.assertTrue(newAwardDto.getAwardEffectiveDate().compareTo(getDate(2008, 2, 11)) == 0);
        Assert.assertTrue(newAwardDto.getAwardExecutionDate().compareTo(getDate(2008, cal.MARCH, 11)) == 0);
        Assert.assertTrue(newAwardDto.getBeginDate().compareTo(getDate(2008, cal.MARCH, 11)) == 0);
        Assert.assertTrue(newAwardDto.getNoticeDate().compareTo(getDate(2008, cal.MARCH, 11)) == 0);
        Assert.assertTrue(newAwardDto.getProjectEndDate().compareTo(getDate(2008, cal.MARCH, 11)) == 0);
        Assert.assertTrue(newAwardDto.getSponsorAwardNumber() == null);
        Assert.assertTrue(newAwardDto.getAccountTypeCode().toString().equalsIgnoreCase("1"));
        Assert.assertTrue(newAwardDto.getActivityTypeCode().toString().equalsIgnoreCase("1"));
        Assert.assertTrue(newAwardDto.getCfdaNumber().equalsIgnoreCase("00.000"));
        Assert.assertTrue(newAwardDto.getMethodOfPaymentCode().equalsIgnoreCase("1"));
        Assert.assertTrue(newAwardDto.getTitle().equalsIgnoreCase("APPLICATION OF MECHANICAL VIBRATION TO ENHANCE ORTHODONTIC TOOTH MOVEMENT"));
        Assert.assertTrue(newAwardDto.getBasisOfPaymentCode().equalsIgnoreCase("1"));
        Assert.assertTrue(newAwardDto.getAwardTransactionTypeCode().toString().equalsIgnoreCase("1"));
        Assert.assertTrue(newAwardDto.getLeadUnitNumber().equalsIgnoreCase("000001"));
        Assert.assertTrue(newAwardDto.getProjectPersons().size() == 0);
        Assert.assertTrue(newAwardDto.getAwardCustomDataList().size() == 0);
        Assert.assertTrue(newAwardDto.getAwardSponsorTerms().size() == 0);
        Assert.assertTrue(newAwardDto.getAwardReportTerms().size() == 0);

        // GET award
        AwardDto savedAward = getAwardController().getAward(newAwardDto.getAwardId(), Boolean.FALSE);
        Assert.assertTrue(savedAward.getProjectPersons().size() == 0);

        String personJson = getPersonsJson();
        mapper = new ObjectMapper();
        List<AwardPersonDto> persons = mapper.readValue(personJson, mapper.getTypeFactory().constructCollectionType(List.class, AwardPersonDto.class) );

        // POST persons
        getAwardController().addAwardPersons(persons, newAwardDto.getAwardId());
        persons = getAwardController().getAwardPersons(newAwardDto.getAwardId());
        Assert.assertTrue(persons.size() == 3);
    }

    @Test
    public void testAwardVersioningAndTandM() throws Exception {
        useAuthorizedUser();
        // POST
        ObjectMapper mapper = new ObjectMapper();
        String awardString1 = getAwardVersion1();

        AwardDto awardDto = mapper.readValue(awardString1, AwardDto.class);
        AwardDto newAwardDto = getAwardController().createAward(awardDto);
        AwardDocument document = getAwardController().getAwardDocumentById(newAwardDto.getAwardId());

        AwardPerson person = document.getAward().getProjectPerson(0);
        setupCreditSplits(person);

        KcServiceLocator.getService(DocumentService.class).saveDocument(document);
        Assert.assertTrue(document.getAward().getAwardSequenceStatus().toString().equalsIgnoreCase("PENDING"));

        getAwardController().submitDocument(document.getAward().getAwardId());
        document = getAwardController().getAwardDocumentById(document.getAward().getAwardId());
        Assert.assertTrue(document.getDocumentHeader().getWorkflowDocument().getStatus().getLabel().equalsIgnoreCase(KewApiConstants.ROUTE_HEADER_FINAL_LABEL));
        Assert.assertTrue(document.getAward().getAwardSequenceStatus().toString().equalsIgnoreCase("ACTIVE"));

        Award award1 = document.getAward();
        String timeAndMoneyString = getTMVersion1();
        timeAndMoneyString = timeAndMoneyString.replace("awardId\":\"3844\"", "awardId\":\"" +  award1.getAwardId() + "\"");
        timeAndMoneyString = timeAndMoneyString.replace("\"destinationAwardNumber\":\"000090-00001\"", "\"destinationAwardNumber\":\"" +  award1.getAwardNumber() + "\"");
        TimeAndMoneyDto timeAndMoneyDto = mapper.readValue(timeAndMoneyString, TimeAndMoneyDto.class);
        String tm1DocumentNumber = getTimeAndMoneyController().createTimeAndMoneyDocument(timeAndMoneyDto);
        getTimeAndMoneyController().submitDocument(tm1DocumentNumber);
        Calendar cal = Calendar.getInstance();

        Assert.assertTrue(award1.getObligatedTotalDirect().compareTo(new ScaleTwoDecimal(121781L)) == 0);
        Assert.assertTrue(award1.getObligatedTotalIndirect().compareTo(new ScaleTwoDecimal(15105L)) == 0);
        Assert.assertTrue(award1.getAnticipatedTotalDirect().compareTo(new ScaleTwoDecimal(332831L)) == 0);
        Assert.assertTrue(award1.getAnticipatedTotalIndirect().compareTo(new ScaleTwoDecimal(39988L)) == 0);

        Assert.assertTrue(award1.getAwardEffectiveDate().compareTo(getDate(2008, 6, 1)) == 0);
        Assert.assertTrue(award1.getNoticeDate().compareTo(getDate(2008, 6, 16)) == 0);
        Assert.assertTrue(award1.getProjectEndDate().compareTo(getDate(2011, 11, 31)) == 0);
        Assert.assertTrue(award1.getObligationExpirationDate().compareTo(getDate(2009, 5, 30)) == 0);
        Assert.assertTrue(award1.getAwardAmountInfo().getCurrentFundEffectiveDate().compareTo(getDate(2008, 6, 01)) == 0);
        Assert.assertTrue(award1.getAwardExecutionDate().compareTo(getDate(2008, 10, 1)) == 0);

        String awardString2 = getAwardVersion2();
        AwardDto award2Dto = mapper.readValue(awardString2, AwardDto.class);
        AwardDto award2ResultDto = getAwardController().versionAward(award2Dto, award1.getAwardId());
        Long award2Id = award2ResultDto.getAwardId();
        AwardDocument awardDocument2 = getAwardController().getAwardDocumentById(award2Id);
        Award award2 = awardDocument2.getAward();
        person = awardDocument2.getAward().getProjectPerson(0);
        setupCreditSplits(person);
        getAwardController().submitDocument(award2.getAwardId());

        String timeAndMoneyString2 = getTMVersion2();
        timeAndMoneyString2 = timeAndMoneyString2.replace("awardId\":\"3844\"", "awardId\":\"" +  award2.getAwardId() + "\"");
        timeAndMoneyString2 = timeAndMoneyString2.replace("\"destinationAwardNumber\":\"000090-00001\"", "\"destinationAwardNumber\":\"" +  award2.getAwardNumber() + "\"");
        TimeAndMoneyDto timeAndMoney2Dto = mapper.readValue(timeAndMoneyString2, TimeAndMoneyDto.class);
        String tmDocNumber2 = getTimeAndMoneyController().versionTimeAndMoney(timeAndMoney2Dto, tm1DocumentNumber);
        getTimeAndMoneyController().submitDocument(tmDocNumber2);

        Assert.assertTrue(award2.getObligatedTotalDirect().compareTo(new ScaleTwoDecimal(222921L)) == 0);
        Assert.assertTrue(award2.getObligatedTotalIndirect().compareTo(new ScaleTwoDecimal(26664L)) == 0);
        Assert.assertTrue(award2.getAnticipatedTotalDirect().compareTo(new ScaleTwoDecimal(332831L)) == 0);
        Assert.assertTrue(award2.getAnticipatedTotalIndirect().compareTo(new ScaleTwoDecimal(39988L)) == 0);

        Assert.assertTrue(award2.getAwardEffectiveDate().compareTo(getDate(2008, 6, 1)) == 0);
        Assert.assertTrue(award2.getNoticeDate().compareTo(getDate(2009, 8, 17)) == 0);
        Assert.assertTrue(award2.getProjectEndDate().compareTo(getDate(2011, 11, 31)) == 0);
        Assert.assertTrue(award2.getObligationExpirationDate().compareTo(getDate(2010, 5, 30)) == 0);
        Assert.assertTrue(award2.getAwardAmountInfo().getCurrentFundEffectiveDate().compareTo(getDate(2009, 6, 01)) == 0);
        Assert.assertTrue(award2.getAwardExecutionDate().compareTo(getDate(2008, 11, 1)) == 0);

        String awardString3 = getAwardVersion3();
        AwardDto award3Dto = mapper.readValue(awardString3, AwardDto.class);
        AwardDto awardVersion3Dto = getAwardController().versionAward(award3Dto, award2.getAwardId());
        Long award3Id = awardVersion3Dto.getAwardId();
        AwardDocument awardDocument3 = getAwardController().getAwardDocumentById(award3Id);
        Award award3 = awardDocument3.getAward();
        person = awardDocument3.getAward().getProjectPerson(0);
        setupCreditSplits(person);
        getAwardController().submitDocument(award3.getAwardId());

        String timeAndMoneyString3 = getTMVersion3();
        timeAndMoneyString3 = timeAndMoneyString3.replace("awardId\":\"3844\"", "awardId\":\"" +  award3.getAwardId() + "\"");
        timeAndMoneyString3 = timeAndMoneyString3.replace("\"destinationAwardNumber\":\"000090-00001\"", "\"destinationAwardNumber\":\"" +  award3.getAwardNumber() + "\"");
        TimeAndMoneyDto timeAndMoney3Dto = mapper.readValue(timeAndMoneyString3, TimeAndMoneyDto.class);
        String tmDocNumber3 = getTimeAndMoneyController().versionTimeAndMoney(timeAndMoney3Dto, tmDocNumber2);
        getTimeAndMoneyController().submitDocument(tmDocNumber3);

        Assert.assertTrue(award3.getObligatedTotalDirect().compareTo(new ScaleTwoDecimal(332831L)) == 0);
        Assert.assertTrue(award3.getObligatedTotalIndirect().compareTo(new ScaleTwoDecimal(39988L)) == 0);
        Assert.assertTrue(award3.getAnticipatedTotalDirect().compareTo(new ScaleTwoDecimal(332831L)) == 0);
        Assert.assertTrue(award3.getAnticipatedTotalIndirect().compareTo(new ScaleTwoDecimal(39988L)) == 0);

        Assert.assertTrue(award3.getAwardEffectiveDate().compareTo(getDate(2008, 6, 1)) == 0);
        Assert.assertTrue(award3.getNoticeDate().compareTo(getDate(2010, 10, 2)) == 0);
        Assert.assertTrue(award3.getProjectEndDate().compareTo(getDate(2011, 11, 31)) == 0);
        Assert.assertTrue(award3.getObligationExpirationDate().compareTo(getDate(2011, 5, 30)) == 0);
        Assert.assertTrue(award3.getAwardAmountInfo().getCurrentFundEffectiveDate().compareTo(getDate(2010, 6, 01)) == 0);
        Assert.assertTrue(award3.getAwardExecutionDate().compareTo(getDate(2008, 6, 1)) == 0);

    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testAwardVersioningAndRoutingWithoutAuthorization() throws Exception {
        useUnauthorizedUser();
        String jsonInString = getCorrectAwardJsonDifferentNoticeDate();
        ObjectMapper mapper = new ObjectMapper();
        AwardDto differentAwardDto = mapper.readValue(jsonInString, AwardDto.class);
        AwardDto differentAwardDtoResponse = getAwardController().versionAward(differentAwardDto, 11L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testAwardCreationGoodJsonWithoutAuthorization() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        String jsonInString = getCorrectJson();
        ObjectMapper mapper = new ObjectMapper();

        AwardDto awardDto = mapper.readValue(jsonInString, AwardDto.class);
        AwardDto newAwardDto = getAwardController().createAward(awardDto);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testGetAwardWithoutAuthorization() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getAwardController().getAward(11L, false);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testGetAwardByCriteriaWithoutAuthorization() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getAwardController().getAwardByCriteria("11", "00001", false);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testDeleteAwardWithoutAuthorization() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getAwardController().deleteAward(11L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testSubmitDocumentWithoutAuthorization() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getAwardController().submitDocument(11L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testGetBudgetsWithoutAuthorization() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getAwardController().getBudgets(11L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testAddAwardPersonsWithoutAuthorization() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getAwardController().addAwardPersons(null, 11L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testGetAwardPersonsWithoutAuthorization() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getAwardController().getAwardPersons(11L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testDeletePersonWithoutAuthorization() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getAwardController().deletePerson(11L, 1L);
    }

    @Override
    public java.sql.Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set( cal.YEAR, year );
        cal.set( cal.MONTH, month);
        cal.set( cal.DATE, day);

        cal.set( cal.HOUR_OF_DAY, 0 );
        cal.set( cal.MINUTE, 0 );
        cal.set( cal.SECOND, 0 );
        cal.set( cal.MILLISECOND, 0 );

        return new java.sql.Date( cal.getTime().getTime() );
    }


    @Override
    public AwardController getAwardController() throws IntrospectionException {
        return KcServiceLocator.getService(AwardController.class);
    }

    @Override
    public TimeAndMoneyController getTimeAndMoneyController() throws IntrospectionException {
        return KcServiceLocator.getService(TimeAndMoneyController.class);
    }
    }
