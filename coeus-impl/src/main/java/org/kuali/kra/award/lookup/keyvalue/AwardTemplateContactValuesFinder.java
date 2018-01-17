/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.keyvalue.PrefixValuesFinder;
import org.kuali.kra.award.home.AwardTemplate;
import org.kuali.kra.award.home.AwardTemplateContact;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kns.document.MaintenanceDocument;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AwardTemplateContactValuesFinder extends FormViewAwareUifKeyValuesFinderBase {

    /**
     * 
     * @return the list of &lt;key, value&gt; pairs of the current award template contacts id
     * and roleCode
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        MaintenanceDocument doc = (MaintenanceDocument) getDocument();
        AwardTemplate awardTemplate = (AwardTemplate) doc.getNoteTarget();
        List<AwardTemplateContact> contacts = awardTemplate.getTemplateContacts();
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        for (Iterator iter = contacts.iterator(); iter.hasNext();) {
            AwardTemplateContact contact = (AwardTemplateContact) iter.next();     
            contact.refreshReferenceObject("contactType");
            
            String key = contact.getRoleCode() + Constants.AWARD_TEMP_RECPNT_CONTACT_TYPE_CODE_ROLODEX_ID_SEPARATOR + contact.getRolodexId().toString();

            StringBuffer sb = new StringBuffer(contact.getContactType().getDescription());
            if (contact.getRolodex() != null) {
                sb.append(" : ");
                if (StringUtils.isNotBlank(contact.getRolodex().getFullName())) {
                    sb.append(contact.getRolodex().getFullName());
                } else {
                    sb.append(contact.getRolodex().getOrganization());
                }
            }
            String label = sb.toString();
            
            keyValues.add(new ConcreteKeyValue(key, label)); 
        }
        keyValues.add(0, new ConcreteKeyValue(PrefixValuesFinder.getPrefixKey(), PrefixValuesFinder.getDefaultPrefixValue()));
        return keyValues;
    }
}
