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
insert into krcr_parm_t (nmspc_cd, cmpnt_cd, parm_nm, obj_id, ver_nbr, parm_typ_cd, val, parm_desc_txt, eval_oprtr_cd, appl_id)
values ('KR-SYS', 'All', 'riceNoteAttachmentDataToS3Conversion.cronExpression', UUID(), 1, 'CONFG', '0 32 * * * ?', 'The cron expression for how often the rice Kew to S3 conversion should be started.', 'A', 'KC');

insert into krcr_parm_t (nmspc_cd, cmpnt_cd, parm_nm, obj_id, ver_nbr, parm_typ_cd, val, parm_desc_txt, eval_oprtr_cd, appl_id)
values ('KR-SYS', 'All', 'riceNoteAttachmentDataToS3Conversion.enabled', UUID(), 1, 'CONFG', 'N', 'Determines whether the rice Kew to S3 conversion will run.', 'A', 'KC');

insert into krcr_parm_t (nmspc_cd, cmpnt_cd, parm_nm, obj_id, ver_nbr, parm_typ_cd, val, parm_desc_txt, eval_oprtr_cd, appl_id)
values ('KR-SYS', 'All', 'riceKradAttachmentDataToS3Conversion.cronExpression', UUID(), 1, 'CONFG', '0 32 * * * ?', 'The cron expression for how often the rice Krad to S3 conversion should be started.', 'A', 'KC');

insert into krcr_parm_t (nmspc_cd, cmpnt_cd, parm_nm, obj_id, ver_nbr, parm_typ_cd, val, parm_desc_txt, eval_oprtr_cd, appl_id)
values ('KR-SYS', 'All', 'riceKradAttachmentDataToS3Conversion.enabled', UUID(), 1, 'CONFG', 'N', 'Determines whether the rice Krad to S3 conversion will run.', 'A', 'KC');

INSERT INTO KRCR_PARM_T (NMSPC_CD, CMPNT_CD, PARM_NM, OBJ_ID, VER_NBR, PARM_TYP_CD, VAL, PARM_DESC_TXT, EVAL_OPRTR_CD, APPL_ID)
VALUES ('KR-SYS', 'All', 'DELETE_FILE_FROM_FILESYSTEM', UUID(), 1, 'CONFG', 'false',
        'Whether to delete the file from the filesystem in the S3 conversion jobs.', 'A', 'KUALI');

INSERT INTO KRCR_PARM_T (NMSPC_CD, CMPNT_CD, PARM_NM, OBJ_ID, VER_NBR, PARM_TYP_CD, VAL, PARM_DESC_TXT, EVAL_OPRTR_CD, APPL_ID)
VALUES ('KC-GEN', 'All', 'DELETE_FILE_FROM_DB', UUID(), 1, 'CONFG', 'false',
        'Whether to delete the file from the database in the S3 conversion jobs.', 'A', 'KUALI');

