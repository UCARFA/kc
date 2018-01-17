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

spool 1712_oracle_kc_rice_server_upgrade.sql.log
@./rice/bootstrap/V1712_003__create_send_notice_permission.sql
@./rice/bootstrap/V1712_012__SF424_Mandatory_questions.sql
@./rice/bootstrap/V1712_013__fix_krms_term_resolver_name.sql
@./rice/bootstrap/V1712_016__update_non_pd_person_role_derived_roles.sql
commit;
