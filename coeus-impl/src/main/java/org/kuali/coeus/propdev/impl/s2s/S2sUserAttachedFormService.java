/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s;

import java.io.IOException;
import java.util.List;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

public interface S2sUserAttachedFormService {
    List<S2sUserAttachedForm> extractNSaveUserAttachedForms(ProposalDevelopmentDocument developmentProposal, S2sUserAttachedForm s2sUserAttachedForm) throws TransformerException, IOException, SAXException, ParserConfigurationException, XPathExpressionException;
    void resetFormAvailability(ProposalDevelopmentDocument developmentProposal, String namespace);
}
