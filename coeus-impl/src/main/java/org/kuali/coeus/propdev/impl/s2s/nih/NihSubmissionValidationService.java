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
