/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * A committee type defines what the committee is responsible for.
 * In the initial release of KC, only one type of committee is 
 * supported: IRB.
 */
@SuppressWarnings("serial")
public class CommitteeType extends KcPersistableBusinessObjectBase {

    public static final String IRB_TYPE_CODE = "1";
    public static final String COI_TYPE_CODE = "2";
    public static final String IACUC_TYPE_CODE = "3";
    
    private String committeeTypeCode;

    private String description;


    public CommitteeType() {
    }

    public String getCommitteeTypeCode() {
        return committeeTypeCode;
    }

    public void setCommitteeTypeCode(String committeeTypeCode) {
        this.committeeTypeCode = committeeTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
