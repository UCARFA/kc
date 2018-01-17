/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.web.struts.form.schedule;

public enum Months {
    
    JANUARY("JAN"), FEBRUARY("FEB"), MARCH("MAR"), APRIL("APR"), MAY("MAY"), JUNE("JUN"), JULY("JUL"), AUGUST("AUG"), SEPTEMBER("SEP"), OCTOBER("OCT"), NOVEMBER("NOV"), DECEMBER("DEC");
    
    private String abbr;

    Months(String abbr) {
        this.abbr = abbr;
    }
    
    public String getAbbr() {
        return abbr;
    }
        
}
