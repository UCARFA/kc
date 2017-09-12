package org.kuali.coeus.common.framework.attachment;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public interface KcAttachmentDataDaoConversion {
    void executeInternal(JobExecutionContext context) throws JobExecutionException;
}
