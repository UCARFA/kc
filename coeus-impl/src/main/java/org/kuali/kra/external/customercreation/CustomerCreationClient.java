/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.customercreation;

import java.util.List;

import org.kuali.coeus.common.framework.sponsor.Sponsor;
import org.kuali.kra.external.service.KcDtoService;
import org.kuali.kra.external.sponsor.SponsorDTO;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

public interface CustomerCreationClient {

    public List<String> createCustomer(Sponsor sponsor, String initiatedByPrincipalName);

    public List<KeyValue> getCustomerTypes();

    public boolean isValidCustomer(String customerNumber);
    
    public void setSponsorDtoService(KcDtoService<SponsorDTO, Sponsor> dtoService);
    
    public void setParameterService(ParameterService parameterService);
}
