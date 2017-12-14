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


\. ./kc/bootstrap/V1712_001__update_citizenship_s2s_error.sql
\. ./kc/bootstrap/V1712_002__active_s2s_hsct_form.sql
\. ./kc/bootstrap/V1712_004__remove_phs_research_training_plan_v4_narrative.sql
\. ./kc/bootstrap/V1712_005__update_ip_attachment_constraint.sql
\. ./kc/bootstrap/V1712_006__add_narrative_order_index.sql
commit;
