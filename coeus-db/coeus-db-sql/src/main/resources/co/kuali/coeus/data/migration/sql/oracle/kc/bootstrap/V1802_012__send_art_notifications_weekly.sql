--
-- Copyright © 2005-2018 Kuali, Inc.
-- All Rights Reserved
-- You may use and modify this code under the terms of the Kuali, Inc.
-- Pre-Release License Agreement. You may not distribute it.
--
-- You should have received a copy of the Kuali, Inc. Pre-Release License
-- Agreement with this file. If not, please write to license@kuali.co.
--

update krcr_parm_t set val = '0 59 23 ? * 1/7 *'
where nmspc_cd = 'KC-AWARD' and parm_nm = 'REPORT_TRACKING_NOTIFICATIONS_BATCH_CRON_TRIGGER'
and val = '0 */10 * * * ?';
