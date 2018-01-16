/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup;

import org.kuali.kra.award.dao.AwardPersonDao;
import org.kuali.kra.lookup.KraLookupableHelperServiceImpl;
import org.kuali.rice.kns.lookup.HtmlData;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AwardPersonLookupableHelperServiceImpl extends KraLookupableHelperServiceImpl {
    private static final long serialVersionUID = 3716323161734123416L;

    private transient AwardPersonDao awardPersonDao;
    
    @Override
    public List<HtmlData> getCustomActionUrls(BusinessObject businessObject, @SuppressWarnings("unchecked") List pkNames) {
        return new ArrayList<HtmlData>();
    }
    
    @Override
    public List<? extends BusinessObject> getSearchResults(Map<String, String> fieldValues) {
        return awardPersonDao.getAwardPersons(fieldValues);
    }
    
    @Override
    protected String getHtmlAction() {
        return "awardPaymentReportsAndTerms.do";
    }
    
    @Override
    protected String getDocumentTypeName() {
        return "AwardDocument";
    }
    
    @Override
    protected String getKeyFieldName() {
        return "awardContactId";
    }

    /**
     * @param awardPersonDao
     */
    public void setAwardPersonDao(AwardPersonDao awardPersonDao) {
        this.awardPersonDao = awardPersonDao;
    }
}
