/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package co.kuali.coeus.common.impl.attachment;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public interface KcAttachmentDataToS3Conversion {
    public void executeInternal(JobExecutionContext context) throws JobExecutionException;
}
