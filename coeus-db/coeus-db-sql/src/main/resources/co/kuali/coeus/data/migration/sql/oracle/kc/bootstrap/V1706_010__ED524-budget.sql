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

INSERT INTO QUESTIONNAIRE (QUESTIONNAIRE_REF_ID,QUESTIONNAIRE_ID,SEQUENCE_NUMBER,NAME,DESCRIPTION,UPDATE_TIMESTAMP,UPDATE_USER,IS_FINAL,VER_NBR,OBJ_ID,FILE_NAME)
values (SEQ_QUESTIONNAIRE_REF_ID.nextval, SEQ_QUESTIONNAIRE_ID.nextval,1,
'ED524 Budget V-1.3 questions','These questions support  ED524 Budget V-1.3 forms.',
SYSDATE, 'admin','Y',1,SYS_GUID(),null);


INSERT INTO QUESTION (QUESTION_REF_ID,QUESTION_ID,SEQUENCE_NUMBER,SEQUENCE_STATUS,QUESTION,STATUS,GROUP_TYPE_CODE,QUESTION_TYPE_ID,LOOKUP_CLASS,LOOKUP_RETURN,DISPLAYED_ANSWERS,
MAX_ANSWERS,ANSWER_MAX_LENGTH,UPDATE_TIMESTAMP,UPDATE_USER,VER_NBR,OBJ_ID,DOCUMENT_NUMBER) values
(SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL,10120,1,'C','Do the instructions for this project indicate this is a restricted program?','I',4,1,null,null,null,1,1,SYSDATE,
 'admin',1,SYS_GUID(),null);

INSERT INTO QUESTIONNAIRE_QUESTIONS (QUESTIONNAIRE_QUESTIONS_ID,QUESTIONNAIRE_REF_ID_FK,QUESTION_REF_ID_FK,QUESTION_NUMBER,PARENT_QUESTION_NUMBER,QUESTION_SEQ_NUMBER,
CONDITION_FLAG,CONDITION_TYPE,CONDITION_VALUE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR)
VALUES (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL,(SELECT QUESTIONNAIRE_REF_ID FROM QUESTIONNAIRE WHERE NAME = 'ED524 Budget V-1.3 questions' AND SEQUENCE_NUMBER = 1),
(SELECT max(QUESTION_REF_ID) FROM QUESTION WHERE QUESTION = 'Do the instructions for this project indicate this is a restricted program?' AND SEQUENCE_NUMBER = 1),1,0,1,'N',
null,null,'admin',SYSDATE,SYS_GUID(),1);

-- usage
INSERT INTO QUESTIONNAIRE_USAGE (QUESTIONNAIRE_USAGE_ID,MODULE_ITEM_CODE,MODULE_SUB_ITEM_CODE,QUESTIONNAIRE_REF_ID_FK,QUESTIONNAIRE_SEQUENCE_NUMBER,RULE_ID,
QUESTIONNAIRE_LABEL,UPDATE_TIMESTAMP,UPDATE_USER,VER_NBR,OBJ_ID,IS_MANDATORY)
values (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL ,3,(SELECT SUB_MODULE_CODE FROM COEUS_SUB_MODULE WHERE DESCRIPTION = 'S2S Questionnaires'),
(SELECT QUESTIONNAIRE_REF_ID FROM QUESTIONNAIRE WHERE NAME = 'ED524 Budget V-1.3 questions' AND SEQUENCE_NUMBER = 1), 1,null,
'ED524 Budget V-1.3 questionnaire',SYSDATE,'admin',1,SYS_GUID(),'N');

insert into s2s_form_to_questionnaire
(S2S_FORM_TO_QUESTIONNAIRE_ID, OPP_NAME_SPACE, FORM_NAME, QUESTIONNAIRE_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID, VER_NBR)
VALUES (SEQ_QUESTIONNAIRE_REF_ID.NEXTVAL, 'http://apply.grants.gov/forms/ED_524_Budget_1_3-V1.3', 'ED_524_Budget_1_3-V1.3',
(select questionnaire_id from questionnaire where name='ED524 Budget V-1.3 questions'), SYSDATE, 'admin', SYS_GUID(), '1');

