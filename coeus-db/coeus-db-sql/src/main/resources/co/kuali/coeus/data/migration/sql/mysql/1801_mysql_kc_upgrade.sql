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


\. ./kc/bootstrap/V1801_001__nsf_id.sql
\. ./kc/bootstrap/V1801_002__version_award_report_tracking.sql
\. ./kc/bootstrap/V1801_003__fdp.sql
\. ./kc/bootstrap/V1801_005__fdp.sql
\. ./kc/bootstrap/V1801_006__nsf_id_varchar.sql
\. ./kc/bootstrap/V1801_007__fdp.sql
\. ./kc/bootstrap/V1801_008__nsf_cover_page_1_8.sql
\. ./kc/bootstrap/V1801_010__base_art_notifications_on_report_params.sql
commit;
