/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireConstants;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.coeus.common.impl.krms.KcKrmsFactBuilderServiceHelper;
import org.kuali.rice.core.api.exception.RiceRuntimeException;
import org.kuali.rice.core.api.util.xml.XmlHelper;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.kew.rule.xmlrouting.XPathHelper;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krms.api.engine.Facts;
import org.kuali.rice.krms.api.engine.Facts.Builder;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import java.io.ByteArrayInputStream;

public class CoiDisclosureFactBuilderServiceImpl extends KcKrmsFactBuilderServiceHelper {
    
    private BusinessObjectService businessObjectService;
    private DocumentService documentService;;
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, String docContent) {
        String documentNumber = getElementValue(docContent, "//documentNumber");
        try {
            CoiDisclosureDocument disclosureDocument = (CoiDisclosureDocument) getDocumentService().getByDocumentHeaderId(documentNumber);
            addFacts(factsBuilder, disclosureDocument);
        }catch (WorkflowException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void addFacts(Builder factsBuilder, KrmsRulesContext document){
        CoiDisclosureDocument disclosureDocument = (CoiDisclosureDocument)document;
        CoiDisclosure coiDisclosure = disclosureDocument.getCoiDisclosure();
        addObjectMembersAsFacts(factsBuilder,coiDisclosure,KcKrmsConstants.CoiDisclosure.COI_DISCLOSURE_CONTEXT_ID,Constants.MODULE_NAMESPACE_COIDISCLOSURE);
        factsBuilder.addFact(KcKrmsConstants.CoiDisclosure.COI_DISCLOSURE, coiDisclosure);

        // Functions
        // Is person under campus code
        // Person campus code
    
        // Questionnaire Prereqs
        factsBuilder.addFact(QuestionnaireConstants.MODULE_CODE, CoeusModule.COI_DISCLOSURE_MODULE_CODE);
        factsBuilder.addFact(QuestionnaireConstants.MODULE_ITEM_KEY, coiDisclosure.getCoiDisclosureNumber());
        factsBuilder.addFact(QuestionnaireConstants.MODULE_SUB_ITEM_KEY, coiDisclosure.getSequenceNumber());
    }
    
    @Override
    protected String getElementValue(String docContent, String xpathExpression) {
        try {
            Document document = XmlHelper.trimXml(new ByteArrayInputStream(docContent.getBytes()));

            XPath xpath = XPathHelper.newXPath();
            String value = (String) xpath.evaluate(xpathExpression, document, XPathConstants.STRING);

            return value;

        } catch (Exception e) {
            throw new RiceRuntimeException(e);
        }
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
