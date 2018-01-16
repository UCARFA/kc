/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.web.struts.form.schedule;

public enum WeekOfMonth {
    
    first("FIRST"), second("SECOND"), third("THIRD"), fourth("FOURTH"), last("LAST");
    
    private String number;
    
    WeekOfMonth(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
    
}
