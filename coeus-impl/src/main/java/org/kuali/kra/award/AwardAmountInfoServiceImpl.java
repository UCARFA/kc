/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardAmountInfo;
import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AwardAmountInfoServiceImpl implements AwardAmountInfoService {

    transient BusinessObjectService businessObjectService;
    transient DocumentService documentService;
    
    /**
     * This method fetches the Award Amount Info object that is to be displayed in UI for Award.  
     * The rules are:
     * 1)the Award Amount Infos awardNumber and versionNumber must match the Award BO
     * 2)The Award Amount Infos timeAndMoneyDocumentNumber must be null or from a T&amp;M document that has been finalized
     * Users don't want this data to apply to Award until the T&amp;M document has been approved.
     */
    @Override
    @SuppressWarnings("unchecked")
    public AwardAmountInfo fetchLastAwardAmountInfoForAwardVersionAndFinalizedTandMDocumentNumber(Award award) {
        
        List<AwardAmountInfo> awardAmountInfos = new ArrayList<>(award.getAwardAmountInfos());
        Collections.reverse(awardAmountInfos);
        return awardAmountInfos.stream().filter(aai -> {
            //the aai needs to be added if it is created on initialization, or in the case of a root node we add a new one for initial money transaction.
            //if an award has been versioned, the initial transaction will be the first index in list.
            if(aai.getTimeAndMoneyDocumentNumber() == null || (aai.getAwardNumber().endsWith("-00001") && 
                    award.getAwardAmountInfos().indexOf(aai) == 1)) {
                return true;
            }else {
                Map<String, Object> fieldValues1 = new HashMap<String, Object>();
                fieldValues1.put("documentNumber", aai.getTimeAndMoneyDocumentNumber());
                List<TimeAndMoneyDocument> timeAndMoneyDocuments =
                    (List<TimeAndMoneyDocument>)getBusinessObjectService().findMatching(TimeAndMoneyDocument.class, fieldValues1);
                if(!timeAndMoneyDocuments.isEmpty()) {
                    try {
                    TimeAndMoneyDocument timeAndMoneyDocument = 
                        (TimeAndMoneyDocument)getDocumentService().getByDocumentHeaderId(timeAndMoneyDocuments.get(0).getDocumentHeader().getDocumentNumber());
                    if(timeAndMoneyDocument.getDocumentHeader().hasWorkflowDocument()) {
                        if(timeAndMoneyDocument.getDocumentHeader().getWorkflowDocument().isFinal()) {
                            return true;
                        }
                    }
                    } catch (WorkflowException e) {
                        throw new RuntimeException(e);
                    }
                }
        
            }
			return false;
        }).findFirst().get();
}
    
    @Override
    public AwardAmountInfo fetchLastAwardAmountInfoForDocNum(Award award, String docNum){
            List<AwardAmountInfo> validAwardAmountInfos = new ArrayList<AwardAmountInfo>();
        int docNumIntValue = Integer.parseInt(docNum.trim());
        
        for(AwardAmountInfo aai : award.getAwardAmountInfos()) {
            if(aai.getTimeAndMoneyDocumentNumber() == null || (aai.getAwardNumber().endsWith("-00001") &&                   
                    award.getAwardAmountInfos().indexOf(aai) == 1)) {
                validAwardAmountInfos.add(aai);
            }else {
                if(Integer.parseInt(aai.getTimeAndMoneyDocumentNumber().trim()) > docNumIntValue) {
                    break;
                }else{
                    validAwardAmountInfos.add(aai);
                }
            }
        }
            return validAwardAmountInfos.get(validAwardAmountInfos.size() -1);
    }
    
    
    @Override

    
public AwardAmountInfo fetchAwardAmountInfoWithHighestTransactionId(List<AwardAmountInfo> awardAmountInfos) {
        
        return awardAmountInfos.get(awardAmountInfos.size() -1);
    }
    
    @Override
    public int fetchIndexOfAwardAmountInfoWithHighestTransactionId(List<AwardAmountInfo> awardAmountInfos) {
       
        return awardAmountInfos.size() - 1;
    }

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
    
}
