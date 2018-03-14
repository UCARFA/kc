/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.specialreview;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.XfaForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.coeus.propdev.impl.s2s.FormUtilityService;
import org.kuali.coeus.s2sgen.api.core.S2SException;
import org.kuali.coeus.s2sgen.api.hash.GrantApplicationHashService;
import org.kuali.kra.infrastructure.KeyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.kuali.coeus.sys.framework.util.CollectionUtils.*;

@Component("proposalSpecialReviewHumanSubjectsAttachmentService")
public class ProposalSpecialReviewHumanSubjectsAttachmentServiceImpl implements ProposalSpecialReviewHumanSubjectsAttachmentService {

    private static final String EMPTY_NODES = "//*[not(node()) and local-name(.) != 'FileLocation' and local-name(.) != 'HashValue' and local-name(.) != 'FileName']";
    private static final String OTHER_PERS = "//*[local-name(.)='ProjectRole' and local-name(../../.)='OtherPersonnel' and count(../NumberOfPersonnel)=0]";
    private static final String GLOB_HASH_VALUE = "glob:HashValue";
    private static final String GLOBAL_V1_0 = "http://apply.grants.gov/system/Global-V1.0";
    private static final String XMLNS_GLOB = "xmlns:glob";
    private static final String MESSAGE = "The pdf form does not contain any data.";
    private static final String UPLOADED_FILE_IS_EMPTY = "Uploaded file is empty";
    private static final String XFA_NS = "http://www.xfa.org/schema/xfa-data/1.0/";

    private static Log LOG = LogFactory.getLog(ProposalSpecialReviewHumanSubjectsAttachmentServiceImpl.class);

    @Autowired
    @Qualifier("formUtilityService")
    private FormUtilityService formUtilityService;

    @Autowired
    @Qualifier("grantApplicationHashService")
    private GrantApplicationHashService grantApplicationHashService;

    @Override
    public Map<String, Object> getSpecialReviewAttachmentXmlFileData(byte pdfFileContents[]) {
        String xml;
        Map<String, byte[]> attachments;
        Map<String, Object> fileData = new HashMap<>();
        PdfReader reader = null;
        try {
            if (pdfFileContents == null || pdfFileContents.length == 0) {
                throw new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_EMPTY, UPLOADED_FILE_IS_EMPTY);
            } else {
                reader = new PdfReader(pdfFileContents);

                attachments = formUtilityService.extractAttachments(reader);
                fileData.put(FILES, attachments);
                XfaForm xfaForm = reader.getAcroFields().getXfa();
                Node domDocument = xfaForm.getDomDocument();
                if (domDocument == null) {
                    throw new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_NOT_FILLED, MESSAGE);
                }

                final Element documentElement = ((Document) domDocument).getDocumentElement();
                if (documentElement == null) {
                    throw new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_NOT_FILLED, MESSAGE);
                }

                final Element datasetsElement = (Element) documentElement.getElementsByTagNameNS(XFA_NS, "datasets").item(0);
                if (datasetsElement == null) {
                    throw new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_NOT_FILLED, MESSAGE);
                }
                final Element dataElement = (Element) datasetsElement.getElementsByTagNameNS(XFA_NS, "data").item(0);
                if (dataElement == null) {
                    throw new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_NOT_FILLED, MESSAGE);
                }
                final Element grantApplicationElement = (Element) dataElement.getChildNodes().item(0);

                if (grantApplicationElement == null) {
                    throw new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_NOT_FILLED, MESSAGE);
                }

                byte[] serializedXML = XfaForm.serializeDoc(grantApplicationElement);
                DocumentBuilderFactory domParserFactory = DocumentBuilderFactory.newInstance();
                domParserFactory.setNamespaceAware(true);
                javax.xml.parsers.DocumentBuilder domParser = domParserFactory.newDocumentBuilder();
                domParserFactory.setIgnoringElementContentWhitespace(true);

                final org.w3c.dom.Document document;
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedXML);
                document = domParser.parse(byteArrayInputStream);
                if (document != null) {
                    Element form;
                    form = document.getDocumentElement();
                    xml = processForm(form, attachments);
                    fileData.put(CONTENT, xml);
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException | XPathExpressionException exception) {
            fileData = null;
            LOG.error("Cannot parse attachment." + exception.getMessage(), exception);
        } finally {
            if (reader != null) reader.close();
        }

        return fileData;
    }


    private String processForm(Element form, Map<String, byte[]> attachments) throws TransformerException, XPathExpressionException {

        String formXML;
        Document doc = formUtilityService.node2Dom(form);
        formUtilityService.correctAttachmentNameHrefHash(doc, attachments
                .entrySet()
                .stream()
                .map(e -> entry(e.getKey(), getGrantApplicationHashService().computeAttachmentHash(e.getValue())))
                .collect(entriesToMap()));
        formUtilityService.removeAllEmptyNodes(doc, EMPTY_NODES, 0);
        formUtilityService.removeAllEmptyNodes(doc, OTHER_PERS, 1);
        formUtilityService.removeAllEmptyNodes(doc, EMPTY_NODES, 0);
        NodeList hashValueNodes = doc.getElementsByTagName(GLOB_HASH_VALUE);
        for (int i = 0; i < hashValueNodes.getLength(); i++) {
            Node hashValue = hashValueNodes.item(i);
            ((Element) hashValue).setAttribute(XMLNS_GLOB, GLOBAL_V1_0);
        }
        formUtilityService.reorderXmlElements(doc);
        formXML = formUtilityService.docToString(doc);
        return formXML;
    }

    public FormUtilityService getFormUtilityService() {
        return formUtilityService;
    }

    public void setFormUtilityService(FormUtilityService formUtilityService) {
        this.formUtilityService = formUtilityService;
    }

    public GrantApplicationHashService getGrantApplicationHashService() {
        return grantApplicationHashService;
    }

    public void setGrantApplicationHashService(GrantApplicationHashService grantApplicationHashService) {
        this.grantApplicationHashService = grantApplicationHashService;
    }
}
