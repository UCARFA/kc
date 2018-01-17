/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.krms;

import org.kuali.coeus.common.framework.krms.KcKrmsCacheManager;
import org.kuali.rice.core.api.cache.CacheAdminService;
import org.kuali.rice.core.api.cache.CacheTarget;
import org.kuali.rice.krms.api.repository.agenda.AgendaDefinition;
import org.kuali.rice.krms.api.repository.proposition.PropositionDefinition;
import org.kuali.rice.krms.api.repository.rule.RuleDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("kcKrmsCacheManager")
public class KcKrmsCacheManagerImpl implements KcKrmsCacheManager {

    @Autowired
    @Qualifier("krmsCacheAdminService")
    private CacheAdminService krmsCacheAdminService;

    static final List<CacheTarget> cacheTargets= new ArrayList<CacheTarget>();
    static{
        cacheTargets.add(CacheTarget.entireCache(AgendaDefinition.Cache.NAME));
        cacheTargets.add(CacheTarget.entireCache(RuleDefinition.Cache.NAME));
        cacheTargets.add(CacheTarget.entireCache(PropositionDefinition.Cache.NAME));
    }

    @Override
    public void clearCache() {
        if(krmsCacheAdminService!=null){
            krmsCacheAdminService.flush(cacheTargets);
        }
    }

    public CacheAdminService getKrmsCacheAdminService() {
        return krmsCacheAdminService;
    }

    public void setKrmsCacheAdminService(CacheAdminService krmsCacheAdminService) {
        this.krmsCacheAdminService = krmsCacheAdminService;
    }
}
