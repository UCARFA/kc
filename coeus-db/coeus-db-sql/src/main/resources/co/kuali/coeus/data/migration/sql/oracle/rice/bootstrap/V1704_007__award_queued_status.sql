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

INSERT INTO KRCR_PARM_T (APPL_ID,NMSPC_CD,PARM_TYP_CD,CMPNT_CD,PARM_NM,PARM_DESC_TXT,VAL,EVAL_OPRTR_CD,OBJ_ID,VER_NBR)
    VALUES ('KUALI','KC-AB','CONFG','Document','awardBudgetStatusQueued','This system parameter maps the AwardBudget status Queued','-1','A',SYS_GUID(),1);

INSERT INTO KRCR_PARM_T (APPL_ID,NMSPC_CD,PARM_TYP_CD,CMPNT_CD,PARM_NM,PARM_DESC_TXT,VAL,EVAL_OPRTR_CD,OBJ_ID,VER_NBR)
    VALUES ('KUALI','KC-AB','CONFG','Document','Enable_Award_Budget_Queued_Status','This feature will change the award budget status to queued on post.','Y','A',SYS_GUID(),1);
