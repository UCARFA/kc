--
-- Kuali Coeus, a comprehensive research administration system for higher education.
--
-- Copyright 2005-2017 Kuali, Inc.
--
-- This program is free software: you can redistribute it and/or modify
-- it under the terms of the GNU Affero General Public License as
-- published by the Free Software Foundation, either version 3 of the
-- License, or (at your option) any later version.
--
-- This program is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
-- GNU Affero General Public License for more details.
--
-- You should have received a copy of the GNU Affero General Public License
-- along with this program.  If not, see <http://www.gnu.org/licenses/>.
--

INSERT INTO questionnaire (QUESTIONNAIRE_REF_ID, QUESTIONNAIRE_ID, SEQUENCE_NUMBER, NAME, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, IS_FINAL, DOCUMENT_NUMBER, VER_NBR, OBJ_ID, file_name, template)
VALUES (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, -5, 1, 'Clinical Trials Decision Tree', 'Relates to clinical trials.', SYSDATE, 'admin', 'Y', NULL, 1,
                                          SYS_GUID(), NULL, NULL);

INSERT INTO QUESTION (QUESTION_REF_ID, QUESTION_ID, SEQUENCE_NUMBER, SEQUENCE_STATUS, QUESTION, STATUS, GROUP_TYPE_CODE, QUESTION_TYPE_ID, LOOKUP_CLASS, LOOKUP_RETURN, DISPLAYED_ANSWERS, MAX_ANSWERS, ANSWER_MAX_LENGTH, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID, DOCUMENT_NUMBER)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, -10131, 1, 'C', 'Are participants assigned to an intervention?', 'I', 4, 1, NULL, NULL, NULL, 1, 1, SYSDATE,
   'admin', 1, SYS_GUID(), NULL);

INSERT INTO QUESTIONNAIRE_QUESTIONS (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, QUESTION_SEQ_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_USER, UPDATE_TIMESTAMP, OBJ_ID, VER_NBR)
VALUES (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                           FROM QUESTIONNAIRE
                                           WHERE QUESTIONNAIRE_ID = '-5' AND SEQUENCE_NUMBER = 1), (SELECT max(QUESTION_REF_ID)
                                                                                                    FROM QUESTION
                                                                                                    WHERE
                                                                                                      QUESTION_ID = '-10131' AND SEQUENCE_NUMBER = 1),
                                          1, 0, 1, 'N', NULL, NULL, 'admin', SYSDATE, SYS_GUID(), 1);


INSERT INTO QUESTION (QUESTION_REF_ID, QUESTION_ID, SEQUENCE_NUMBER, SEQUENCE_STATUS, QUESTION, STATUS, GROUP_TYPE_CODE, QUESTION_TYPE_ID, LOOKUP_CLASS, LOOKUP_RETURN, DISPLAYED_ANSWERS, MAX_ANSWERS, ANSWER_MAX_LENGTH, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID, DOCUMENT_NUMBER)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, -10132, 1, 'C', 'Is the study designed to evaluate the effect of the intervention on the participants?', 'I', 4,
                                     1, NULL, NULL, NULL, 1, 1, SYSDATE, 'admin', 1, SYS_GUID(), NULL);

INSERT INTO QUESTIONNAIRE_QUESTIONS (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, QUESTION_SEQ_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_USER, UPDATE_TIMESTAMP, OBJ_ID, VER_NBR)
VALUES (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                           FROM QUESTIONNAIRE
                                           WHERE QUESTIONNAIRE_ID = '-5' AND SEQUENCE_NUMBER = 1), (SELECT max(QUESTION_REF_ID)
                                                                                                    FROM QUESTION
                                                                                                    WHERE
                                                                                                      QUESTION_ID = '-10132' AND SEQUENCE_NUMBER = 1),
                                          2, 1, 1, 'Y', '4', 'Y', 'admin', SYSDATE, SYS_GUID(), 1);


INSERT INTO QUESTION (QUESTION_REF_ID, QUESTION_ID, SEQUENCE_NUMBER, SEQUENCE_STATUS, QUESTION, STATUS, GROUP_TYPE_CODE, QUESTION_TYPE_ID, LOOKUP_CLASS, LOOKUP_RETURN, DISPLAYED_ANSWERS, MAX_ANSWERS, ANSWER_MAX_LENGTH, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID, DOCUMENT_NUMBER)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, -10133, 1, 'C', 'Is the effect being evaluated on health-related biomedical or behavioral outcome?', 'I', 4, 1,
                                     NULL, NULL, NULL, 1, 1, SYSDATE, 'admin', 1, SYS_GUID(), NULL);

INSERT INTO QUESTIONNAIRE_QUESTIONS (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, QUESTION_SEQ_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_USER, UPDATE_TIMESTAMP, OBJ_ID, VER_NBR)
VALUES (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                           FROM QUESTIONNAIRE
                                           WHERE QUESTIONNAIRE_ID = '-5' AND SEQUENCE_NUMBER = 1), (SELECT max(QUESTION_REF_ID)
                                                                                                    FROM QUESTION
                                                                                                    WHERE
                                                                                                      QUESTION_ID = '-10133' AND SEQUENCE_NUMBER = 1),
                                          3, 2, 1, 'Y', '4', 'Y', 'admin', SYSDATE, SYS_GUID(), 1);

INSERT INTO QUESTIONNAIRE_USAGE (QUESTIONNAIRE_USAGE_ID, MODULE_ITEM_CODE, MODULE_SUB_ITEM_CODE, QUESTIONNAIRE_REF_ID_FK, QUESTIONNAIRE_SEQUENCE_NUMBER, RULE_ID, QUESTIONNAIRE_LABEL, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID, IS_MANDATORY)
VALUES (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, 3, 0, (SELECT QUESTIONNAIRE_REF_ID
                                                 FROM QUESTIONNAIRE
                                                 WHERE QUESTIONNAIRE_ID = -5 AND SEQUENCE_NUMBER = 1), 1, 'RES-BOOT10000',
                                          'Clinical Trials Decision Tree', SYSDATE, 'admin', 1, SYS_GUID(), 'N');