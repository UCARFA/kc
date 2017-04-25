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


\. ./kc/bootstrap/V1704_001__credit_split_enhancement.sql
\. ./kc/bootstrap/V1704_002__fdp_modification_update.sql
\. ./kc/bootstrap/V1704_003__fdp_agreement_form_update.sql
\. ./kc/bootstrap/V1704_004__subaward_modification_unilateral_template_update.sql
\. ./kc/bootstrap/V1704_005__FDP_Attachment_3A_form_update.sql
\. ./kc/bootstrap/V1704_006__FDP_Attachment_3BPage2_form_update.sql
\. ./kc/bootstrap/V1704_009__XML_REORDER.sql
\. ./kc/bootstrap/V1704_010__RESKC-1841.sql
commit;
