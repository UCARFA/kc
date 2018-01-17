/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.correspondence;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class CorrespondentType extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private String correspondentTypeCode;

    private String description;

    private String qualifier;

    public CorrespondentType() {
    }

    public String getCorrespondentTypeCode() {
        return correspondentTypeCode;
    }

    public void setCorrespondentTypeCode(String correspondentTypeCode) {
        this.correspondentTypeCode = correspondentTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }
}
