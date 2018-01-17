/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.coi.framework;

import javax.validation.constraints.Pattern;

public class DisclosureProjectStatus {
    @Pattern(regexp = "[a-zA-Z0-9]+")
    String userId;
    @Pattern(regexp = "[a-zA-Z ]+")
    String status;
    @Pattern(regexp = "[a-zA-Z ]+")
    String disposition;
    @Pattern(regexp = "[a-zA-Z ]+")
    String annualDisclosureStatus;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getAnnualDisclosureStatus() {
        return annualDisclosureStatus;
    }

    public void setAnnualDisclosureStatus(String annualDisclosureStatus) {
        this.annualDisclosureStatus = annualDisclosureStatus;
    }
}
