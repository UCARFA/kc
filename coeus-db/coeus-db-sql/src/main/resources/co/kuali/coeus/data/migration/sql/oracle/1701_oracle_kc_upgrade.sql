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

spool 1701_oracle_kc_upgrade.sql.log
@./kc/bootstrap/V1701_002__return.sql
@./kc/bootstrap/V1701_003__question_fix.sql
@./kc/bootstrap/V1701_004__NSF-cover-page1-7.sql
@./kc/bootstrap/V1701_006__RESKC-1956.sql
@./kc/bootstrap/V1701_007__cost_share_type.sql
@./kc/bootstrap/V1701_010__NSF-cover-page1-7-fixes.sql
@./kc/bootstrap/V1701_011__RESKC-1441_credit_split.sql
commit;
