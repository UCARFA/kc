/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.person.citi;

import org.apache.commons.collections4.MapUtils;
import org.kuali.coeus.common.framework.person.citi.PersonTrainingCitiCourse;
import org.kuali.coeus.common.framework.person.citi.PersonTrainingCitiRecord;
import org.kuali.rice.kns.inquiry.KualiInquirableImpl;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;


public class PersonTrainingCitiCourseInquirableImpl extends KualiInquirableImpl {

    @Override
    public BusinessObject getBusinessObject(@SuppressWarnings("unchecked") Map fieldValues) {
        if (MapUtils.isEmpty(fieldValues)) {
            return null;
        }

        final Collection<PersonTrainingCitiRecord> records = getLookupService().findCollectionBySearchHelper(PersonTrainingCitiRecord.class, fieldValues, true);
        final Optional<PersonTrainingCitiRecord> record = records.stream().findFirst();
        if (record.isPresent()) {
            final PersonTrainingCitiRecord firstRecord = record.get();
            return new PersonTrainingCitiCourse(firstRecord.getGroupId(), firstRecord.getGroup(),
                    firstRecord.getStageNumber(), firstRecord.getStage());
        }
        return null;
    }

}
