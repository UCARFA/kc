/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.print;

/**
 * 
 * This class identifies the template print functionality for committee schedule reports.
 */
public abstract class ScheduleTemplatePrintBase extends TemplatePrintBase {
    
    
    private static final long serialVersionUID = -1565960151556324475L;
    public static final String REPORT_PARAMETER_KEY = "protoCorrespTypeCode";

    @Override
    public String getProtoCorrespTypeCode() {
        return  (String) getReportParameters().get(REPORT_PARAMETER_KEY);
    }
   
   
}
