--
-- Kuali Coeus, a comprehensive research administration system for higher education.
--
-- Copyright 2005-2016 Kuali, Inc.
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

UPDATE subaward_forms
SET form = NULL
WHERE FORM_ID IN ('FDP_AFOSR', 'FDP_AMRMC', 'FDP_AMRAA', 'FDP_ARO', 'FDP_DOE', 'FDP_EPA', 'FDP_NASA', 'FDP_NIH', 'FDP_NSF', 'FDP_ONR', 'FDP_USDA');
