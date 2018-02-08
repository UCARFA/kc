/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s;


import com.lowagie.text.pdf.*;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.propdev.api.s2s.S2sFormConfigurationContract;
import org.kuali.coeus.propdev.api.s2s.S2sFormConfigurationService;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.specialreview.ProposalSpecialReviewHumanSubjectsAttachmentService;
import org.kuali.coeus.s2sgen.api.core.AuditError;
import org.kuali.coeus.s2sgen.api.core.InfastructureConstants;
import org.kuali.coeus.s2sgen.api.core.S2SException;
import org.kuali.coeus.s2sgen.api.generate.FormGenerationResult;
import org.kuali.coeus.s2sgen.api.generate.FormGeneratorService;
import org.kuali.coeus.s2sgen.api.generate.FormMappingInfo;
import org.kuali.coeus.s2sgen.api.generate.FormMappingService;
import org.kuali.coeus.s2sgen.api.hash.GrantApplicationHashService;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.kra.infrastructure.KeyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component("s2sUserAttachedFormService")
public class S2sUserAttachedFormServiceImpl implements S2sUserAttachedFormService {

    private static final String XFA_NS = "http://www.xfa.org/schema/xfa-data/1.0/";
    private static final String USER_ATTACHED_FORMS_ERRORS = "userAttachedFormsErrors";

    @Autowired
    @Qualifier("formGeneratorService")
    private FormGeneratorService formGeneratorService;

    @Autowired
    @Qualifier("formMappingService")
    private FormMappingService formMappingService;

    @Autowired
    @Qualifier("grantApplicationHashService")
    private GrantApplicationHashService grantApplicationHashService;

    @Autowired
    @Qualifier("globalVariableService")
    private GlobalVariableService globalVariableService;

    @Autowired
    @Qualifier("s2sFormConfigurationService")
    private S2sFormConfigurationService s2sFormConfigurationService;

    @Autowired
    @Qualifier("formUtilityService")
    private FormUtilityService formUtilityService;

    @Autowired
    @Qualifier("proposalSpecialReviewHumanSubjectsAttachmentService")
    private ProposalSpecialReviewHumanSubjectsAttachmentService proposalSpecialReviewHumanSubjectsAttachmentService;

