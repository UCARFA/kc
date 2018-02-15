--
-- Copyright © 2005-2018 Kuali, Inc.
-- All Rights Reserved
-- You may use and modify this code under the terms of the Kuali, Inc.
-- Pre-Release License Agreement. You may not distribute it.
--
-- You should have received a copy of the Kuali, Inc. Pre-Release License
-- Agreement with this file. If not, please write to license@kuali.co.
--

insert into krcr_parm_t (nmspc_cd, cmpnt_cd, parm_nm, obj_id, ver_nbr, parm_typ_cd, val, parm_desc_txt, eval_oprtr_cd, appl_id)
values ('KC-AWARD', 'Document', 'Report_Tracking_UNIT_Digest_Notification_Cron_Trigger', uuid(), 1, 'CONFG', '0 59 23 15 * ?', 'Using a quartz cron expression, schedule the frequency of when batch notification overdue digest by UNIT should be sent.', 'A', 'KC');

insert into krcr_parm_t (nmspc_cd, cmpnt_cd, parm_nm, obj_id, ver_nbr, parm_typ_cd, val, parm_desc_txt, eval_oprtr_cd, appl_id)
values ('KC-AWARD', 'Document', 'Ascend_Unit_Hierarchy_For_Report_Tracking_Digest_Unit_Admins', uuid(), 1, 'CONFG', 'true', 'Determines whether or not award report tracking digest notifications should be sent to all Unit Administrators at or above the units associated with reports in the digest. Default value is true.', 'A', 'KC');
