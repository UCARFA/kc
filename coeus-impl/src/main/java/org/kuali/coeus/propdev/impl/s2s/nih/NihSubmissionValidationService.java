/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s.nih;

import gov.nih.era.svs.types.*;
import org.kuali.coeus.s2sgen.api.generate.AttachmentData;

import java.util.List;

public interface NihSubmissionValidationService {

    /**
     * Validates form with Nih.  This service is intentionally resilient in regards to input parameters. All parameters
     * are allowed to be null or blank and this service will degrade accordingly.
     *
     * @param xmlText the xml that the s2s generators created.
     * @param attachments any attachments in the s2s submission
     * @param dunsNumber an optional duns number
     * @return a validation response.  In the case that this service is not enabled or a blank xmlText is passed in an
     * empty response will be returned
     */
    ValidateApplicationResponse validateApplication(String xmlText, List<AttachmentData> attachments, String dunsNumber);
}
