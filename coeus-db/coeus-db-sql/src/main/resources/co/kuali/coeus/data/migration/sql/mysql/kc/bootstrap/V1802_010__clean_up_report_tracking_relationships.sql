--
-- Copyright © 2005-2018 Kuali, Inc.
-- All Rights Reserved
-- You may use and modify this code under the terms of the Kuali, Inc.
-- Pre-Release License Agreement. You may not distribute it.
--
-- You should have received a copy of the Kuali, Inc. Pre-Release License
-- Agreement with this file. If not, please write to license@kuali.co.
--

set @today = date_format(now(), '%Y%m%d');
set @sql = concat("create table award_report_tracking_backup_", @today, " as select *, now() as date_backed_up ",
	"from award_report_tracking art ",
	"where award_id is null ",
	"or award_report_term_id is null ",
	"or not exists (",
		"select * from award_report_terms where award_report_terms_id = art.award_report_term_id)");
prepare stmt from @sql;
execute stmt;

delete from art
using award_report_tracking as art
where award_id is null
or award_report_term_id is null
or not exists (
	select * from award_report_terms where award_report_terms_id = art.award_report_term_id);

alter table award_report_tracking modify award_id decimal(22,0) not null;
alter table award_report_tracking modify award_report_term_id decimal(12,0) not null;
alter table award_report_tracking add constraint award_report_tracking_fk2 foreign key (award_report_term_id) references award_report_terms (award_report_terms_id);
