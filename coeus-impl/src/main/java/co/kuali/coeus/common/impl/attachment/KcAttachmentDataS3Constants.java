/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package co.kuali.coeus.common.impl.attachment;


public class KcAttachmentDataS3Constants {

    static final String S3_INTEGRATION_ENABLED = "S3_INTEGRATION_ENABLED";
    static final String S3_DUAL_SAVE_ENABLED = "S3_DUAL_SAVE_ENABLED";
    static final String S3_DUAL_RETRIEVE_ENABLED = "S3_DUAL_RETRIEVE_ENABLED";

    static final String RETRIEVE_FILE_METHOD = "retrieveFile";
    static final String GET_FILE_CONTENTS_METHOD = "getFileContents";
    static final String S3_FILE_CLASS = "co.kuali.coeus.s3.api.S3File";
    static final String SET_ID_METHOD = "setId";
    static final String SET_FILE_CONTENTS_METHOD = "setFileContents";
    static final String CREATE_FILE_METHOD = "createFile";
    static final String GET_FILE_META_DATA_METHOD = "getFileMetaData";
    static final String DELETE_FILE_METHOD = "deleteFile";

    private KcAttachmentDataS3Constants() {
        throw new UnsupportedOperationException("do not call");
    }
}
