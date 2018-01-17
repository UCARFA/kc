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

update NIH_VALIDATION_MAPPING SET FORCE_ERROR = 'N' where FORCE_ERROR = '0';
update NIH_VALIDATION_MAPPING SET FORCE_ERROR = 'Y' where FORCE_ERROR = '1';
update NIH_VALIDATION_MAPPING SET APPEND_TO_ORIGINAL = 'N' where APPEND_TO_ORIGINAL = '0';
update NIH_VALIDATION_MAPPING SET APPEND_TO_ORIGINAL = 'Y' where APPEND_TO_ORIGINAL = '1';
update NIH_VALIDATION_MAPPING SET ACTIVE = 'Y' where ACTIVE = '1';
update NIH_VALIDATION_MAPPING SET ACTIVE = 'N' where ACTIVE = '0';