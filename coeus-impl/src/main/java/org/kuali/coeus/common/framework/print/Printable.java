/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.print;

import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.framework.print.watermark.Watermarkable;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.springframework.core.io.Resource;

import javax.xml.transform.Source;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * This interface marks reports, notifications, BOs and Documents as printable
 * in Kuali-Coeus. KC Docs &amp; BOs that will be printed via KC printing services
 * should implement this interface.
 */
public interface Printable extends Serializable {

	Map<String, Resource> getPdfForms();
	Map<String, byte[]> fillPdfForms(Map<String, Resource> pdfForms, Map<String, XmlObject> xml);
	Map<String, byte[]> sortPdfForms(Map<String, byte[]> forms);
	/**
	 * 
	 * This method provides a way to get the XSL Transform(s) for the KC
	 * generated XML. This XSLT will create a transformed XML-FO stream that
	 * will be converted to PDF. Note that multiple transforms are possible on
	 * this data.
	 */
    List<Source> getXSLTemplates();

    Map<String,Source> getXSLTemplateWithBookmarks();
	/**
	 * 
	 * This method will provide the either reflected or XML-Bean based XML for
	 * input to the Transform into XML-FO.
	 */
	Map<String, XmlObject> renderXML() throws PrintingException;

	/**
	 * 
	 * This method will provide the document object associated with the
	 * printable
	 * 
	 * @return ResearchDocument
	 */
	KcPersistableBusinessObjectBase getPrintableBusinessObject();
	
	/**
	 * This method will return the PDF attachments specific to the printable.
	 * During printing the attachments will be added as bookmarks to the output.
	 * The Key in the map is used as the name of the bookmark.
	 * @return Map of Attachment pdf bytes with bookmark names.
	 */
	Map<String, byte[]> getAttachments();
	
	/**
	 * 
	 * This method returns whether to enable or disable watermark
	 *in the report.
	 * @return boolean Value
	 */
	boolean isWatermarkEnabled();
	/**
	 *  
	 * This method for setting the appropriate watermark
	 * with respect to the document.
	 * @return Watermarkable
	 */
	Watermarkable getWatermarkable();
}
