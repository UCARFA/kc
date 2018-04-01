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


\. ./rice/bootstrap/V1803_002__change_applicant_org_parameter.sql
\. ./rice/bootstrap/V1803_003__update_parameter_name.sql
\. ./rice/bootstrap/V1803_004__api_feature_flag.sql
\. ./rice/bootstrap/V1803_005__excluded_cp_report_codes_parameter.sql
\. ./rice/bootstrap/V1803_006__api_fix_feature_flag.sql
commit;
