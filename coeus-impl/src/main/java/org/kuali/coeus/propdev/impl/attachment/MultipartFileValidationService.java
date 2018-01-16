/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;

import org.kuali.rice.krad.util.MessageMap;
import org.springframework.web.multipart.MultipartFile;

public interface MultipartFileValidationService {

    /**
     * Validates a MultipartFile and returns error messages.
     * @param errorPath the error path.  cannot be blank
     * @param file the multipart file. cannot be null.
     * @return empty MessageMap if valid
     * @throws IllegalArgumentException if the errorPath is blank or the file is null.
     */
    MessageMap validateMultipartFile(String errorPath, MultipartFile file);
}
