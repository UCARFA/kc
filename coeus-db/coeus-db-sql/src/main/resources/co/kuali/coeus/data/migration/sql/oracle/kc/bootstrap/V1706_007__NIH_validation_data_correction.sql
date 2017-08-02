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

update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.3' where RULE_NUMBER = '0.3';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.11' where RULE_NUMBER = '0.11';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.27' where RULE_NUMBER = '0.27';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.28' where RULE_NUMBER = '0.28';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.31' where RULE_NUMBER = '0.31';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.38' where RULE_NUMBER = '0.38';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.37' where RULE_NUMBER = '0.37';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.8' where RULE_NUMBER = '0.8';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.9' where RULE_NUMBER = '0.9';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.1' where RULE_NUMBER = '0.1';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.13' where RULE_NUMBER = '0.13';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.2' where RULE_NUMBER = '0.2';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.21' where RULE_NUMBER = '0.21';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.23' where RULE_NUMBER = '0.23';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.25' where RULE_NUMBER = '0.25';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.26' where RULE_NUMBER = '0.26';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.34' where RULE_NUMBER = '0.34';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '000.35' where RULE_NUMBER = '0.35';
update NIH_VALIDATION_MAPPING SET RULE_NUMBER = '001.1.1' where RULE_NUMBER = '01.1.1';

update NIH_VALIDATION_MAPPING SET FORCE_ERROR = 'N' where FORCE_ERROR = '0';
update NIH_VALIDATION_MAPPING SET FORCE_ERROR = 'Y' where FORCE_ERROR = '1';
update NIH_VALIDATION_MAPPING SET APPEND_TO_ORIGINAL = 'N' where APPEND_TO_ORIGINAL = '0';
update NIH_VALIDATION_MAPPING SET APPEND_TO_ORIGINAL = 'Y' where APPEND_TO_ORIGINAL = '1';
update NIH_VALIDATION_MAPPING SET ACTIVE = 'Y' where ACTIVE = '1';
update NIH_VALIDATION_MAPPING SET ACTIVE = 'N' where ACTIVE = '0';