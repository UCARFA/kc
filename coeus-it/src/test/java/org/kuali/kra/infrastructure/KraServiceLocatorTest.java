/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.infrastructure;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.common.proposal.framework.mail.MailType;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.criteria.Predicate;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.datetime.DateTimeService;
import org.kuali.rice.coreservice.api.CoreServiceApiServiceLocator;
import org.kuali.rice.coreservice.api.parameter.ParameterQueryResults;
import org.kuali.rice.coreservice.api.parameter.ParameterRepositoryService;
import org.kuali.rice.kns.service.DataDictionaryService;
import org.kuali.rice.krad.dao.BusinessObjectDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.kuali.kra.infrastructure.Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT;
import static org.kuali.rice.coreservice.framework.parameter.ParameterConstants.DOCUMENT_COMPONENT;
/**
 * This class tests the KcServiceLocator
 */ 
public class KraServiceLocatorTest extends KcIntegrationTestBase {

    private ParameterRepositoryService parameterRepositoryService;
    
    @Before
    public void setUpServices() {
        this.parameterRepositoryService = CoreServiceApiServiceLocator.getParameterRepositoryService();
    }
    
    @Test public void testGetDataDictionaryService() throws Exception {
        DataDictionaryService dataDictionaryService = (DataDictionaryService) KcServiceLocator.getService(Constants.DATA_DICTIONARY_SERVICE_NAME);
        assertNotNull(dataDictionaryService);

        assertEquals("ProposalDevelopmentDocument", dataDictionaryService.getDataDictionary().getDocumentEntry(org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument.class.getName()).getDocumentTypeName());
    }

    @Test public void testGetDateTimeService() throws Exception {
        DateTimeService dateTimeService = (DateTimeService) KcServiceLocator.getService(Constants.DATE_TIME_SERVICE_NAME);
        assertNotNull(dateTimeService);
        Date currentDate = dateTimeService.getCurrentDate();
        Date currentDate2 = new Date(System.currentTimeMillis());
        long diff = currentDate.getTime() - currentDate2.getTime();

        assertTrue("Should be less than one second difference between dates", diff < 1000);
    }

    @Test public void testBusinessObjectDaoService() throws Exception {
        BusinessObjectDao businessObjectDao = (BusinessObjectDao) KcServiceLocator.getService(Constants.BUSINESS_OBJECT_DAO_NAME);
        assertNotNull(businessObjectDao);

        Collection carrierTypes = businessObjectDao.findAll(MailType.class);
        assertEquals(3, carrierTypes.size());
    }

    @Test public void testProposalDevelopmentParameters() throws Exception {
        QueryByCriteria.Builder queryBuilder = QueryByCriteria.Builder.create();
        List<Predicate> predicates = new ArrayList<Predicate>();
        ParameterQueryResults parameterQueryResults = null;
        predicates.add(PredicateFactory.equal("namespaceCode", MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT));
        predicates.add(PredicateFactory.equal("componentCode", DOCUMENT_COMPONENT));
        queryBuilder.setPredicates(PredicateFactory.and(predicates.toArray(new Predicate[] {})));
        parameterQueryResults = parameterRepositoryService.findParameters(queryBuilder.build());

        assertNotNull(parameterQueryResults); 
        assertNotNull(parameterQueryResults.getResults());
        //We are using getResults().size() because parameterQueryResults.getTotalRowCount is null even when the results list is not and contains one or more records
        assertTrue(parameterQueryResults.getResults().size() > 0);
    }

}
