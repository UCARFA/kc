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


\. ./kc/bootstrap/V1702_002__fdp_form_update.sql
\. ./kc/bootstrap/V1702_003__fdp_form_update.sql
\. ./kc/bootstrap/V1702_004__fdp_form_update.sql
\. ./kc/bootstrap/V1702_007__fdp_form_update.sql
\. ./kc/bootstrap/V1702_008__template_fields.sql
\. ./kc/bootstrap/V1702_011__name_fix.sql
\. ./kc/bootstrap/V1702_012__fix_fin_api.sql
\. ./kc/bootstrap/V1702_014__tbn_active.sql
commit;
