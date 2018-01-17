/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.service.ResearchAreasService;
import org.kuali.kra.service.ResearchAreasServiceBase;
import org.kuali.kra.web.struts.action.ResearchAreasActionBase;

public class ResearchAreasAction extends ResearchAreasActionBase {

    @Override
    protected ResearchAreasServiceBase getResearchAreasService() {
        return KcServiceLocator.getService(ResearchAreasService.class);
    }

    @Override
    protected String getResearchAreasTask() {
        return TaskName.MAINTAIN_RESEARCH_AREAS;
    }
}
