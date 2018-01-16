/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.threers;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class IacucProtocolAlternateSearchDatabase extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -1319710309210165533L;
    
    private Integer iacucProtocolAltSearchDbId;
    private Integer iacucAltSearchId;
    private String alternateSearchDatabaseName;
    
    public Integer getIacucProtocolAltSearchDbId() {
        return iacucProtocolAltSearchDbId;
    }
    public void setIacucProtocolAltSearchDbId(Integer iacucProtocolAltSearchDbId) {
        this.iacucProtocolAltSearchDbId = iacucProtocolAltSearchDbId;
    }
    public Integer getIacucAltSearchId() {
        return iacucAltSearchId;
    }
    public void setIacucAltSearchId(Integer iacucProtocolAltSearchId) {
        this.iacucAltSearchId = iacucProtocolAltSearchId;
    }
    public String getAlternateSearchDatabaseName() {
        return alternateSearchDatabaseName;
    }
    public void setAlternateSearchDatabaseName(String alternateSearchDatabaseName) {
        this.alternateSearchDatabaseName = alternateSearchDatabaseName;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IacucProtocolAlternateSearchDatabase) {
            return this.getAlternateSearchDatabaseName().equals(((IacucProtocolAlternateSearchDatabase)obj).getAlternateSearchDatabaseName());
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return this.getAlternateSearchDatabaseName().hashCode();
    }
    
    
}