    @Override
    public List<S2sUserAttachedForm> extractNSaveUserAttachedForms(ProposalDevelopmentDocument developmentProposal,
                                                                   S2sUserAttachedForm s2sUserAttachedForm) throws TransformerException, IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        PdfReader reader = null;
        final List<S2sUserAttachedForm> formBeans;
        try{
            byte pdfFileContents[] = s2sUserAttachedForm.getNewFormFileBytes();
            if(pdfFileContents==null || pdfFileContents.length==0){
                S2SException s2sException = new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_EMPTY,"Uploaded file is empty");
              s2sException.setTabErrorKey(USER_ATTACHED_FORMS_ERRORS);
              throw s2sException;
            }else{
                try{
                    reader = new PdfReader(pdfFileContents);
                }catch(IOException ioex){
                    S2SException s2sException = new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_NOT_PDF,"Uploaded file is not Grants.Gov fillable form",ioex.getMessage());
                    s2sException.setTabErrorKey(USER_ATTACHED_FORMS_ERRORS);
                    throw s2sException;
                }
                Map<String, byte[]> attachments = formUtilityService.extractAttachments(reader);
                formBeans = extractAndPopulateXml(developmentProposal,reader,s2sUserAttachedForm,attachments);
            }
            setFormsAvailability(developmentProposal,formBeans);
        }finally{
            if(reader!=null) reader.close();
        }
        return formBeans;
    }

    private void throwInvalidError() {
        S2SException s2sException = new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_WRONG_FILE_TYPE,"Uploaded file is not Grants.Gov fillable form");
        s2sException.setTabErrorKey(USER_ATTACHED_FORMS_ERRORS);
        throw s2sException;
    }

    protected List<S2sUserAttachedForm> extractAndPopulateXml(ProposalDevelopmentDocument developmentProposal, PdfReader reader, S2sUserAttachedForm userAttachedForm, Map<String, byte[]> attachments) throws TransformerException, IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        List<S2sUserAttachedForm> formBeans = new ArrayList<>();
        XfaForm xfaForm = reader.getAcroFields().getXfa();
        Document domDocument = xfaForm.getDomDocument();
        if (domDocument == null) {
            throwInvalidError();
        }

        final Element documentElement = domDocument.getDocumentElement();
        if (documentElement == null) {
            throwInvalidError();
        }

        final Element datasetsElement = (Element) documentElement.getElementsByTagNameNS(XFA_NS, "datasets").item(0);
        if(datasetsElement == null){
            throwInvalidError();
        }
        final Element dataElement = (Element) datasetsElement.getElementsByTagNameNS(XFA_NS, "data").item(0);
        if(dataElement == null){
            throwInvalidError();
        }

        final Node grantApplicationElement = dataElement.getChildNodes().item(0);

        if (grantApplicationElement == null) {
            S2SException s2sException = new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_NOT_FILLED,"The pdf form does not contain any data.");
            s2sException.setTabErrorKey(USER_ATTACHED_FORMS_ERRORS);
            throw s2sException;
        }

        byte[] serializedXML = XfaForm.serializeDoc(grantApplicationElement);
        final Document document;
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedXML)) {
            document = createDomBuilder().parse(byteArrayInputStream);
        }
        if (document != null) {
            Element form;
            NodeList elements = document.getElementsByTagNameNS("http://apply.grants.gov/system/MetaGrantApplication", "Forms");
            Element element = (Element)elements.item(0);
            if(element!=null){
                NodeList formChildren = element.getChildNodes();
                int formsCount = formChildren.getLength();
                if(formsCount>1){
                     NodeList selectedOptionalFormElements = document.getElementsByTagNameNS("http://apply.grants.gov/system/MetaGrantApplicationWrapper", "SelectedOptionalForms");
                    int selectedOptionalFormsCount = selectedOptionalFormElements==null?0:selectedOptionalFormElements.getLength();
                    if (selectedOptionalFormsCount > 0) {
                        Element selectedFormNode = (Element) selectedOptionalFormElements.item(0);
                        NodeList selectedForms = selectedFormNode.getElementsByTagNameNS("http://apply.grants.gov/system/MetaGrantApplicationWrapper","FormTagName");
                        int selectedFormsCount = selectedForms == null ? 0 : selectedForms.getLength();
                        if (selectedFormsCount > 0) {
                            List<String> seletctedForms = new ArrayList<>();
                            for (int j = 0; j < selectedFormsCount; j++) {
                                Element selectedForm = (Element) selectedForms.item(j);
                                String formName = selectedForm.getTextContent();
                                seletctedForms.add(formName);

                            }
                            for (int i = 0; i < formsCount; i++) {
                                form = (Element) formChildren.item(i);
                                String formNodeName = form.getLocalName();
                                if (seletctedForms.contains(formNodeName)) {
                                    addForm(developmentProposal, formBeans, form, userAttachedForm, attachments);
                                }
                            }
                        }
                    }
                }else{
                    form = (Element) formChildren.item(0);
                    addForm(developmentProposal,formBeans,form,userAttachedForm, attachments);
                }
            }else{
                form = document.getDocumentElement();
                addForm(developmentProposal,formBeans,form,userAttachedForm, attachments);
            }
        }
        return formBeans;
    }

    protected void addForm(ProposalDevelopmentDocument developmentProposal, List<S2sUserAttachedForm> formBeans, Element form,
                           S2sUserAttachedForm userAttachedFormBean, Map<String, byte[]> attachments) throws TransformerException, XPathExpressionException {
        S2sUserAttachedForm userAttachedForm = processForm(developmentProposal, form,userAttachedFormBean,attachments);
        if(userAttachedForm!=null){
            formBeans.add(userAttachedForm);
        }
    }
    private void validateForm(ProposalDevelopmentDocument developmentProposal, S2sUserAttachedForm userAttachedForm) throws S2SException{
        S2sOpportunity opportunity = developmentProposal.getDevelopmentProposal().getS2sOpportunity();
        if(opportunity!=null){
            List<S2sUserAttachedForm> userAttachedForms = developmentProposal.getDevelopmentProposal().getS2sUserAttachedForms();
            for (S2sUserAttachedForm s2sForm : userAttachedForms) {
                if(userAttachedForm.getNamespace().equals(s2sForm.getNamespace())){
                    S2SException s2sException  = new S2SException(KeyConstants.S2S_DUPLICATE_USER_ATTACHED_FORM,
                                "The form is already available in the forms list",userAttachedForm.getFormName());
                    s2sException.setTabErrorKey(USER_ATTACHED_FORMS_ERRORS);
                    throw s2sException;
                }
            }
        }
    }

    private S2sUserAttachedForm processForm(ProposalDevelopmentDocument developmentProposal, Element form, S2sUserAttachedForm userAttachedForm, Map<String, byte[]> attachments) throws TransformerException, XPathExpressionException {
        
        String formname;
        String namespaceUri;
        String formXML;
        namespaceUri = form.getNamespaceURI();
        formname = form.getLocalName();
        FormMappingInfo bindingInfoBean = formMappingService.getFormInfo(namespaceUri);
        if (bindingInfoBean != null) {
            S2sFormConfigurationContract formConfig = s2sFormConfigurationService.findS2sFormConfigurationByFormName(bindingInfoBean.getFormName());
            if (formConfig == null || formConfig.isActive()) {
                S2SException s2SException = new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_NOT_ALLOWED,
                        "The form is not configured for user attachment", formname);
                s2SException.setTabErrorKey(USER_ATTACHED_FORMS_ERRORS);
                throw s2SException;
            }
        }
        Document doc = formUtilityService.node2Dom(form);

        doHumanStudiesWorkaround(doc, attachments);

        String xpathEmptyNodes = "//*[not(node()) and local-name(.) != 'FileLocation' and local-name(.) != 'HashValue' and local-name(.) != 'FileName']";// and not(FileLocation[@href])]";// and string-length(normalize-space(@*)) = 0 ]";
        String xpathOtherPers = "//*[local-name(.)='ProjectRole' and local-name(../../.)='OtherPersonnel' and count(../NumberOfPersonnel)=0]";
        formUtilityService.removeAllEmptyNodes(doc, xpathEmptyNodes, 0);
        formUtilityService.removeAllEmptyNodes(doc, xpathOtherPers, 1);
        formUtilityService.removeAllEmptyNodes(doc, xpathEmptyNodes, 0);
        NodeList hashValueNodes =  doc.getElementsByTagName("glob:HashValue");
        for (int i = 0; i < hashValueNodes.getLength(); i++) {
            Node hashValue = hashValueNodes.item(i);
            ((Element)hashValue).setAttribute("xmlns:glob", "http://apply.grants.gov/system/Global-V1.0");
        }

        formUtilityService.reorderXmlElements(doc);

        S2sUserAttachedForm newUserAttachedForm = cloneUserAttachedForm(userAttachedForm);
        newUserAttachedForm.setNamespace(namespaceUri);
        newUserAttachedForm.setFormName(formname);
        updateAttachmentNodes(doc, newUserAttachedForm, attachments);
        formXML = formUtilityService.docToString(doc);

        S2sUserAttachedFormFile newUserAttachedFormFile = new S2sUserAttachedFormFile();
        newUserAttachedFormFile.setXmlFile(formXML);
        if (!validateUserAttachedFormFile(newUserAttachedFormFile, formname))
            return null;

        validateForm(developmentProposal,newUserAttachedForm);

        for (S2sUserAttachedFormAtt attachment : newUserAttachedForm.getS2sUserAttachedFormAtts()) {
            attachment.setS2sUserAttachedForm(newUserAttachedForm);
            for (S2sUserAttachedFormAttFile file : attachment.getS2sUserAttachedFormAttFiles()) {
                file.setS2sUserAttachedFormAtt(attachment);
            }
        }

        newUserAttachedFormFile.setFormFile(userAttachedForm.getNewFormFileBytes());
        newUserAttachedFormFile.setS2sUserAttachedForm(newUserAttachedForm);
        newUserAttachedFormFile.setUpdateUser(userAttachedForm.getUpdateUser());
        newUserAttachedForm.getS2sUserAttachedFormFileList().add(newUserAttachedFormFile);
        return newUserAttachedForm;
        
    }

    /**
     * Human Studies attachments are not properly deserialized by itext or pdfbox.  This method searches for human studies attachments deserializes
     * them into xml and manually appends the xml to the form.
     *
     * @param doc         the form as an Xml Document.  This document could get modified by this method.
     * @param attachments form attachments.  This map could get modified by this method.
     */
    private void doHumanStudiesWorkaround(Document doc, Map<String, byte[]> attachments) {
        final Map<String, byte[]> allHsAttachments = new HashMap<>();

        final NodeList hsAtt = doc.getElementsByTagNameNS("http://apply.grants.gov/forms/PHSHumanSubjectsAndClinicalTrialsInfo-V1.0", "ATT");
        for (int i = 0; i < hsAtt.getLength(); i++) {
            final Node attachmentName = hsAtt.item(i);
            byte[] hsAttPdf = attachments.get(attachmentName.getTextContent());
            if (hsAttPdf != null) {
                try {
                    final Map<String, Object> hsAttinfo = proposalSpecialReviewHumanSubjectsAttachmentService.getSpecialReviewAttachmentXmlFileData(hsAttPdf);
                    if (hsAttinfo != null) {
                        final String hsXml = (String) hsAttinfo.get(ProposalSpecialReviewHumanSubjectsAttachmentService.CONTENT);
                        if (StringUtils.isNotBlank(hsXml)) {
                            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(hsXml.getBytes(StandardCharsets.UTF_8.name()))) {
                                final Document hsDocument = createDomBuilder().parse(byteArrayInputStream);
                                final Node hsNode = hsDocument.getElementsByTagNameNS("http://apply.grants.gov/forms/HumanSubjectStudy-V1.0", "HumanSubjectStudy").item(0);
                                final NodeList hsAttachment = doc.getElementsByTagNameNS("http://apply.grants.gov/forms/PHSHumanSubjectsAndClinicalTrialsInfo-V1.0", "HumanSubjectStudyAttachment");
                                final Node hsAttachmentNode = hsAttachment.item(0);
                                hsAttachmentNode.appendChild(doc.importNode(hsNode, true));
                            }
                        }
                        final Map<String, byte[]> hsctAttachments = (Map<String, byte[]>) hsAttinfo.get(ProposalSpecialReviewHumanSubjectsAttachmentService.FILES);
                        if (hsctAttachments != null) {
                            allHsAttachments.putAll(hsctAttachments);
                        }
                    } else {
                        globalVariableService.getMessageMap().putError(USER_ATTACHED_FORMS_ERRORS, KeyConstants.S2S_USER_ATTACHED_FORM_NOT_VALID, "The human studies attachment " + attachmentName.getTextContent() + " is invalid");
                    }
                } catch (RuntimeException | ParserConfigurationException | IOException | SAXException e) {
                    globalVariableService.getMessageMap().putError(USER_ATTACHED_FORMS_ERRORS, KeyConstants.S2S_USER_ATTACHED_FORM_NOT_VALID, "The human studies attachment " + attachmentName.getTextContent() + " is invalid");
                }
            }
        }
        attachments.putAll(allHsAttachments);
    }

    private DocumentBuilder createDomBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory domParserFactory = DocumentBuilderFactory.newInstance();
        domParserFactory.setNamespaceAware(true);
        DocumentBuilder domParser = domParserFactory.newDocumentBuilder();
        domParserFactory.setIgnoringElementContentWhitespace(true);
        return domParser;
    }

    private boolean validateUserAttachedFormFile(S2sUserAttachedFormFile userAttachedFormFile, String formName) {
        FormGenerationResult result = formGeneratorService.validateUserAttachedFormFile(userAttachedFormFile, formName);
        if(!result.isValid()) {
            setValidationErrorMessage(result);
            return false;
        }
        return true;
    }

    protected void setValidationErrorMessage(FormGenerationResult result) {
        for (AuditError error : result.getErrors()) {
            globalVariableService.getMessageMap().putError(USER_ATTACHED_FORMS_ERRORS, KeyConstants.S2S_USER_ATTACHED_FORM_NOT_VALID, error.getMessageKey());
        }
    }


    private S2sUserAttachedForm cloneUserAttachedForm(
            S2sUserAttachedForm userAttachedForm) {
        S2sUserAttachedForm newUserAttachedForm = new S2sUserAttachedForm();
        newUserAttachedForm.setDescription(userAttachedForm.getDescription());
        newUserAttachedForm.setFormFileName(userAttachedForm.getFormFileName());
        newUserAttachedForm.setNamespace(userAttachedForm.getNamespace());
        newUserAttachedForm.setFormName(userAttachedForm.getFormName());
        newUserAttachedForm.setS2sUserAttachedFormAtts(userAttachedForm.getS2sUserAttachedFormAtts());
        newUserAttachedForm.setProposalNumber(userAttachedForm.getProposalNumber());
        newUserAttachedForm.setUpdateUser(userAttachedForm.getUpdateUser());
        newUserAttachedForm.setUpdateTimestamp(userAttachedForm.getUpdateTimestamp());
        return newUserAttachedForm;
    }

    private void updateAttachmentNodes(Document document, S2sUserAttachedForm userAttachedFormBean, Map<String, byte[]> attachments) {
        NodeList lstFileName = document.getElementsByTagNameNS("http://apply.grants.gov/system/Attachments-V1.0", "FileName");
        NodeList lstFileLocation = document.getElementsByTagNameNS("http://apply.grants.gov/system/Attachments-V1.0", "FileLocation");
        NodeList lstHashValue = document.getElementsByTagNameNS("http://apply.grants.gov/system/Global-V1.0", "HashValue");
        NodeList lstMimeType = document.getElementsByTagNameNS("http://apply.grants.gov/system/Attachments-V1.0","MimeType");


        if ( (lstFileName.getLength() != lstFileLocation.getLength()) || 
                (lstFileLocation.getLength() != lstHashValue.getLength())) {
            throw new S2SException("Attachment node occurrences and number of attachments mismatch in PDF File");
        }

        org.w3c.dom.Node fileNode, hashNode, mimeTypeNode;
        org.w3c.dom.NamedNodeMap fileNodeMap;
        String fileName;
        byte[] fileBytes;
        String hashValue;
        String contentId;
        List<S2sUserAttachedFormAtt> attachmentList = new ArrayList<>();
        for (int index = 0; index < lstFileName.getLength(); index++) {
            fileNode = lstFileName.item(index);
            if (fileNode.getFirstChild() == null) {
                continue;//no attachments
            }
            fileName = fileNode.getFirstChild().getNodeValue();
            fileBytes = attachments.get(fileName);
            if (fileBytes == null || fileBytes.length == 0) {
                throw new S2SException("FileName mismatch in XML and PDF extracted file");
            }

            hashValue = grantApplicationHashService.computeAttachmentHash(fileBytes);
            hashNode = lstHashValue.item(index);
            NamedNodeMap hashNodeMap = hashNode.getAttributes();
            Node temp = document.createTextNode(hashValue);
            hashNode.appendChild(temp);

            Node hashAlgorithmNode = hashNodeMap.getNamedItemNS("http://apply.grants.gov/system/Global-V1.0", "hashAlgorithm");
            hashAlgorithmNode.setNodeValue(InfastructureConstants.HASH_ALGORITHM);
            hashNodeMap.setNamedItemNS(hashAlgorithmNode);
            
            fileNode = lstFileLocation.item(index);
            fileNodeMap = fileNode.getAttributes();
            fileNode = fileNodeMap.getNamedItemNS("http://apply.grants.gov/system/Attachments-V1.0", "href");
            contentId = fileNode.getNodeValue();

            S2sUserAttachedFormAtt userAttachedFormAttachment = new S2sUserAttachedFormAtt();
            S2sUserAttachedFormAttFile userAttachedFormAttachmentFile = new S2sUserAttachedFormAttFile();
            userAttachedFormAttachmentFile.setAttachment(fileBytes);
            userAttachedFormAttachment.getS2sUserAttachedFormAttFiles().add(userAttachedFormAttachmentFile);
            userAttachedFormAttachment.setContentId(contentId);
            userAttachedFormAttachment.setName(fileName);
            
            mimeTypeNode = lstMimeType.item(0);
            String contentType = mimeTypeNode.getFirstChild().getNodeValue();
            userAttachedFormAttachment.setType(contentType);

            userAttachedFormAttachment.setProposalNumber(userAttachedFormBean.getProposalNumber());
            userAttachedFormAttachment.setS2sUserAttachedForm(userAttachedFormBean);
            attachmentList.add(userAttachedFormAttachment);
        }
        userAttachedFormBean.setS2sUserAttachedFormAtts(attachmentList);
    }

    @Override
    public void resetFormAvailability(ProposalDevelopmentDocument developmentProposal, String namespace) {
        S2sOpportunity opportunity = developmentProposal.getDevelopmentProposal().getS2sOpportunity();
        if(opportunity!=null) {
            List<S2sOppForms> oppForms = opportunity.getS2sOppForms(); 
            if(oppForms!=null) {
            	setS2sOppFormsAvailability(oppForms, namespace, false);
            }
        }
    }

    protected void setFormsAvailability(ProposalDevelopmentDocument developmentProposal, List<S2sUserAttachedForm> savedFormBeans) {
        S2sOpportunity opportunity = developmentProposal.getDevelopmentProposal().getS2sOpportunity();
        if(opportunity!=null){
            List<S2sOppForms> oppForms = opportunity.getS2sOppForms(); 
            if(oppForms!=null){
            	savedFormBeans.forEach(s2sUserAttachedForm -> setS2sOppFormsAvailability(oppForms, s2sUserAttachedForm.getNamespace(), true));
            }
        }
    }
    
    protected void setS2sOppFormsAvailability(List<S2sOppForms> oppForms, String namespace, boolean isAvailable) {
    	oppForms.stream()
    	.filter(s2sOppForms -> s2sOppForms.getS2sOppFormsId().getOppNameSpace().equals(namespace))
    	.forEach(s2sOppForms -> {
    	    s2sOppForms.setAvailable(isAvailable);
    	    s2sOppForms.setUserAttachedForm(isAvailable);
    	    s2sOppForms.setInclude(isAvailable);
    	});
    }

    public FormMappingService getFormMappingService() {
        return formMappingService;
    }

    public void setFormMappingService(FormMappingService formMappingService) {
        this.formMappingService = formMappingService;
    }

    public GrantApplicationHashService getGrantApplicationHashService() {
        return grantApplicationHashService;
    }

    public void setGrantApplicationHashService(GrantApplicationHashService grantApplicationHashService) {
        this.grantApplicationHashService = grantApplicationHashService;
    }

    public GlobalVariableService getGlobalVariableService() {
        return globalVariableService;
    }

    public void setGlobalVariableService(GlobalVariableService globalVariableService) {
        this.globalVariableService = globalVariableService;
    }

    public FormGeneratorService getFormGeneratorService() {
        return formGeneratorService;
    }

    public void setFormGeneratorService(FormGeneratorService formGeneratorService) {
        this.formGeneratorService = formGeneratorService;
    }

    public FormUtilityService getFormUtilityService() {
        return formUtilityService;
    }

    public void setFormUtilityService(FormUtilityService formUtilityService) {
        this.formUtilityService = formUtilityService;
    }

    public S2sFormConfigurationService getS2sFormConfigurationService() {
        return s2sFormConfigurationService;
    }

    public void setS2sFormConfigurationService(S2sFormConfigurationService s2sFormConfigurationService) {
        this.s2sFormConfigurationService = s2sFormConfigurationService;
    }

    public ProposalSpecialReviewHumanSubjectsAttachmentService getProposalSpecialReviewHumanSubjectsAttachmentService() {
        return proposalSpecialReviewHumanSubjectsAttachmentService;
    }

    public void setProposalSpecialReviewHumanSubjectsAttachmentService(ProposalSpecialReviewHumanSubjectsAttachmentService proposalSpecialReviewHumanSubjectsAttachmentService) {
        this.proposalSpecialReviewHumanSubjectsAttachmentService = proposalSpecialReviewHumanSubjectsAttachmentService;
    }
}
