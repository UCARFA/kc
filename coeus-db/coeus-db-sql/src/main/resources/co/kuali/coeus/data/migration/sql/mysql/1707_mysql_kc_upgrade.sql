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


\. ./kc/bootstrap/V1707_001__ED524-supplemental.sql
\. ./kc/bootstrap/V1707_002__ED524-supplement-disable.sql
\. ./kc/bootstrap/V1707_003__multi_choice_question.sql
\. ./kc/bootstrap/V1707_004__award_posts_indexes.sql
\. ./kc/bootstrap/V1707_006__SF424_Mandatory_questions.sql
\. ./kc/bootstrap/V1707_007__SF424_Mandatory_narratives.sql
commit;
