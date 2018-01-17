/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.personnel;

import org.kuali.coeus.common.budget.framework.personnel.JobCode;
import org.kuali.coeus.common.budget.framework.personnel.JobCodeService;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("jobCodeService")
public class JobCodeServiceImpl implements JobCodeService {

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;    

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    /**
     * 
     * This method provides the appropriate JobCode object
     * for a particular jobCode string.
     * 
     */
    @Override
    public JobCode findJobCodeRef(String jobCode) {
        return getDataObjectService().find(JobCode.class, jobCode);
    }

    @Override
    public String findJobCodeTitle(String jobCode) {
        String jobTitle = null;
        JobCode jcRef= findJobCodeRef(jobCode);
        if (jcRef!= null) {
            jobTitle = jcRef.getJobTitle();
        }
        return jobTitle;
    }
    

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

	public DataObjectService getDataObjectService() {
		return dataObjectService;
	}

	public void setDataObjectService(DataObjectService dataObjectService) {
		this.dataObjectService = dataObjectService;
	}

}
