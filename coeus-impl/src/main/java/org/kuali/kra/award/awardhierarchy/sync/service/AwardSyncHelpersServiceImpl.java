/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.service;

import org.kuali.kra.award.awardhierarchy.sync.helpers.AwardSyncHelper;

import java.util.Map;

public class AwardSyncHelpersServiceImpl implements AwardSyncHelpersService {

    private Map<String, AwardSyncHelper> syncHelpers;
    
    @Override
    public AwardSyncHelper getSyncHelper(String className) {
        if (className.contains(".")) {
            return getSyncHelpers().get(className.substring(className.lastIndexOf(".")+1));
        } else { 
            return getSyncHelpers().get(className);
        }
    }

    protected Map<String, AwardSyncHelper> getSyncHelpers() {
        return syncHelpers;
    }

    public void setSyncHelpers(Map<String, AwardSyncHelper> syncHelpers) {
        this.syncHelpers = syncHelpers;
    }

}
