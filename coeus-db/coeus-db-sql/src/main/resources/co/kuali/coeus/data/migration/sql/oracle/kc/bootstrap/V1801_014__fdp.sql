--
-- Copyright © 2005-2018 Kuali, Inc.
-- All Rights Reserved
-- You may use and modify this code under the terms of the Kuali, Inc.
-- Pre-Release License Agreement. You may not distribute it.
--
-- You should have received a copy of the Kuali, Inc. Pre-Release License
-- Agreement with this file. If not, please write to license@kuali.co.
--

ALTER TABLE SUBAWARD_TEMPLATE_INFO
  ADD (
  DATA_SHARING_CD VARCHAR2(4));

ALTER TABLE SUBAWARD_TEMPLATE_INFO
  ADD (
  IRB_IACUC_CONTACT NUMBER(3, 0));

UPDATE subaward_forms
SET form = NULL
WHERE FORM_ID = 'FDP_ATT_3A';