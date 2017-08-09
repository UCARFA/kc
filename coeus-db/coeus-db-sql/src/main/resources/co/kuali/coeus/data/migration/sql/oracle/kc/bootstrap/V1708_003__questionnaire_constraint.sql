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

declare
  l_max_value number;
begin

  select max(question_id) into l_max_value from question;

  execute immediate 'drop sequence SEQ_QUESTION_ID';
  execute immediate 'CREATE SEQUENCE SEQ_QUESTION_ID START WITH ' || l_max_value || ' INCREMENT BY 1 NOMAXVALUE NOCYCLE NOCACHE ORDER';

end;
/

ALTER TABLE QUESTION
  ADD CONSTRAINT UC1_QUESTION UNIQUE (QUESTION_ID, SEQUENCE_NUMBER);

ALTER TABLE QUESTION
  ADD CONSTRAINT UC2_QUESTION UNIQUE (OBJ_ID);

ALTER TABLE QUESTION
  ADD CONSTRAINT FK_QUESTION_TYPE
FOREIGN KEY (QUESTION_TYPE_ID) REFERENCES question_types(QUESTION_TYPE_ID);

ALTER TABLE question_explanation
  ADD CONSTRAINT UC1_question_explan UNIQUE (OBJ_ID);

ALTER TABLE question_multi_choice
  ADD CONSTRAINT UC1_question_mc UNIQUE (OBJ_ID);

ALTER TABLE question_types
  ADD CONSTRAINT UC1_question_types UNIQUE (OBJ_ID);

ALTER TABLE questionnaire
  ADD CONSTRAINT UC1_questionnaire UNIQUE (QUESTIONNAIRE_ID, SEQUENCE_NUMBER);

ALTER TABLE questionnaire
  ADD CONSTRAINT UC2_questionnaire UNIQUE (OBJ_ID);

ALTER TABLE questionnaire_answer
  ADD CONSTRAINT UC1_questionnaire_answer UNIQUE (OBJ_ID);

ALTER TABLE questionnaire_answer
  ADD CONSTRAINT FK_ANSWER_QUEST_QUESTIONS
FOREIGN KEY (QUESTIONNAIRE_QUESTIONS_ID_FK) REFERENCES questionnaire_questions(QUESTIONNAIRE_QUESTIONS_ID);

ALTER TABLE questionnaire_answer_header
  ADD CONSTRAINT UC1_questionnaire_ah UNIQUE (OBJ_ID);

ALTER TABLE questionnaire_condition_type
  ADD CONSTRAINT UC1_questionnaire_cond_type UNIQUE (OBJ_ID);

ALTER TABLE questionnaire_questions
  ADD CONSTRAINT UC1_questionnaire_questions UNIQUE (OBJ_ID);

ALTER TABLE questionnaire_usage
  ADD CONSTRAINT UC1_questionnaire_usage UNIQUE (OBJ_ID);

ALTER TABLE questionnaire_usage
  ADD CONSTRAINT FK_qu_module_code
FOREIGN KEY (MODULE_ITEM_CODE) REFERENCES coeus_module(module_code);
