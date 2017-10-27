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

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.lowagie.text.pdf.PdfReader;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.s2sgen.api.core.S2SException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.TransformerException;

public interface S2sUserAttachedFormService {
    List<S2sUserAttachedForm> extractNSaveUserAttachedForms(ProposalDevelopmentDocument developmentProposal, S2sUserAttachedForm s2sUserAttachedForm) throws Exception;

    Map<Object, Object> extractAttachments(PdfReader reader)throws IOException;

    Document node2Dom(org.w3c.dom.Node n) throws TransformerException;

    void reorderXmlElements(Document doc);

    void removeAllEmptyNodes(Document document, String xpath, int parentLevel) throws TransformerException;

    String docToString(Document node) throws S2SException;

    void resetFormAvailability(ProposalDevelopmentDocument developmentProposal, String namespace);

    }
