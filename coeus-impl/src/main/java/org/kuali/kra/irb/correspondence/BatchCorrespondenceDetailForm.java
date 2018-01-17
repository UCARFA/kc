/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.correspondence;

import org.kuali.rice.kns.web.struts.form.KualiForm;

import java.util.ArrayList;
import java.util.List;

public class BatchCorrespondenceDetailForm extends KualiForm {

    private static final long serialVersionUID = 8987463989398244188L;

    private BatchCorrespondence batchCorrespondence;
    private String batchCorrespondenceTypeCode;
    private BatchCorrespondenceDetail newBatchCorrespondenceDetail;
    private List<BatchCorrespondenceDetail> deletedBatchCorrespondenceDetail;
    
    private boolean readOnly;
    
    public BatchCorrespondenceDetailForm() {
        super();
        // if set to null in rice20, it can't be populated for batch correspondence
        this.setBatchCorrespondence(new BatchCorrespondence());
        this.setBatchCorrespondenceTypeCode(null);
        this.setNewBatchCorrespondenceDetail(new BatchCorrespondenceDetail());
        this.setDeletedBatchCorrespondenceDetail(new ArrayList<BatchCorrespondenceDetail>());
    }

    public BatchCorrespondence getBatchCorrespondence() {
        return batchCorrespondence;
    }

    public void setBatchCorrespondence(BatchCorrespondence batchCorrespondence) {
        this.batchCorrespondence = batchCorrespondence;
    }

    public String getBatchCorrespondenceTypeCode() {
        return batchCorrespondenceTypeCode;
    }

    public void setBatchCorrespondenceTypeCode(String batchCorrespondenceTypeCode) {
        this.batchCorrespondenceTypeCode = batchCorrespondenceTypeCode;
    }

    public BatchCorrespondenceDetail getNewBatchCorrespondenceDetail() {
        return newBatchCorrespondenceDetail;
    }

    public void setNewBatchCorrespondenceDetail(BatchCorrespondenceDetail newBatchCorrespondenceDetail) {
        this.newBatchCorrespondenceDetail = newBatchCorrespondenceDetail;
    }

    public List<BatchCorrespondenceDetail> getDeletedBatchCorrespondenceDetail() {
        return deletedBatchCorrespondenceDetail;
    }

    public void setDeletedBatchCorrespondenceDetail(List<BatchCorrespondenceDetail> deletedBatchCorrespondenceDetail) {
        this.deletedBatchCorrespondenceDetail = deletedBatchCorrespondenceDetail;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }
    

}
