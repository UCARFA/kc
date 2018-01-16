/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.dd;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.kns.util.WebUtils;
import org.kuali.rice.kns.web.struts.action.KualiAction;
import org.kuali.rice.krad.bo.BusinessObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.List;

public class DataDictionaryFileAction extends KualiAction {

    private static final String ID = "id";
    private static final String CONTENT_TYPE_XML = "text/xml";

    public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        final DataDictionaryFileLookupableHelperServiceImpl lookupableHelperService = KcServiceLocator.getService("dataDictionaryFileLookupableHelperService");
        final List<? extends BusinessObject> results = lookupableHelperService.getSearchResults(Collections.singletonMap(ID, request.getParameter(ID)));

        if (!results.isEmpty()) {
            DataDictionaryFile file = (DataDictionaryFile) results.get(0);
            streamToResponse(file.getContent(), file.getName(), CONTENT_TYPE_XML, response);
        }

        return null;
    }

    protected void streamToResponse(byte[] fileContents, String fileName, String fileContentType, HttpServletResponse response) throws Exception {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(fileContents.length)) {
            baos.write(fileContents);
            WebUtils.saveMimeOutputStreamAsFile(response, fileContentType, baos, fileName);
        }
    }
}
