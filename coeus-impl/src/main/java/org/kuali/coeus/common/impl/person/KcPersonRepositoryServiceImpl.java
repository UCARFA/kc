/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.person;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.api.person.KcPersonContract;
import org.kuali.coeus.common.api.person.KcPersonRepositoryService;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("kcPersonRepositoryService")
public class KcPersonRepositoryServiceImpl implements KcPersonRepositoryService {

    @Autowired
    @Qualifier("kcPersonService")
    private KcPersonService kcPersonService;

    @Override
    public KcPersonContract findKcPersonByUserName(String userName) {
        if (StringUtils.isBlank(userName)) {
            throw new IllegalArgumentException("userName is blank");
        }

        return kcPersonService.getKcPersonByUserName(userName);
    }

    @Override
    public KcPersonContract findKcPersonByPersonId(String personId) {
        if (StringUtils.isBlank(personId)) {
            throw new IllegalArgumentException("personId is blank");
        }

        return kcPersonService.getKcPersonByPersonId(personId);
    }

    public KcPersonService getKcPersonService() {
        return kcPersonService;
    }

    public void setKcPersonService(KcPersonService kcPersonService) {
        this.kcPersonService = kcPersonService;
    }
}
