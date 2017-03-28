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
VALUES ('KC-SUBAWARD','Document','FDP_NIH_Policy', SYS_GUID(),1,'CONFG','http://grants.nih.gov/policy/notices.htm','The value entered here will populate the FDP form Attachment 2 for NIH for the General Terms and Conditions 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_NIH_Grants_Policy_Statement', SYS_GUID(),1,'CONFG','http://grants.nih.gov/grants/policy/nihgps/nihgps.pdf','The value entered here will populate the FDP form Attachment 2 for NIH for the General Terms and Conditions 3','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_NIH_Interim_Research_Terms', SYS_GUID(),1,'CONFG','https://www.nsf.gov/awards/managing/rtc.jsp','The value entered here will populate the FDP form Attachment 2 for NIH for the General Terms and Conditions 4 part 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_NIH_Agency_Requirements', SYS_GUID(),1,'CONFG','http://grants.nih.gov/grants/policy/NIH%20Interim%20Grant%20General%20Conditions.pdf','The value entered here will populate the FDP form Attachment 2 for NIH for the General Terms and Conditions 4 part 2','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_NIH_FCOI_Guidance', SYS_GUID(),1,'CONFG','NIH - 42 CFR Part 50 Subpart F','The value entered here will populate the FDP form Attachment 2 for NIH for the Promoting Objectivity in Research','A','KC');
