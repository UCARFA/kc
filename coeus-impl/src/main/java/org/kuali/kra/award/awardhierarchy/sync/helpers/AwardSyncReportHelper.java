/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.helpers;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncChange;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncType;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.paymentreports.awardreports.AwardReportTerm;
import org.kuali.rice.krad.bo.PersistableBusinessObject;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * Award Hierarchy Sync Helper for Reports.
 */
public class AwardSyncReportHelper extends AwardSyncHelperBase {
    
    @SuppressWarnings("unchecked")
    @Override
    public void applySyncChange(Award award, AwardSyncChange change) 
        throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, 
        ClassNotFoundException, NoSuchMethodException, InstantiationException {
        Collection reports = award.getAwardReportTermItems();
        AwardReportTerm report = (AwardReportTerm) getAwardSyncUtilityService().findMatchingBo(reports, change.getXmlExport().getKeys());
        if (StringUtils.equals(change.getSyncType(), AwardSyncType.ADD_SYNC.getSyncValue())) {
            if (report != null) {
                this.setValuesOnSyncable(report, change.getXmlExport().getValues(), change);
            } else {
                report = new AwardReportTerm();
                setValuesOnSyncable(report, change.getXmlExport().getKeys(), change);
                setValuesOnSyncable(report, change.getXmlExport().getValues(), change);
                award.add(report);
            }
        } else {
            if (report != null) {
                reports.remove(report);
            }
        }
    }
    
    @Override
    protected String getObjectDesc(PersistableBusinessObject syncableObject, String attrName) {
        return "Report";
    }
    
    @Override
    protected String getDataDesc(PersistableBusinessObject syncableObject, String attrName) {
        AwardReportTerm term = (AwardReportTerm) syncableObject;
        String result = term.getReportClass().getDescription()+ DELIMITER
            + term.getReport().getDescription();
        if (term.getFrequency() != null) {
            result += DELIMITER + term.getFrequency().getDescription();
        }
        if (term.getFrequencyBase() != null) {
            result += DELIMITER + term.getFrequencyBase().getDescription();
        }
        if (term.getDistribution() != null) {
            result += DELIMITER + term.getDistribution().getDescription();
        }
        return result;
    }     
}
