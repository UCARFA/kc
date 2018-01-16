/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.specialapproval.approvedequipment;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;

import java.io.Serializable;
import java.util.List;

/**
 * This class supports the Award Form / AwardPaymentReportsAndTermsAction classes for SpecialApproval
 */
public class SpecialApprovalBean implements Serializable {
    private static final long serialVersionUID = -6976882557080351302L;
    
    protected AwardForm form;

    protected SpecialApprovalBean(AwardForm form) {
        this.form = form;
    }


    protected Award getAward() {
        return form.getAwardDocument().getAward();
    }


    protected AwardDocument getAwardDocument() {
        return form.getAwardDocument();
    }


    /**
     * @param collection
     * @param deletedIndex
     */
    protected void removeCollectionItem(List<? extends KcPersistableBusinessObjectBase> collection, int deletedIndex) {
        if(deletedIndex >= 0 && deletedIndex < collection.size()) {
            collection.remove(deletedIndex);
        }
    }
}
