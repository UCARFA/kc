/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.personfinancialentity;

import org.kuali.kra.coi.DisclosureReporterUnit;

/**
 * 
 * This class is FE reporter units.  KC only
 */
public class FinancialEntityReporterUnit extends DisclosureReporterUnit {

    private static final long serialVersionUID = -1254443328656115963L;

    private Long financialEntityReporterUnitsId;

    private Long financialEntityReporterId;

    private String unitNumber;

    private boolean leadUnitFlag;

    private String personId;

    //    @SkipVersioning  
    private FinancialEntityReporter financialEntityReporter;

    public FinancialEntityReporterUnit() {
        setLeadUnitFlag(false);
    }

    public Long getFinancialEntityReporterUnitsId() {
        return financialEntityReporterUnitsId;
    }

    public void setFinancialEntityReporterUnitsId(Long financialEntityReporterUnitsId) {
        this.financialEntityReporterUnitsId = financialEntityReporterUnitsId;
    }

    @Override
    public String getUnitNumber() {
        return unitNumber;
    }

    @Override
    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    @Override
    public boolean isLeadUnitFlag() {
        return leadUnitFlag;
    }

    @Override
    public void setLeadUnitFlag(boolean leadUnitFlag) {
        this.leadUnitFlag = leadUnitFlag;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Long getFinancialEntityReporterId() {
        return financialEntityReporterId;
    }

    public void setFinancialEntityReporterId(Long financialEntityReporterId) {
        this.financialEntityReporterId = financialEntityReporterId;
    }

    public FinancialEntityReporter getFinancialEntityReporter() {
        return financialEntityReporter;
    }

    public void setFinancialEntityReporter(FinancialEntityReporter financialEntityReporter) {
        this.financialEntityReporter = financialEntityReporter;
    }

    @Override
    public Long getReporterUnitId() {
        return getFinancialEntityReporterUnitsId();
    }
}
