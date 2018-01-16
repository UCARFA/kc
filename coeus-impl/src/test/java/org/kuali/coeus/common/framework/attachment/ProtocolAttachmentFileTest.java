/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.attachment;

import org.apache.struts.upload.FormFile;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.framework.attachment.AttachmentFile;
import org.kuali.coeus.common.framework.attachment.AttachmentFile.CreateException;
import java.io.IOException;

import static org.hamcrest.core.Is.is;

/**
 * Tests for {@link AttachmentFile ProtocolAttachmentFile}.
 */
public class ProtocolAttachmentFileTest {

    private static final String FILE_DATA_ID = "123";
	Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};
    
    /**
     * Tests that factory method properly handles a null form file.
     */
    @Test(expected=IllegalArgumentException.class)
    public void createFromFormFileNullFormFile() {
        AttachmentFile.createFromFormFile(null);
    }
    
    /**
     * Test that confirms proper handling of long file names.
     * @throws Exception if bad happens.
     */
    @Test
    public void createFromFormFileLongName() throws Exception {
        final String fileName = "fileNamethrows Exceptionthrows Exceptionthrows Exceptionthrows Exceptionthrows Exceptionthrows Exceptionthrows Exceptionthrows Exceptionthrows Exceptionthrows Exception";
        
        String newFileName = AttachmentFile.removeFrontForLength(fileName, AttachmentFile.MAX_FILE_NAME_LENGTH);

        
        Assert.assertThat(newFileName, is(fileName.substring(fileName.length() - AttachmentFile.MAX_FILE_NAME_LENGTH)));
    }

    /**
     * Tests that IOExceptions are properly handled by wrapping in a CreateException.
     * @throws Exception if bad happens.
     */
    @Test(expected=CreateException.class)
    public void testCreateException() throws Exception {
        final FormFile formFile = this.context.mock(FormFile.class);
        final String fileName = "fileName";
        final String fileType = "fileType";
        
        this.context.checking(new Expectations() {{
            one(formFile).getFileName();
            will(returnValue(fileName));
            
            one(formFile).getContentType();
            will(returnValue(fileType));
            
            one(formFile).getFileData();
            will(throwException(new IOException()));
        }});
        
        AttachmentFile.createFromFormFile(formFile);
        this.context.assertIsSatisfied();
    }
    
    /**
     * 
     * Creates a form file setting jmock expectations.
     * @param fileName the fileName
     * @param type the type
     * @param data the data
     * @return the form file.
     * @throws IOException if unable to access file data
     */
    private FormFile createMockFormFileWithExpectations(final String fileName, final String type, final byte[] data) throws IOException {
        final FormFile formFile = this.context.mock(FormFile.class);
        
        this.context.checking(new Expectations() {{
            one(formFile).getFileName();
            will(returnValue(fileName));
            
            one(formFile).getContentType();
            will(returnValue(type));
            
            one(formFile).getFileData();
            will(returnValue(data));
        }});
        
        return formFile;
    }
}
