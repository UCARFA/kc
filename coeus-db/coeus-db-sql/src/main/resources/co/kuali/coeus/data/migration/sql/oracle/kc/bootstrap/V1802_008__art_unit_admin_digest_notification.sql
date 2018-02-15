--
-- Copyright © 2005-2018 Kuali, Inc.
-- All Rights Reserved
-- You may use and modify this code under the terms of the Kuali, Inc.
-- Pre-Release License Agreement. You may not distribute it.
--
-- You should have received a copy of the Kuali, Inc. Pre-Release License
-- Agreement with this file. If not, please write to license@kuali.co.
--

insert into notification_type (notification_type_id, module_code, action_code, description, subject, message, prompt_user, send_notification, update_user, update_timestamp, ver_nbr, obj_id)
values (seq_notification_type_id.nextval, 1, '-2', 'Award Report Tracking Unit Overdue Digest Notification', 'Overdue Reports',
	'<p>The following reports are overdue for {LEAD_UNIT_NAME}. Please submit ASAP.</p>{BEGIN_DIGEST_TABLE}<table><tr><th>Award Number</th><th>Sponsor</th><th>Sponsor Award Number</th><th>Award Title</th><th>PI</th><th>Unit</th><th>Account Number</th><th>Report Class</th><th>Report Type</th><th>Due Date</th></tr>{BEGIN_REPEAT_SECTION}<tr><td><a href="{DOCUMENT_PREFIX}/awardHome.do?methodToCall=docHandler&docId={DOCUMENT_NUMBER}&command=displayDocSearchView" target="_blank">{AWARD_NUMBER}</a></td><td>{SPONSOR_NAME}</td><td>{SPONSOR_AWARD_NUMBER}</td><td>{AWARD_TITLE}</td><td>{PI_NAME}</td><td>{LEAD_UNIT_NAME}</td><td>{ACCOUNT_NUMBER}</td><td>{REPORT_CLASS}</td><td>{REPORT_TYPE}</td><td>{REPORT_DUE_DATE}</td></tr>{END_REPEAT_SECTION}</table>{END_DIGEST_TABLE}',
	'N', 'Y', 'admin', SYSDATE, 1, sys_guid());

insert into notification_type_recipient (notification_type_recipient_id, notification_type_id, role_name, update_user, update_timestamp, ver_nbr, obj_id, role_sub_qualifier)
values (seq_notification_type_id.nextval, (select notification_type_id from notification_type where module_code = 1 and action_code = '-2'), 'KC-AWARD:All Unit Administrators', 'admin', SYSDATE, 1, sys_guid(), '3');

insert into notification_mdl_role_qlfr (notification_mdl_role_qlfr_id, notification_module_role_id, obj_id, ver_nbr, update_timestamp, update_user, qualifier)
values (seq_ntfctn_mdl_role_qlfr_id.nextval, (select notification_module_role_id from notification_module_role where role_name = 'KC-AWARD:All Unit Administrators'), sys_guid(), 1, SYSDATE, 'admin', 'subunits');
