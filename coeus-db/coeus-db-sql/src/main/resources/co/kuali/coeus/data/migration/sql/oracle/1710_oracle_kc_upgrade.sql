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

spool 1710_oracle_kc_upgrade.sql.log
@./kc/bootstrap/V1710_001__add_new_form.sql
@./kc/bootstrap/V1710_002__add_new_form.sql
@./kc/bootstrap/V1710_003__add_new_form.sql
@./kc/bootstrap/V1710_006__cert_header.sql
@./kc/bootstrap/V1710_007__quartz_cleanup.sql
@./kc/bootstrap/V1710_009__add_form.sql
@./kc/bootstrap/V1710_011__PHS_CoverPageSupplement_V4.sql
@./kc/bootstrap/V1710_013__PHS_CoverPageSupplement_V4_fix.sql
commit;
