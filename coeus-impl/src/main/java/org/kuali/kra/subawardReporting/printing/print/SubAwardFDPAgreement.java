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
package org.kuali.kra.subawardReporting.printing.print;

import java.io.ByteArrayInputStream;
import java.util.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;


import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.sys.framework.util.CollectionUtils;
import org.kuali.kra.subaward.bo.SubAwardForms;
import org.kuali.kra.subaward.reporting.printing.service.SubAwardPrintingService;
import org.springframework.core.io.Resource;


public class SubAwardFDPAgreement extends AbstractPrint {

    private Map<String, Resource> pdfForms;

    @Override
    public Map<String,Source> getXSLTemplateWithBookmarks() {
        return getSelectedTemplates().stream()
                .map(s -> CollectionUtils.<String, Source>entry(s.getFormId(), new StreamSource(new ByteArrayInputStream(s.getAttachmentContent()))))
                .collect(CollectionUtils.entriesToMap());
    }

    private Collection<SubAwardForms> getSelectedTemplates() {
        return (Collection<SubAwardForms> ) getReportParameters().get(SubAwardPrintingService.SELECTED_TEMPLATES);
    }

    @Override
    public Map<String, Resource> getPdfForms() {
        return pdfForms;
    }

    public void setPdfForms(Map<String, Resource> pdfForms) {
        this.pdfForms = pdfForms;
    }

    @Override
    public Map<String, byte[]> fillPdfForms(Map<String, Resource> pdfForms, Map<String, XmlObject> xml) {
        return Collections.emptyMap();
    }

    @Override
    public Map<String, byte[]> sortPdfForms(Map<String, byte[]> forms) {
        return forms;
    }
}
