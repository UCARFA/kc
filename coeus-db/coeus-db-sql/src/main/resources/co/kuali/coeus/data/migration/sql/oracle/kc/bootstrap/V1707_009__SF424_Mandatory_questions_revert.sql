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
delete from questionnaire_answer where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'This type of submission is' and QUESTION_ID = 10121);
delete from QUESTIONNAIRE_QUESTIONS where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'This type of submission is' and QUESTION_ID = 10121);
delete from QUESTION WHERE QUESTION = 'This type of submission is' and QUESTION_ID = 10121;

delete from questionnaire_answer where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Please specify' and QUESTION_ID = 10122);
delete from QUESTIONNAIRE_QUESTIONS where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Please specify' and QUESTION_ID = 10122);
delete from QUESTION WHERE QUESTION = 'Please specify' and QUESTION_ID = 10122;

delete from questionnaire_answer where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Select an applicable frequency for this type of submission' and QUESTION_ID = 10123);
delete from QUESTIONNAIRE_QUESTIONS where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Select an applicable frequency for this type of submission' and QUESTION_ID = 10123);
delete from QUESTION WHERE QUESTION = 'Select an applicable frequency for this type of submission' and QUESTION_ID = 10123;

delete from questionnaire_answer where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Please specify' and QUESTION_ID = 10124);
delete from QUESTIONNAIRE_QUESTIONS where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Please specify' and QUESTION_ID = 10124);
delete from QUESTION WHERE QUESTION = 'Please specify' and QUESTION_ID = 10124;

delete from questionnaire_answer where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Is this submission a consolidated application/plan/funding request?' and QUESTION_ID = 10125);
delete from QUESTIONNAIRE_QUESTIONS where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Is this submission a consolidated application/plan/funding request?' and QUESTION_ID = 10125);
delete from QUESTION WHERE QUESTION = 'Is this submission a consolidated application/plan/funding request?' and QUESTION_ID = 10125;

delete from questionnaire_answer where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Provide a consolidated application/plan/funding request explanation' and QUESTION_ID = 10126);
delete from QUESTIONNAIRE_QUESTIONS where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Provide a consolidated application/plan/funding request explanation' and QUESTION_ID = 10126);
delete from QUESTION WHERE QUESTION = 'Provide a consolidated application/plan/funding request explanation' and QUESTION_ID = 10126;

delete from questionnaire_answer where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Does the funding agency request a list of areas affected by funding?' and QUESTION_ID = 10127);
delete from QUESTIONNAIRE_QUESTIONS where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Does the funding agency request a list of areas affected by funding?' and QUESTION_ID = 10127);
delete from QUESTION WHERE QUESTION = 'Does the funding agency request a list of areas affected by funding?' and QUESTION_ID = 10127;

delete from questionnaire_answer where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Provide a list of areas affected, using the categories specified in the opportunity instructions' and QUESTION_ID = 10128);
delete from QUESTIONNAIRE_QUESTIONS where QUESTION_REF_ID_FK = (select QUESTION_REF_ID from QUESTION WHERE QUESTION = 'Provide a list of areas affected, using the categories specified in the opportunity instructions' and QUESTION_ID = 10128);
delete from QUESTION WHERE QUESTION = 'Provide a list of areas affected, using the categories specified in the opportunity instructions' and QUESTION_ID = 10128;

delete from questionnaire_answer where QUESTIONNAIRE_QUESTIONS_ID_FK in (select QUESTIONNAIRE_QUESTIONS_ID from QUESTIONNAIRE_QUESTIONS where RULE_ID = 'KC152');
delete from QUESTIONNAIRE_QUESTIONS where RULE_ID = 'KC152';

INSERT INTO S2S_FORM_CONFIG
(S2S_FORM_CONFIG_ID,
 FORM_NAME,
 ACTIVE_FLAG,
 INACTIVE_MESSAGE,
 VER_NBR,
 OBJ_ID,
 UPDATE_TIMESTAMP,
 UPDATE_USER) VALUES
  (SEQ_S2S_FORM_CONFIG_ID.nextval,
   'SF424Mandatory1_2_V1_2',
   'N',
   'The form is still undergoing testing. Expect it to be available soon.',
   '1',
   SYS_GUID(),
   sysdate,
   'admin');