/*
 * Copyright 2005-2014 The Kuali Foundation.
 * 
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.s2s.generator.impl;


import org.kuali.coeus.common.budget.api.core.BudgetContract;
import org.kuali.coeus.propdev.api.budget.subaward.BudgetSubAwardAttachmentContract;
import org.kuali.coeus.propdev.api.budget.subaward.BudgetSubAwardsContract;
import org.kuali.coeus.common.framework.attachment.KcAttachmentService;
import org.kuali.coeus.propdev.api.core.ProposalDevelopmentDocumentContract;
import org.kuali.kra.s2s.S2SException;
import org.kuali.coeus.propdev.api.budget.subaward.BudgetSubAwardsService;
import org.kuali.kra.s2s.generator.S2SBaseFormGenerator;
import org.kuali.kra.s2s.generator.bo.AttachmentData;
import org.kuali.kra.s2s.util.S2SConstants;
import org.kuali.kra.s2s.validator.S2SErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class has methods that are common to all the versions of RRSubAwardBudget form.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */

public abstract class S2SAdobeFormAttachmentBaseGenerator extends S2SBaseFormGenerator {

    protected static final String RR_BUDGET_10_NAMESPACE_URI = "http://apply.grants.gov/forms/RR_Budget-V1.0";
    protected static final String RR_BUDGET_11_NAMESPACE_URI = "http://apply.grants.gov/forms/RR_Budget-V1.1";
    protected static final String LOCAL_NAME = "RR_Budget";

    public ArrayList <String> attachmentList = new ArrayList<String> ();
    public ArrayList <String> budgetIdList = new ArrayList<String> ();
    public ArrayList <String> budgetSubawardNumberList = new ArrayList<String> ();

    @Autowired
    @Qualifier("budgetSubAwardsService")
    private BudgetSubAwardsService budgetSubAwardsService;

    @Autowired
    @Qualifier("kcAttachmentService")
    private KcAttachmentService  kcAttachmentService;
    /**
     * This method convert node of form in to a Document
     * 
     * @param node n {Node} node entry.
     * @return Document containing doc information
     */

    public Document nodeToDom(org.w3c.dom.Node node) throws S2SException {
        try {
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer xf = tf.newTransformer();
            javax.xml.transform.dom.DOMResult dr = new javax.xml.transform.dom.DOMResult();
            xf.transform(new javax.xml.transform.dom.DOMSource(node), dr);
            return (Document) dr.getNode();

        }
        catch (javax.xml.transform.TransformerException ex) {
            throw new S2SException(ex.getMessage());
        }
    }


