/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.springframework.mock.web.MockMultipartFile;

public class MultipartFileValidationServiceImplTest {

    @Test(expected = IllegalArgumentException.class)
    public void test_validate_null_errorPath() {
        final MultipartFileValidationServiceImpl mp = new MultipartFileValidationServiceImpl();
        mp.validateMultipartFile(null, new MockMultipartFile("foo.txt", new byte[] {}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_validate_blank_errorPath() {
        final MultipartFileValidationServiceImpl mp = new MultipartFileValidationServiceImpl();
        mp.validateMultipartFile(" ", new MockMultipartFile("foo.txt", new byte[] {}));
    }

    @Test
    public void test_validate_null_file() {
        final MultipartFileValidationServiceImpl mp = new MultipartFileValidationServiceImpl();
        Assert.assertTrue(mp.validateMultipartFile("a_prop", null).containsMessageKey(KeyConstants.ERROR_ATTACHMENT_FILE_REQURIED));
    }

    @Test
    public void test_validate_valid_file_size() {
        final MultipartFileValidationServiceImpl mp = new MultipartFileValidationServiceImpl();
        mp.validateMultipartFile("a_prop", new MockMultipartFile("foo.txt", new byte[] {1, 2}));
    }

    @Test
    public void test_validate_invalid_file_size() {
        final MultipartFileValidationServiceImpl mp = new MultipartFileValidationServiceImpl();
        Assert.assertTrue(mp.validateMultipartFile("a_prop", new MockMultipartFile("foo.txt", new byte[] {}))
                .containsMessageKey(RiceKeyConstants.ERROR_UPLOADFILE_EMPTY));
    }
}
