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


\. ./kc/bootstrap/V1703_001__fdp_form_update.sql
\. ./kc/bootstrap/V1703_002__ip_fAndARate_table.sql
\. ./kc/bootstrap/V1703_006__compliance.sql
\. ./kc/bootstrap/V1703_009__cost_share_table_change.sql
\. ./kc/bootstrap/V1703_010__subaward_template_fields.sql
\. ./kc/bootstrap/V1703_011__fdp_mod_update.sql
\. ./kc/bootstrap/V1703_012__fdp_mod_update.sql
\. ./kc/bootstrap/V1703_016__fdp_form_update.sql
\. ./kc/bootstrap/V1703_017__line_item_number_expand.sql
\. ./kc/bootstrap/V1703_019__subaward_idc_fields.sql
\. ./kc/bootstrap/V1703_020__line_item_sequence_expand.sql
commit;