    /**
     * This method convert xml string in to a Document
     * 
     * @param xmlSource {xml String} xml source entry.
     * @return Document containing doc information
     */
    public Document stringToDom(String xmlSource) throws S2SException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xmlSource)));
        }
        catch (SAXException ex) {
            throw new S2SException(ex.getMessage());
        }
        catch (ParserConfigurationException ex) {
            throw new S2SException(ex.getMessage());
        }
        catch (IOException ex) {
            throw new S2SException(ex.getMessage());
        }
    }

    /**
     * This method convert Document to a byte Array
     * 
     * @param node {Document} node entry.
     * @return byte Array containing doc information
     */
    public byte[] docToBytes(Document node) throws S2SException {
        return docToString(node).getBytes();
    }

    /**
     * This method convert Document to a String
     * 
     * @param node {Document} node entry.
     * @return String containing doc information
     */
    public String docToString(Document node) throws S2SException {
        try {
            DOMSource domSource = new DOMSource(node);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            return writer.toString();
        }
        catch (Exception e) {
            throw new S2SException(e.getMessage(),e);
        }
    }

    /**
     * 
     * This method is used to return the attachment name which comes from BudgetSubawards
     * 
     * @param budgetSubAwards(BudgetSubAwards) budget sub award entry.
     * @return String attachment name for the budget sub awards.
     */
    protected String prepareAttName(BudgetSubAwardsContract budgetSubAwards) {
        StringBuilder attachmentName = new StringBuilder();
        boolean hasSameFileName = false;
        boolean isAlreadyprinted = false;
        int attachmentCount=0;
        int suffix=1;
       
        int index =0;
        for(String budgetId : budgetIdList){
            
            if(budgetSubAwards.getBudgetId().toString().equals(budgetId)){
                if(budgetSubawardNumberList.get(index).equals(budgetSubAwards.getSubAwardNumber().toString())){
                    attachmentList.clear();
                    isAlreadyprinted = true;
                    break;
                }
            }
            index++;
        }
        if(isAlreadyprinted){
            budgetIdList.clear();
            budgetSubawardNumberList.clear();
        }
        
        //checking organization name and replacing invalid characters
        // with underscores.
        String cleanSubAwardOrganizationName = getKcAttachmentService()
                .checkAndReplaceInvalidCharacters(budgetSubAwards.getOrganizationName());
        attachmentName.append(cleanSubAwardOrganizationName);
        List<? extends BudgetSubAwardsContract> budgetSubAwardsList =  getBudgetSubAwardsService().findBudgetSubAwardsByBudgetId(budgetSubAwards.getBudgetId());
        ArrayList<String> attachments = new ArrayList<String> ();
        for (BudgetSubAwardsContract budgetSubAward: budgetSubAwardsList) {
            StringBuilder existingAttachmentName = new StringBuilder();
            String subAward_OrganizationName = getKcAttachmentService()
                    .checkAndReplaceInvalidCharacters(budgetSubAward.getOrganizationName());
            existingAttachmentName.append(subAward_OrganizationName);
            attachments.add(existingAttachmentName.toString());                 
        }
        for (String attachment : attachments) {
            if (attachment.equals(attachmentName.toString())) {
                attachmentCount++;
            }
        }        
        if (attachmentCount>1 && !attachmentList.contains(attachmentName.toString())) {
            attachmentList.add(attachmentName.toString());
            if(attachmentName.length() > 49){
                attachmentName.delete(49, attachmentName.length());               
             }
            attachmentName.append(1);
            hasSameFileName = true;                
        } else {
            for (String attachment:attachmentList) {                  
                if (attachment.equals(attachmentName.toString())) {
                    suffix++;
                }                    
            }
        }            
        if (attachmentList.contains(attachmentName.toString()) && !hasSameFileName) {
            attachmentList.add(attachmentName.toString());
            if(attachmentName.length() > 49){
                attachmentName.delete(49, attachmentName.length());               
             }
            attachmentName.append(suffix);
        } else {
            attachmentList.add(attachmentName.toString());             
        }                           
        budgetIdList.add(budgetSubAwards.getBudgetId().toString());
        budgetSubawardNumberList.add(budgetSubAwards.getSubAwardNumber().toString());           
        return attachmentName.toString();
    }


    
    /**
     * Adding attachments to subaward
     */
    protected void addSubAwdAttachments(BudgetSubAwardsContract budgetSubAwards) {
        List<? extends BudgetSubAwardAttachmentContract> subAwardAttachments = budgetSubAwards.getBudgetSubAwardAttachments();
        for (BudgetSubAwardAttachmentContract budgetSubAwardAttachment : subAwardAttachments) {
            AttachmentData attachmentData = new AttachmentData();
            attachmentData.setContent(budgetSubAwardAttachment.getData());
            attachmentData.setContentId(budgetSubAwardAttachment.getName());
            attachmentData.setContentType(budgetSubAwardAttachment.getType());
            attachmentData.setFileName(budgetSubAwardAttachment.getName());
            addAttachment(attachmentData);
        }
    }
    /**
     * 
     * This method is used to get BudgetSubAwrads from ProposalDevelopmentDocumentContract
     * 
     * @param ProposalDevelopmentDocumentContract (ProposalDevelopmentDocumentContract)
     * @return List<BudgetSubAwards> list of budget sub awards.
     */
    protected List<BudgetSubAwardsContract> getBudgetSubAwards(ProposalDevelopmentDocumentContract ProposalDevelopmentDocumentContract,
            String namespace,boolean checkNull) {
        List<BudgetSubAwardsContract> budgetSubAwardsList = new ArrayList<BudgetSubAwardsContract>();
        BudgetContract budget = findBudgetFromProposal(ProposalDevelopmentDocumentContract);
        if(budget==null){
            getAuditErrors().add(S2SErrorHandler.getError(S2SConstants.SUB_AWARD_BUDGET_NOT_FOUND));
        }else{
            budgetSubAwardsList = findBudgetSubawards(namespace, budget,checkNull);
            if(budgetSubAwardsList.isEmpty()){
                getAuditErrors().add(S2SErrorHandler.getError(S2SConstants.SUB_AWARD_BUDGET_NOT_FOUND));
            }
        }
        return budgetSubAwardsList;
    }


    /**
     * This method is to find the subaward budget BOs for the given namespace
     * @param namespace
     * @param budget
     * @return
     */
    @SuppressWarnings("unchecked")
    private List<BudgetSubAwardsContract> findBudgetSubawards(String namespace, BudgetContract budget,boolean checkNull) {
        List<BudgetSubAwardsContract> budgetSubAwardsList = new ArrayList<>();
        budgetSubAwardsList.addAll(getBudgetSubAwardsService().findBudgetSubAwardsByBudgetIdAndNamespace(budget.getBudgetId(), namespace));

        if(checkNull){
            budgetSubAwardsList.addAll(getBudgetSubAwardsService().findBudgetSubAwardsByBudgetIdAndNullNamespace(budget.getBudgetId()));
        }
        return budgetSubAwardsList;
    }

    private BudgetContract findBudgetFromProposal(ProposalDevelopmentDocumentContract proposalDevelopmentDocument) {
        return pdDoc.getDevelopmentProposal().getFinalBudget();
    }

    public BudgetSubAwardsService getBudgetSubAwardsService() {
        return budgetSubAwardsService;
    }

    public void setBudgetSubAwardsService(BudgetSubAwardsService budgetSubAwardsService) {
        this.budgetSubAwardsService = budgetSubAwardsService;
    }

    public KcAttachmentService getKcAttachmentService() {
        return kcAttachmentService;
    }

    public void setKcAttachmentService(KcAttachmentService kcAttachmentService) {
        this.kcAttachmentService = kcAttachmentService;
    }
}
