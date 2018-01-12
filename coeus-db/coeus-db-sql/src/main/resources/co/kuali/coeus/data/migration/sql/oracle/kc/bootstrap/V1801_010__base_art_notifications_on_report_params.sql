--
-- Kuali Coeus, a comprehensive research administration system for higher education.
--
-- Copyright 2005-2018 Kuali, Inc.
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

alter table AWARD_REPORT_NOTIFICATION_SENT add (report_class_code varchar(3), report_code varchar(3));

update award_report_notification_sent arns
set (report_class_code, report_code) = (
	select report_class_code, report_code FROM award_report_terms
	where award_report_terms_id = arns.award_report_term_id);

alter table award_report_notification_sent drop column award_report_term_id;

create index ix_art_award_id on award_report_tracking (award_id);
create index ix_art_report_class_code on award_report_tracking (report_class_code);
