/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.propdev.impl.s2s;


import com.lowagie.text.pdf.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xpath.XPathAPI;
import org.kuali.coeus.propdev.api.s2s.S2sFormConfigurationContract;
import org.kuali.coeus.propdev.api.s2s.S2sFormConfigurationService;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
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
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.w3c.dom.*;

import javax.xml.bind.UnmarshalException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

@Component("s2sUserAttachedFormService")
public class S2sUserAttachedFormServiceImpl implements S2sUserAttachedFormService {

    private static final Log LOG = LogFactory.getLog(S2sUserAttachedFormServiceImpl.class);

    private static final String DUPLICATE_FILE_NAMES = "Attachments contain duplicate file names";
    private static final String XFA_NS = "http://www.xfa.org/schema/xfa-data/1.0/";
    private static final String USER_ATTACHED_FORMS_ERRORS = "userAttachedFormsErrors";

    @Autowired
    @Qualifier("formGeneratorService")
    private FormGeneratorService formGeneratorService;

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

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

    @Override
    public List<S2sUserAttachedForm> extractNSaveUserAttachedForms(ProposalDevelopmentDocument developmentProposal,
                                                                        S2sUserAttachedForm s2sUserAttachedForm) throws Exception{
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
                Map<Object, Object> attachments = extractAttachments(reader);
                formBeans = extractAndPopulateXml(developmentProposal,reader,s2sUserAttachedForm,attachments);
            }
            setFormsAvailability(developmentProposal,formBeans);
        }finally{
            if(reader!=null) reader.close();
        }
        return formBeans;
    }

    @Override
    public Map<Object, Object> extractAttachments(PdfReader reader)throws IOException{
        Map<Object, Object> fileMap = new HashMap<>();
        
        PdfDictionary catalog = reader.getCatalog();
        PdfDictionary names = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.NAMES));
        if (names != null) {
            PdfDictionary embFiles = (PdfDictionary) PdfReader.getPdfObject(names.get(new PdfName("EmbeddedFiles")));
            if (embFiles != null) {
                HashMap embMap = PdfNameTree.readTree(embFiles);

                for (Object o : embMap.values()) {
                    PdfDictionary filespec = (PdfDictionary) PdfReader.getPdfObject((PdfObject) o);
                    Object[] fileInfo = unpackFile(filespec);
                    if (!fileMap.containsKey(fileInfo[0])) {
                        fileMap.put(fileInfo[0], fileInfo[1]);
                    }
                }
            }
        }
        for (int k = 1; k <= reader.getNumberOfPages(); ++k) {
            PdfArray annots = (PdfArray) PdfReader.getPdfObject(reader.getPageN(k).get(PdfName.ANNOTS));
            if (annots == null)
                continue;
            for (Iterator i = annots.listIterator(); i.hasNext();) {
                PdfDictionary annot = (PdfDictionary) PdfReader.getPdfObject((PdfObject) i.next());
                PdfName subType = (PdfName) PdfReader.getPdfObject(annot.get(PdfName.SUBTYPE));
                if (!PdfName.FILEATTACHMENT.equals(subType))
                    continue;
                PdfDictionary filespec = (PdfDictionary) PdfReader.getPdfObject(annot.get(PdfName.FS));
                Object[] fileInfo = unpackFile(filespec);
                if(fileMap.containsKey(fileInfo[0])) {
                    throw new RuntimeException(DUPLICATE_FILE_NAMES);
                }
                fileMap.put(fileInfo[0], fileInfo[1]);
            }
        }
        
        return fileMap;
    }
    /**
     * Unpacks a file attachment.
     * @param filespec The dictionary containing the file specifications
     */
    private Object[] unpackFile(PdfDictionary filespec)throws IOException  {

        if (filespec == null)
            return null;
        
        PdfName type = (PdfName) PdfReader.getPdfObject(filespec.get(PdfName.TYPE));
        
        if (!PdfName.F.equals(type) && !PdfName.FILESPEC.equals(type))
            return null;
        
        PdfDictionary ef = (PdfDictionary) PdfReader.getPdfObject(filespec.get(PdfName.EF));
        if (ef == null)
            return null;
        
        PdfString fn = (PdfString) PdfReader.getPdfObject(filespec.get(PdfName.F));
        if (fn == null)
            return null;
        
        File fLast = new File(fn.toUnicodeString());
        
        PRStream prs = (PRStream) PdfReader.getPdfObject(ef.get(PdfName.F));
        if (prs == null)
            return null;
        
        
        
        byte attachmentByte[] = PdfReader.getStreamBytes(prs);
        Object[] fileInfo = new Object[2];
        fileInfo[0]=fLast.getName();
        fileInfo[1]=attachmentByte;
        return fileInfo;
    }

    private void throwInvalidError() {
        S2SException s2sException = new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_WRONG_FILE_TYPE,"Uploaded file is not Grants.Gov fillable form");
        s2sException.setTabErrorKey(USER_ATTACHED_FORMS_ERRORS);
        throw s2sException;
    }

    protected List<S2sUserAttachedForm> extractAndPopulateXml(ProposalDevelopmentDocument developmentProposal, PdfReader reader, S2sUserAttachedForm userAttachedForm, Map attachments) throws Exception {
        List<S2sUserAttachedForm> formBeans = new ArrayList<>();
        XfaForm xfaForm = reader.getAcroFields().getXfa();
        Node domDocument = xfaForm.getDomDocument();
        if(domDocument == null){
            throwInvalidError();
        }

        final Element documentElement = ((Document) domDocument).getDocumentElement();
        if(documentElement == null){
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
        final Element grantApplicationElement = (Element) dataElement.getChildNodes().item(0);

        if (grantApplicationElement == null) {
            S2SException s2sException = new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_NOT_FILLED,"The pdf form does not contain any data.");
            s2sException.setTabErrorKey(USER_ATTACHED_FORMS_ERRORS);
            throw s2sException;
        }

        byte[] serializedXML = XfaForm.serializeDoc(grantApplicationElement);
        DocumentBuilderFactory domParserFactory = DocumentBuilderFactory.newInstance();
        domParserFactory.setNamespaceAware(true);
        javax.xml.parsers.DocumentBuilder domParser = domParserFactory.newDocumentBuilder();
        domParserFactory.setIgnoringElementContentWhitespace(true);

        final org.w3c.dom.Document document;
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedXML)) {
            document = domParser.parse(byteArrayInputStream);
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
                            List<String> exceptions = new ArrayList<>();
                            for (int i = 0; i < formsCount; i++) {
                                form = (Element) formChildren.item(i);
                                String formNodeName = form.getLocalName();
                                if (seletctedForms.contains(formNodeName)) {
                                    try{
                                        addForm(developmentProposal,formBeans,form,userAttachedForm, attachments);
                                    }catch(UnmarshalException ume){
                                        exceptions.add("Not able to create xml for the form "+formNodeName+" Root Cause:"+ume.getMessage()+"<br>");
                                    }

                                }
                            }
                            if(!exceptions.isEmpty()) throw new S2SException(exceptions.toString());
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
            S2sUserAttachedForm userAttachedFormBean, Map attachments) throws Exception {
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

    private S2sUserAttachedForm processForm(ProposalDevelopmentDocument developmentProposal, Element form,S2sUserAttachedForm userAttachedForm, Map attachments) throws Exception {
        
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
        Document doc = node2Dom(form);
        String xpathEmptyNodes = "//*[not(node()) and local-name(.) != 'FileLocation' and local-name(.) != 'HashValue' and local-name(.) != 'FileName']";// and not(FileLocation[@href])]";// and string-length(normalize-space(@*)) = 0 ]";
        String xpathOtherPers = "//*[local-name(.)='ProjectRole' and local-name(../../.)='OtherPersonnel' and count(../NumberOfPersonnel)=0]";
        removeAllEmptyNodes(doc,xpathEmptyNodes,0);
        removeAllEmptyNodes(doc,xpathOtherPers,1);
        removeAllEmptyNodes(doc,xpathEmptyNodes,0);
        NodeList hashValueNodes =  doc.getElementsByTagName("glob:HashValue");
        for (int i = 0; i < hashValueNodes.getLength(); i++) {
            Node hashValue = hashValueNodes.item(i);
            ((Element)hashValue).setAttribute("xmlns:glob", "http://apply.grants.gov/system/Global-V1.0");
        }

        reorderXmlElements(doc);

        S2sUserAttachedForm newUserAttachedForm = cloneUserAttachedForm(userAttachedForm);
        newUserAttachedForm.setNamespace(namespaceUri);
        newUserAttachedForm.setFormName(formname);
        updateAttachmentNodes(doc, newUserAttachedForm, attachments);
        formXML = docToString(doc);

        S2sUserAttachedFormFile newUserAttachedFormFile = new S2sUserAttachedFormFile();
        newUserAttachedFormFile.setXmlFile(formXML);
        if(!validateUserAttachedFormFile(newUserAttachedFormFile, formname, developmentProposal))
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

    @Override
    public Document node2Dom(org.w3c.dom.Node n) throws TransformerException {
        javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
        javax.xml.transform.Transformer xf = tf.newTransformer();
        javax.xml.transform.dom.DOMResult dr = new javax.xml.transform.dom.DOMResult();
        xf.transform(new javax.xml.transform.dom.DOMSource(n),dr);
        return (Document)dr.getNode();
    }

    @Override
    public void reorderXmlElements(Document doc) {
        Collection<UserAttachedFormsXMLReorder> userAttachedFormsXmlReorders = getBusinessObjectService().findAll(UserAttachedFormsXMLReorder.class);
        if (userAttachedFormsXmlReorders != null) {
            userAttachedFormsXmlReorders.forEach(userAttachedFormsXMLReorder -> {
                try {
                    reorderXmlElement(doc, userAttachedFormsXMLReorder.getNodeToMove(), userAttachedFormsXMLReorder.getTargetNode(), userAttachedFormsXMLReorder.isMoveAfter());
                } catch (Exception e) {
                    LOG.error("Could not move XML node " + userAttachedFormsXMLReorder.getNodeToMove() + "next to " + userAttachedFormsXMLReorder.getTargetNode());
                }
            });
        }
    }

    protected void reorderXmlElement(Document doc, String original, String target, boolean insertAfter) {
        final NodeList originalNodes =  doc.getElementsByTagName(original);
        if (originalNodes != null && originalNodes.getLength() > 0) {
            final Node originalNode = originalNodes.item(0);
            final NodeList targetNodes = doc.getElementsByTagName(target);
            if (targetNodes != null && targetNodes.getLength() > 0) {
                if (insertAfter) {
                    moveNode(originalNode, targetNodes.item(0).getNextSibling());
                } else {
                    moveNode(originalNode, targetNodes.item(0));
                }
            }
        }
    }

    private void moveNode(Node original, Node target) {
        final Node copy = original.cloneNode(true);
        final Node parent = target.getParentNode();
        parent.insertBefore(copy, target);
        parent.removeChild(original);
    }

    @Override
    public void removeAllEmptyNodes(Document document, String xpath, int parentLevel) throws TransformerException {
        NodeList emptyElements =  XPathAPI.selectNodeList(document,xpath);
        for (int i = emptyElements.getLength()-1; i > -1; i--){
              Node nodeToBeRemoved = emptyElements.item(i);
              int hierLevel = parentLevel;
              while(hierLevel-- > 0){
                  nodeToBeRemoved = nodeToBeRemoved.getParentNode();
              }
              nodeToBeRemoved.getParentNode().removeChild(nodeToBeRemoved);
        }
        NodeList moreEmptyElements =  XPathAPI.selectNodeList(document,xpath);
        if(moreEmptyElements.getLength()>0){
            removeAllEmptyNodes(document,xpath,parentLevel);
        }
    }   

    private boolean validateUserAttachedFormFile(S2sUserAttachedFormFile userAttachedFormFile, String formName, ProposalDevelopmentDocument developmentProposal) throws Exception{
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

    /**
     * This method convert Document to a String
     * 
     * @param node {Document} node entry.
     * @return String containing doc information
     */
    @Override
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
            throw new S2SException(e.getMessage());
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

    private void updateAttachmentNodes(Document document, S2sUserAttachedForm userAttachedFormBean, Map attachments) throws Exception{
        NodeList lstFileName = document.getElementsByTagNameNS("http://apply.grants.gov/system/Attachments-V1.0", "FileName");
        NodeList lstFileLocation = document.getElementsByTagNameNS("http://apply.grants.gov/system/Attachments-V1.0", "FileLocation");
        NodeList lstHashValue = document.getElementsByTagNameNS("http://apply.grants.gov/system/Global-V1.0", "HashValue");
        NodeList lstMimeType = document.getElementsByTagNameNS("http://apply.grants.gov/system/Attachments-V1.0","MimeType");


        if ( (lstFileName.getLength() != lstFileLocation.getLength()) || 
                (lstFileLocation.getLength() != lstHashValue.getLength())) {
            throw new S2SException("Attachment node occurances and number of attachments mismatch in PDF File");
        }

        org.w3c.dom.Node fileNode, hashNode, mimeTypeNode;
        org.w3c.dom.NamedNodeMap fileNodeMap;
        String fileName; 
        byte fileBytes[];
        String hashValue;
        String contentId;
        List<S2sUserAttachedFormAtt> attachmentList = new ArrayList<>();
        for (int index = 0; index < lstFileName.getLength(); index++) {
            fileNode = lstFileName.item(index);
            if (fileNode.getFirstChild() == null) {
                continue;//no attachments
            }
            fileName = fileNode.getFirstChild().getNodeValue(); 
            fileBytes = (byte[]) attachments.get(fileName);
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

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
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
}
