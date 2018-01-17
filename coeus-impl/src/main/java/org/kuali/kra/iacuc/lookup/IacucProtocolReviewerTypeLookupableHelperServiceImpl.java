/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.lookup;

import org.kuali.kra.iacuc.actions.submit.IacucProtocolReviewerType;
import org.kuali.rice.kns.lookup.KualiLookupableHelperServiceImpl;
import org.kuali.rice.krad.bo.BusinessObject;

public class IacucProtocolReviewerTypeLookupableHelperServiceImpl extends KualiLookupableHelperServiceImpl {
    
    private static final long serialVersionUID = -7379856633866034252L;

    @Override
    protected boolean allowsMaintenanceDeleteAction(BusinessObject businessObject) {

        boolean allowsDelete = true;

        if (businessObject instanceof IacucProtocolReviewerType) {
            IacucProtocolReviewerType reviewerType = (IacucProtocolReviewerType)businessObject; 
            if (IacucProtocolReviewerType.PRIMARY.equals(reviewerType.getReviewerTypeCode()) ||
                IacucProtocolReviewerType.COMMITTEE.equals(reviewerType.getReviewerTypeCode())) {
                allowsDelete = false;
            }
        }
        return allowsDelete;
    }
}
