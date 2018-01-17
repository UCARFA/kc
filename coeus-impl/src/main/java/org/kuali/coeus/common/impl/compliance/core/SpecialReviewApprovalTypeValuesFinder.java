/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.compliance.core;

import org.kuali.coeus.sys.framework.keyvalue.DataObjectValuesFinder;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.common.framework.compliance.core.SpecialReviewApprovalType;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.data.DataObjectService;

import java.util.List;

/**
 * See {@link #getKeyValues()}.
 */
public class SpecialReviewApprovalTypeValuesFinder extends DataObjectValuesFinder {

    public static final String DESCRIPTION = "description";
    public static final String APPROVAL_TYPE_CODE = "approvalTypeCode";

    /**
     * Gets the keyvalue pair for {@link SpecialReviewApprovalType SpecialReviewApprovalType}.
     * The key is the specialReviewApprovalTypeCode and the value is the description.
     * 
     * @return a list of {@link KeyValue KeyValue}
     */
    @Override
    public List<KeyValue> getKeyValues() {
    	setKeyValueAttributes();
        setOrderByField(DESCRIPTION);
        final List<KeyValue> specialReviewApprovalTypes = super.getKeyValues();
        return specialReviewApprovalTypes;
    }

    protected void setKeyValueAttributes() {
        setDataObjectClass(SpecialReviewApprovalType.class);
        setKeyAttributeName(APPROVAL_TYPE_CODE);
        setLabelAttributeName(DESCRIPTION);
    }
    
    @Override
    public DataObjectService getDataObjectService() {
    	if (super.getDataObjectService() == null) {
    		this.setDataObjectService(KcServiceLocator.getService(DataObjectService.class));
    	}
    	return super.getDataObjectService();
    }   
}
