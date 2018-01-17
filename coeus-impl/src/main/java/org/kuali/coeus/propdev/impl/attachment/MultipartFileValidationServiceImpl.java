/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;


import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.krad.util.MessageMap;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("multipartFileValidationService")
public class MultipartFileValidationServiceImpl implements MultipartFileValidationService {

    @Override
    public MessageMap validateMultipartFile(String errorPath, MultipartFile file) {
        if (StringUtils.isBlank(errorPath)) {
            throw new IllegalArgumentException("errorPath cannot be blank");
        }

        final MessageMap messages = new MessageMap();
        if (file == null) {
            messages.putError(errorPath, KeyConstants.ERROR_ATTACHMENT_FILE_REQURIED);
        }else if (file.getSize() == 0) {
            messages.putError(errorPath, RiceKeyConstants.ERROR_UPLOADFILE_EMPTY, file.getOriginalFilename());
        }
        return messages;
    }
}
