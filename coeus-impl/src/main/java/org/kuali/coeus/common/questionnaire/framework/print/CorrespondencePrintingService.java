/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.framework.print;

import org.kuali.coeus.common.framework.print.Printable;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.protocol.actions.print.CorrespondencePrintOption;

import java.util.List;

public interface CorrespondencePrintingService {
    /**
     * 
     * Provides a hook to fetch correspondences' {@code Printable}s.
     * @param printableBusinessObject
     * @param correspondenceToPrint List of selected Correspondences to print, in the form of {@code CorrespondencePrintOption}s
     * @return List of printable correspondences.
     */
    public List<Printable> getCorrespondencePrintable(KcPersistableBusinessObjectBase printableBusinessObject,
            List<CorrespondencePrintOption> correspondenceToPrint);
}
