/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

import static org.kuali.coeus.sys.framework.service.KcServiceLocator.getService;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.common.framework.org.Organization;
import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.coeus.propdev.impl.attachment.NarrativeAttachment;
import org.kuali.coeus.propdev.impl.attachment.NarrativeType;
import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.util.ClassLoaderUtils;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class RRBudgetV1_3GeneratorTest extends
		S2SModularBudgetTestBase {

	@Override
	protected String getFormGeneratorName() {
		return RRBudgetV1_3Generator.class.getSimpleName();
	}

	@Override
	protected void prepareData(ProposalDevelopmentDocument document)
			throws Exception {

		Organization organization = getService(DataObjectService.class).findUnique(Organization.class, 
				QueryByCriteria.Builder.forAttribute("organizationId", "000001").build());
		document.getDevelopmentProposal().getApplicantOrganization().setOrganization(organization);

		NarrativeAttachment narrativeAttachment = new NarrativeAttachment();
		DefaultResourceLoader resourceLoader = new DefaultResourceLoader(
				ClassLoaderUtils.getDefaultClassLoader());
		Resource resource = resourceLoader
				.getResource(S2STestConstants.ATT_PACKAGE + "/exercise2.pdf");
		InputStream inputStream = resource.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		byte[] narrativePdf = new byte[bis.available()];
		narrativeAttachment.setData(narrativePdf);
		narrativeAttachment.setName("exercise1");
		Narrative narrative = new Narrative();
		List<Narrative> narrativeList = new ArrayList<Narrative>();
		narrative.setDevelopmentProposal(document.getDevelopmentProposal());
		NarrativeType narrativeType = getService(DataObjectService.class).findUnique(NarrativeType.class, QueryByCriteria.Builder.forAttribute("code", "7").build());
		narrative.setName("exercise1");
        narrative.setNarrativeType(narrativeType);
		narrative.setNarrativeTypeCode(narrativeType.getCode());
		narrative.setNarrativeAttachment(narrativeAttachment);
        narrative.setModuleNumber(1);
        narrative.setModuleSequenceNumber(1);
        narrative.setModuleStatusCode("C");
		narrativeList.add(narrative);
		document.getDevelopmentProposal().setNarratives(narrativeList);

		List<ProposalPerson> proposalPersons = new ArrayList<ProposalPerson>();
		ProposalPerson principalInvestigator = new ProposalPerson();
		principalInvestigator.setFirstName("ALAN");
		principalInvestigator.setLastName("MCAFEE");
		principalInvestigator.setProposalPersonRoleId("PI");
		principalInvestigator.setPersonId("0001");
		principalInvestigator.setRolodexId(0010);
        principalInvestigator.setProposalPersonNumber(1);
        principalInvestigator.setDevelopmentProposal(document.getDevelopmentProposal());
		proposalPersons.add(principalInvestigator);
		document.getDevelopmentProposal().setProposalPersons(proposalPersons);

		ProposalDevelopmentBudgetExt proposalDevelopmentBudgetExt = new ProposalDevelopmentBudgetExt();
        proposalDevelopmentBudgetExt.setDevelopmentProposal(document.getDevelopmentProposal());
        proposalDevelopmentBudgetExt.setBudgetVersionNumber(1);
		proposalDevelopmentBudgetExt.setBudgetStatus("1");
		proposalDevelopmentBudgetExt.setBudgetId(1L);
		proposalDevelopmentBudgetExt
				.setName("test Document Description");
		proposalDevelopmentBudgetExt.setOnOffCampusFlag("Y");
		proposalDevelopmentBudgetExt.setStartDate(new Date(new Long(
				"1183316613046")));
		proposalDevelopmentBudgetExt.setEndDate(new Date(new Long(
				"1214852613046")));
		proposalDevelopmentBudgetExt.setOhRateTypeCode("1");
		proposalDevelopmentBudgetExt.setOhRateClassCode("1");
		proposalDevelopmentBudgetExt.setModularBudgetFlag(false);
		proposalDevelopmentBudgetExt.setUrRateClassCode("1");
		
		List<BudgetPeriod> budgetPeriods = new ArrayList<BudgetPeriod>();
		BudgetPeriod budgetPeriod = new BudgetPeriod();
		budgetPeriod.setBudgetPeriodId(1L);
		budgetPeriod.setStartDate(new Date(new Long("1183316613046")));
		budgetPeriod.setEndDate(new Date(new Long("1214852613046")));
		budgetPeriod.setBudgetPeriod(1);

		budgetPeriod.setBudget(proposalDevelopmentBudgetExt);
		budgetPeriods.add(budgetPeriod);
		proposalDevelopmentBudgetExt.setBudgetPeriods(budgetPeriods);
		
		List<ProposalDevelopmentBudgetExt> proposalDevelopmentBudgetExtList = new ArrayList<ProposalDevelopmentBudgetExt>();
		proposalDevelopmentBudgetExtList.add(proposalDevelopmentBudgetExt);
		document.getDevelopmentProposal().setBudgets(proposalDevelopmentBudgetExtList);	
		document.getDevelopmentProposal().setFinalBudget(proposalDevelopmentBudgetExt);
	}
}
