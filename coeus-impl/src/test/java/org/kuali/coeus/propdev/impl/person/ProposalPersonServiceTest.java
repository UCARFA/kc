/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.core.api.criteria.GenericQueryResults;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.krad.data.DataObjectService;

public class ProposalPersonServiceTest {
	private Mockery context;
	private ProposalPersonServiceImpl proposalPersonService;
	private DataObjectService dataObjectService;
	private GenericQueryResults.Builder proposalPersonListBuilder;
	private KcPersonService kcPersonService;

	@Before
	public void setUp() throws Exception {
		context = new JUnit4Mockery() {
			{
				setThreadingPolicy(new Synchroniser());
			}
		};
		proposalPersonService = new ProposalPersonServiceImpl();
		dataObjectService = context.mock(DataObjectService.class);
		kcPersonService = context.mock(KcPersonService.class);

		final ProposalPerson proposalPerson = new ProposalPerson();

		proposalPersonListBuilder = (GenericQueryResults.Builder<ProposalPerson>) GenericQueryResults.Builder.create();
		proposalPersonListBuilder.setResults(new ArrayList<ProposalPerson>() {
			{
				add(proposalPerson);
			}
		});
	}

	@Test
	public void test_getProposalKeyPersonnel() {
		final QueryByCriteria.Builder criteria = QueryByCriteria.Builder
				.create().setPredicates(
						PredicateFactory.equal(
								"developmentProposal.proposalNumber", "111"));

		context.checking(new Expectations() {
			{
				oneOf(dataObjectService).findMatching(ProposalPerson.class,
						criteria.build()).getResults();
				will(returnValue(proposalPersonListBuilder.build()));
			}
		});
		proposalPersonService.setDataObjectService(dataObjectService);

		assertEquals(1.0, proposalPersonService.getProposalKeyPersonnel("111")
				.size(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_getProposalKeyPersonnel_no_proposalNumber() {
		final QueryByCriteria.Builder criteria = QueryByCriteria.Builder
				.create().setPredicates(
						PredicateFactory.equal(
								"developmentProposal.proposalNumber", null));

		context.checking(new Expectations() {
			{
				oneOf(dataObjectService).findMatching(ProposalPerson.class,
						criteria.build()).getResults();
				will(returnValue(proposalPersonListBuilder.build()));
			}
		});
		proposalPersonService.setDataObjectService(dataObjectService);
		proposalPersonService.getProposalKeyPersonnel(null);
	}

	@Test
	public void test_getPersonName() {
		ProposalDevelopmentDocument doc = new ProposalDevelopmentDocument();
		List<ProposalPerson> proposalPersons = new ArrayList<ProposalPerson>();
		ProposalPerson proposalPerson = new ProposalPerson();
		proposalPerson.setPersonId("123");
		proposalPerson.setFullName("ALAN  MCAFEE");
		proposalPersons.add(proposalPerson);
		doc.getDevelopmentProposal().setProposalPersons(proposalPersons);
		assertEquals(proposalPersonService.getPersonName(doc, "123"),
				"ALAN  MCAFEE");
	}

	@Test
	public void test_getPersonName_no_propPersonName() {
		ProposalDevelopmentDocument doc = new ProposalDevelopmentDocument();
		List<ProposalPerson> proposalPersons = new ArrayList<ProposalPerson>();
		ProposalPerson proposalPerson = new ProposalPerson();
		proposalPerson.setPersonId("123");
		proposalPersons.add(proposalPerson);
		doc.getDevelopmentProposal().setProposalPersons(proposalPersons);

		final KcPerson person = new KcPerson() {
			private String personId;
            @Override
			public void setPersonId(String personId) {
				this.personId = personId;
			}
		};
		context.checking(new Expectations() {
			{
				oneOf(kcPersonService).getKcPersonByPersonId("123");
				will(returnValue(person));
			}
		});
		proposalPersonService.setKcPersonService(kcPersonService);
		assertNotNull(proposalPersonService.getPersonName(doc, "123"));
	}

	@Test
	public void test_getPersonName_empty_proposalPersons() {
		ProposalDevelopmentDocument doc = new ProposalDevelopmentDocument();
		doc.getDevelopmentProposal().setProposalNumber("111");
		final QueryByCriteria.Builder criteria = QueryByCriteria.Builder
				.create().setPredicates(
						PredicateFactory.equal(
								"developmentProposal.proposalNumber", "111"));
		final KcPerson person = new KcPerson() {
            private String personId;
            @Override
			public void setPersonId(String personId) {
				this.personId = personId;
			}
		};
		context.checking(new Expectations() {
			{
				oneOf(dataObjectService).findMatching(ProposalPerson.class,
						criteria.build()).getResults();
				will(returnValue(proposalPersonListBuilder.build()));
				oneOf(kcPersonService).getKcPersonByPersonId("123");
				will(returnValue(person));
			}
		});
		proposalPersonService.setDataObjectService(dataObjectService);
		proposalPersonService.setKcPersonService(kcPersonService);

		assertNotNull(proposalPersonService.getPersonName(doc, "123"));
	}
}
