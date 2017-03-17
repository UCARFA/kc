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

-- agenda type
insert into KRMS_TYP_T (TYP_ID, NM, NMSPC_CD, SRVC_NM, ACTV, VER_NBR)
	VALUES ('RES-BOOT10009', 'Cost Share Agenda', 'KC-KRMS', 'costShareAgendaTypeService', 'Y', 1);

insert into KRMS_TYP_ATTR_T (TYP_ATTR_ID, SEQ_NO, TYP_ID, ATTR_DEFN_ID, ACTV, VER_NBR)
	VALUES ('RES-BOOT10000', 1, 'RES-BOOT10009', 'KC1000', 'Y', 1);

insert into KRMS_CNTXT_VLD_AGENDA_TYP_T (CNTXT_VLD_AGENDA_ID, CNTXT_ID, AGENDA_TYP_ID, VER_NBR)
	VALUES ('RES-BOOT10000', 'KC-PD-CONTEXT', 'RES-BOOT10009', 1);

-- roles
INSERT INTO KRIM_TYP_T (KIM_TYP_ID, OBJ_ID, VER_NBR, NM, SRVC_NM, ACTV_IND, NMSPC_CD)
VALUES( 'RESBOOT-1001', SYS_GUID(), 1, 'Derived Role: Proposal Cost Share Unit Administrators', 'proposalCostShareUnitAdministratorDerivedRoleTypeService', 'Y', 'KC-PD');

-- create new roles
INSERT INTO KRIM_ROLE_T (ROLE_ID, OBJ_ID, VER_NBR, ROLE_NM, NMSPC_CD, DESC_TXT, KIM_TYP_ID, ACTV_IND, LAST_UPDT_DT)
VALUES ('RESBOOT-1000', SYS_GUID(), 1, 'Cost Share Approver Unit Admin', 'KC-PD', 'Proposal Cost Share Unit Administrators',  'RESBOOT-1001', 'Y', SYSDATE);

-- unit administrator type
INSERT INTO UNIT_ADMINISTRATOR_TYPE (UNIT_ADMINISTRATOR_TYPE_CODE,DESCRIPTION,DEFAULT_GROUP_FLAG,MULTIPLES_FLAG,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR)
    VALUES ('-1','COST_SHARE_ADMINISTRATOR','C','N','admin',SYSDATE,SYS_GUID(),1);

INSERT INTO KRCR_PARM_T (APPL_ID, NMSPC_CD, CMPNT_CD, PARM_NM, VAL, PARM_DESC_TXT, PARM_TYP_CD, EVAL_OPRTR_CD, OBJ_ID, VER_NBR)
VALUES ('KUALI', 'KC-PD', 'All', 'COST_SHARE_ADMINISTRATOR_TYPE_CODE', '-1', 'Cost share administrator type code', 'CONFG', 'A', SYS_GUID(), 1);