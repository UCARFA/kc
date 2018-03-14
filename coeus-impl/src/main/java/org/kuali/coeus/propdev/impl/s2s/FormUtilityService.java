/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s;

import com.lowagie.text.pdf.PdfReader;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Map;

public interface FormUtilityService {
    Map<String, byte[]> extractAttachments(PdfReader reader) throws IOException;

    Document node2Dom(Node n) throws TransformerException;

    String docToString(Document node) throws TransformerException;

    void reorderXmlElements(Document doc);

    void removeAllEmptyNodes(Document document, String xpath, int parentLevel) throws XPathExpressionException;

    void correctAttachmentNameHrefHash(Document document, Map<String, String> attachmentHashes);
}
