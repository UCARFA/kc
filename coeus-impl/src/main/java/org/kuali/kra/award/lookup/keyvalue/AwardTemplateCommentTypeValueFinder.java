/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.bo.CommentType;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.*;

/**
 * This class is used to get the Frequency BO for AwardProposalDue control
 */
public class AwardTemplateCommentTypeValueFinder  extends UifKeyValuesFinderBase {
    
    /**
     * Constructs the list of Comment BOs.  Each entry
     * in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * report class code and the "value" is the textual description that is viewed
     * by a user.  The list is obtained from the AwardDocument if any are defined there. 
     * Otherwise, it is obtained from a lookup of the COMMENT_TYPE database table
     * via the "KeyValueFinderService".
     * 
     * @return the list of &lt;key, value&gt; pairs of comment types.  The first entry
     * is always &lt;"", "select:"&gt;.
     *
     */
    @Override
    public List<KeyValue> getKeyValues() {
        KeyValuesService keyValuesService = (KeyValuesService) KcServiceLocator.getService("keyValuesService");
        Map<String, Object> fieldValues = new HashMap<String, Object>();
        fieldValues.put("templateFlag", Boolean.TRUE);
        Collection reportClasses = keyValuesService.findMatching(CommentType.class, fieldValues);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        for (Iterator iter = reportClasses.iterator(); iter.hasNext();) {
            CommentType comment = (CommentType) iter.next();
            keyValues.add(new ConcreteKeyValue(comment.getCommentTypeCode(), comment.getDescription()));                            
        }
                
        return keyValues;
    }
   

}
