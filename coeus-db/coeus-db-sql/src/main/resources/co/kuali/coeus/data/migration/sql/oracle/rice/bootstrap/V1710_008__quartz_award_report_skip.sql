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

insert into KRCR_PARM_T values ('KC-AWARD', 'Document', 'REPORT_TRACKING_NOTIFICATIONS_BATCH_SKIP_MISFIRE', sys_guid(), 1, 'CONFG', 'true', 'Determines whether if a report tracking notification batch job misses its start time if it will skip that time and run again at the next scheduled time(true) or trigger a new batch instantly(false)', 'A', 'KC');

