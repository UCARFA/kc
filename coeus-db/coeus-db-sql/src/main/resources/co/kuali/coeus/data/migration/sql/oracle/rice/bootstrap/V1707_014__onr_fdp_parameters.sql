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

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_ONR_Policy', sys_guid(),1,'CONFG','http://www.onr.navy.mil/contracts-grants.aspx','The value entered here will populate the FDP form Attachment 2 for ONR for the General Terms and Conditions 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_ONR_Grants_Policy_Statement', sys_guid(),1,'CONFG','2 CFR 200, as modified and supplemented by the Department of Defense''s (DoD) interim implementation found at 2 CFR part 1103, (79 FR 76047, December 19, 2014), all of which are incorporated herein by reference.','The value entered here will populate the FDP form Attachment 2 for ONR for the General Terms and Conditions 3','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_ONR_Interim_Research_Terms', sys_guid(),1,'CONFG','http://www.onr.navy.mil/Contracts-Grants/submit-proposal/grants-proposal/~/media/Files/Contracts-Grants/docs/DoD-Research-Terms-Conditions-JUL2016.ashxp','The value entered here will populate the FDP form Attachment 2 for ONR for the General Terms and Conditions 4 part 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_ONR_Agency_Requirements', sys_guid(),1,'CONFG','http://www.onr.navy.mil/Contracts-Grants/submit-proposal/grants-proposal/grants-terms-conditions.aspx','The value entered here will populate the FDP form Attachment 2 for ONR for the General Terms and Conditions 4 part 2','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_ONR_FCOI_Guidance', sys_guid(),1,'CONFG','ONR - As stated in the solicitation','The value entered here will populate the FDP form Attachment 2 for ONR for the Promoting Objectivity in Research','A','KC');
