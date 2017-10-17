--
-- Kuali Coeus, a comprehensive research administration system for higher education.
-- 
-- Copyright 2005-2015 Kuali, Inc.
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

INSERT INTO KRMS_TERM_T (TERM_ID, TERM_SPEC_ID, VER_NBR, DESC_TXT)
VALUES ('RES-BOOT10020', 'KC2000', 1, 'PHS HumanSubjectsAndClinicalTrialsInfo V1.0 Term');
INSERT INTO KRMS_TERM_PARM_T (TERM_PARM_ID, TERM_ID, NM, VAL, VER_NBR)
VALUES ('RES-BOOT10020', 'RES-BOOT10020', 'GrantsGov Form Name', 'PHS_HumanSubjectsAndClinicalTrialsInfo_V1.0', 1);
INSERT INTO KRMS_RULE_T (RULE_ID, NMSPC_CD, NM, PROP_ID, ACTV, VER_NBR, DESC_TXT) VALUES
  ('KC153', 'KC-PD', 'PHS_HumanSubjectsAndClinicalTrialsInfo_V1.0 (Q IDs -10130)', NULL, 'Y', 1,
   'PHS_HumanSubjectsAndClinicalTrialsInfo_V1.0 (Q IDs -10130)');
INSERT INTO KRMS_AGENDA_ITM_T (AGENDA_ITM_ID, RULE_ID, SUB_AGENDA_ID, AGENDA_ID, VER_NBR, WHEN_TRUE, WHEN_FALSE, ALWAYS)
VALUES ('RES-BOOT10020', 'KC153', NULL, 'KC1000', 1, NULL, NULL, NULL);
INSERT INTO KRMS_PROP_T (PROP_ID, DESC_TXT, DSCRM_TYP_CD, RULE_ID, VER_NBR)
VALUES ('RES-BOOT10020', 'PHS_HumanSubjectsAndClinicalTrialsInfo_V1.0', 'S', 'KC153', 1);
UPDATE KRMS_RULE_T
SET PROP_ID = 'RES-BOOT10020'
WHERE RULE_ID = 'KC153';
INSERT INTO KRMS_PROP_PARM_T (PROP_PARM_ID, PROP_ID, PARM_VAL, PARM_TYP_CD, SEQ_NO, VER_NBR)
VALUES ('RES-BOOT10001', 'RES-BOOT10020', 'RES-BOOT10020', 'T', 0, 1);
INSERT INTO KRMS_PROP_PARM_T (PROP_PARM_ID, PROP_ID, PARM_VAL, PARM_TYP_CD, SEQ_NO, VER_NBR)
VALUES ('RES-BOOT10002', 'RES-BOOT10020', '=', 'O', 2, 1);
INSERT INTO KRMS_PROP_PARM_T (PROP_PARM_ID, PROP_ID, PARM_VAL, PARM_TYP_CD, SEQ_NO, VER_NBR)
VALUES ('RES-BOOT10003', 'RES-BOOT10020', 'true', 'C', 1, 1);
UPDATE KRMS_AGENDA_ITM_T
SET ALWAYS = 'RES-BOOT10020'
WHERE AGENDA_ITM_ID = 'KC2011';
