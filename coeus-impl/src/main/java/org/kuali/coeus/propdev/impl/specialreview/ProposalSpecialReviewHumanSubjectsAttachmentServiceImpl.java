package org.kuali.coeus.propdev.impl.specialreview;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.XfaForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.coeus.propdev.impl.s2s.S2sUserAttachedFormService;
import org.kuali.coeus.s2sgen.api.core.S2SException;
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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component("proposalSpecialReviewHumanSubjectsAttachmentService")
public class ProposalSpecialReviewHumanSubjectsAttachmentServiceImpl implements ProposalSpecialReviewHumanSubjectsAttachmentService {

    public static final String CONTENT = "content";
    public static final String EMPTY_NODES = "//*[not(node()) and local-name(.) != 'FileLocation' and local-name(.) != 'HashValue' and local-name(.) != 'FileName']";
    public static final String OTHER_PERS = "//*[local-name(.)='ProjectRole' and local-name(../../.)='OtherPersonnel' and count(../NumberOfPersonnel)=0]";
    public static final String GLOB_HASH_VALUE = "glob:HashValue";
    public static final String GLOBAL_V1_0 = "http://apply.grants.gov/system/Global-V1.0";
    public static final String XMLNS_GLOB = "xmlns:glob";
    public static final String MESSAGE = "The pdf form does not contain any data.";
    public static final String UPLOADED_FILE_IS_EMPTY = "Uploaded file is empty";
    private static final String XFA_NS = "http://www.xfa.org/schema/xfa-data/1.0/";
    public static final String FILES = "files";
    private static Log LOG = LogFactory.getLog(ProposalSpecialReviewHumanSubjectsAttachmentServiceImpl.class);

    @Autowired
    @Qualifier("s2sUserAttachedFormService")
    private S2sUserAttachedFormService s2sUserAttachedFormService;


    public Map<String, Object> getSpecialReviewAttachmentXmlFileData(byte pdfFileContents[]) {
        String xml;
        Map<Object, Object> attachments;
        Map<String, Object> fileData = new HashMap<>();
        PdfReader reader = null;
        try {
            if (pdfFileContents == null || pdfFileContents.length == 0) {
                throw new S2SException(KeyConstants.S2S_USER_ATTACHED_FORM_EMPTY, UPLOADED_FILE_IS_EMPTY);
            } else {
                reader = new PdfReader(pdfFileContents);

                attachments = s2sUserAttachedFormService.extractAttachments(reader);
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
                    xml = processForm(form);
                    fileData.put(CONTENT, xml);
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException exception) {
            fileData = null;
            LOG.error("Cannot parse attachment." + exception.getMessage(), exception);
        }
        finally {
            if (reader != null) reader.close();
        }

        return fileData;
    }


    private String processForm(Element form) throws TransformerException {

        String formXML;
        Document doc = s2sUserAttachedFormService.node2Dom(form);
        s2sUserAttachedFormService.removeAllEmptyNodes(doc, EMPTY_NODES, 0);
        s2sUserAttachedFormService.removeAllEmptyNodes(doc, OTHER_PERS, 1);
        s2sUserAttachedFormService.removeAllEmptyNodes(doc, EMPTY_NODES, 0);
        NodeList hashValueNodes = doc.getElementsByTagName(GLOB_HASH_VALUE);
        for (int i = 0; i < hashValueNodes.getLength(); i++) {
            Node hashValue = hashValueNodes.item(i);
            ((Element) hashValue).setAttribute(XMLNS_GLOB, GLOBAL_V1_0);
        }
        s2sUserAttachedFormService.reorderXmlElements(doc);
        formXML = s2sUserAttachedFormService.docToString(doc);
        return formXML;
    }

}
