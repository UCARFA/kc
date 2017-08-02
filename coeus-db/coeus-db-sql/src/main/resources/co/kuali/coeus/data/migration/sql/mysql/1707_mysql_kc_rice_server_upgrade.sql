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


\. ./rice/bootstrap/V1707_005__SF424_Mandatory_questions.sql
\. ./rice/bootstrap/V1707_010__serialization_logging.sql
\. ./rice/bootstrap/V1707_012__RESKC-2382.sql
\. ./rice/bootstrap/V1707_013__nasa_fdp_parameters.sql
\. ./rice/bootstrap/V1707_014__onr_fdp_parameters.sql
\. ./rice/bootstrap/V1707_015__force_xsl_param.sql
commit;
