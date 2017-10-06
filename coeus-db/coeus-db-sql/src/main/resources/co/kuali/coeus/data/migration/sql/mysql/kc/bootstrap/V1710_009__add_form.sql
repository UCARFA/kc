--
-- Kuali Coeus, a comprehensive research administration system for higher education.
--
-- Copyright 2005-2016 Kuali, Inc.
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


INSERT INTO NARRATIVE_TYPE (NARRATIVE_TYPE_CODE, DESCRIPTION, NARRATIVE_TYPE_GROUP, ALLOW_MULTIPLE, SYSTEM_GENERATED, UPDATE_USER, UPDATE_TIMESTAMP, OBJ_ID, VER_NBR)
VALUES ('-3', 'PHS_HumanSubjectsAndCT_InvolveHumanSpecimensExp', 'P', 'N', 'N', 'admin', NOW(), UUID(), 1);

INSERT INTO NARRATIVE_TYPE (NARRATIVE_TYPE_CODE, DESCRIPTION, NARRATIVE_TYPE_GROUP, ALLOW_MULTIPLE, SYSTEM_GENERATED, UPDATE_USER, UPDATE_TIMESTAMP, OBJ_ID, VER_NBR)
VALUES ('-4', 'PHS_HumanSubjectsAndCT_OtherRequestedInfo', 'P', 'N', 'N', 'admin', NOW(), UUID(), 1);

INSERT INTO SEQ_VALID_NARR_FORMS_ID VALUES (NULL);
INSERT INTO VALID_NARR_FORMS (VALID_NARR_FORMS_ID, FORM_NAME, NARRATIVE_TYPE_CODE, MANDATORY, UPDATE_USER, UPDATE_TIMESTAMP, OBJ_ID)
VALUES ((SELECT (MAX(ID))
         FROM SEQ_VALID_NARR_FORMS_ID), 'PHS_HumanSubjectsAndClinicalTrialsInfo_V1.0', '-3', 'N', 'admin', NOW(),
        UUID());

INSERT INTO SEQ_VALID_NARR_FORMS_ID VALUES (NULL);
INSERT INTO VALID_NARR_FORMS (VALID_NARR_FORMS_ID, FORM_NAME, NARRATIVE_TYPE_CODE, MANDATORY, UPDATE_USER, UPDATE_TIMESTAMP, OBJ_ID)
VALUES ((SELECT (MAX(ID))
         FROM SEQ_VALID_NARR_FORMS_ID), 'PHS_HumanSubjectsAndClinicalTrialsInfo_V1.0', '-4', 'N', 'admin', NOW(),
        UUID());

INSERT INTO exemption_type (EXEMPTION_TYPE_CODE, DESCRIPTION, DETAILED_DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ('7', 'E7', 'Human subjects involved—multiple exemption categories designated.', NOW(), 'admin', 1, UUID());

INSERT INTO exemption_type (EXEMPTION_TYPE_CODE, DESCRIPTION, DETAILED_DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ('8', 'E8', 'Human subjects involved—applicability of human subjects regulations waived by the Secretary, HHS.',
        NOW(), 'admin', 1, UUID());


INSERT INTO SEQ_QUESTIONNAIRE_REF_ID VALUES (NULL);
INSERT INTO QUESTION (QUESTION_REF_ID, QUESTION_ID, SEQUENCE_NUMBER, SEQUENCE_STATUS, QUESTION, STATUS, GROUP_TYPE_CODE, QUESTION_TYPE_ID, LOOKUP_CLASS, LOOKUP_RETURN, DISPLAYED_ANSWERS, MAX_ANSWERS, ANSWER_MAX_LENGTH, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID, DOCUMENT_NUMBER)
VALUES ((SELECT (MAX(ID))
         FROM SEQ_QUESTIONNAIRE_REF_ID), -10130, 1, 'C',
                                         'Does the proposed research involve human specimens and/or data?', 'A', 2, 1,
                                         NULL, NULL, NULL, 1, 1, NOW(), 'admin', 1, UUID(), NULL);

INSERT INTO SEQ_QUESTIONNAIRE_REF_ID VALUES (NULL);
INSERT INTO QUESTIONNAIRE_QUESTIONS (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, QUESTION_SEQ_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_USER, UPDATE_TIMESTAMP, OBJ_ID, VER_NBR, RULE_ID)
VALUES ((SELECT (MAX(ID))
         FROM SEQ_QUESTIONNAIRE_REF_ID), (SELECT QUESTIONNAIRE_REF_ID
                                          FROM QUESTIONNAIRE
                                          WHERE NAME = 'GG S2S Forms' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                                                             FROM QUESTIONNAIRE
                                                                                             WHERE
                                                                                               NAME = 'GG S2S Forms')),
                                         (SELECT max(QUESTION_REF_ID)
                                          FROM QUESTION
                                          WHERE QUESTION_ID = '-10130'), 295, 0, 1, 'N', NULL, NULL, 'admin', NOW(),
        UUID(), 1, 'KC153');