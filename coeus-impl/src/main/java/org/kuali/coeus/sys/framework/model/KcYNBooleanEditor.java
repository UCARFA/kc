/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.model;

import org.kuali.rice.krad.web.bind.UifBooleanEditor;

public class KcYNBooleanEditor extends UifBooleanEditor {
    @Override
    public String getAsText() {
        if(this.getValue() == null) {
            return "";
        }
        if (this.getValue() instanceof String){
            setAsText(this.getValue().toString().trim());
        }
        if(((Boolean)this.getValue()).booleanValue()) {
            return "Yes";
        }
        else {
            return "No";
        }
    }
}
