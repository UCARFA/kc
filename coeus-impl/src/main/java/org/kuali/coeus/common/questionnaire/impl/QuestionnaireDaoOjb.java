/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.questionnaire.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.QueryByCriteria;
import org.apache.ojb.broker.query.QueryFactory;
import org.apache.ojb.broker.query.ReportQueryByCriteria;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;
import org.kuali.coeus.common.questionnaire.framework.core.Questionnaire;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireConstants;
import org.kuali.rice.core.framework.persistence.ojb.dao.PlatformAwareDaoBaseOjb;

public class QuestionnaireDaoOjb extends PlatformAwareDaoBaseOjb implements QuestionnaireDao {

    @Override
    public Integer getCurrentQuestionnaireSequenceNumber(String questionnaireSeqId) {
        final Criteria criteria = new Criteria();
        criteria.addEqualTo(QuestionnaireConstants.QUESTIONNAIRE_SEQUENCE_ID_PARAMETER_NAME, questionnaireSeqId);
        final String[] columns = {"max(" + QuestionnaireConstants.QUESTIONNAIRE_SEQUENCE_NUMBER_PARAMETER_NAME + ")"};
        final ReportQueryByCriteria query = QueryFactory.newReportQuery(Questionnaire.class, columns, criteria, false);
        final Iterator iter = getPersistenceBrokerTemplate().getReportQueryIteratorByQuery(query);
        final Integer sequenceNumber = iter.hasNext() ? ((BigDecimal) ((Object[]) iter.next())[0]).intValue() : null;
        while (iter.hasNext()) {
            iter.next(); // exhaust the iterator so the db resources will be closed.  See org.apache.ojb.broker.accesslayer.OJBIterator
        }

        return sequenceNumber;
    }

    @Override
    public List<AnswerHeader> getQuestionnaireAnswers(String moduleCode, String moduleItemKey, String moduleSubItemKey) {
        String certificationModuleItemKey = moduleItemKey + "|%";
        Criteria certificationCriteria = new Criteria();
        certificationCriteria.addEqualTo(QuestionnaireConstants.MODULE_ITEM_CODE, moduleCode);
        certificationCriteria.addEqualTo(QuestionnaireConstants.MODULE_SUB_ITEM_KEY, moduleSubItemKey);
        certificationCriteria.addLike(QuestionnaireConstants.MODULE_ITEM_KEY, certificationModuleItemKey);

        Criteria otherQuestionnaireCriteria = new Criteria();
        otherQuestionnaireCriteria.addEqualTo(QuestionnaireConstants.MODULE_ITEM_CODE, moduleCode);
        otherQuestionnaireCriteria.addEqualTo(QuestionnaireConstants.MODULE_SUB_ITEM_KEY, moduleSubItemKey);
        otherQuestionnaireCriteria.addEqualTo(QuestionnaireConstants.MODULE_ITEM_KEY, moduleItemKey);

        certificationCriteria.addOrCriteria(otherQuestionnaireCriteria);

        QueryByCriteria query = QueryFactory.newQuery(AnswerHeader.class, certificationCriteria);

        return (List<AnswerHeader>) getPersistenceBrokerTemplate().getCollectionByQuery(query);
    }

}
