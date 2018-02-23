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

set define off
set sqlblanklines on

spool 1802_oracle_kc_upgrade.sql.log
@./kc/bootstrap/V1802_002__nihData.sql
@./kc/bootstrap/V1802_003__fdp.sql
@./kc/bootstrap/V1802_005__form_other.sql
@./kc/bootstrap/V1802_006__art_pi_digest_notification.sql
@./kc/bootstrap/V1802_008__art_unit_admin_digest_notification.sql
@./kc/bootstrap/V1802_010__clean_up_report_tracking_relationships.sql
@./kc/bootstrap/V1802_011__remove_art_overdue_column.sql
@./kc/bootstrap/V1802_012__send_art_notifications_weekly.sql
@./kc/bootstrap/V1802_013__award_payment_schedule_term_fk.sql
commit;
