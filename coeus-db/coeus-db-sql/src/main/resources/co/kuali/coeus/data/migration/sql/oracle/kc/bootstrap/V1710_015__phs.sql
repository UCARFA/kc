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


INSERT INTO questionnaire (QUESTIONNAIRE_REF_ID, QUESTIONNAIRE_ID, SEQUENCE_NUMBER, NAME, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, IS_FINAL, DOCUMENT_NUMBER, VER_NBR, OBJ_ID, file_name, template)
VALUES (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, -4, 1, 'PHS Fellowship Supplemental 4.0',
                                          'The responses are used to populate the PHS 398 Fellowship Supplement v4-0 for submission via Grants.gov.',
                                          SYSDATE, 'admin', 'Y', NULL, 1, SYS_GUID(), NULL, NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 5 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                   FROM QUESTION
                                                                                   WHERE QUESTION_ID = 5)), 5, 0, 'N', NULL, NULL, SYSDATE, 'kr', 5,
   1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 6 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                   FROM QUESTION
                                                                                   WHERE QUESTION_ID = 6)), 6, 5, 'Y', '4', 'Y', SYSDATE, 'kr', 1, 1,
   SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 7 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                   FROM QUESTION
                                                                                   WHERE QUESTION_ID = 7)), 7, 6, 'Y', '4', 'Y', SYSDATE, 'kr', 1, 1,
   SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 24 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 24)), 26, 0, 'N', NULL, NULL, SYSDATE, 'kr',
                                     8, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 32 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 32)), 27, 26, 'Y', '4', 'Y', SYSDATE, 'kr', 1,
   1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 28 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 28)), 32, 0, 'N', NULL, NULL, SYSDATE, 'kr',
                                     9, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 29 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 29)), 33, 32, 'Y', '4', 'Y', SYSDATE, 'kr', 1,
   1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 33 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 33)), 49, 27, 'N', NULL, NULL, SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 36 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 36)), 72, 0, 'N', NULL, NULL, SYSDATE, 'kr',
                                     10, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 37 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 37)), 73, 72, 'Y', '4', 'Y', SYSDATE, 'kr', 2,
   1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 38 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 38)), 74, 73, 'Y', '4', 'Y', SYSDATE, 'kr', 1,
   1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 51 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 51)), 75, 74, 'N', NULL, NULL, SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 40 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 40)), 76, 75, 'N', NULL, NULL, SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 41 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 41)), 77, 76, 'N', NULL, NULL, SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 42 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 42)), 78, 0, 'N', NULL, NULL, SYSDATE, 'kr',
                                     7, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 35 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 35)), 79, 78, 'Y', '4', 'Y', SYSDATE, 'kr', 1,
   1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 99 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE
                                                                                      QUESTION_ID = 99 AND LOOKUP_RETURN = 'GraduateLevelDegree1-2')
                                            AND LOOKUP_RETURN = 'GraduateLevelDegree1-2'), 80, 78, 'Y', '4', 'Y', SYSDATE, 'kr', 2, 1, SYS_GUID(),
   NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 16 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 16)), 81, 80, 'Y', '2', 'MOTH', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 17 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 17)), 82, 80, 'Y', '2', 'DOTH', SYSDATE, 'kr',
                                     2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 18 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 18)), 83, 80, 'Y', '2', 'DDOT', SYSDATE, 'kr',
                                     3, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 19 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 19)), 84, 80, 'Y', '2', 'VDOT', SYSDATE, 'kr',
                                     4, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 100 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                     FROM QUESTION
                                                                                     WHERE QUESTION_ID = 100)), 85, 80, 'Y', '2', 'OTH', SYSDATE,
                                     'kr', 5, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 21 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 21)), 86, 80, 'Y', '2', 'MDOT', SYSDATE, 'kr',
                                     6, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 43 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 43)), 87, 49, 'N', NULL, NULL, SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 44 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 44)), 88, 87, 'Y', '4', 'Y', SYSDATE, 'kr', 1,
   1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 47 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 47)), 120, 72, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 48 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 48)), 121, 120, 'N', NULL, NULL, SYSDATE,
                                     'kr', 1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 50 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 50)), 122, 121, 'N', NULL, NULL, SYSDATE,
                                     'kr', 1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 49 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 49)), 123, 87, 'N', NULL, NULL, SYSDATE, 'kr',
                                     2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 45 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 45)), 124, 123, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 46 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 46)), 125, 123, 'N', NULL, NULL, SYSDATE,
                                     'kr', 2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 27 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 27)), 126, 125, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 31 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 31)), 127, 125, 'N', NULL, NULL, SYSDATE,
                                     'kr', 2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 32 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 32)), 128, 127, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 33 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 33)), 129, 128, 'N', NULL, NULL, SYSDATE,
                                     'kr', 1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 43 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 43)), 130, 129, 'N', NULL, NULL, SYSDATE,
                                     'kr', 1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 44 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 44)), 131, 130, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 49 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 49)), 132, 130, 'N', NULL, NULL, SYSDATE,
                                     'kr', 2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 45 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 45)), 133, 132, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 46 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 46)), 134, 132, 'N', NULL, NULL, SYSDATE,
                                     'kr', 2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 27 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 27)), 135, 134, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 31 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 31)), 136, 134, 'N', NULL, NULL, SYSDATE,
                                     'kr', 2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 32 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 32)), 137, 136, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 33 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 33)), 138, 137, 'N', NULL, NULL, SYSDATE,
                                     'kr', 1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 43 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 43)), 139, 138, 'N', NULL, NULL, SYSDATE,
                                     'kr', 1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 44 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 44)), 140, 139, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 49 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 49)), 141, 139, 'N', NULL, NULL, SYSDATE,
                                     'kr', 2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 45 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 45)), 142, 141, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 46 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 46)), 143, 141, 'N', NULL, NULL, SYSDATE,
                                     'kr', 2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 27 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 27)), 144, 143, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 31 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 31)), 145, 143, 'N', NULL, NULL, SYSDATE,
                                     'kr', 2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 32 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 32)), 146, 145, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 33 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 33)), 147, 146, 'N', NULL, NULL, SYSDATE,
                                     'kr', 1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 43 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 43)), 148, 147, 'N', NULL, NULL, SYSDATE,
                                     'kr', 1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 44 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 44)), 149, 148, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 49 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 49)), 150, 148, 'N', NULL, NULL, SYSDATE,
                                     'kr', 2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 45 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 45)), 151, 150, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 46 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 46)), 152, 150, 'N', NULL, NULL, SYSDATE,
                                     'kr', 2, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 27 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                    FROM QUESTION
                                                                                    WHERE QUESTION_ID = 27)), 153, 152, 'Y', '4', 'Y', SYSDATE, 'kr',
                                     1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 145 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                     FROM QUESTION
                                                                                     WHERE QUESTION_ID = 145)), 154, 0, 'N', NULL, NULL, SYSDATE,
                                     'kr', 4, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 146 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                     FROM QUESTION
                                                                                     WHERE QUESTION_ID = 146)), 155, 154, 'Y', '4', 'Y', SYSDATE,
                                     'kr', 1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 147 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                     FROM QUESTION
                                                                                     WHERE QUESTION_ID = 147)), 156, 155, 'Y', '4', 'Y', SYSDATE,
                                     'kr', 1, 1, SYS_GUID(), NULL);


INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = 148 AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                     FROM QUESTION
                                                                                     WHERE QUESTION_ID = 148)), 157, 156, 'Y', '4', 'N', SYSDATE,
                                     'kr', 1, 1, SYS_GUID(), NULL);

-- FOT question
INSERT INTO questionnaire_questions (QUESTIONNAIRE_QUESTIONS_ID, QUESTIONNAIRE_REF_ID_FK, QUESTION_REF_ID_FK, QUESTION_NUMBER, PARENT_QUESTION_NUMBER, CONDITION_FLAG, CONDITION_TYPE, CONDITION_VALUE, UPDATE_TIMESTAMP, UPDATE_USER, QUESTION_SEQ_NUMBER, VER_NBR, OBJ_ID, RULE_ID)
VALUES
  (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, (SELECT QUESTIONNAIRE_REF_ID
                                      FROM QUESTIONNAIRE
                                      WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1),
                                     (SELECT QUESTION_REF_ID
                                      FROM QUESTION
                                      WHERE QUESTION_ID = '200' AND SEQUENCE_NUMBER = (SELECT MAX(SEQUENCE_NUMBER)
                                                                                       FROM QUESTION
                                                                                       WHERE QUESTION_ID = 200)), 160, 0, 'N', NULL, NULL, SYSDATE,
                                     'kr', 6, 1, SYS_GUID(), NULL);


INSERT INTO QUESTIONNAIRE_USAGE (QUESTIONNAIRE_USAGE_ID, MODULE_ITEM_CODE, MODULE_SUB_ITEM_CODE, QUESTIONNAIRE_REF_ID_FK, QUESTIONNAIRE_SEQUENCE_NUMBER, RULE_ID, QUESTIONNAIRE_LABEL, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID, IS_MANDATORY)
VALUES (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, 3, 2, (SELECT QUESTIONNAIRE_REF_ID
                                                 FROM QUESTIONNAIRE
                                                 WHERE QUESTIONNAIRE_ID = -4 AND SEQUENCE_NUMBER = 1), 1, NULL, 'PHS Fellowship Supplemental 4.0',
                                          SYSDATE, 'admin', 1, SYS_GUID(), 'N');


INSERT INTO s2s_form_to_questionnaire (S2S_FORM_TO_QUESTIONNAIRE_ID, OPP_NAME_SPACE, FORM_NAME, QUESTIONNAIRE_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID, VER_NBR)
VALUES (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, 'http://apply.grants.gov/forms/PHS_Fellowship_Supplemental_4_0-V4.0', 'PHS_Fellowship_Supplemental_4_0', -4,
        SYSDATE, 'admin', SYS_GUID(), '1');
