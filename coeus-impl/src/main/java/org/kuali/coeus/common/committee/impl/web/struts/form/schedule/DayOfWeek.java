/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.web.struts.form.schedule;

public enum DayOfWeek {
    
    Sunday("SUN"), Monday("MON"), Tuesday("TUE"), Wednesday("WED"), Thursday("THU"), Friday("FRI"), Saturday("SAT");
    
    private String abbr;

    DayOfWeek(String abbr) {
        this.abbr = abbr;
    }
    
    public String getAbbr() {
        return abbr;
    }
    
}
