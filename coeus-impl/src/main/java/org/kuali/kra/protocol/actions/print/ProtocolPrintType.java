/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.print;

import java.util.ArrayList;
import java.util.List;


public enum ProtocolPrintType {
    
    PROTOCOL_SUMMARY_VIEW_REPORT("Summary View Report"), 
    PROTOCOL_FULL_PROTOCOL_REPORT("Full ProtocolBase Report"),
    PROTOCOL_PROTOCOL_HISTORY_REPORT("ProtocolBase History Report"), 
    PROTOCOL_REVIEW_COMMENTS_REPORT("Review Comments Report");

    private String protocolPrintType;

    
    ProtocolPrintType(String protocolPrintType) {
        
    }
    
    public String getProtocolPrintType() {
        return protocolPrintType;
    }

    public static List<String>  getReportTypes() {
        List<String> reportTypes = new ArrayList<String>();
        for (ProtocolPrintType printType : values()) {
            reportTypes.add(printType.getProtocolPrintType());
        }
        return reportTypes;
        
    }

}
