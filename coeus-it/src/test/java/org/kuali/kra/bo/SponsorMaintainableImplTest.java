/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.bo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.sponsor.Sponsor;
import org.kuali.coeus.common.impl.sponsor.SponsorMaintainableImpl;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.coreservice.impl.parameter.ParameterServiceImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

import static org.junit.Assert.*;

public class SponsorMaintainableImplTest extends KcIntegrationTestBase {

    public static final String SPONSOR_DOC_TYPE_NAME = "SponsorMaintenanceDocument";
    
    protected SponsorMaintainableImpl sponsorMaintainableImpl;
    protected ParameterServiceMock parameterService;
    
    @Before
    public void setUp() throws Exception {
        parameterService = new ParameterServiceMock();
        sponsorMaintainableImpl = new SponsorMaintainableImpl();
        sponsorMaintainableImpl.setBoClass(Sponsor.class);
        sponsorMaintainableImpl.setBusinessObject(new Sponsor());
        sponsorMaintainableImpl.setParameterService(parameterService);
        sponsorMaintainableImpl.setSponsorCodeIncrementer(new DataFieldMaxValueIncrementer() {
            int i = 0;
            @Override
            public int nextIntValue() throws DataAccessException {
                return i++;
            }

            @Override
            public long nextLongValue() throws DataAccessException {
                return i++;
            }

            @Override
            public String nextStringValue() throws DataAccessException {
                return String.valueOf(i++);
            }
        });
    }
    
    @Test
    public void testGenerateDefaultValues() {
        parameterService.autoGenSponsorCode = true;
        sponsorMaintainableImpl.setGenerateDefaultValues(SPONSOR_DOC_TYPE_NAME);
        Sponsor sponsor = (Sponsor) sponsorMaintainableImpl.getBusinessObject();
        assertTrue(StringUtils.isNotBlank(sponsor.getSponsorCode()));
    }
    
    @Test
    public void testDefaultValues() {
        parameterService.autoGenSponsorCode = false;
        sponsorMaintainableImpl.setGenerateDefaultValues(SPONSOR_DOC_TYPE_NAME);
        Sponsor sponsor = (Sponsor) sponsorMaintainableImpl.getBusinessObject();
        assertTrue(StringUtils.isBlank(sponsor.getSponsorCode()));
    }

    class ParameterServiceMock extends ParameterServiceImpl {
        public boolean autoGenSponsorCode = true;
        @Override
        public Boolean getParameterValueAsBoolean(String namespace, String detailCode, String parmValue) {
            assertEquals(Constants.KC_GENERIC_PARAMETER_NAMESPACE, namespace);
            assertEquals(Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, detailCode);
            assertEquals(SponsorMaintainableImpl.AUTO_GEN_SPONSOR_CODE_PARM, parmValue);
            return autoGenSponsorCode;
        }
    }
}
