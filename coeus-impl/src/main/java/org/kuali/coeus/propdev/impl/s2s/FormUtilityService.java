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

import com.lowagie.text.pdf.PdfReader;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Map;

public interface FormUtilityService {
    Map<String, byte[]> extractAttachments(PdfReader reader) throws IOException;

    Document node2Dom(Node n) throws TransformerException;

    String docToString(Document node) throws TransformerException;

    void reorderXmlElements(Document doc);

    void removeAllEmptyNodes(Document document, String xpath, int parentLevel) throws TransformerException;
}
