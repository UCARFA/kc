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

spool 1802_oracle_kc_rice_server_upgrade.sql.log
@./rice/bootstrap/V1802_001__nih_validation_service_caching.sql
@./rice/bootstrap/V1802_004__version_lock_feature.sql
@./rice/bootstrap/V1802_007__art_pi_digest_cron_trigger.sql
@./rice/bootstrap/V1802_009__art_unit_admin_digest_cron_trigger.sql
commit;
