/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.threers;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.protocol.ProtocolDocumentBase;

import java.util.List;

public class AddAlternateSearchEvent extends KcDocumentEventBaseExtension {

    private IacucAlternateSearch alternateSearch;
    private List<String> selectedDatabases;
    
    protected AddAlternateSearchEvent(ProtocolDocumentBase document, IacucAlternateSearch alternateSearch, List<String> selectedDatabases) {
        super("Add Alternate Search", "", document);
        
        this.alternateSearch = alternateSearch;
        this.selectedDatabases = selectedDatabases;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public KcBusinessRule getRule() {
        return new AddAlternateSearchRule();
    }

    public IacucAlternateSearch getAlternateSearch() {
        return alternateSearch;
    }

    public void setAlternateSearch(IacucAlternateSearch alternateSearch) {
        this.alternateSearch = alternateSearch;
    }

    public List<String> getSelectedDatabases() {
        return selectedDatabases;
    }

    public void setSelectedDatabases(List<String> selectedDatabases) {
        this.selectedDatabases = selectedDatabases;
    }

}
