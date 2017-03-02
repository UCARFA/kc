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


\. ./rice/bootstrap/V1702_001__nih_validation_service.sql
\. ./rice/bootstrap/V1702_005__key_personnel_cert_feature_flag.sql
\. ./rice/bootstrap/V1702_006__RESKC-1938_KRMS_func.sql
\. ./rice/bootstrap/V1702_009__fdp_params.sql
\. ./rice/bootstrap/V1702_010__RESKC-1939_KRMS_func.sql
\. ./rice/bootstrap/V1702_013__RESKC-1940_KRMS_func.sql
\. ./rice/bootstrap/V1702_015__cost_share_src_account_validation.sql
commit;
