/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.print.stream.xml;

import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import java.util.Map;

/**
 * This class is used for generating XML stream for report generation of any
 * document.
 * 
 */
public interface XmlStream {

	/**
	 * This method generates XML for a given {@link org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase} based
	 * on the parameters provided in a {@link Map} and returns an
	 * {@link XmlObject} of the generated XML.
	 * 
	 * @param printableBusinessObject
	 *            for which XMl is to be generated
	 * @param reportParameters
	 *            {@link Map} of various parameters required for XML generation
	 * @return Map consisting of XML Objects mapped to bookmarks
	 * @throws PrintingException
	 *             in case of any errors occur during report generation
	 */
	Map<String, XmlObject> generateXmlStream(
			KcPersistableBusinessObjectBase printableBusinessObject, Map<String, Object> reportParameters);
}
