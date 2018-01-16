/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.threers;

import org.kuali.kra.protocol.ProtocolAssociateBase;
import org.kuali.rice.krad.bo.PersistableBusinessObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IacucAlternateSearch extends ProtocolAssociateBase {

    private static final long serialVersionUID = -7711644839097962481L;
    
    private Integer iacucAltSearchId;
    private Date searchDate;
    private List<IacucProtocolAlternateSearchDatabase> databases;
    private String yearsSearched;
    private String keywords;
    private String comments;
    
    
    public IacucAlternateSearch() {
        databases = new ArrayList<IacucProtocolAlternateSearchDatabase>();
    }

    public Integer getIacucAltSearchId() {
        return iacucAltSearchId;
    }

    public void setIacucAltSearchId(Integer iacucAltSearchId) {
        this.iacucAltSearchId = iacucAltSearchId;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }

    public List<IacucProtocolAlternateSearchDatabase> getDatabases() {
        return databases;
    }

    public void setDatabases(List<IacucProtocolAlternateSearchDatabase> databases) {
        this.databases = databases;
    }

    public String getYearsSearched() {
        return yearsSearched;
    }

    public void setYearsSearched(String yearsSearched) {
        this.yearsSearched = yearsSearched;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public void resetPersistenceState() {
        this.setIacucAltSearchId(null);        
    }
    
    @Override
    public List<Collection<PersistableBusinessObject>> buildListOfDeletionAwareLists() {      
        List managedLists = super.buildListOfDeletionAwareLists();
        managedLists.add(getDatabases());
        
        return managedLists;
    }
}
