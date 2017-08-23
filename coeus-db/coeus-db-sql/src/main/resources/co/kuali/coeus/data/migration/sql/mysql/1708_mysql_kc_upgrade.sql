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


\. ./kc/bootstrap/V1708_001__NIH_validation.sql
\. ./kc/bootstrap/V1708_002__NIH_validation_fix.sql
\. ./kc/bootstrap/V1708_003__questionnaire_constraint.sql
\. ./kc/bootstrap/V1708_004__quartz_update.sql
\. ./kc/bootstrap/V1708_005__quartz_update_kc.sql
\. ./kc/bootstrap/V1708_008__fdp_amraa.sql
\. ./kc/bootstrap/V1708_009__fdp_modification_update.sql
\. ./kc/bootstrap/V1708_013__fdp_modification_update.sql
commit;
