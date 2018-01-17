/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.subcontracting.reporting.dao;

import org.kuali.kra.award.subcontracting.reporting.SubcontractingExpenditureCategoryDetails;

import java.sql.Date;
import java.util.List;

public interface SubcontractingExpenditureCategoryDetailsDao {
    
    public List<SubcontractingExpenditureCategoryDetails> findCategoryDetailsByFiscalPeriodRange(Date startDate, Date endDate);

}
