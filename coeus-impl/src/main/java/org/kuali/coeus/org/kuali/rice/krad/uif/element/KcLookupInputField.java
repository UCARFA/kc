/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.org.kuali.rice.krad.uif.element;

import org.kuali.rice.krad.datadictionary.AttributeDefinition;
import org.kuali.rice.krad.lookup.LookupInputField;

public class KcLookupInputField extends LookupInputField {

    @Override
    public void copyFromAttributeDefinition(AttributeDefinition attributeDefinition) {
        this.setUppercaseValue(attributeDefinition.getForceUppercase());
        super.copyFromAttributeDefinition(attributeDefinition);
    }
}
