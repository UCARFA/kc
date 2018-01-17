/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.print;

import java.util.List;

/**
 * 
 * This class provides the API for KC Printing. It will take any KC
 * <code>Printable</code> and return the printable PDF form of that Printable
 * in an OutputStream which can be decorated how the implementing print consumer
 * requires.
 * 
 */
public interface PrintingService {

	/**
	 * 
	 * This method invokes the KC printable architecture for reports,
	 * notifications, docs and bos. It will take raw KC XML from bo/docs and
	 * perform the XSLT to generate XML-FO, and will render the Printable XML-FO
	 * as a PDF OutputStream.
	 */
	AttachmentDataSource print(Printable printableArtifact)
			throws PrintingException;

	/**
	 * 
	 * This method invokes the KC printable architecture for reports,
	 * notifications, docs and bos. It will take raw KC XML from bo/docs and
	 * perform the XSLT to generate XML-FO, and will render the {@link List} of
	 * Printable XML-FO as a PDF OutputStream.
	 */
	AttachmentDataSource print(List<Printable> printableArtifactList)
			throws PrintingException;
}
