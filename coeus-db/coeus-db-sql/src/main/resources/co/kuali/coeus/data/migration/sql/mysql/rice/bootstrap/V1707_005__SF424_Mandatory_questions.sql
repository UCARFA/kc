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

insert into KRMS_TERM_T(TERM_ID,TERM_SPEC_ID,VER_NBR,DESC_TXT) values ('RES-BOOT10019','KC2000',1,'SF424Mandatory 1.2 Term');
insert into KRMS_TERM_PARM_T(TERM_PARM_ID,TERM_ID,NM,VAL,VER_NBR) values ('RES-BOOT10019','RES-BOOT10019','GrantsGov Form Name','SF424Mandatory1_2_V1_2',1);
insert into KRMS_RULE_T (RULE_ID,NMSPC_CD,NM,PROP_ID,ACTV,VER_NBR,DESC_TXT) values ('KC152','KC-PD','SF424Mandatory1_2_V1_2 (Q IDs 129, 130, 131, 10121, 10122, 10123, 10124, 10125, 10126, 10127, 10128, 10129)',null,'Y',1,'SF424Mandatory1_2_V1_2 (Q IDs 129, 130, 131, 10121, 10122, 10123, 10124, 10125, 10126, 10127, 10128, 10129)');
insert into KRMS_AGENDA_ITM_T(AGENDA_ITM_ID,RULE_ID,SUB_AGENDA_ID,AGENDA_ID,VER_NBR,WHEN_TRUE,WHEN_FALSE,ALWAYS) values ('RES-BOOT10019','KC152',null,'KC1000',1,null,null,null);
insert into KRMS_PROP_T (PROP_ID,DESC_TXT,DSCRM_TYP_CD,RULE_ID,VER_NBR) values ('RES-BOOT10019','SF424Mandatory1_2_V1_2','S','KC152',1);
update KRMS_RULE_T set PROP_ID='RES-BOOT10019' where RULE_ID='KC152';
insert into KRMS_PROP_PARM_T (PROP_PARM_ID,PROP_ID,PARM_VAL,PARM_TYP_CD,SEQ_NO,VER_NBR) values ('KC2034','RES-BOOT10019','RES-BOOT10019','T',0,1);
insert into KRMS_PROP_PARM_T (PROP_PARM_ID,PROP_ID,PARM_VAL,PARM_TYP_CD,SEQ_NO,VER_NBR) values ('KC2035','RES-BOOT10019','=','O',2,1);
insert into KRMS_PROP_PARM_T (PROP_PARM_ID,PROP_ID,PARM_VAL,PARM_TYP_CD,SEQ_NO,VER_NBR) values ('KC2036','RES-BOOT10019','true','C',1,1);
update KRMS_AGENDA_ITM_T set ALWAYS='RES-BOOT10019' where AGENDA_ITM_ID='KC2011';
