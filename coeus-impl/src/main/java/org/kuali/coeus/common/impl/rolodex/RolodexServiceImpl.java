/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.rolodex;

import org.kuali.coeus.common.framework.rolodex.Rolodex;
import org.kuali.coeus.common.api.rolodex.RolodexContract;
import org.kuali.coeus.common.api.rolodex.RolodexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.kuali.rice.krad.data.DataObjectService;


@Service("rolodexService")
public class RolodexServiceImpl implements RolodexService {

	@Autowired
	@Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Override
    public RolodexContract getRolodex(Integer rolodexId) {
        if (rolodexId == null) {
            throw new IllegalArgumentException("rolodexId is null");
        }

        return dataObjectService.find(Rolodex.class, rolodexId);
    }

    public DataObjectService getDataObjectService() {
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }
}
