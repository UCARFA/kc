/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller;

import org.kuali.coeus.sys.api.model.KcFile;
import org.kuali.rice.krad.util.KRADUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public final class ControllerFileUtils {

    private ControllerFileUtils() {
        throw new UnsupportedOperationException("do not call");
    }

    public final static void streamToResponse(KcFile attachmentDataSource, HttpServletResponse response) throws Exception {
        streamToResponse(attachmentDataSource.getData(),attachmentDataSource.getName(),attachmentDataSource.getType(),response);
    }

    public final static void streamToResponse(byte[] fileContents, String fileName, String fileContentType, HttpServletResponse response) throws Exception {
        long size = fileContents.length;
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(fileContents)) {
            KRADUtils.addAttachmentToResponse(response, inputStream, fileContentType, fileName, size);
            response.flushBuffer();
        }
    }

    public static void streamOutputToResponse(HttpServletResponse response, ByteArrayOutputStream stream,
                                               String contentType, String fileName, long fileSize) throws IOException {

        // If there are quotes in the name, we should replace them to avoid issues.
        // The filename will be wrapped with quotes below when it is set in the header
        String updateFileName;
        if (fileName.contains("\"")) {
            updateFileName = fileName.replaceAll("\"", "");
        } else {
            updateFileName = fileName;
        }

        // set response
        response.setContentType(contentType);
        response.setContentLength(org.springframework.util.NumberUtils.convertNumberToTargetClass(fileSize,
                Integer.class));
        response.setHeader("Content-disposition", "attachment; filename=\"" + updateFileName + "\"");
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");

        // Copy the input stream to the response
        if (stream != null) {
            stream.writeTo(response.getOutputStream());
        }
    }
}
