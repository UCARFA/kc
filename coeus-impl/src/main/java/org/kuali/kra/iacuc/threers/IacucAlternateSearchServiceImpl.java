/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.threers;

import org.kuali.kra.iacuc.IacucProtocol;

import java.util.ArrayList;
import java.util.List;

public class IacucAlternateSearchServiceImpl implements IacucAlternateSearchService {

    @Override
    public void addAlternateSearch(IacucProtocol protocol, IacucAlternateSearch newAlternateSearch, List<String> selectedDatabases) {
               
        List<IacucProtocolAlternateSearchDatabase> databases = new ArrayList<IacucProtocolAlternateSearchDatabase>();
        for (String newDb : selectedDatabases) {
            databases.add(createAltSearchDB(newDb));
        }
        
        newAlternateSearch.setDatabases(databases);
        
        List<IacucAlternateSearch> searches = protocol.getIacucAlternateSearches();
        if (searches == null) {
          searches = new ArrayList<IacucAlternateSearch>(); 
        }
                
        searches.add(newAlternateSearch);
        
        protocol.setIacucAlternateSearches(searches);        
    }

    @Override
    public void deleteAlternateSearch(IacucProtocol protocol, int index) {
        if (index >= 0 && index < protocol.getIacucAlternateSearches().size()) {
            protocol.getIacucAlternateSearches().remove(index);
        }
        
    }

    private IacucProtocolAlternateSearchDatabase createAltSearchDB(String dbName) {
        IacucProtocolAlternateSearchDatabase db = new IacucProtocolAlternateSearchDatabase();
        db.setAlternateSearchDatabaseName(dbName);
        return db;
    }    
}
