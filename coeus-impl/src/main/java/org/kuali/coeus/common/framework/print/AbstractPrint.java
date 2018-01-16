/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.print;


import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.framework.print.stream.xml.XmlStream;
import org.kuali.coeus.common.framework.print.watermark.Watermarkable;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.springframework.core.io.Resource;

import javax.xml.transform.Source;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * This class provides all the objects required for printing reports. It
 * provides methods for fetching XML generator {@link XmlStream},{@link org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase},
 * {@link Map} of parameters required for printing.
 * 
 */
public abstract class AbstractPrint implements Printable {

	private XmlStream xmlStream;
	private KcPersistableBusinessObjectBase printableBusinessObject;
	 // reportParameters used to pass parameters to CommitteeTemplatePrint.java
	private Map<String, Object> reportParameters;
	private Map<String, byte[]> attachments;
	

	public XmlStream getXmlStream() {
		return xmlStream;
	}

	public void setXmlStream(XmlStream xmlStream) {
		this.xmlStream = xmlStream;
	}

    @Override
    public KcPersistableBusinessObjectBase getPrintableBusinessObject() {
        return printableBusinessObject;
    }

	public void setPrintableBusinessObject(KcPersistableBusinessObjectBase printableBusinessObject) {
		this.printableBusinessObject = printableBusinessObject;
	}

	public Map<String, Object> getReportParameters() {
		return reportParameters;
	}

	public void setReportParameters(Map<String, Object> reportParameters) {
		this.reportParameters = reportParameters;
	}
	@Override
	public Map<String, byte[]> getAttachments() {
		return attachments;
	}

	public void setAttachments(Map<String, byte[]> attachments) {
		this.attachments = attachments;
	}

	@Override
	public Map<String, XmlObject> renderXML() throws PrintingException {
		return getXmlStream().generateXmlStream(
				getPrintableBusinessObject(), getReportParameters());
	}

	@Override
    public Map<String,Source> getXSLTemplateWithBookmarks(){
        return null;
    }
	@Override
    public List<Source> getXSLTemplates(){
        return null;
    }

    @Override
    public Map<String, Resource> getPdfForms() {
    	return Collections.emptyMap();
	}

	@Override
	public Map<String, byte[]> fillPdfForms(Map<String, Resource> pdfForms, Map<String, XmlObject> xml) {
		return Collections.emptyMap();
	}

	@Override
	public Map<String, byte[]> sortPdfForms(Map<String, byte[]> forms) {
		return forms;
	}

	@Override
    public boolean isWatermarkEnabled(){
        return false;
    }

	@Override
    public Watermarkable getWatermarkable(){
        if(isWatermarkEnabled()){
            throw new RuntimeException("Watermarkable not implemented");
        }else{
            return null;
        }
    }

}
