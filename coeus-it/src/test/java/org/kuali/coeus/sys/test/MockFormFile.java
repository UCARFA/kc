/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.test;

import org.apache.struts.upload.FormFile;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class MockFormFile implements FormFile {

    private String contentType;
    private int fileSize;
    private String fileName;
    private byte[] fileData;

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public int getFileSize() {
        return fileSize;
    }

    @Override
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public byte[] getFileData() throws FileNotFoundException, IOException {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException, IOException {
        return new ByteArrayInputStream(fileData);
    }

    @Override
    public void destroy() {

    }
}
