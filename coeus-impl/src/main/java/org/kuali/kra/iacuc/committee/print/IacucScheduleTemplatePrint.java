/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.print;

import org.kuali.coeus.common.committee.impl.print.ScheduleTemplatePrintBase;
import org.kuali.kra.iacuc.correspondence.IacucProtocolCorrespondenceTemplateService;

public class IacucScheduleTemplatePrint extends ScheduleTemplatePrintBase {


    private static final long serialVersionUID = -9175459734372306511L;
    
    public void setIacucProtocolCorrespondenceTemplateService(IacucProtocolCorrespondenceTemplateService iacucProtocolCorrespondenceTemplateService) {
        this.setProtocolCorrespondenceTemplateService(iacucProtocolCorrespondenceTemplateService);
    }

}
