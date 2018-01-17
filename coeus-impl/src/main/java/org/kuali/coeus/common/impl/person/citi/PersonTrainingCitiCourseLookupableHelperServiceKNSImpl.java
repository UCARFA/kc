/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.person.citi;

import org.kuali.coeus.common.framework.person.citi.PersonTrainingCitiCourse;
import org.kuali.coeus.common.framework.person.citi.PersonTrainingCitiRecord;
import org.kuali.coeus.sys.framework.util.CollectionUtils;
import org.kuali.rice.kns.lookup.KualiLookupableHelperServiceImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("personTrainingCitiCourseLookupableHelperServiceKNS")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class PersonTrainingCitiCourseLookupableHelperServiceKNSImpl extends KualiLookupableHelperServiceImpl {

    @Override
    public List<PersonTrainingCitiCourse> getSearchResults(Map<String, String> fieldValues) {
        this.businessObjectClass = PersonTrainingCitiRecord.class;
        @SuppressWarnings("unchecked")
        final List<PersonTrainingCitiRecord> results = (List<PersonTrainingCitiRecord>) super.getSearchResults(fieldValues);
        this.businessObjectClass = PersonTrainingCitiCourse.class;
        return results.stream()
                .map(rec ->  new PersonTrainingCitiCourse(rec.getGroupId(), rec.getGroup(),
                rec.getStageNumber(), rec.getStage()))
                .filter(CollectionUtils.distinctByKey(PersonTrainingCitiCourse::getTitle))
                .collect(Collectors.toList());
    }
}
