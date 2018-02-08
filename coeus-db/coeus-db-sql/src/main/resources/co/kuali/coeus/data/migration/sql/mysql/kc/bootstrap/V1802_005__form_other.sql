--
-- Copyright © 2005-2018 Kuali, Inc.
-- All Rights Reserved
-- You may use and modify this code under the terms of the Kuali, Inc.
-- Pre-Release License Agreement. You may not distribute it.
--
-- You should have received a copy of the Kuali, Inc. Pre-Release License
-- Agreement with this file. If not, please write to license@kuali.co.
--

INSERT INTO SEQ_VALID_NARR_FORMS_ID VALUES (null);

INSERT INTO VALID_NARR_FORMS (VALID_NARR_FORMS_ID,FORM_NAME,NARRATIVE_TYPE_CODE,MANDATORY,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID)
VALUES ((SELECT MAX(ID) FROM SEQ_VALID_NARR_FORMS_ID),'Other-V1.2','19','N','admin',NOW(), UUID());
