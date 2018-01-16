/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s;

import com.lowagie.text.pdf.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xpath.XPathAPI;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

@Component("formUtilityService")
public class FormUtilityServiceImpl implements FormUtilityService {

    private static final Log LOG = LogFactory.getLog(FormUtilityServiceImpl.class);

    private static final String DUPLICATE_FILE_NAMES = "Attachments contain duplicate file names";

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Override
    public Map<String, byte[]> extractAttachments(PdfReader reader) throws IOException {
        Map<String, byte[]> fileMap = new HashMap<>();

        PdfDictionary catalog = reader.getCatalog();
        PdfDictionary names = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.NAMES));
        if (names != null) {
            PdfDictionary embFiles = (PdfDictionary) PdfReader.getPdfObject(names.get(new PdfName("EmbeddedFiles")));
            if (embFiles != null) {
                HashMap embMap = PdfNameTree.readTree(embFiles);

                for (Object o : embMap.values()) {
                    PdfDictionary filespec = (PdfDictionary) PdfReader.getPdfObject((PdfObject) o);
                    final Map.Entry<String, byte[]> fileInfo = unpackFile(filespec);
                    if (fileInfo != null) {
                        if (!fileMap.containsKey(fileInfo.getKey())) {
                            fileMap.put(fileInfo.getKey(), fileInfo.getValue());
                        }
                    }
                }
            }
        }
        for (int k = 1; k <= reader.getNumberOfPages(); ++k) {
            PdfArray annots = (PdfArray) PdfReader.getPdfObject(reader.getPageN(k).get(PdfName.ANNOTS));
            if (annots == null)
                continue;
            for (Iterator i = annots.listIterator(); i.hasNext(); ) {
                PdfDictionary annot = (PdfDictionary) PdfReader.getPdfObject((PdfObject) i.next());
                PdfName subType = (PdfName) PdfReader.getPdfObject(annot.get(PdfName.SUBTYPE));
                if (!PdfName.FILEATTACHMENT.equals(subType))
                    continue;
                PdfDictionary filespec = (PdfDictionary) PdfReader.getPdfObject(annot.get(PdfName.FS));
                final Map.Entry<String, byte[]> fileInfo = unpackFile(filespec);
                if (fileInfo != null) {
                    if (!fileMap.containsKey(fileInfo.getKey())) {
                        fileMap.put(fileInfo.getKey(), fileInfo.getValue());
                    } else {
                        throw new RuntimeException(DUPLICATE_FILE_NAMES);
                    }
                }
            }
        }

        return fileMap;
    }

    /**
     * Unpacks a file attachment.
     *
     * @param filespec The dictionary containing the file specifications
     */
    private Map.Entry<String, byte[]> unpackFile(PdfDictionary filespec) throws IOException {

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
        return new AbstractMap.SimpleImmutableEntry<>(fLast.getName(), attachmentByte);
    }

    @Override
    public Document node2Dom(org.w3c.dom.Node n) throws TransformerException {
        javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
        javax.xml.transform.Transformer xf = tf.newTransformer();
        javax.xml.transform.dom.DOMResult dr = new javax.xml.transform.dom.DOMResult();
        xf.transform(new javax.xml.transform.dom.DOMSource(n), dr);
        return (Document) dr.getNode();
    }

    @Override
    public void reorderXmlElements(Document doc) {
        Collection<UserAttachedFormsXMLReorder> userAttachedFormsXmlReorders = getBusinessObjectService().findAll(UserAttachedFormsXMLReorder.class);
        if (userAttachedFormsXmlReorders != null) {
            userAttachedFormsXmlReorders.forEach(userAttachedFormsXMLReorder -> {
                try {
                    reorderXmlElement(doc, userAttachedFormsXMLReorder.getNodeToMove(), userAttachedFormsXMLReorder.getTargetNode(), userAttachedFormsXMLReorder.isMoveAfter());
                } catch (Exception e) {
                    LOG.error("Could not move XML node " + userAttachedFormsXMLReorder.getNodeToMove() + "next to " + userAttachedFormsXMLReorder.getTargetNode(), e);
                }
            });
        }
    }

    protected void reorderXmlElement(Document doc, String original, String target, boolean insertAfter) {
        final NodeList originalNodes = doc.getElementsByTagName(original);
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
        NodeList emptyElements = XPathAPI.selectNodeList(document, xpath);
        for (int i = emptyElements.getLength() - 1; i > -1; i--) {
            Node nodeToBeRemoved = emptyElements.item(i);
            int hierLevel = parentLevel;
            while (hierLevel-- > 0) {
                nodeToBeRemoved = nodeToBeRemoved.getParentNode();
            }
            nodeToBeRemoved.getParentNode().removeChild(nodeToBeRemoved);
        }
        NodeList moreEmptyElements = XPathAPI.selectNodeList(document, xpath);
        if (moreEmptyElements.getLength() > 0) {
            removeAllEmptyNodes(document, xpath, parentLevel);
        }
    }

    /**
     * This method convert Document to a String
     *
     * @param node {Document} node entry.
     * @return String containing doc information
     */
    @Override
    public String docToString(Document node) throws TransformerException {
        DOMSource domSource = new DOMSource(node);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);
        return writer.toString();
    }

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
}
